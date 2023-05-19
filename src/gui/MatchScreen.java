package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class MatchScreen {

	private JFrame frmMatch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchScreen window = new MatchScreen();
					window.frmMatch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MatchScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMatch = new JFrame();
		frmMatch.setTitle("Arena");
		frmMatch.setBounds(100, 100, 450, 300);
		frmMatch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatch.getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(58, 130, 318, 55);
		frmMatch.getContentPane().add(progressBar);
		
		JLabel lblNewLabel = new JLabel("Match In Progress. . .");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(120, 83, 194, 22);
		frmMatch.getContentPane().add(lblNewLabel);
	}
}
