package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class userInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userInterface window = new userInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public userInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1018, 604);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(37, 16, 0, 0);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(42, 16, 0, 0);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to KickHeroes ");
		lblNewLabel.setBounds(141, 132, 829, 164);
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 52));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Press \"Start\" to play!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(401, 281, 233, 49);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnNewButton.setBounds(347, 356, 287, 106);
		frame.getContentPane().add(btnNewButton);
	}
}
