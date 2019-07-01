package myMenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import Fixture.AddMatch;
import Fixture.MatchInfo;
import Fixture.UpdateMatch;
import Record.Record;
import Record.RecordGoal;
import Record.RecordMatchScore;
import member.Addmember;
import member.DBconnection;
import member.Login;
import member.MemberInfo;
import member.Updateinfo;
import net.proteanit.sql.DbUtils;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
//import net.proteanit.sql.DbUtils;

public class Menu extends JFrame {
   
	private JPanel contentPane;
	private Timer t;
	public int count=0 ;
	public int countMe;
	private JTable table;
	public JTable tableMatch2;
	private JTable table_1;
	private JTable table_3;
	private JTable table_4;
	private Goal myGoal;
	public int goal=0;
	private int goal1=0;
	private JLabel label_1;
	private JLabel label_2;
	public JLabel lblNewLabel_3;
	public JPanel panel_13;
	public JButton btnUpdate;
	public JButton btnDisplay;
	public JButton btnDelete;
	public JButton addMatch;
	

	/**
	 * Launch the application.
	 */
	public int getMID() {
		int mid=0;
		int selectRow = tableMatch2.getSelectedRow();
		TableModel model = tableMatch2.getModel();
		String name = model.getValueAt(selectRow, 0).toString();
		String query= "SELECT `mid` FROM `matches` WHERE `date` = ?";
		PreparedStatement st;
		ResultSet rs;
		try {
			st = DBconnection.getConnection().prepareStatement(query);
			st.setString(1, name);
			rs=st.executeQuery();
			if(rs.next()) {
				mid = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mid;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param  
	 * 
	 */
	public Menu() {};
	public Menu(int i) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel home = new JPanel();
		home.setBackground(new Color(204, 204, 204));
		contentPane.add(home, "name_54964195979851");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(63, 0, 827, 85);
		
		JLabel lblFootballManagementSystem = new JLabel("SoccerX");
		lblFootballManagementSystem.setBounds(82, 97, 467, 165);
		lblFootballManagementSystem.setFont(new Font("Nunito", Font.BOLD, 99));
		home.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(-6, 0, 76, 578);
		home.add(panel);
		
		 panel_13 = new JPanel();
		panel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Addmember member= new Addmember(i);
    			member.setVisible(true);
    			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_13.setBackground(Color.LIGHT_GRAY);
				panel_13.revalidate();
			}
		});
		panel_13.setBounds(6, 113, 69, 50);
		panel.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblSquad = new JLabel("Squad");
		lblSquad.setBounds(13, 16, 38, 16);
		panel_13.add(lblSquad);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setBackground(Color.LIGHT_GRAY);
				panel_5.revalidate();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.frame.setVisible(true);
				dispose();
			}
		});
		panel_5.setLayout(null);
		panel_5.setBounds(6, 25, 69, 50);
		panel.add(panel_5);
		
		JLabel lblLogOut = new JLabel("Log Out");
		lblLogOut.setBounds(6, 16, 57, 16);
		panel_5.add(lblLogOut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(63, 298, 827, 270);
		home.add(panel_1);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(0, 102, 153));
		
		JPanel panel_2 = new JPanel();
		
		panel_2.setBorder(new CompoundBorder());
		
		JLabel lblNewLabel_2 = new JLabel("V");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Nunito SemiBold", Font.PLAIN, 99));
		
		JLabel lblS = new JLabel("S");
		lblS.setForeground(Color.BLUE);
		lblS.setFont(new Font("Nunito SemiBold", Font.PLAIN, 99));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder());
		
		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/img/soccer_badge-512.png")));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new CompoundBorder());
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/img/117063761.jpg")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(37)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(72)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
		);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
		);
		panel_4.setLayout(gl_panel_4);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(43)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblS, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblS, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(20))
		);
		panel_3.setLayout(gl_panel_3);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 824, Short.MAX_VALUE)
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 85, Short.MAX_VALUE)
		);
		panel_6.setLayout(gl_panel_6);
		home.add(panel_6);
		home.add(lblFootballManagementSystem);
		
		
		JPanel inMatch = new JPanel();
		inMatch.setLayout(null);
		inMatch.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(inMatch, "name_54964166452093");
		
		JButton button = new JButton("Record");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Record().show();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(751, 180, 76, 24);
		inMatch.add(button);
		
		JButton button_1 = new JButton("Record");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Record().show();
			}
		});
		button_1.setBounds(150, 181, 76, 24);
		inMatch.add(button_1);
		
