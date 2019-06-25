package Fixture;

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

import Home.DBconnection;
import myMenu.Menu;
import net.proteanit.sql.DbUtils;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class AddMatch extends JFrame {

	private JPanel contentPane;
	public JTable tableMatch;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//instantiate Addmatch obj
					AddMatch frame = new AddMatch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
//get MID from selected row in table 
	public int getMID() {
		int mid=0;
		int selectRow = tableMatch.getSelectedRow();
		TableModel model = tableMatch.getModel();
	   // get name from the o index in the row  
		String name = model.getValueAt(selectRow, 0).toString();
		//? where will we put the value of name into
		String query= "SELECT `mid` FROM `member` WHERE `name` = ?";
		PreparedStatement st;
		ResultSet rs;
		try {
			st = DBconnection.getConnection().prepareStatement(query);
			//here we put it
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


	/**
	 * Create the frame.
	 */
	public AddMatch() {

	}
	
	
	public AddMatch(int tid) {
		//new JFrame window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1080,720);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Add Member
		JButton btnNewButton = new JButton("Add Member");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatchInfo member = new MatchInfo(tid, tableMatch);
				member.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNewButton.setBounds(804, 21, 229, 115);
		contentPane.add(btnNewButton);
		//End Add Member
		
		//Edit
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectRow = tableMatch.getSelectedRow();
				if (selectRow >= 0) {
					TableModel model = tableMatch.getModel();
					UpdateMatch update = new UpdateMatch(selectRow , model , getMID() , tableMatch , tid);
					update.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"<html><font face='Arial' size='8' color='blue'>No match is selected");
				}
				

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(79, 581, 185, 63);
		contentPane.add(btnNewButton_1);
		//End Edit
		
		//Display
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
					tableMatch.setModel(DbUtils.resultSetToTableModel(rs));
					 
				

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(38, 24, 229, 115);
		contentPane.add(btnNewButton_2);
		//end Display 
		
		//Delete
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent arg0) {
				int selectRow = tableMatch.getSelectedRow();
				String query="DELETE FROM `member` WHERE `mid` = ?";
				PreparedStatement st;
				if(selectRow >= 0) {
				int message = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this player?","Delete",JOptionPane.YES_NO_OPTION);
				if(message == JOptionPane.YES_NO_OPTION) {
					try {
						TableModel model = tableMatch.getModel();
						String name = model.getValueAt(selectRow, 0).toString();
						st = DBconnection.getConnection().prepareStatement(query);
						st.setInt(1, getMID());
						if(st.executeUpdate() != 0) {
							JOptionPane.showMessageDialog(null,"Player named : "+name+" is deleted");
							MatchInfo member1 = new MatchInfo(tid,tableMatch);
							member1.displayJtableInfo(tid, tableMatch);
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
		
// End Delete
		
		//Component Table , ScrollPane
		tableMatch = new JTable();
		JScrollPane scrollPane = new JScrollPane(tableMatch);
		scrollPane.setBounds(23, 149, 1003, 405);
		contentPane.add(scrollPane);
		JTableHeader theader = tableMatch.getTableHeader();
		theader.setBackground(Color.pink);
		theader.setForeground(Color.white);
		theader.setFont(new Font("Tahoma", Font.BOLD , 25));
		tableMatch.setFont(new Font("Arial",Font.BOLD,20));
		tableMatch.setRowHeight(30);
		tableMatch.setForeground(Color.yellow);
		tableMatch.setBackground(Color.darkGray);
		tableMatch.setAlignmentX(CENTER_ALIGNMENT);
		tableMatch.setAlignmentY(CENTER_ALIGNMENT);
		scrollPane.setViewportView(tableMatch);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		}
		//End JFrame window
	}

