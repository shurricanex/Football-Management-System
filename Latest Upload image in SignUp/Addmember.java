import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JLabel;
public class Addmember extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addmember frame = new Addmember();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// get MID from the name of members to use in other jframe
	public int getMID() {
		int mid=0;
		int selectRow = table.getSelectedRow();
		TableModel model = table.getModel();
		String name = model.getValueAt(selectRow, 0).toString();
		String query= "SELECT `mid` FROM `member` WHERE `name` = ?";
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
	//display image football logo on Jlabel 
	public void displayImage(JLabel label , int tid) throws SQLException, IOException{
		PreparedStatement st;
		ResultSet rs;
		String query = "select imageLogo from teamleader where tid = ?";
		st = DBconnection.getConnection().prepareStatement(query);
		st.setInt(1, tid);
		rs = st.executeQuery();
		if (rs.next()) {
			BufferedImage im = ImageIO.read(rs.getBinaryStream("imageLogo"));
			Image dimg = im.getScaledInstance(label.getWidth(), label.getHeight(),
			        Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dimg);
			label.setIcon(icon);
			
		}
		
	}


	/**
	 * Create the frame.
	 */
	public Addmember() {

	}
	public Addmember(int tid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1080,720);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Member");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MemberInfo member = new MemberInfo(tid, table);
				member.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNewButton.setBounds(804, 21, 229, 115);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectRow = table.getSelectedRow();
				if (selectRow >= 0) {
					TableModel model = table.getModel();
					Updateinfo update = new Updateinfo(getMID() , tid,table);
					update.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"<html><font face='Arial' size='8' color='blue'>No player is selected");
				}
				

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(79, 581, 185, 63);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Display");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement st;
				ResultSet rs;
				String query= "SELECT `name` as `Name`,`height` as `Height (cm)`,`age` as `Age`,`ShirtNumber` as `ShirtNumber` FROM `member` WHERE `tid` = ?";
				try {
					st = DBconnection.getConnection().prepareStatement(query);
					st.setInt(1, tid);
					rs = st.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(38, 24, 229, 115);
		contentPane.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent arg0) {
				int selectRow = table.getSelectedRow();
				String query="DELETE FROM `member` WHERE `mid` = ?";
				PreparedStatement st;
				if(selectRow >= 0) {
				int message = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this player?","Delete",JOptionPane.YES_NO_OPTION);
				if(message == JOptionPane.YES_NO_OPTION) {
					try {
						TableModel model = table.getModel();
						String name = model.getValueAt(selectRow, 0).toString();
						st = DBconnection.getConnection().prepareStatement(query);
						st.setInt(1, getMID());
						if(st.executeUpdate() != 0) {
							JOptionPane.showMessageDialog(null,"Player named : "+name+" is deleted");
							MemberInfo member1 = new MemberInfo(tid,table);
							member1.displayJtableInfo(tid, table);
						}
						else {
							JOptionPane.showMessageDialog(null,"Error deleting player");
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				
				
			}
				else {
						JOptionPane.showMessageDialog(null,"No player is selected");
					}
				}

		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(756, 581, 185, 63);
		contentPane.add(btnNewButton_3);
		

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(23, 149, 1003, 405);
		contentPane.add(scrollPane);
		JTableHeader theader = table.getTableHeader();
		theader.setBackground(Color.pink);
		theader.setForeground(Color.white);
		theader.setFont(new Font("Tahoma", Font.BOLD , 25));
		table.setFont(new Font("Arial",Font.BOLD,20));
		table.setRowHeight(30);
		table.setForeground(Color.yellow);
		table.setBackground(Color.darkGray);
		table.setAlignmentX(CENTER_ALIGNMENT);
		table.setAlignmentY(CENTER_ALIGNMENT);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(270, 0, 533, 149);
		contentPane.add(lblNewLabel);
		try {
			displayImage(lblNewLabel, tid);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		}
		
	}