//		JButton btnNewButton = new JButton("Record");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				new Record().show();
//			}
//		});
//		
//		JButton button_4 = new JButton("Record");
//		button_4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				new Record().show();
//			}
//		});
		
		JButton button_2 = new JButton("-");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goal1--;
				label_1.setText(String.valueOf(goal1));
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setToolTipText("^");
		button_2.setBounds(606, 116, 25, 24);
		inMatch.add(button_2);
		
		JButton button_3 = new JButton("+");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				goal++;
		label_2.setText(String.valueOf(goal));
		
	           RecordGoal recordGoal = new  RecordGoal(getMID(),getTID(lblNewLabel_3),count,goal);
                  recordGoal.setVisible(true);
		
			}
		});
		
		button_3.setBounds(342, 116, 25, 24);
		inMatch.add(button_3);
		
		JButton button_4 = new JButton("+");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goal1++;
				label_1.setText(String.valueOf(goal1));
				 RecordGoal recordGoal = new  RecordGoal(getMID(),getTID(lblNewLabel_1),count,goal1);
                 recordGoal.setVisible(true);
			}
		});
		
		button_4.setBounds(569, 116, 25, 24);
		inMatch.add(button_4);
		
		JButton button_5 = new JButton("-");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goal--;
				label_2.setText(String.valueOf(goal));
			}
		});
		button_5.setBounds(379, 116, 25, 24);
		inMatch.add(button_5);
		
		 label_1 = new JLabel("New label",SwingConstants.CENTER);
		label_1.setBounds(565, 28, 78, 75);
		inMatch.add(label_1);
		label_1.setText(String.valueOf(goal1));
		label_1.setFont(new Font("Nunito",Font.PLAIN,50));
		
		label_2 = new JLabel("New label",SwingConstants.CENTER);
		label_2.setBounds(326, 28, 78, 76);
		inMatch.add(label_2);
		label_2.setText(String.valueOf(goal));
		label_2.setFont(new Font("Nunito",Font.PLAIN,50));
		
