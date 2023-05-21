package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import main.Athlete;
import main.GameManager;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;

public class MatchScreen {

	private JFrame frmMatchScreen;
	private GameManager manager;
	private ArrayList<Athlete> playerTeam;
	private ArrayList<Athlete> opponentTeam;


	public MatchScreen(GameManager incomingManager) {
		manager = incomingManager;
		playerTeam = manager.getMainRoster();
		opponentTeam = manager.getOpponentRoster();
		System.out.println(playerTeam);
		System.out.println(opponentTeam);
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
		playerPanel.setBounds(87, 122, 225, 380);
		frmMatchScreen.getContentPane().add(playerPanel);
		playerPanel.setLayout(null);
		
		JLabel strikerLabel1 = new JLabel("Striker:" + playerTeam.get(0).getName());
		strikerLabel1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		strikerLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		strikerLabel1.setBounds(10, 98, 205, 14);
		playerPanel.add(strikerLabel1);
		
		JLabel strikerMatchupLabel = new JLabel(playerTeam.get(0).getMatchUpResult());
		if (playerTeam.get(0).getMatchUpResult() == "Won faceoff") {
			strikerMatchupLabel.setForeground(new Color(0, 128, 0));
		} else {
			strikerMatchupLabel.setForeground(new Color(255, 66, 66));
		}
		strikerMatchupLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		strikerMatchupLabel.setBounds(123, 118, 92, 14);
		playerPanel.add(strikerMatchupLabel);
		
		JLabel leftWingLabel2 = new JLabel("Left Wing: " + playerTeam.get(1).getName());
		leftWingLabel2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		leftWingLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		leftWingLabel2.setBounds(10, 154, 205, 14);
		playerPanel.add(leftWingLabel2);
		
		JLabel leftWingMatchupLabel = new JLabel(playerTeam.get(1).getMatchUpResult());
		leftWingMatchupLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		if (playerTeam.get(1).getMatchUpResult() == "Won faceoff") {
			leftWingMatchupLabel.setForeground(new Color(0, 128, 0));
		} else {
			leftWingMatchupLabel.setForeground(new Color(255, 66, 66));
		}
		leftWingMatchupLabel.setBounds(123, 179, 92, 14);
		playerPanel.add(leftWingMatchupLabel);		
		
		JLabel rightWingLabel3 = new JLabel("Right Wing: " + playerTeam.get(2).getName());
		rightWingLabel3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rightWingLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		rightWingLabel3.setBounds(10, 210, 205, 14);
		playerPanel.add(rightWingLabel3);
		
		JLabel rightWingMatchupLabel = new JLabel(playerTeam.get(2).getMatchUpResult());
		if (playerTeam.get(2).getMatchUpResult() == "Won faceoff") {
			rightWingMatchupLabel.setForeground(new Color(0, 128, 0));
		} else {
			rightWingMatchupLabel.setForeground(new Color(255, 66, 66));
		}
		rightWingMatchupLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		rightWingMatchupLabel.setBounds(123, 230, 92, 14);
		playerPanel.add(rightWingMatchupLabel);	
		
		JLabel defenderLabel4 = new JLabel("Defender: " + playerTeam.get(3).getName());
		defenderLabel4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		defenderLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		defenderLabel4.setBounds(10, 266, 205, 14);
		playerPanel.add(defenderLabel4);
		
		JLabel defenderMatchupLabel = new JLabel(playerTeam.get(3).getMatchUpResult());
		defenderMatchupLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		if (playerTeam.get(3).getMatchUpResult() == "Won faceoff") {
			defenderMatchupLabel.setForeground(new Color(0, 128, 0));
		} else {
			defenderMatchupLabel.setForeground(new Color(255, 66, 66));
		}
		defenderMatchupLabel.setBounds(123, 286, 92, 14);
		playerPanel.add(defenderMatchupLabel);	
		
		JLabel keeperLabel5 = new JLabel("Keeper: " + playerTeam.get(4).getName());
		keeperLabel5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		keeperLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		keeperLabel5.setBounds(10, 322, 205, 14);
		playerPanel.add(keeperLabel5);
		
		JLabel keeperMatchupLabel = new JLabel(playerTeam.get(4).getMatchUpResult());
		keeperMatchupLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		if (playerTeam.get(4).getMatchUpResult() == "Won faceoff") {
			keeperMatchupLabel.setForeground(new Color(0, 128, 0));
		} else {
			keeperMatchupLabel.setForeground(new Color(255, 66, 66));
		}
		keeperMatchupLabel.setBounds(123, 342, 92, 14);
		playerPanel.add(keeperMatchupLabel);	
		
		JLabel playerTeamName = new JLabel("Your Team");
		playerTeamName.setText(manager.getTeamName());
		playerTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		playerTeamName.setBounds(10, 42, 205, 14);
		playerPanel.add(playerTeamName);
		
		JPanel opponentPanel = new JPanel();
		opponentPanel.setLayout(null);
		opponentPanel.setBounds(399, 122, 225, 380);
		frmMatchScreen.getContentPane().add(opponentPanel);
		
		JLabel opponentLabel1_1 = new JLabel("Striker: " + opponentTeam.get(0).getName());
		opponentLabel1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		opponentLabel1_1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel1_1.setBounds(10, 98, 205, 14);
		opponentPanel.add(opponentLabel1_1);
		
		JLabel opponentLabel2_1 = new JLabel("Left Wing: " + opponentTeam.get(1).getName());
		opponentLabel2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		opponentLabel2_1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel2_1.setBounds(10, 154, 205, 14);
		opponentPanel.add(opponentLabel2_1);
		
		JLabel opponentLabel3_1 = new JLabel("Right Wing: " + opponentTeam.get(2).getName());
		opponentLabel3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		opponentLabel3_1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel3_1.setBounds(10, 210, 205, 14);
		opponentPanel.add(opponentLabel3_1);
		
		JLabel opponentLabel4_1 = new JLabel("Defender: " + opponentTeam.get(3).getName());
		opponentLabel4_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		opponentLabel4_1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel4_1.setBounds(10, 266, 205, 14);
		opponentPanel.add(opponentLabel4_1);
		
		JLabel opponentLabel5_1 = new JLabel("Keeper: " + opponentTeam.get(4).getName());
		opponentLabel5_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		opponentLabel5_1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel5_1.setBounds(10, 322, 205, 14);
		opponentPanel.add(opponentLabel5_1);
		
		JLabel opponentName = new JLabel("Opponent");
		opponentName.setText(manager.getOpponentName());
		opponentName.setHorizontalAlignment(SwingConstants.CENTER);
		opponentName.setBounds(10, 42, 205, 14);
		opponentPanel.add(opponentName);
		
		JLabel outcomeHighlight = new JLabel("The winner of this match is");
		outcomeHighlight.setHorizontalAlignment(SwingConstants.CENTER);
		outcomeHighlight.setFont(new Font("Tahoma", Font.BOLD, 12)); 
		outcomeHighlight.setBounds(250, 66, 211, 14);
		frmMatchScreen.getContentPane().add(outcomeHighlight);		
		
		JLabel outcomeLabel = new JLabel("Victory Text");
		outcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		if (manager.getMatchOutcome() == "Victory") {
			outcomeLabel.setText(manager.getTeamName());
			outcomeLabel.setForeground(new Color(0, 128, 0));
		} else {
			outcomeLabel.setText(manager.getOpponentName());
			outcomeLabel.setForeground(new Color(255, 66, 66));
		}
		outcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outcomeLabel.setBounds(158, 76, 394, 45);
		frmMatchScreen.getContentPane().add(outcomeLabel);
		
		JButton backButton = new JButton("Go back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		backButton.setBounds(231, 513, 250, 50);
		frmMatchScreen.getContentPane().add(backButton);
		
	}
}
