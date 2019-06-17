package myMenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {

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
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel_8, "name_54964166452093");
		
		JButton button = new JButton("Record");
		button.setBounds(751, 180, 76, 24);
		panel_8.add(button);
		
		JButton button_1 = new JButton("Record");
		button_1.setBounds(150, 181, 76, 24);
		panel_8.add(button_1);
		
		JButton button_2 = new JButton("-");
		button_2.setToolTipText("^");
		button_2.setBounds(606, 116, 25, 24);
		panel_8.add(button_2);
		
		JButton button_3 = new JButton("+");
		button_3.setBounds(342, 116, 25, 24);
		panel_8.add(button_3);
		
		JButton button_4 = new JButton("+");
		button_4.setBounds(568, 116, 25, 24);
		panel_8.add(button_4);
		
		JButton button_5 = new JButton("-");
		button_5.setBounds(379, 116, 25, 24);
		panel_8.add(button_5);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(714, 21, 113, 99);
		panel_8.add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(148, 21, 113, 99);
		panel_8.add(label_2);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(568, 37, 64, 67);
		panel_8.add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(342, 37, 64, 67);
		panel_8.add(editorPane_1);
		
		JLabel label_3 = new JLabel("\n");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		label_3.setBackground(new Color(0, 204, 204));
		label_3.setBounds(456, 37, 64, 67);
		panel_8.add(label_3);
		
		JButton button_6 = new JButton("Starts");
		button_6.setBackground(new Color(0, 204, 0));
		button_6.setBounds(431, 97, 42, 22);
		panel_8.add(button_6);
		
		JButton button_7 = new JButton("stop");
		button_7.setBackground(Color.RED);
		button_7.setBounds(497, 97, 42, 22);
		panel_8.add(button_7);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(528, 148, 268, 34);
		panel_8.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(183, 148, 268, 34);
		panel_8.add(textField_1);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setForeground(Color.WHITE);
		editorPane_2.setBackground(Color.BLACK);
		editorPane_2.setBounds(284, 203, 25, 22);
		panel_8.add(editorPane_2);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setForeground(Color.WHITE);
		editorPane_3.setBackground(Color.BLACK);
		editorPane_3.setBounds(284, 294, 25, 22);
		panel_8.add(editorPane_3);
		
		JEditorPane editorPane_4 = new JEditorPane();
		editorPane_4.setForeground(Color.WHITE);
		editorPane_4.setBackground(Color.BLACK);
		editorPane_4.setBounds(284, 483, 25, 22);
		panel_8.add(editorPane_4);
		
		JEditorPane editorPane_5 = new JEditorPane();
		editorPane_5.setForeground(Color.WHITE);
		editorPane_5.setBackground(Color.BLACK);
		editorPane_5.setBounds(284, 394, 25, 22);
		panel_8.add(editorPane_5);
		
		JEditorPane editorPane_6 = new JEditorPane();
		editorPane_6.setForeground(Color.WHITE);
		editorPane_6.setBackground(Color.BLACK);
		editorPane_6.setBounds(364, 251, 25, 22);
		panel_8.add(editorPane_6);
		
		JEditorPane editorPane_7 = new JEditorPane();
		editorPane_7.setForeground(Color.WHITE);
		editorPane_7.setBackground(Color.BLACK);
		editorPane_7.setBounds(364, 411, 25, 22);
		panel_8.add(editorPane_7);
		
		JEditorPane editorPane_8 = new JEditorPane();
		editorPane_8.setForeground(Color.WHITE);
		editorPane_8.setBackground(Color.BLACK);
		editorPane_8.setBounds(426, 213, 25, 22);
		panel_8.add(editorPane_8);
		
		JEditorPane editorPane_9 = new JEditorPane();
		editorPane_9.setForeground(Color.WHITE);
		editorPane_9.setBackground(Color.BLACK);
		editorPane_9.setBounds(426, 345, 25, 22);
		panel_8.add(editorPane_9);
		
		JEditorPane editorPane_10 = new JEditorPane();
		editorPane_10.setForeground(Color.WHITE);
		editorPane_10.setBackground(Color.BLACK);
		editorPane_10.setBounds(426, 467, 25, 22);
		panel_8.add(editorPane_10);
		
		JEditorPane editorPane_11 = new JEditorPane();
		editorPane_11.setForeground(Color.WHITE);
		editorPane_11.setBackground(Color.BLACK);
		editorPane_11.setBounds(166, 345, 25, 22);
		panel_8.add(editorPane_11);
		
		JEditorPane editorPane_12 = new JEditorPane();
		editorPane_12.setForeground(Color.BLACK);
		editorPane_12.setBackground(Color.LIGHT_GRAY);
		editorPane_12.setBounds(636, 257, 25, 22);
		panel_8.add(editorPane_12);
		
		JEditorPane editorPane_13 = new JEditorPane();
		editorPane_13.setForeground(Color.BLACK);
		editorPane_13.setBackground(Color.LIGHT_GRAY);
		editorPane_13.setBounds(636, 345, 25, 22);
		panel_8.add(editorPane_13);
		
		JEditorPane editorPane_14 = new JEditorPane();
		editorPane_14.setForeground(Color.BLACK);
		editorPane_14.setBackground(Color.LIGHT_GRAY);
		editorPane_14.setBounds(712, 305, 25, 22);
		panel_8.add(editorPane_14);
		
		JEditorPane editorPane_15 = new JEditorPane();
		editorPane_15.setForeground(Color.BLACK);
		editorPane_15.setBackground(Color.LIGHT_GRAY);
		editorPane_15.setBounds(714, 213, 25, 22);
		panel_8.add(editorPane_15);
		
		JEditorPane editorPane_16 = new JEditorPane();
		editorPane_16.setForeground(Color.BLACK);
		editorPane_16.setBackground(Color.LIGHT_GRAY);
		editorPane_16.setBounds(712, 398, 25, 22);
		panel_8.add(editorPane_16);
		
		JEditorPane editorPane_17 = new JEditorPane();
		editorPane_17.setForeground(Color.BLACK);
		editorPane_17.setBackground(Color.LIGHT_GRAY);
		editorPane_17.setBounds(712, 480, 25, 22);
		panel_8.add(editorPane_17);
		
		JEditorPane editorPane_18 = new JEditorPane();
		editorPane_18.setForeground(Color.BLACK);
		editorPane_18.setBackground(Color.LIGHT_GRAY);
		editorPane_18.setBounds(789, 345, 25, 22);
		panel_8.add(editorPane_18);
		
		JEditorPane editorPane_19 = new JEditorPane();
		editorPane_19.setForeground(Color.BLACK);
		editorPane_19.setBackground(Color.LIGHT_GRAY);
		editorPane_19.setBounds(543, 345, 25, 22);
		panel_8.add(editorPane_19);
		
		JEditorPane editorPane_20 = new JEditorPane();
		editorPane_20.setForeground(Color.BLACK);
		editorPane_20.setBackground(Color.LIGHT_GRAY);
		editorPane_20.setBounds(543, 257, 25, 22);
		panel_8.add(editorPane_20);
		
		JEditorPane editorPane_21 = new JEditorPane();
		editorPane_21.setForeground(Color.BLACK);
		editorPane_21.setBackground(Color.LIGHT_GRAY);
		editorPane_21.setBounds(543, 438, 25, 22);
		panel_8.add(editorPane_21);
		
		JEditorPane editorPane_22 = new JEditorPane();
		editorPane_22.setForeground(Color.BLACK);
		editorPane_22.setBackground(Color.LIGHT_GRAY);
		editorPane_22.setBounds(636, 438, 25, 22);
		panel_8.add(editorPane_22);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Menu.class.getResource("/img/Screen Shot 2019-05-31 at 9.32.52 AM.png")));
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(145, 186, 699, 338);
		panel_8.add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setIcon(new ImageIcon(Menu.class.getResource("/img/background_striped_lawn.jpg")));
		label_5.setBounds(75, -11, 815, 589);
		panel_8.add(label_5);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBackground(new Color(0, 51, 102));
		contentPane.add(panel, "name_54964175415993");
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(0, 51, 102));
		panel_9.setBounds(0, 0, 76, 578);
		panel_8.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(0, 51, 102));
		panel_10.setBounds(0, 18, 75, 50);
		panel_9.add(panel_10);
		
		JLabel label_6 = new JLabel("");
		

		
		label_6.setIcon(new ImageIcon(Menu.class.getResource("/img/icons8-menu-filled-50.png")));
		label_6.setBounds(12, 0, 50, 50);
		panel_10.add(label_6);
		
		JButton button_8 = new JButton("New button");
		button_8.setBounds(497, 97, 42, 22);
		panel_8.add(button_8);
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(0, 51, 102));
		panel_7.setBounds(0, 18, 75, 50);
		panel.add(panel_7);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Menu.class.getResource("/img/icons8-menu-filled-50.png")));
		label.setBounds(12, 0, 50, 50);
		panel_7.add(label);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBackground(new Color(204, 204, 204));
		contentPane.add(panel_5, "name_54964195979851");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(63, 0, 827, 85);
		
		JLabel lblFootballManagementSystem = new JLabel("SoccerX");
		lblFootballManagementSystem.setBounds(82, 97, 467, 165);
		lblFootballManagementSystem.setFont(new Font("Nunito", Font.BOLD, 99));
		panel_5.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(63, 298, 827, 270);
		panel_5.add(panel_1);
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
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
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
					.addGap(112)
					.addComponent(lblS, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
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
		panel_5.add(panel_6);
		panel_5.add(lblFootballManagementSystem);
		
		JPanel panel_11 = new JPanel();
		contentPane.add(panel_11, "name_61919408412833");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(panel_5);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(panel_8);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
	}
	
}
