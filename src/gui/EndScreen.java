package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.Athlete;
import main.GameManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
/**
 * This is the final screen of the game and it is opened at the end of the season.
 * Displays a summary of the season, showing stats such as matches won and poinst earned.
 * @author Stephen Huang
 * @author Jasmine Ong
 *
 */
public class EndScreen {
	/**
	 * The EndScreen frame which contains all the UI elements.
	 */
	private JFrame frmEndScreen;
	/**
	 * The instance of GameManager managing this screen.
	 */
	private GameManager manager;
	/**
	 * Create the application.
	 * Takes an incoming maanger and makes it the manager of the screen
	 * @param incomingManager GameManager
	 */
	public EndScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmEndScreen.setLocationRelativeTo(null);
		frmEndScreen.setVisible(true);
	}
	/**
	 * Close the end screen window.
	 */
	public void closeWindow( ) {
		frmEndScreen.dispose();
	}
	/**
	 * Close this instance of EndScreen using GameManager
	 */
	public void finishedWindow( ) {
		manager.closeEndScreen(this);
	}
	
	/**
	 * Launch the application.
	 * @param args array of command-line arguments for the application
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
		
		JLabel moneyEarnedLabel = new JLabel("Money Earned: $" + manager.getMoneyFormat(manager.getMoneyEarned()));
		moneyEarnedLabel.setVerticalAlignment(SwingConstants.TOP);
		moneyEarnedLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moneyEarnedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyEarnedLabel.setBounds(10, 96, 421, 23);
		summaryPanel.add(moneyEarnedLabel);
		
		JLabel matchesWonLabel = new JLabel("Matches Won: " + manager.getGamesWon());
		matchesWonLabel.setVerticalAlignment(SwingConstants.TOP);
		matchesWonLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		matchesWonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		matchesWonLabel.setBounds(10, 136, 421, 23);
		summaryPanel.add(matchesWonLabel);
		
		JLabel matchesPlayedLabel = new JLabel("Matches Played: " + manager.getGamesPlayed());
		matchesPlayedLabel.setVerticalAlignment(SwingConstants.TOP);
		matchesPlayedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		matchesPlayedLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		matchesPlayedLabel.setBounds(10, 176, 421, 23);
		summaryPanel.add(matchesPlayedLabel);
		
		JLabel seasonLengthLabel = new JLabel("Season Length: " + manager.getTotalWeeks());
		seasonLengthLabel.setVerticalAlignment(SwingConstants.TOP);
		seasonLengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		seasonLengthLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		seasonLengthLabel.setBounds(10, 216, 421, 23);
		summaryPanel.add(seasonLengthLabel);
		
		JLabel seasonPointsLabel = new JLabel("Season Points Earned: " + manager.getSeasonPoints());
		seasonPointsLabel.setVerticalAlignment(SwingConstants.TOP);
		seasonPointsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		seasonPointsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		seasonPointsLabel.setBounds(10, 256, 421, 23);
		summaryPanel.add(seasonPointsLabel); 
		
		Athlete bestAthlete = manager.getBestAthlete();
		JLabel bestAthleteLabel = new JLabel("");
		if (bestAthlete != null) {
			bestAthleteLabel.setText("Best Athlete: " + bestAthlete.getName() + " with (" + bestAthlete.getFaceOffWins() + ") faceoff wins");
		}
		bestAthleteLabel.setVerticalAlignment(SwingConstants.TOP);
		bestAthleteLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bestAthleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bestAthleteLabel.setBounds(10, 296, 421, 23);
		summaryPanel.add(bestAthleteLabel);
		
		JLabel thanksLabel = new JLabel("Thank you for playing!");
		thanksLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		thanksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thanksLabel.setBounds(10, 325, 421, 35);
		summaryPanel.add(thanksLabel);
		
		JLabel winLoseLabel = new JLabel("");
		winLoseLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		winLoseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winLoseLabel.setBounds(10, 65, 622, 22);
		frmEndScreen.getContentPane().add(winLoseLabel);
		if (manager.getCanContinue() == false) {
			winLoseLabel.setText("You Lost. You ran out of Money and Athletes :(");
			winLoseLabel.setForeground(new Color(255, 66, 66));
		}
		else if (manager.getEnoughAthletes() == false) {
			winLoseLabel.setText("You Lost. You ran out Athletes :(");
			winLoseLabel.setForeground(new Color(255, 66, 66));
		}
		else {
			winLoseLabel.setText("You Won!!! Congratulations for completing the season! :D");
			winLoseLabel.setForeground(new Color(0, 128, 0));
		}
	}
}
