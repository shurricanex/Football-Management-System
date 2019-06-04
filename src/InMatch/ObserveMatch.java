package InMatch;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AddStatus.Add;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JEditorPane;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ObserveMatch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Timer t;
	public  int count;
//	private JLabel myLabel = new Add().goalTime;
		private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObserveMatch frame = new ObserveMatch();
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
	public ObserveMatch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button_3 = new JButton("-");
		button_3.setToolTipText("^");
		button_3.setBounds(606, 116, 25, 24);
		contentPane.add(button_3);
		
		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Add().show();
			}
		});
		btnNewButton_2.setBounds(342, 116, 25, 24);
		contentPane.add(btnNewButton_2);
		
		JButton button_2 = new JButton("+");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(568, 116, 25, 24);
		contentPane.add(button_2);
		
		JButton button_1 = new JButton("-");
		button_1.setBounds(379, 116, 25, 24);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("New label");
		label.setBounds(714, 21, 113, 99);
		contentPane.add(label);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(148, 21, 113, 99);
		contentPane.add(lblNewLabel_3);
		
		JEditorPane editorPane_21 = new JEditorPane();
		editorPane_21.setBounds(568, 37, 64, 67);
		contentPane.add(editorPane_21);
		
		JEditorPane editorPane_22 = new JEditorPane();
		editorPane_22.setBounds(342, 37, 64, 67);
		contentPane.add(editorPane_22);
		
		JLabel footballTimer = new JLabel("\n");
		footballTimer.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		footballTimer.setBackground(new Color(0, 204, 204));
		footballTimer.setForeground(Color.WHITE);
		footballTimer.setBounds(456, 37, 64, 67);
		contentPane.add(footballTimer);
