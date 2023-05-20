package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import main.GameManager;

import javax.swing.JLabel;
import java.awt.Font;

public class MatchScreen {

	private JFrame frmMatchScreen;
	private GameManager manager;


	public MatchScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmMatchScreen.setVisible(true);
		
	}
	
	public void closeWindow() {
		frmMatchScreen.dispose();
	}
	
	public void finishedWindow() {
		manager.closeMatchScreen(this); 
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchScreen window = new MatchScreen();
					window.frmMatchScreen.setVisible(true);
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
		frmMatchScreen = new JFrame();
		frmMatchScreen.setTitle("VolleyballWorld - Arena");
		frmMatchScreen.setBounds(100, 100, 450, 300);
		frmMatchScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatchScreen.getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(58, 130, 318, 55);
		frmMatchScreen.getContentPane().add(progressBar);
		
		JLabel lblNewLabel = new JLabel("Match In Progress. . .");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(120, 83, 194, 22);
		frmMatchScreen.getContentPane().add(lblNewLabel);
	}
}
