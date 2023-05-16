package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import main.GameManager;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextPane;

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
		frame.setBounds(100, 100, 611, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("KickHeroes");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		titleLabel.setBounds(197, 30, 200, 14);
		frame.getContentPane().add(titleLabel);
		
		JLabel teamLabel = new JLabel(manager.getTeamName() + " Sports Club");
		teamLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamLabel.setBounds(175, 83, 244, 14);
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
		
		JButton btnClub = new JButton("Go to the club");
		btnClub.setBounds(227, 180, 140, 23);
		frame.getContentPane().add(btnClub);
		
		JButton btnStadium = new JButton("Go to the stadium");
		btnStadium.setBounds(227, 240, 140, 23);
		frame.getContentPane().add(btnStadium);
		
		JButton btnMarket = new JButton("Visit the market");
		btnMarket.setBounds(227, 300, 140, 23);
		frame.getContentPane().add(btnMarket);
		
		JButton btnBye = new JButton("Take a bye ");
		btnBye.setBounds(227, 360, 140, 23);
		frame.getContentPane().add(btnBye);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(227, 420, 140, 23);
		frame.getContentPane().add(btnQuit);
		

	}
}
