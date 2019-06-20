import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import java.sql.*;
public class Login {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public int getTID() {
		String username = usernameField.getText();
		PreparedStatement st;
		ResultSet rs;
		int tid=0;
		String query = "SELECT `tid` FROM `teamleader` WHERE `username`=?";
		try {
			st = DBconnection.getConnection().prepareStatement(query);
			st.setString(1, username);
			rs = st.executeQuery();
			if(rs.next()) {
				tid = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tid;
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToFootball = new JLabel("Welcome to Football Management System");
		lblWelcomeToFootball.setForeground(Color.YELLOW);
		lblWelcomeToFootball.setFont(new Font("Lucida Handwriting", Font.BOLD, 26));
		lblWelcomeToFootball.setBackground(Color.LIGHT_GRAY);
		lblWelcomeToFootball.setBounds(238, 54, 682, 62);
		frame.getContentPane().add(lblWelcomeToFootball);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUsername.setBounds(174, 196, 191, 102);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPassword.setBounds(184, 311, 207, 75);
		frame.getContentPane().add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		usernameField.setBounds(346, 220, 377, 56);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement st;
				ResultSet rs;
				String username = usernameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String query = "SELECT * FROM `teamleader` WHERE `username` = ? AND `password` = ?";
				try {
					st = DBconnection.getConnection().prepareStatement(query);
					st.setString(1, username);
					st.setString(2, password);
					rs = st.executeQuery();
					if(rs.next()) {
						//Show new form 
						Addmember member= new Addmember(getTID());
						member.setVisible(true);
						frame.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(frame, "Incorrect username or password","Error login", 2);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnLogin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnLogin.setBackground(Color.GREEN);
			}
			@Override
			public void focusLost(FocusEvent e) {
				btnLogin.setBackground(Color.white);
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setBounds(346, 325, 377, 56);
		frame.getContentPane().add(passwordField);




		btnLogin.setForeground(Color.BLUE);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(283, 445, 191, 75);
		frame.getContentPane().add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp signup = new SignUp();
				signup.setVisible(true);
			}
		});
		btnSignUp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnSignUp.setBackground(Color.blue);
				btnSignUp.setForeground(Color.white);
			}
			@Override
			public void focusLost(FocusEvent e) {
				btnSignUp.setBackground(Color.white);
				btnSignUp.setForeground(Color.blue);
			}
		});
		btnSignUp.setBackground(Color.WHITE);
		btnSignUp.setForeground(Color.BLUE);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSignUp.setBounds(569, 445, 191, 75);
		frame.getContentPane().add(btnSignUp);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	}

}