//		myGoal = new Goal();
//		  goal = myGoal.getGoal();
//		 System.out.println(ggoal);
		
		
		JLabel label_3 = new JLabel("\n");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		label_3.setBackground(new Color(0, 204, 204));
		label_3.setBounds(456, 37, 64, 67);
		inMatch.add(label_3);
		
		JButton button_6 = new JButton("Starts");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActionListener mine1=new ActionListener() {
		               
					
					
					public int countMe;
					

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						count++;
						label_3.setText(count+"");
//						myLabel.setText(count+"");
//						countMe = count;
//						System.out.println(countMe);
					}
					};
				t = new Timer(10000, mine1);
				t.start();
			}
		});
		button_6.setBackground(new Color(0, 204, 0));
		button_6.setBounds(431, 97, 42, 22);
		inMatch.add(button_6);
		
		JButton button_7 = new JButton("stop");
		button_7.setBackground(Color.RED);
		button_7.setBounds(497, 97, 42, 22);
		inMatch.add(button_7);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setForeground(Color.WHITE);
		editorPane_2.setBackground(Color.BLACK);
		editorPane_2.setBounds(284, 203, 25, 22);
		inMatch.add(editorPane_2);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setForeground(Color.WHITE);
		editorPane_3.setBackground(Color.BLACK);
		editorPane_3.setBounds(284, 294, 25, 22);
		inMatch.add(editorPane_3);
		
		JEditorPane editorPane_4 = new JEditorPane();
		editorPane_4.setForeground(Color.WHITE);
		editorPane_4.setBackground(Color.BLACK);
		editorPane_4.setBounds(284, 483, 25, 22);
		inMatch.add(editorPane_4);
		
		JEditorPane editorPane_5 = new JEditorPane();
		editorPane_5.setForeground(Color.WHITE);
		editorPane_5.setBackground(Color.BLACK);
		editorPane_5.setBounds(284, 394, 25, 22);
		inMatch.add(editorPane_5);
		
		JEditorPane editorPane_6 = new JEditorPane();
		editorPane_6.setForeground(Color.WHITE);
		editorPane_6.setBackground(Color.BLACK);
		editorPane_6.setBounds(364, 251, 25, 22);
		inMatch.add(editorPane_6);
		
		JEditorPane editorPane_7 = new JEditorPane();
		editorPane_7.setForeground(Color.WHITE);
		editorPane_7.setBackground(Color.BLACK);
		editorPane_7.setBounds(364, 411, 25, 22);
		inMatch.add(editorPane_7);
		
		JEditorPane editorPane_8 = new JEditorPane();
		editorPane_8.setForeground(Color.WHITE);
		editorPane_8.setBackground(Color.BLACK);
		editorPane_8.setBounds(426, 213, 25, 22);
		inMatch.add(editorPane_8);
		
		JEditorPane editorPane_9 = new JEditorPane();
		editorPane_9.setForeground(Color.WHITE);
		editorPane_9.setBackground(Color.BLACK);
		editorPane_9.setBounds(426, 345, 25, 22);
		inMatch.add(editorPane_9);
		
		JEditorPane editorPane_10 = new JEditorPane();
		editorPane_10.setForeground(Color.WHITE);
		editorPane_10.setBackground(Color.BLACK);
		editorPane_10.setBounds(426, 467, 25, 22);
		inMatch.add(editorPane_10);
		
		JEditorPane editorPane_11 = new JEditorPane();
		editorPane_11.setForeground(Color.WHITE);
		editorPane_11.setBackground(Color.BLACK);
		editorPane_11.setBounds(166, 345, 25, 22);
		inMatch.add(editorPane_11);
		
		JEditorPane editorPane_12 = new JEditorPane();
		editorPane_12.setForeground(Color.BLACK);
		editorPane_12.setBackground(Color.LIGHT_GRAY);
		editorPane_12.setBounds(636, 257, 25, 22);
		inMatch.add(editorPane_12);
		
		JEditorPane editorPane_13 = new JEditorPane();
		editorPane_13.setForeground(Color.BLACK);
		editorPane_13.setBackground(Color.LIGHT_GRAY);
		editorPane_13.setBounds(636, 345, 25, 22);
		inMatch.add(editorPane_13);
		
		JEditorPane editorPane_14 = new JEditorPane();
		editorPane_14.setForeground(Color.BLACK);
		editorPane_14.setBackground(Color.LIGHT_GRAY);
		editorPane_14.setBounds(712, 305, 25, 22);
		inMatch.add(editorPane_14);
		
		JEditorPane editorPane_15 = new JEditorPane();
		editorPane_15.setForeground(Color.BLACK);
		editorPane_15.setBackground(Color.LIGHT_GRAY);
		editorPane_15.setBounds(714, 213, 25, 22);
		inMatch.add(editorPane_15);
		
		JEditorPane editorPane_16 = new JEditorPane();
		editorPane_16.setForeground(Color.BLACK);
		editorPane_16.setBackground(Color.LIGHT_GRAY);
		editorPane_16.setBounds(712, 398, 25, 22);
		inMatch.add(editorPane_16);
		
		JEditorPane editorPane_17 = new JEditorPane();
		editorPane_17.setForeground(Color.BLACK);
		editorPane_17.setBackground(Color.LIGHT_GRAY);
		editorPane_17.setBounds(712, 480, 25, 22);
		inMatch.add(editorPane_17);
		
		JEditorPane editorPane_18 = new JEditorPane();
		editorPane_18.setForeground(Color.BLACK);
		editorPane_18.setBackground(Color.LIGHT_GRAY);
		editorPane_18.setBounds(789, 345, 25, 22);
		inMatch.add(editorPane_18);
		
		JEditorPane editorPane_19 = new JEditorPane();
		editorPane_19.setForeground(Color.BLACK);
		editorPane_19.setBackground(Color.LIGHT_GRAY);
		editorPane_19.setBounds(543, 345, 25, 22);
		inMatch.add(editorPane_19);
		
		JEditorPane editorPane_20 = new JEditorPane();
		editorPane_20.setForeground(Color.BLACK);
		editorPane_20.setBackground(Color.LIGHT_GRAY);
		editorPane_20.setBounds(543, 257, 25, 22);
		inMatch.add(editorPane_20);
		
		JEditorPane editorPane_21 = new JEditorPane();
		editorPane_21.setForeground(Color.BLACK);
		editorPane_21.setBackground(Color.LIGHT_GRAY);
		editorPane_21.setBounds(543, 438, 25, 22);
		inMatch.add(editorPane_21);
		
		JEditorPane editorPane_22 = new JEditorPane();
		editorPane_22.setForeground(Color.BLACK);
		editorPane_22.setBackground(Color.LIGHT_GRAY);
		editorPane_22.setBounds(636, 438, 25, 22);
		inMatch.add(editorPane_22);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Menu.class.getResource("/img/Screen Shot 2019-05-31 at 9.32.52 AM.png")));
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(145, 186, 699, 338);
		inMatch.add(label_4);
		
		
		
		
		
		
		
		 //Model of All club and team 
		        DefaultTableModel model = new DefaultTableModel(new String[] {"team_name","username","phonenumber"},0)
		        		{
		        	
		        	public boolean isCellEditable(int row, int column) {
                           return false;
		        	}
		        	
		        		};
		      //End Model   		
		        		
		 try {
			 PreparedStatement st;
	            String query ="SELECT * FROM teamleader";
	            st = DBconnection.getConnection().prepareStatement(query);
	           
	            
	            ResultSet Rs = st.executeQuery();
	            while(Rs.next()){
	            	String d = Rs.getString("team_name");
	                String e = Rs.getString("username");
//	                String f = Rs.getString("password");
	                int g = Rs.getInt("phonenumber");
//	            	model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getInt(4)});
	                model.addRow(new Object[]{d, e, g});
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	
		 
		 
		 
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(0, 51, 102));
		panel_9.setBounds(0, 0, 76, 578);
		inMatch.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(0, 51, 102));
		panel_10.setBounds(0, 18, 75, 50);
		panel_9.add(panel_10);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(12, 0, 50, 50);
		panel_10.add(label_6);
		

		
		label_6.setIcon(new ImageIcon(Menu.class.getResource("/img/icons8-menu-filled-50.png")));
		
			
		JButton button_8 = new JButton("New button");
		button_8.setBounds(497, 97, 42, 22);
		inMatch.add(button_8);
		
		 lblNewLabel_3 = new JLabel("New label",SwingConstants.CENTER);
		lblNewLabel_3.setBounds(205, 135, 237, 38);
		inMatch.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label", SwingConstants.CENTER);
		lblNewLabel_4.setBounds(532, 134, 231, 40);
		inMatch.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Submit match");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String score1 = label_1.getText();
				String score2 =label_2.getText();
				
				RecordMatchScore rec = new RecordMatchScore(getMID(),label_1,label_2);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(426, 145, 117, 29);
		inMatch.add(btnNewButton);
		JLabel label_5 = new JLabel("New label");
		label_5.setIcon(new ImageIcon(Menu.class.getResource("/img/background_striped_lawn.jpg")));
		label_5.setBounds(75, -11, 815, 589);
		inMatch.add(label_5);
		JPanel teamOrClub = new JPanel();
		teamOrClub.setBorder(new LineBorder(new Color(0, 0, 0)));
		teamOrClub.setLayout(null);
		teamOrClub.setBackground(Color.LIGHT_GRAY);
		contentPane.add(teamOrClub, "name_54964175415993");
		
		JLabel lblFixture = new JLabel("Team / Club");
		lblFixture.setFont(new Font("Nunito SemiBold", Font.PLAIN, 50));
		lblFixture.setBounds(351, -21, 322, 127);
		teamOrClub.add(lblFixture);
		//		model.addColumn("team_name");
		//		model.addColumn("username");
		//		model.addColumn("password");
		//		model.addColumn("phonenumber");
				table_1 = new JTable();
				
				
				

				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(77, 81, 807, 481);
				teamOrClub.add(scrollPane);
				
				
				
