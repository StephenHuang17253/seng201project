package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import main.GameManager;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MainScreen {

	private JFrame frame;
	private GameManager manager;

	/**
	 * Create the application.
	 */
	public MainScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}	
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeMainScreen(this);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 611, 648);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("KickHeroes");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		titleLabel.setBounds(197, 24, 200, 35);
		frame.getContentPane().add(titleLabel);
		
		JLabel teamLabel = new JLabel(manager.getTeamName() + " Sports Club");
		teamLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamLabel.setBounds(175, 83, 244, 22);
		frame.getContentPane().add(teamLabel);
		
		JLabel moneyLabel = new JLabel("Money: $" + manager.getMoneyString());
		moneyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		moneyLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		moneyLabel.setBounds(35, 132, 200, 14);
		frame.getContentPane().add(moneyLabel);
		
		JLabel weeksLeftLabel = new JLabel("Total weeks: " + manager.getTotalWeeks());
		weeksLeftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weeksLeftLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		weeksLeftLabel.setBounds(418, 132, 140, 14);
		frame.getContentPane().add(weeksLeftLabel);
		
		JLabel weekLabel = new JLabel("Week: " + manager.getWeek());
		weekLabel.setHorizontalAlignment(SwingConstants.LEFT);
		weekLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		weekLabel.setBounds(270, 132, 113, 14);
		frame.getContentPane().add(weekLabel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buttonPanel.setBounds(0, 168, 595, 441);
		frame.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton btnClub = new JButton("Go to the club");
		btnClub.setBounds(97, 16, 400, 75);
		buttonPanel.add(btnClub);
		
		JButton btnStadium = new JButton("Go to the stadium");
		btnStadium.setBounds(97, 98, 400, 75);
		buttonPanel.add(btnStadium);
		
		JButton btnMarket = new JButton("Visit the market");
		btnMarket.setBounds(97, 180, 400, 75);
		buttonPanel.add(btnMarket);
		
		JButton btnBye = new JButton("Take a bye ");
		btnBye.setBounds(97, 262, 400, 75);
		buttonPanel.add(btnBye);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(97, 344, 400, 75);
		buttonPanel.add(btnQuit);
		

	}
}
