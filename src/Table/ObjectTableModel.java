package Table;


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public abstract class ObjectTableModel<T> extends AbstractTableModel {
    private List<T> objectRows = new ArrayList<>();

    public List<T> getObjectRows() {
        return objectRows;
    }

    public void setObjectRows(List<T> objectRows) {
        this.objectRows = objectRows;
    }

    @Override
    public int getRowCount() {
        return objectRows.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T t = objectRows.get(rowIndex);
        return getValueAt(t, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        T t = objectRows.get(rowIndex);
        if(t instanceof Editable){
            if(!((Editable) t).isEditable()){
                return false;
            }
        }
        return isColumnEditable(columnIndex);
    }

    public void setValueAt(Object value, int row, int column) {
        if(!isCellEditable(row, column)){
            return;
        }
        T t = objectRows.get(row);
        if(setObjectFieldValue(t, column, value)){
            fireTableCellUpdated(row, column);
        }
    }

    public abstract  boolean isColumnEditable(int columnIndex);
    public abstract Object getValueAt(T t, int columnIndex);
    public abstract boolean setObjectFieldValue(T t, int column, Object value);

    @Override
    public abstract String getColumnName(int column);

    public abstract String getFieldName(int column);
}