//				table_1.setColumnSelectionAllowed(true);
//				table_1.setCellSelectionEnabled(true);
				table_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
				scrollPane.setViewportView(table_1);
				table_1.setRowHeight(50);
				table_1.setModel(model);
				
				JPanel panel_7 = new JPanel();
				panel_7.setLayout(null);
				panel_7.setBackground(new Color(0, 51, 102));
				panel_7.setBounds(0, 0, 76, 578);
				teamOrClub.add(panel_7);
				
				JPanel panel_8 = new JPanel();
				panel_8.setLayout(null);
				panel_8.setBackground(new Color(0, 51, 102));
				panel_8.setBounds(0, 18, 75, 50);
				panel_7.add(panel_8);
				
				JLabel label_7 = new JLabel("");
				
				label_7.setIcon(new ImageIcon(Menu.class.getResource("/img/icons8-menu-filled-50.png")));
				label_7.setBounds(12, 0, 50, 50);
				panel_8.add(label_7);
		
		JPanel table_2 = new JPanel();
		contentPane.add(table_2, "name_61919408412833");
		table_2.setLayout(null);
		
		JLabel lblTable = new JLabel("Table");
		lblTable.setFont(new Font("Nunito Light", Font.PLAIN, 50));
		lblTable.setBounds(369, 6, 134, 91);
		table_2.add(lblTable);
		//table in position table
