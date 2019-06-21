package Hok;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;


public class SignUp extends JFrame {
	private JPasswordField confirmpasswordField;
	private JTextField teamnameField;
	private JTextField unameField;
	 private JTextField phonenumberField;
	 private JPasswordField passwordField;
	 
	 
	 // check the field input if they are right or wrong
	 public boolean verifyField()
		{
			String username = unameField.getText();
			String phonenumber = phonenumberField.getText();
			String password = String.valueOf(passwordField.getPassword());
			String confirmpassword= String.valueOf(confirmpasswordField.getPassword());
			String teamname= teamnameField.getText();
			
			if(!password.equals(confirmpassword)) {
				JOptionPane.showMessageDialog(null, "Password doesn't match");
				return false;
			}
			else if(username.trim().equals("Please enter your username") || phonenumber.trim().equals("Please enter your phone number") || password.trim().equals("***************") || confirmpassword.trim().equals("***************") || teamname.trim().equals("Please enter your team name")) {
				JOptionPane.showMessageDialog(null, "One or More Fields are empty");
				return false;	
			}
			else {
				return true;
			}
			
		//chek if username already exist in database	
		}
	 public boolean checkUsername(String username) throws SQLException {
		 
		 PreparedStatement st;
		 ResultSet rs;
		 boolean exist=false;
		 
		 
		 String query = "SELECT * FROM `teamleader` WHERE `username`= ?";
		 st = DBconnection.getConnection().prepareStatement(query);
		 st.setString(1, username);
		 rs= st.executeQuery();
		 if(rs.next()) {
			 exist = true;
			 JOptionPane.showMessageDialog(null, "This username already existed", "Username Exist", 2);
		 }
		 return exist;
		 
	 }
	 
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setSize(1080,720);
		getContentPane().setLayout(null);
		


			
			JLabel lblSignUp = new JLabel("Sign Up");
			lblSignUp.setBackground(Color.GREEN);
			lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblSignUp.setBounds(464, 0, 110, 114);
			getContentPane().add(lblSignUp);
			
			JLabel lblUsername = new JLabel("Username :");
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblUsername.setBounds(198, 138, 154, 79);
			getContentPane().add(lblUsername);
			
			JLabel lblPassword = new JLabel("Phone Number :");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblPassword.setBounds(139, 230, 229, 88);
			getContentPane().add(lblPassword);
			
