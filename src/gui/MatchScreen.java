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
		frmMatchScreen.setTitle("Match");
		frmMatchScreen.setBounds(100, 100, 727, 541);
		frmMatchScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatchScreen.getContentPane().setLayout(null);
		
		JLabel headerLabel = new JLabel(manager.getTeamName() + " vs " + manager.getOpponentName());
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		headerLabel.setBounds(97, 33, 517, 22);
		frmMatchScreen.getContentPane().add(headerLabel);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBounds(10, 122, 225, 380);
		frmMatchScreen.getContentPane().add(playerPanel);
		playerPanel.setLayout(null);
		
		JLabel strikerLabel1 = new JLabel("Striker:" + playerTeam.get(0).getName());
		strikerLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		strikerLabel1.setBounds(10, 98, 192, 14);
		playerPanel.add(strikerLabel1);
		
		JLabel leftWingLabel2 = new JLabel("Left Wing: " + playerTeam.get(1).getName());
		leftWingLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		leftWingLabel2.setBounds(10, 154, 192, 14);
		playerPanel.add(leftWingLabel2);
		
		JLabel rightWingLabel3 = new JLabel("Right Wing: " + playerTeam.get(2).getName());
		rightWingLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		rightWingLabel3.setBounds(10, 210, 192, 14);
		playerPanel.add(rightWingLabel3);
		
		JLabel defenderLabel4 = new JLabel("Defender: " + playerTeam.get(3).getName());
		defenderLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		defenderLabel4.setBounds(10, 266, 192, 14);
		playerPanel.add(defenderLabel4);
		
		JLabel keeperLabel5 = new JLabel("Keeper: " + playerTeam.get(4).getName());
		keeperLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		keeperLabel5.setBounds(10, 322, 192, 14);
		playerPanel.add(keeperLabel5);
		
		JLabel playerTeamName = new JLabel("Your Team");
		playerTeamName.setText(manager.getTeamName());
		playerTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		playerTeamName.setBounds(10, 42, 192, 14);
		playerPanel.add(playerTeamName);
		
		JPanel opponentPanel = new JPanel();
		opponentPanel.setLayout(null);
		opponentPanel.setBounds(476, 122, 225, 380);
		frmMatchScreen.getContentPane().add(opponentPanel);
		
		JLabel opponentLabel1_1 = new JLabel("Striker: " + opponentTeam.get(0).getName());
		opponentLabel1_1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel1_1.setBounds(10, 98, 192, 14);
		opponentPanel.add(opponentLabel1_1);
		
		JLabel opponentLabel2_1 = new JLabel("Left Wing: " + opponentTeam.get(1).getName());
		opponentLabel2_1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel2_1.setBounds(10, 154, 192, 14);
		opponentPanel.add(opponentLabel2_1);
		
		JLabel opponentLabel3_1 = new JLabel("Right Wing: " + opponentTeam.get(2).getName());
		opponentLabel3_1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel3_1.setBounds(10, 210, 192, 14);
		opponentPanel.add(opponentLabel3_1);
		
		JLabel opponentLabel4_1 = new JLabel("Defender: " + opponentTeam.get(3).getName());
		opponentLabel4_1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel4_1.setBounds(10, 266, 192, 14);
		opponentPanel.add(opponentLabel4_1);
		
		JLabel opponentLabel5_1 = new JLabel("Keeper: " + opponentTeam.get(4).getName());
		opponentLabel5_1.setHorizontalAlignment(SwingConstants.CENTER);
		opponentLabel5_1.setBounds(10, 322, 192, 14);
		opponentPanel.add(opponentLabel5_1);
		
		JLabel opponentName = new JLabel("Opponent");
		opponentName.setText(manager.getOpponentName());
		opponentName.setHorizontalAlignment(SwingConstants.CENTER);
		opponentName.setBounds(10, 42, 192, 14);
		opponentPanel.add(opponentName);
	}
}
