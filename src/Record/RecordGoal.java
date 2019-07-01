package Record;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import member.Addmember;
import member.DBconnection;
import myMenu.Menu;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordGoal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordGoal frame = new RecordGoal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public boolean verifyField() {
		String name = textField.getText();
		String  type= textField_1.getText();
		if(name.trim().equals("") || type.trim().equals("") ) {
			JOptionPane.showMessageDialog(null,"please fill all field");
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * Create the frame.
	 */
	public RecordGoal() { };
	public RecordGoal(int mid , int tid, int count, int goal) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 358, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(169, 58, 144, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPlayerNumber = new JLabel("Player number");
		lblPlayerNumber.setBounds(35, 63, 89, 16);
		contentPane.add(lblPlayerNumber);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBounds(169, 105, 144, 26);
		contentPane.add(textField_1);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(35, 110, 89, 16);
		contentPane.add(lblType);
		
		JButton btnOk = new JButton("ok");
		btnOk.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				String pNumber = textField.getText();
				String type = textField_1.getText();
			
				PreparedStatement st;
				String insertquery = "INSERT INTO `score`(`pid`,`mid`, `tid`, `time`, `type`,`goal`) VALUES (?,?,?,?,?,?)";
				if(verifyField()==true) {
					int pNumber1 = Integer.parseInt(pNumber);
					
//				try {
//					if(!checkShirtnumber(shirtnumber)) {
					try {
							st = DBconnection.getConnection().prepareStatement(insertquery);
							st.setInt(1, pNumber1);
							st.setInt(2, mid);
							st.setInt(3, tid);
							st.setInt(4, count);
							st.setString(5,type);
							st.setInt(6, goal);
							
							if(st.executeUpdate() != 0) {
								JOptionPane.showMessageDialog(null,"Successfully Added");
								dispose();
							}
						
				}
					catch(Exception e1) {
						e1.printStackTrace();
					}
			}
			}
				
		});
		btnOk.setBounds(115, 177, 75, 29);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(189, 177, 75, 29);
		contentPane.add(btnCancel);
		btnCancel.addMouseListener(new MouseAdapter() {
		
			@Override
			
			public void mouseClicked(MouseEvent e) {
				
				dispose();
			}
		});
		
		
				
		
		
	}


}
