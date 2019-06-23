package Fixture;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import Home.DBconnection;
import net.proteanit.sql.DbUtils;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdateMatch extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField ageField;
	private JTextField heightField;
	private JTextField shirtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateMatch frame = new UpdateMatch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public boolean checkShirtnumber(int shirtnumber , JTable table) throws SQLException{
		int selectRow = table.getSelectedRow();
		TableModel model = table.getModel();
		// get mid of selected row
		String shirtnumber1 = model.getValueAt(selectRow, 3).toString();
		int shirtnumber2 = Integer.parseInt(shirtnumber1);
		PreparedStatement st;
		ResultSet rs;
		String query= "select * from member where shirtnumber = ?";
		st = DBconnection.getConnection().prepareStatement(query);
		st.setInt(1, shirtnumber);
		rs = st.executeQuery();
		if(rs.next()) {
			if(rs.getInt(4)==shirtnumber2) {
				return false;
			}
			else {
			JOptionPane.showMessageDialog(null,"This shirt number is already taken");
			return true;
			}
		}
		else {
			return false;
		}
	}

	
	public boolean verifyField() {
		String name = nameField.getText();
		String age= ageField.getText();
		String height = heightField.getText();
		String shirtnumber = shirtField.getText();
		if(name.trim().equals("") || age.trim().equals("") || height.trim().equals("")|| shirtnumber.trim().equals("")) {
			JOptionPane.showMessageDialog(null,"One or more fields are empty");
			return false;
		}
		else {
			return true;
		}
	}
public UpdateMatch() {
	
}
	/**
	 * Create the frame.
	 */
	public UpdateMatch(int selectRow , TableModel model ,int mid , JTable table , int tid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(500,620);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(67, 58, 121, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Age :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(83, 159, 121, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Height (cm) :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(12, 272, 140, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Shirt Number :");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setBounds(0, 382, 176, 58);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = nameField.getText();
				String age1 = ageField.getText();
				String height1 = heightField.getText();
				String shirtnumber1  = shirtField.getText();
				if(verifyField()) {
					int  age= Integer.parseInt(age1);
					int height = Integer.parseInt(height1);
					int shirtnumber = Integer.parseInt(shirtnumber1);
					try {
						if(!checkShirtnumber(shirtnumber , table)) {
							PreparedStatement st;
							String query = "UPDATE `member` SET `name`=?,`height`=?,`age`=?,`ShirtNumber`=? WHERE `mid` = ?";
							try {
								st = DBconnection.getConnection().prepareStatement(query);
								st.setString(1, name);
								st.setInt(2, height);
								st.setInt(3, age);
								st.setInt(4, shirtnumber);
								st.setInt(5, mid);
								if(st.executeUpdate() != 0) {
									JOptionPane.showMessageDialog(null, "Update successfully");
									dispose();
									MatchInfo member1= new MatchInfo(tid , table);
									member1.displayJtableInfo(tid, table);
								}
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnNewButton.setBounds(162, 474, 162, 66);
		contentPane.add(btnNewButton);
		
		nameField = new JTextField();
		nameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				nameField.selectAll();
			}
		});
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameField.setBounds(148, 58, 270, 48);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		ageField = new JTextField();
		ageField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(!Character.isDigit(arg0.getKeyChar())) {
					arg0.consume();
				}
			}
		});
		ageField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ageField.selectAll(); 
			}
		});
		ageField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ageField.setBounds(148, 164, 270, 48);
		contentPane.add(ageField);
		ageField.setColumns(10);
		
		heightField = new JTextField();
		heightField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		heightField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				heightField.selectAll();
			}
		});
		heightField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		heightField.setBounds(148, 274, 270, 48);
		contentPane.add(heightField);
		heightField.setColumns(10);
		
		shirtField = new JTextField();
		shirtField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()) || shirtField.getText().length()>1) {
					e.consume();
				}
			}
		});
		shirtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				shirtField.selectAll();
			}
		});
		shirtField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shirtField.setBounds(148, 389, 270, 48);
		contentPane.add(shirtField);
		shirtField.setColumns(10);
		nameField.setText(model.getValueAt(selectRow, 0).toString());
		ageField.setText(model.getValueAt(selectRow,1).toString());
		heightField.setText(model.getValueAt(selectRow, 2).toString());
		shirtField.setText(model.getValueAt(selectRow, 3).toString());
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

}
