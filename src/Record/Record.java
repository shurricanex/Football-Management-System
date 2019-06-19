package Record;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Record extends JFrame {
   
	private JPanel contentPane;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Record frame = new Record();
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
	public Record() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 388, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(0, 0, 388, 387);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(194, 5, 0, 16);
		panel.add(textPane);
		
		JLabel lblNewLabel = new JLabel("Card");
		lblNewLabel.setBounds(174, 26, 61, 16);
		panel.add(lblNewLabel);
		
		JLabel lblSubstituteWith = new JLabel("Substitution");
		lblSubstituteWith.setBounds(152, 209, 103, 16);
		panel.add(lblSubstituteWith);
		
		JLabel lblSubstitionWith = new JLabel("Substition with");
		lblSubstitionWith.setBounds(63, 256, 103, 16);
		panel.add(lblSubstitionWith);
		
		textField = new JTextField();
		textField.setBounds(194, 253, 61, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Confirm");
//		btnNewButton_1.addMouseListener(new MouseAdapter() {
//			
////			public void mouseClicked(MouseEvent e) {
////				
////					frame.dispose();
////				
////			}
//		});
	
		
		
		btnNewButton_1.setBounds(141, 323, 117, 29);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 54, 331, 128);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Yellow card");
		lblNewLabel_2.setBounds(23, 32, 89, 16);
		panel_1.add(lblNewLabel_2);
		
		JLabel label = new JLabel("New label");
		label.setBounds(125, 32, 61, 16);
		panel_1.add(label);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setBounds(225, 27, 44, 29);
		panel_1.add(btnNewButton);
		
		JButton button = new JButton("-");
		button.setBounds(269, 27, 44, 29);
		panel_1.add(button);
		
		JLabel lblRedCard = new JLabel("Red card");
		lblRedCard.setBounds(42, 78, 89, 16);
		panel_1.add(lblRedCard);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(125, 78, 61, 16);
		panel_1.add(label_1);
		
		JButton button_2 = new JButton("-");
		button_2.setBounds(269, 73, 44, 29);
		panel_1.add(button_2);
		
		JButton button_1 = new JButton("+");
		button_1.setBounds(225, 73, 44, 29);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(30, 231, 331, 73);
		panel.add(panel_2);
	}
	private void keyPressed(KeyEvent evt) {
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
         System.out.println("Entered and close");
        	

        }
        };
		
}
