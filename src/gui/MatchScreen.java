package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import main.Athlete;
import main.GameManager;
import main.Match;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This is the screen that displays the outcome of a Match and the individual Athlete faceoffs that constitute a Match.
 * @author Stephen Huang
 *
 */
public class MatchScreen {
	/**
	 * The MatchScreen frame in which all UI elements are contained.
	 */
	private JFrame frmMatchScreen;
	/**
	 * The instance of GameManager which manages this screen.
	 */
	private GameManager manager;
	/**
	 * The ArrayList that will store the player's Athletes.
	 */
	private ArrayList<Athlete> playerTeam;
	/**
	 * The ArrayList will that store the opponent's Athletes.
	 */
	private ArrayList<Athlete> opponentTeam;
	/**
	 * The Match object representing the Match being played.
	 */
	private Match match;

	/**
	 * Create the Application.
	 * Takes an incoming manager and makes it the manager of the screen.
	 * Takes an incoming Match to display.
	 * Set teams using manager.
	 * @param incomingManager the GameManager
	 * @param incomingMatch the Match
	 */
	public MatchScreen(GameManager incomingManager, Match incomingMatch) {
		manager = incomingManager;
		playerTeam = manager.getMainRoster();
		opponentTeam = manager.getOpponentRoster();
		match = incomingMatch;
		//System.out.println(playerTeam);
		//System.out.println(opponentTeam);
		initialize();
		frmMatchScreen.setVisible(true);
		
	}
	/**
	 * Close the match screen window.
	 */
	public void closeWindow() {
		frmMatchScreen.dispose();
	}
	/**
	 * Close this instance of the MatchScreen using GameManager
	 */
	public void finishedWindow() {
		manager.closeMatchScreen(this); 
	}
	