			unameField = new JTextField();
			unameField.setForeground(SystemColor.controlHighlight);
			unameField.setText("Please enter your username");
			unameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
			unameField.setBounds(364, 153, 421, 50);
			getContentPane().add(unameField);
			unameField.setColumns(10);
			unameField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if (unameField.getText().trim().equals("Please enter your username")){
						unameField.setText("");
						unameField.setForeground(Color.BLACK);
					}

				}
				@Override
				public void focusLost(FocusEvent e) {
					if(unameField.getText().trim().equals("") || unameField.getText().trim().toLowerCase().equals("")) {
						unameField.setText("Please enter your username");
						unameField.setForeground(SystemColor.controlHighlight);
					}

				}
			});
			
			phonenumberField = new JTextField();
			phonenumberField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					if(!Character.isDigit(arg0.getKeyChar())) {
						arg0.consume();
					}
				}
			});

			phonenumberField.setForeground(SystemColor.controlHighlight);
			phonenumberField.setText("Please enter your phone number");
			phonenumberField.setFont(new Font("Tahoma", Font.PLAIN, 25));
			phonenumberField.setBounds(364, 250, 421, 50);
			getContentPane().add(phonenumberField);
			phonenumberField.setColumns(10);
			phonenumberField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if (phonenumberField.getText().trim().equals("Please enter your phone number")){
						phonenumberField.setText("");
						phonenumberField.setForeground(Color.BLACK);
					}

				}
				@Override
				public void focusLost(FocusEvent e) {
					if(phonenumberField.getText().trim().equals("") || phonenumberField.getText().trim().toLowerCase().equals("")) {
						phonenumberField.setText("Please enter your phone number");
						phonenumberField.setForeground(SystemColor.controlHighlight);
					}

				}
			});
			
			
			JButton btnSignUp = new JButton("Sign Up");
			btnSignUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String username = unameField.getText();
					String phonenumber = phonenumberField.getText();
					String password = String.valueOf(passwordField.getPassword());
					String confirmpassword= String.valueOf(confirmpasswordField.getPassword());
					String teamname = teamnameField.getText();
					
					if(verifyField()) {
						try {
							if(!checkUsername(username)) {
								PreparedStatement st;
								String insertQuery= "INSERT INTO `teamleader`(`team_name`, `username`, `password`, `phonenumber`) VALUES (?,?,?,?)";
								st= DBconnection.getConnection().prepareStatement(insertQuery);
								
								st.setString(1, teamname);
								st.setString(2, username);
								st.setString(3,	password );
								st.setString(4, phonenumber);
								if(st.executeUpdate() != 0) {
									
									JOptionPane.showMessageDialog(null,"Your account has been created successfully !");
									unameField.setText("Please enter your username");
									unameField.setForeground(SystemColor.controlHighlight);
									passwordField.setText("***************");
									passwordField.setForeground(SystemColor.controlHighlight);
									teamnameField.setText("Please enter your team name");
									teamnameField.setForeground(SystemColor.controlHighlight);
									confirmpasswordField.setText("***************");
									confirmpasswordField.setForeground(SystemColor.controlHighlight);
									phonenumberField.setText("Please enter your phone number");
									phonenumberField.setForeground(SystemColor.controlHighlight);
								}
								else {
									JOptionPane.showMessageDialog(null,"Error: Check your information");
								}
									
								
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
					
				}
			});
			btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnSignUp.setBounds(477, 598, 154, 62);
			getContentPane().add(btnSignUp);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					}
			});
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			btnCancel.setBounds(0, 0, 154, 62);
			getContentPane().add(btnCancel);
			
			JLabel lblPassword_1 = new JLabel("Password :");
			lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblPassword_1.setBounds(203, 349, 165, 43);
			getContentPane().add(lblPassword_1);
			
			passwordField = new JPasswordField();
			passwordField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					String pass = String.valueOf(passwordField.getPassword());
					if (pass.trim().equals("***************")){
						passwordField.setText("");
						passwordField.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					String pass= String.valueOf(passwordField.getPassword());
					if(pass.trim().equals("")|| pass.trim().toLowerCase().equals("")) {
						passwordField.setText("***************");
						passwordField.setForeground(SystemColor.controlHighlight);
						
					}
				}
			});
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
			passwordField.setBounds(364, 346, 421, 50);
			passwordField.setText("***************");
			passwordField.setForeground(SystemColor.controlHighlight);
			getContentPane().add(passwordField);
			
			JLabel lblNewLabel = new JLabel("Confirm password :");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel.setBounds(99, 427, 297, 62);
			getContentPane().add(lblNewLabel);
			
			confirmpasswordField = new JPasswordField();
			confirmpasswordField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					String pass = String.valueOf(confirmpasswordField.getPassword());
					if (pass.trim().equals("***************")){
						confirmpasswordField.setText("");
						confirmpasswordField.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					String pass = String.valueOf(confirmpasswordField.getPassword());
					if(pass.trim().equals("")|| pass.trim().toLowerCase().equals("")) {
						confirmpasswordField.setText("***************");
						confirmpasswordField.setForeground(SystemColor.controlHighlight);
						
					}
					
				}
			});
			confirmpasswordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
			confirmpasswordField.setBounds(364, 438, 421, 50);
			confirmpasswordField.setText("***************");
			confirmpasswordField.setForeground(SystemColor.controlHighlight);
			getContentPane().add(confirmpasswordField);
			
			JLabel lblNewLabel_1 = new JLabel("Team Name :");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1.setBounds(180, 524, 172, 43);
			getContentPane().add(lblNewLabel_1);
			
			teamnameField = new JTextField();
			teamnameField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (teamnameField.getText().trim().equals("Please enter your team name")){
						teamnameField.setText("");
						teamnameField.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(teamnameField.getText().trim().equals("") || teamnameField.getText().trim().toLowerCase().equals("")) {
						teamnameField.setText("Please enter your team name");
						teamnameField.setForeground(SystemColor.controlHighlight);
					}
				}
			});
			teamnameField.setForeground(Color.LIGHT_GRAY);
			teamnameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
			teamnameField.setText("Please enter your team name");
			teamnameField.setBounds(364, 521, 421, 50);
			getContentPane().add(teamnameField);
			teamnameField.setColumns(10);
			

			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		}
	
	

	}
	




