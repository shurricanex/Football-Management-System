package AddStatus;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import InMatch.ObserveMatch;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public JLabel goalTime;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
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
	public Add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGoalBy = new JLabel("Goal by ");
		lblGoalBy.setBounds(170, 24, 51, 29);
		contentPane.add(lblGoalBy);
		
		textField = new JTextField();
		textField.setBounds(160, 78, 75, 74);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblGoalStatus = new JLabel("Goal Status");
		lblGoalStatus.setBounds(155, 206, 80, 16);
		contentPane.add(lblGoalStatus);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 291, 65, 61);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(115, 291, 65, 61);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(208, 291, 65, 61);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(297, 291, 65, 61);
		contentPane.add(panel_3);
//		int myLast = new ObserveMatch().ActionListener().actionPerformed().countMe;

		 goalTime = new JLabel("");
		goalTime.setBounds(97, 30, 61, 16);
		contentPane.add(goalTime);
		//goalTime.setText(myLast+"");
//		public getGt() {
//		}
		
	}
}
