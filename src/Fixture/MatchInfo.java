package Fixture;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Home.DBconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class MatchInfo extends JFrame {

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
					MatchInfo frame = new MatchInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	public boolean checkShirtnumber(int shirtnumber) throws SQLException{
		PreparedStatement st;
		ResultSet rs;
		String query= "select * from member where shirtnumber = ?";
		st = DBconnection.getConnection().prepareStatement(query);
		st.setInt(1, shirtnumber);
		rs = st.executeQuery();
		if(rs.next()) {
			JOptionPane.showMessageDialog(null,"This shirt number is already taken");
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * Create the frame.
	 */
	
	public void displayJtableInfo(int tid , JTable table) {
		PreparedStatement st;
		ResultSet rs;
		String query= "SELECT `name` as `Name`,`height` as `Height`,`age` as `Age`,`ShirtNumber` as `ShirtNumber` FROM `member` WHERE `tid` = ?";
		try {
			st = DBconnection.getConnection().prepareStatement(query);
			st.setInt(1, tid);
			rs = st.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public MatchInfo() {

	}
	
	public MatchInfo(int tid , JTable table) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(500,620);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//add label 
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(67, 58, 121, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Team1 :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(67, 159, 121, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Time :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(67, 272, 140, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Team2 :");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setBounds(67, 382, 176, 58);
		contentPane.add(lblNewLabel_3);
		// end add label
		
		//Add button
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String age1 = ageField.getText();
				String height1 = heightField.getText();
				String shirtnumber1 = shirtField.getText();
					PreparedStatement st;
					String insertquery = "INSERT INTO `matches`(`date`,`home`, `start_time`,`away`) VALUES (?,?,?,?)";
					if (verifyField()) {
//						int age = Integer.parseInt(age1);
//						int height = Integer.parseInt(height1);
//						int shirtnumber = Integer.parseInt(shirtnumber1);
					try {
//						if(!checkShirtnumber(shirtnumber1)) {
//							try {
								st = DBconnection.getConnection().prepareStatement(insertquery);
//								st.setInt(1, tid);
								st.setString(1, name);
								st.setString(2, age1);
								st.setString(3, height1);
								st.setString(4,shirtnumber1);
								if(st.executeUpdate() != 0) {
									JOptionPane.showMessageDialog(null,"Successfully Added");
									dispose();
//									displayJtableInfo(tid , table);

//								}

								
//							} catch (SQLException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

				
				
				
				
			}
		//end Add button 
);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnNewButton.setBounds(162, 474, 162, 66);
		contentPane.add(btnNewButton);
		// Create textFields
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameField.setBounds(148, 58, 270, 48);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		ageField = new JTextField();
//		ageField.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyTyped(KeyEvent arg0) {
//				if(!Character.isDigit(arg0.getKeyChar())) {
//					arg0.consume();
//				}
//			}
//		});
		ageField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ageField.setBounds(148, 164, 270, 48);
		contentPane.add(ageField);
		ageField.setColumns(10);
		
		heightField = new JTextField();
//		heightField.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyTyped(KeyEvent e) {
//				if(!Character.isDigit(e.getKeyChar())) {
//					e.consume();
//				}
//				
//			}
//		});
		heightField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		heightField.setBounds(148, 274, 270, 48);
		contentPane.add(heightField);
		heightField.setColumns(10);
		
		shirtField = new JTextField();
		
//		shirtField.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyTyped(KeyEvent e) {
//				int fieldlength = shirtField.getText().length();
//				if(fieldlength>1) {
//					e.consume();
//				}
//				
//				if(!Character.isDigit(e.getKeyChar())) {
//					e.consume();
//				}
//			}
//		});
		shirtField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shirtField.setBounds(148, 389, 270, 48);
		contentPane.add(shirtField);
		shirtField.setColumns(10);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
