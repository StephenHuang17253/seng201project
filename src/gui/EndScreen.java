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
		
		JLabel teamLabel = new JLabel(manager.getTeamName() + " Sports Club");
		teamLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamLabel.setBounds(10, 11, 421, 34);
		summaryPanel.add(teamLabel);
		
		JLabel panelLabel = new JLabel("Season Summary");
		panelLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelLabel.setBounds(139, 44, 163, 23);
		summaryPanel.add(panelLabel);
		
		JLabel moneyEarnedLabel = new JLabel("Money earned: $");
		moneyEarnedLabel.setVerticalAlignment(SwingConstants.TOP);
		moneyEarnedLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moneyEarnedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyEarnedLabel.setBounds(10, 96, 421, 23);
		summaryPanel.add(moneyEarnedLabel);
		
		JLabel matchesWonLabel = new JLabel("Matches won: ");
		matchesWonLabel.setVerticalAlignment(SwingConstants.TOP);
		matchesWonLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		matchesWonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		matchesWonLabel.setBounds(10, 136, 421, 23);
		summaryPanel.add(matchesWonLabel);
		
		JLabel seasonPointsLabel = new JLabel("Season points earned: " + manager.getSeasonPoints());
		seasonPointsLabel.setVerticalAlignment(SwingConstants.TOP);
		seasonPointsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		seasonPointsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		seasonPointsLabel.setBounds(10, 176, 421, 23);
		summaryPanel.add(seasonPointsLabel); 
		
		JLabel bestAthleteLabel = new JLabel("Best Athlete: ");
		bestAthleteLabel.setVerticalAlignment(SwingConstants.TOP);
		bestAthleteLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bestAthleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bestAthleteLabel.setBounds(10, 218, 421, 23);
		summaryPanel.add(bestAthleteLabel);
		
		JLabel thanksLabel = new JLabel("Thank you for playing!");
		thanksLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		thanksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thanksLabel.setBounds(114, 276, 213, 35);
		summaryPanel.add(thanksLabel);
	}
}
