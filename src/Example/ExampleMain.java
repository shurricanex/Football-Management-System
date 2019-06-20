package Example;

import util.RandomUtil;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Table.DisplayableObjectTableModel;
import Table.JCheckBoxWithIcon;
import Table.ObjectTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ExampleMain {
    private static final ImageIcon editIcon = new ImageIcon(ExampleMain.class.getResource("/img/icons8-menu-filled-50.png"));

    public static void main(String[] args) {
        JFrame frame = createFrame();
        ObjectTableModel<Employee> tableModel = new DisplayableObjectTableModel<>(Employee.class);
        tableModel.setObjectRows(getEmployees());
        JTable table = new JTable(tableModel);
        initDeptComboBoxEditor(table);
        table.setDefaultRenderer(Object.class, createRenderer());
        table.setDefaultRenderer(Boolean.class, createCheckBoxRenderer());
        tableModel.addTableModelListener((e)->{table.repaint();});
        JCheckBoxWithIcon checkBox = new JCheckBoxWithIcon();
        checkBox.setHorizontalAlignment(JCheckBox.CENTER);
        checkBox.setCheckBoxIcon(editIcon);
        table.setDefaultEditor(Boolean.class, new DefaultCellEditor(checkBox));
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static TableCellRenderer createRenderer() {
        return new DefaultTableCellRenderer() {
            {
                super.setHorizontalTextPosition(SwingConstants.LEFT);
            }

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setIcon(table.isCellEditable(row, column) ? editIcon : null);
                return this;
            }
        };
    }

    private static TableCellRenderer createCheckBoxRenderer() {
        return new TableCellRenderer() {
            JCheckBoxWithIcon box = new JCheckBoxWithIcon();
            final Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);
            {
                box.setHorizontalAlignment(JLabel.CENTER);
                box.setBorderPainted(true);
            }

            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                if (isSelected) {
                    box.setForeground(table.getSelectionForeground());
                    box.setBackground(table.getSelectionBackground());
                } else {
                    box.setForeground(table.getForeground());
                    box.setBackground(table.getBackground());
                }
                box.setSelected((value != null && ((Boolean) value).booleanValue()));

                if (hasFocus) {
                    box.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
                } else {
                    box.setBorder(noFocusBorder);
                }

                if (table.isCellEditable(row, column)) {
                    box.setCheckBoxIcon(editIcon);
                } else {
                    box.setCheckBoxIcon(null);
                }
                return box;
            }
        };
    }

    private static void initDeptComboBoxEditor(JTable table) {
        JComboBox comboBox = new JComboBox(Employee.DEPT_LIST);
        DefaultCellEditor editor = new DefaultCellEditor(comboBox);
        TableColumn column = table.getColumnModel().getColumn(Employee.DEPT_INDEX);
        column.setCellEditor(editor);
    }

    public static List<Employee> getEmployees() {
        final List<Employee> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Employee e = new Employee();
            e.setName(RandomUtil.getFullName());
            e.setPhone(Integer.toString(RandomUtil.getInt(111111111, 999999999)));
            e.setDept(RandomUtil.getAnyOf(Employee.DEPT_LIST));
            e.setFullTime(RandomUtil.getBoolean());
            e.setDateOfBirth(RandomUtil.getDate(1950, 2000));
            list.add(e);
        }
        return list;
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame("Editable JTable with Edit Icons Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 300));
        return frame;
    }
}