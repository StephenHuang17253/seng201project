package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.GameManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class EndScreen {

	private JFrame frmEndScreen;
	private GameManager manager;

	public EndScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmEndScreen.setVisible(true);
	}
	
	public void closeWindow( ) {
		frmEndScreen.dispose();
	}
	
	public void finishedWindow( ) {
		manager.closeEndScreen(this);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndScreen window = new EndScreen();
					window.frmEndScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EndScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEndScreen = new JFrame();
		frmEndScreen.setTitle("KickHeroes - Thanks for playing");
		frmEndScreen.setBounds(100, 100, 658, 548);
		frmEndScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEndScreen.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Game Over\r\n");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 42));
		titleLabel.setBounds(191, 24, 260, 38);
		frmEndScreen.getContentPane().add(titleLabel);
		
		JPanel summaryPanel = new JPanel();
		summaryPanel.setBounds(100, 86, 441, 385);
		frmEndScreen.getContentPane().add(summaryPanel);
		summaryPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Club Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(114, 11, 213, 23);
		summaryPanel.add(lblNewLabel);
		
		JLabel panelLabel = new JLabel("Season Summary");
		panelLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelLabel.setBounds(139, 40, 163, 23);
		summaryPanel.add(panelLabel);
		
		JLabel moneyEarnedLabel = new JLabel("Money earned: $");
		moneyEarnedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyEarnedLabel.setBounds(143, 96, 155, 14);
		summaryPanel.add(moneyEarnedLabel);
		
		JLabel matchesWonLabel = new JLabel("Matches won: ");
		matchesWonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		matchesWonLabel.setBounds(154, 136, 133, 14);
		summaryPanel.add(matchesWonLabel);
		
		JLabel seasonPointsLabel = new JLabel("Season points earned: ");
		seasonPointsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		seasonPointsLabel.setBounds(143, 176, 155, 14);
		summaryPanel.add(seasonPointsLabel);
		
		JLabel bestAthleteLabel = new JLabel("Best Athlete: ");
		bestAthleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bestAthleteLabel.setBounds(143, 218, 155, 14);
		summaryPanel.add(bestAthleteLabel);
		
		JLabel thanksLabel = new JLabel("Thank you for playing!");
		thanksLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		thanksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thanksLabel.setBounds(114, 276, 213, 35);
		summaryPanel.add(thanksLabel);
	}
}