//		DefaultTableModel model1 = new DefaultTableModel(new String[] {"position","club","played","Won","drawn","lost","GF","GA","GD","point"},0);
//		 try {
//			 PreparedStatement st;
//	            String query ="SELECT * FROM teamleader";
//	            st = DBconnection.getConnection().prepareStatement(query);
//	           
//	            
//	            ResultSet Rs = st.executeQuery();
//	            while(Rs.next()){
//	            	String d = Rs.getString("team_name");
////	                String f = Rs.getString("password");
////	                int g = Rs.getInt("phonenumber");
////	            	model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getInt(4)});
//	                model1.addRow(new Object[]{1, d, 0});
//			      MatchInfo info = new MatchInfo();
//			      info.displayJtableInfo(table_3);
//	            }
//	        } catch (Exception e) {
//	            System.out.println(e.getMessage());
//	        }
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(75, 96, 815, 466);
		table_2.add(scrollPane_1);
		table_3 = new JTable();
		scrollPane_1.setViewportView(table_3);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(new Color(0, 51, 102));
		panel_11.setBounds(0, 0, 76, 578);
		table_2.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(0, 51, 102));
		panel_12.setBounds(0, 18, 75, 50);
		panel_11.add(panel_12);
		
		JLabel label_8 = new JLabel("");
		
		label_8.setIcon(new ImageIcon(Menu.class.getResource("/img/icons8-menu-filled-50.png")));
		label_8.setBounds(12, 0, 50, 50);
		panel_12.add(label_8);
		
		JPanel fixture = new JPanel();
//		JScrollPane scrollPane2 = new JScrollPane();
//		scrollPane2.setBounds(23, 149, 1003, 405);
		
		contentPane.add(fixture, "name_22447715096617");
		fixture.setLayout(null);
		//component
		tableMatch2 = new JTable();
		JScrollPane scrollPane2 = new JScrollPane(tableMatch2);
		scrollPane2.setBounds(75, 80, 815, 498);
//		contentPane.add(scrollPane2);
		fixture.add( scrollPane2);
		JTableHeader theader = tableMatch2.getTableHeader();
		theader.setBackground(Color.pink);
		theader.setForeground(Color.white);
		theader.setFont(new Font("Tahoma", Font.BOLD , 25));
		tableMatch2.setFont(new Font("Arial",Font.BOLD,20));
		tableMatch2.setRowHeight(30);
		tableMatch2.setForeground(Color.yellow);
		tableMatch2.setBackground(Color.darkGray);
		tableMatch2.setAlignmentX(CENTER_ALIGNMENT);
		tableMatch2.setAlignmentY(CENTER_ALIGNMENT);
//		scrollPane.setViewportView(tableMatch2);
	//	 	End	contentPane.add(scrollPane);
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBackground(new Color(0, 51, 102));
		panel_14.setBounds(0, 0, 76, 578);
		fixture.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBackground(new Color(0, 51, 102));
		panel_15.setBounds(0, 18, 75, 50);
		panel_14.add(panel_15);
		
		JLabel label_9 = new JLabel("");
		
		label_9.setIcon(new ImageIcon(Menu.class.getResource("/img/icons8-menu-filled-50.png")));
		label_9.setBounds(12, 0, 50, 50);
		panel_15.add(label_9);
		
		//show match table  
		
//		fixture.add(new AddMatch().tableMatch);
		
		addMatch = new JButton("Add match");
		addMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatchInfo match = new MatchInfo( tableMatch2);
				match.setVisible(true);
			}
		});
		addMatch.setBounds(394, 10, 178, 58);
		fixture.add(addMatch);
		
		 btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