	/**
	 * Launch the application.
	 * @param args an array of command-line arguments for the application
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
		frmMatchScreen.setTitle("KickHeroes - " + manager.getTeamName() + " vs " + manager.getOpponentName());
		frmMatchScreen.setBounds(100, 100, 727, 621);
		frmMatchScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatchScreen.getContentPane().setLayout(null);
		
		JLabel headerLabel = new JLabel(manager.getTeamName() + " vs " + manager.getOpponentName());
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		headerLabel.setBounds(92, 11, 527, 44);
		frmMatchScreen.getContentPane().add(headerLabel);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBounds(80, 132, 225, 360);
		frmMatchScreen.getContentPane().add(playerPanel);
		playerPanel.setLayout(null);
		
		Athlete teamStriker = null;
		Athlete teamLeftWing = null;
		Athlete teamRightWing = null;
		Athlete teamDefender = null;
		Athlete teamKeeper = null;
		
		for (Athlete athlete : manager.getMainRoster()) {
			
			switch(athlete.getPosition()) {
			 	case "Striker":
			 		teamStriker = athlete;
			 		break;
			 	case "Left Wing":
			 		teamLeftWing = athlete;
			 		break;
			 	case "Right Wing":
			 		teamRightWing = athlete;
			 		break;
			    case "Defender":
			    	teamDefender = athlete;
			    	break;
			    case "Keeper":
			    	teamKeeper = athlete;
			    	break;
			}
		}
		
		JLabel strikerLabel1 = new JLabel("Striker: " + teamStriker.getName() + " (" + teamStriker.getProficiency() + ")");
		strikerLabel1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		strikerLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		strikerLabel1.setBounds(10, 77, 205, 14);
		playerPanel.add(strikerLabel1);
		
		
		JLabel strikerMatchupLabel = new JLabel(teamStriker.getMatchUpResult());
		strikerMatchupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		if (teamStriker.getMatchUpResult() == "Won faceoff") {
			strikerMatchupLabel.setForeground(new Color(0, 128, 0));
		} else {
			strikerMatchupLabel.setForeground(new Color(255, 66, 66));
		}
		strikerMatchupLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		strikerMatchupLabel.setBounds(66, 92, 92, 15);
		playerPanel.add(strikerMatchupLabel);
		
		JLabel leftWingLabel = new JLabel("Left Wing: " + teamLeftWing.getName() + " (" + teamLeftWing.getProficiency() + ")");
		leftWingLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		leftWingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftWingLabel.setBounds(10, 133, 205, 14);
		playerPanel.add(leftWingLabel);
		
		JLabel leftWingMatchupLabel = new JLabel(teamLeftWing.getMatchUpResult());
		leftWingMatchupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftWingMatchupLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		if (teamLeftWing.getMatchUpResult() == "Won faceoff") {
			leftWingMatchupLabel.setForeground(new Color(0, 128, 0));
		} else {
			leftWingMatchupLabel.setForeground(new Color(255, 66, 66));
		}
		leftWingMatchupLabel.setBounds(66, 148, 92, 15);
		playerPanel.add(leftWingMatchupLabel);		
		
		JLabel rightWingLabel = new JLabel("Right Wing: " + teamRightWing.getName() + " (" + teamRightWing.getProficiency() + ")");
		rightWingLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rightWingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightWingLabel.setBounds(10, 190, 205, 14);
		playerPanel.add(rightWingLabel);
		
		JLabel rightWingMatchupLabel = new JLabel(teamRightWing.getMatchUpResult());
		rightWingMatchupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		if (teamRightWing.getMatchUpResult() == "Won faceoff") {
			rightWingMatchupLabel.setForeground(new Color(0, 128, 0));
		} else {
			rightWingMatchupLabel.setForeground(new Color(255, 66, 66));
		}
		rightWingMatchupLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		rightWingMatchupLabel.setBounds(66, 205, 92, 15);
		playerPanel.add(rightWingMatchupLabel);	
		
		JLabel defenderLabel = new JLabel("Defender: " + teamDefender.getName() + " (" + teamDefender.getProficiency() + ")");
		defenderLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		defenderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defenderLabel.setBounds(10, 245, 205, 14);
		playerPanel.add(defenderLabel);
		
		JLabel defenderMatchupLabel = new JLabel(teamDefender.getMatchUpResult());
		defenderMatchupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defenderMatchupLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		if (teamDefender.getMatchUpResult() == "Won faceoff") {
			defenderMatchupLabel.setForeground(new Color(0, 128, 0));
		} else {
			defenderMatchupLabel.setForeground(new Color(255, 66, 66));
		}
		defenderMatchupLabel.setBounds(66, 260, 92, 15);
		playerPanel.add(defenderMatchupLabel);	
		
		JLabel keeperLabel = new JLabel("Keeper: " + teamKeeper.getName() + " (" + teamKeeper.getProficiency() + ")");
		keeperLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		keeperLabel.setHorizontalAlignment(SwingConstants.CENTER);
		keeperLabel.setBounds(10, 300, 205, 14);
		playerPanel.add(keeperLabel);
		
		JLabel keeperMatchupLabel = new JLabel("" + teamKeeper.getMatchUpResult());
		keeperMatchupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		keeperMatchupLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		if (teamKeeper.getMatchUpResult() == "Won faceoff") {
			keeperMatchupLabel.setForeground(new Color(0, 128, 0));
		} else {
			keeperMatchupLabel.setForeground(new Color(255, 66, 66));
		}
		keeperMatchupLabel.setBounds(66, 315, 92, 15);
		playerPanel.add(keeperMatchupLabel);	
		
		JLabel playerTeamName = new JLabel("Your Team");
		playerTeamName.setText(manager.getTeamName());
		playerTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		playerTeamName.setBounds(10, 30, 205, 14);
		playerPanel.add(playerTeamName);
		
		JLabel playerScoreLabel = new JLabel("Score: " + match.getPlayerScore());
		playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerScoreLabel.setBounds(66, 5, 92, 14);
		playerPanel.add(playerScoreLabel);
		
		JPanel opponentPanel = new JPanel();
		opponentPanel.setLayout(null);
		opponentPanel.setBounds(415, 132, 225, 360);
		frmMatchScreen.getContentPane().add(opponentPanel);
		
		JLabel opponentLabel1 = new JLabel("Striker: " + opponentTeam.get(0).getName() + " (" + opponentTeam.get(0).getProficiency() + ")");
		opponentLabel1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		opponentLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel1.setBounds(10, 77, 205, 14);
		opponentPanel.add(opponentLabel1);
		
		JLabel opponentLabel2 = new JLabel("Left Wing: " + opponentTeam.get(1).getName() + " (" + opponentTeam.get(1).getProficiency() + ")");
		opponentLabel2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		opponentLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel2.setBounds(10, 133, 205, 14);
		opponentPanel.add(opponentLabel2);
		
		JLabel opponentLabel3 = new JLabel("Right Wing: " + opponentTeam.get(2).getName() + " (" + opponentTeam.get(2).getProficiency() + ")");
		opponentLabel3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		opponentLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel3.setBounds(10, 190, 205, 14);
		opponentPanel.add(opponentLabel3);
		
		JLabel opponentLabel4 = new JLabel("Defender: " + opponentTeam.get(3).getName() + " (" + opponentTeam.get(3).getProficiency() + ")");
		opponentLabel4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		opponentLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel4.setBounds(10, 245, 205, 14);
		opponentPanel.add(opponentLabel4);
		
		JLabel opponentLabel5 = new JLabel("Keeper: " + opponentTeam.get(4).getName() + " (" + opponentTeam.get(4).getProficiency() + ")");
		opponentLabel5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		opponentLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel5.setBounds(10, 300, 205, 14);
		opponentPanel.add(opponentLabel5);
		
		JLabel opponentName = new JLabel("Opponent");
		opponentName.setText(manager.getOpponentName());
		opponentName.setHorizontalAlignment(SwingConstants.CENTER);
		opponentName.setBounds(10, 30, 205, 14);
		opponentPanel.add(opponentName);
		
		JLabel opponentScoreLabel = new JLabel("Score: " + match.getOpponentScore());
		opponentScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		opponentScoreLabel.setBounds(78, 5, 69, 14);
		opponentPanel.add(opponentScoreLabel);
		
		JLabel outcomeHighlight = new JLabel("The winner of this match...");
		outcomeHighlight.setHorizontalAlignment(SwingConstants.CENTER);
		outcomeHighlight.setFont(new Font("Tahoma", Font.BOLD, 12)); 
		outcomeHighlight.setBounds(250, 66, 211, 14);
		frmMatchScreen.getContentPane().add(outcomeHighlight);		
		
		JLabel outcomeLabel = new JLabel("Victory Text");
		outcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		outcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outcomeLabel.setBounds(158, 76, 394, 45);
		frmMatchScreen.getContentPane().add(outcomeLabel);
		
		if (match.getOutcome() == "Victory") {
			outcomeLabel.setText(manager.getTeamName());
			outcomeLabel.setForeground(new Color(0, 128, 0));			
		} else if (match.getOutcome() == "Defeat (Stamina)") {
			outcomeLabel.setText(manager.getOpponentName());
			outcomeLabel.setForeground(new Color(255, 66, 66));	
			Object message = "All of your athletes were injured during the match " + manager.getOpponentName()
			 + "\nAs a result you were forced to forfeit. ";
			Component forfeitMatch = null;
			JOptionPane.showMessageDialog(forfeitMatch, message, "Match concluded", JOptionPane.WARNING_MESSAGE);	
		} else {
			outcomeLabel.setText(manager.getOpponentName());
			outcomeLabel.setForeground(new Color(255, 66, 66));				
		}
		
		JButton backButton = new JButton("Go back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (match.getOutcome() == "Victory") {
					if (manager.getDifficulty() == "Normal") {
						Object message = "Congrulations on winning the match against " + manager.getOpponentName()
						 + "\nPrize winnings: " + match.createPrizeString(match.getPrizeMoney())
						 + "\nSeason points earned: " + match.getPointGain();
						Component newWeekFrame = null;
						JOptionPane.showMessageDialog(newWeekFrame, message, "Match concluded", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						Object message = "Congrulations on winning the match against " + manager.getOpponentName()
						 + "\nPrize winnings: " + match.createPrizeString(match.getPrizeMoney())
						 + "\nSeason points earned: " + match.getPointGain() + " + 5"
						 + "\nYou earned an extra 5 points for hard difficulty!";
						Component newWeekFrame = null;
						JOptionPane.showMessageDialog(newWeekFrame, message, "Match concluded", JOptionPane.INFORMATION_MESSAGE);
					}
							
				}
				finishedWindow();
				manager.launchStadiumScreen();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		backButton.setBounds(231, 513, 250, 50);
		frmMatchScreen.getContentPane().add(backButton);
		
	}
}