//		contentPane.add(myLabel);

		
		JButton btnNewButton_1 = new JButton("Starts");
		btnNewButton_1.setBackground(new Color(0, 204, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count=0;
			t = new Timer(10000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					count++;
					footballTimer.setText(count+"");
//					myLabel.setText(count+"");
				}
				});
			t.start();
			}
		});
		btnNewButton_1.setAction(action);
		btnNewButton_1.setBounds(431, 97, 42, 22);
		contentPane.add(btnNewButton_1);
		
		JButton btnStop = new JButton("stop");
		btnStop.setBackground(new Color(255, 0, 0));
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.stop();
			}
		});
		btnStop.setAction(action);
		btnStop.setBounds(497, 97, 42, 22);
		contentPane.add(btnStop);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(528, 148, 268, 34);
		contentPane.add(textField_1);
		
		textField = new JTextField();
		textField.setBounds(183, 148, 268, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(284, 203, 25, 22);
		editorPane.setForeground(Color.WHITE);
		editorPane.setBackground(Color.BLACK);
		contentPane.add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(284, 294, 25, 22);
		editorPane_1.setForeground(Color.WHITE);
		editorPane_1.setBackground(Color.BLACK);
		contentPane.add(editorPane_1);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setBounds(284, 483, 25, 22);
		editorPane_3.setForeground(Color.WHITE);
		editorPane_3.setBackground(Color.BLACK);
		contentPane.add(editorPane_3);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(284, 394, 25, 22);
		editorPane_2.setForeground(Color.WHITE);
		editorPane_2.setBackground(Color.BLACK);
		contentPane.add(editorPane_2);
		
		JEditorPane editorPane_4 = new JEditorPane();
		editorPane_4.setBounds(364, 251, 25, 22);
		editorPane_4.setForeground(Color.WHITE);
		editorPane_4.setBackground(Color.BLACK);
		contentPane.add(editorPane_4);
		
		JEditorPane editorPane_5 = new JEditorPane();
		editorPane_5.setBounds(364, 411, 25, 22);
		editorPane_5.setForeground(Color.WHITE);
		editorPane_5.setBackground(Color.BLACK);
		contentPane.add(editorPane_5);
		
		JEditorPane editorPane_6 = new JEditorPane();
		editorPane_6.setBounds(426, 213, 25, 22);
		editorPane_6.setForeground(Color.WHITE);
		editorPane_6.setBackground(Color.BLACK);
		contentPane.add(editorPane_6);
		
		JEditorPane editorPane_7 = new JEditorPane();
		editorPane_7.setBounds(426, 345, 25, 22);
		editorPane_7.setForeground(Color.WHITE);
		editorPane_7.setBackground(Color.BLACK);
		contentPane.add(editorPane_7);
		
		JEditorPane editorPane_8 = new JEditorPane();
		editorPane_8.setBounds(426, 467, 25, 22);
		editorPane_8.setForeground(Color.WHITE);
		editorPane_8.setBackground(Color.BLACK);
		contentPane.add(editorPane_8);
		
		JEditorPane editorPane_9 = new JEditorPane();
		editorPane_9.setBounds(166, 345, 25, 22);
		editorPane_9.setForeground(Color.WHITE);
		editorPane_9.setBackground(Color.BLACK);
		contentPane.add(editorPane_9);
		
		JEditorPane editorPane_10 = new JEditorPane();
		editorPane_10.setBounds(636, 257, 25, 22);
		editorPane_10.setForeground(Color.BLACK);
		editorPane_10.setBackground(Color.LIGHT_GRAY);
		contentPane.add(editorPane_10);
		
		JEditorPane editorPane_11 = new JEditorPane();
		editorPane_11.setBounds(636, 345, 25, 22);
		editorPane_11.setForeground(Color.BLACK);
		editorPane_11.setBackground(Color.LIGHT_GRAY);
		contentPane.add(editorPane_11);
		
		JEditorPane editorPane_12 = new JEditorPane();
		editorPane_12.setBounds(712, 305, 25, 22);
		editorPane_12.setForeground(Color.BLACK);
		editorPane_12.setBackground(Color.LIGHT_GRAY);
		contentPane.add(editorPane_12);
		
		JEditorPane editorPane_13 = new JEditorPane();
		editorPane_13.setBounds(714, 213, 25, 22);
		editorPane_13.setForeground(Color.BLACK);
		editorPane_13.setBackground(Color.LIGHT_GRAY);
		contentPane.add(editorPane_13);
		
		JEditorPane editorPane_14 = new JEditorPane();
		editorPane_14.setBounds(712, 398, 25, 22);
		editorPane_14.setForeground(Color.BLACK);
		editorPane_14.setBackground(Color.LIGHT_GRAY);
		contentPane.add(editorPane_14);
		
		JEditorPane editorPane_15 = new JEditorPane();
		editorPane_15.setBounds(712, 480, 25, 22);
		editorPane_15.setForeground(Color.BLACK);
		editorPane_15.setBackground(Color.LIGHT_GRAY);
		contentPane.add(editorPane_15);
		
		JEditorPane editorPane_16 = new JEditorPane();
		editorPane_16.setBounds(789, 345, 25, 22);
		editorPane_16.setForeground(Color.BLACK);
		editorPane_16.setBackground(Color.LIGHT_GRAY);
		contentPane.add(editorPane_16);
		
		JEditorPane editorPane_17 = new JEditorPane();
		editorPane_17.setBounds(543, 345, 25, 22);
		editorPane_17.setForeground(Color.BLACK);
		editorPane_17.setBackground(Color.LIGHT_GRAY);
		contentPane.add(editorPane_17);
		
		JEditorPane editorPane_18 = new JEditorPane();
		editorPane_18.setBounds(543, 257, 25, 22);
		editorPane_18.setForeground(Color.BLACK);
		editorPane_18.setBackground(Color.LIGHT_GRAY);
		contentPane.add(editorPane_18);
		
		JEditorPane editorPane_19 = new JEditorPane();
		editorPane_19.setBounds(543, 438, 25, 22);
		editorPane_19.setForeground(Color.BLACK);
		editorPane_19.setBackground(Color.LIGHT_GRAY);
		contentPane.add(editorPane_19);
		
		JEditorPane editorPane_20 = new JEditorPane();
		editorPane_20.setBounds(636, 438, 25, 22);
		editorPane_20.setForeground(Color.BLACK);
		editorPane_20.setBackground(Color.LIGHT_GRAY);
		contentPane.add(editorPane_20);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(145, 186, 699, 338);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon(ObserveMatch.class.getResource("/img/Screen Shot 2019-05-31 at 9.32.52 AM.png")));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(75, 0, 825, 578);
		lblNewLabel.setIcon(new ImageIcon(ObserveMatch.class.getResource("/img/background_striped_lawn.jpg")));
		contentPane.add(lblNewLabel);
		validate();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 76, 578);
		panel.setBackground(new Color(0, 51, 102));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(115,163,239));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(0,51,102));
			}
		});
		panel_1.setBackground(new Color(0, 51, 102));
		panel_1.setBounds(0, 18, 75, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(12, 0, 50, 50);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(ObserveMatch.class.getResource("/img/icons8-menu-filled-50.png")));
		
		JButton button = new JButton("New button");
		button.setBounds(497, 97, 42, 22);
		contentPane.add(button);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