//					PreparedStatement st;
//					ResultSet rs;
//					String query= "SELECT `date` as `Date`,`home` as `Home`,`start_time` as `Time`,`away` as `Away` FROM `matches`";
//					try {
//						st = DBconnection.getConnection().prepareStatement(query);
//						st.setInt(1, 1);
//						rs = st.executeQuery();
//						tableMatch2.setModel(DbUtils.resultSetToTableModel(rs));
//						 
//					
//                
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
			
//				}
				//Replace above code with just this object
//				MatchInfo member2= new MatchInfo(1 , tableMatch2);
//				member2.displayJtableInfo(1, tableMatch2);
				//Display InMatch observation
				
					int selectRow = tableMatch2.getSelectedRow();
					if (selectRow >= 0) {
						
//         				UpdateMatch update = new UpdateMatch(selectRow , model , getMID() , tableMatch2 , 1);
//						update.setVisible(true);
						TableModel matchModel = tableMatch2.getModel();
						lblNewLabel_3.setText(matchModel.getValueAt(selectRow,1).toString());
						lblNewLabel_4.setText(matchModel.getValueAt(selectRow,3).toString());
						contentPane.removeAll();
						contentPane.add(inMatch);
						contentPane.repaint();
						contentPane.revalidate();
						
					}
					else {
						JOptionPane.showMessageDialog(null,"<html><font face='Arial' size='8' color='blue'>No match is selected");
					}
					

				}
					
			
		});
		
		
		btnDisplay.setBounds(154, 15, 117, 29);
		fixture.add(btnDisplay);
		
		 btnUpdate = new JButton("update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow = tableMatch2.getSelectedRow();
				if (selectRow >= 0) {
					TableModel model = tableMatch2.getModel();
					UpdateMatch update = new UpdateMatch(selectRow , model , getMID() , tableMatch2 , 1);
					update.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"<html><font face='Arial' size='8' color='blue'>No match is selected");
				}
				

			}
			
		});
		btnUpdate.setBounds(659, 10, 178, 58);
		fixture.add(btnUpdate);
	
		//Delete match
		 btnDelete = new JButton("delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow = tableMatch2.getSelectedRow();
				String query="DELETE FROM `matches` WHERE `mid` = ?";
				PreparedStatement st;
				if(selectRow >= 0) {
				int message = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this player?","Delete",JOptionPane.YES_NO_OPTION);
				if(message == JOptionPane.YES_NO_OPTION) {
					try {
						TableModel model = tableMatch2.getModel();
						String name = model.getValueAt(selectRow, 0).toString();
						st = DBconnection.getConnection().prepareStatement(query);
						st.setInt(1, getMID());
						if(st.executeUpdate() != 0) {
							JOptionPane.showMessageDialog(null,"Player named : "+name+" is deleted");
							MatchInfo match1 = new MatchInfo(tableMatch2);
							match1.displayJtableInfo(tableMatch2);
						}
						else {
							JOptionPane.showMessageDialog(null,"Error deleting player");
						}

					} catch (SQLException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}
				}

				
				
			}
				else {
						JOptionPane.showMessageDialog(null,"No player is selected");
					}
			}
		});
		btnDelete.setBounds(154, 39, 117, 29);
		fixture.add(btnDelete);
		

		// Switch from home to match list
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(fixture);
				contentPane.repaint();
				contentPane.revalidate();
				//Display matches when click on Match VS logo
				MatchInfo member1= new MatchInfo(tableMatch2);
				member1.displayJtableInfo(tableMatch2);
				//end display
			}
			
		});
		//End Home to Match list 
		
		//Team logo icon action
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(teamOrClub);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		//Team Position Table
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(table_2);
				contentPane.repaint();
				contentPane.revalidate();
				MatchInfo posTable= new MatchInfo(table_3);
				posTable.displayPosition(table_3);
				
			}
		});
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(home);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(home);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(home);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(fixture);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});

		

	}
	
	//testing get account id and get username 
	public int getTID(JLabel label) {
		String teamName = label.getText();
		PreparedStatement st;
		ResultSet rs;
		int tid=0;
		String query = "SELECT `tid` FROM `teamleader` WHERE `team_name`=?";
		try {
			st = DBconnection.getConnection().prepareStatement(query);
			st.setString(1, teamName);
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
}
