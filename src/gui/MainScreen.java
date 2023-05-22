package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import main.GameManager;
import main.RandomEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component; 

public class MainScreen {

	private JFrame frmMainScreen;
	private GameManager manager;


	public MainScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmMainScreen.setVisible(true);
	}	
	
	public void closeWindow() {
		frmMainScreen.dispose();
	}
	
	public void finishedWindow(String next) {
		manager.closeMainScreen(this, next);
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frmMainScreen.setVisible(true);
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
		frmMainScreen = new JFrame();
		frmMainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainScreen.setTitle("KickHeroes - Main Menu");
		frmMainScreen.setBounds(100, 100, 611, 648);
		frmMainScreen.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("KickHeroes");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		titleLabel.setBounds(10, 24, 575, 49);
		frmMainScreen.getContentPane().add(titleLabel);
		
		JLabel teamLabel = new JLabel(manager.getTeamName() + " Sports Club");
		teamLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamLabel.setBounds(175, 83, 244, 22);
		frmMainScreen.getContentPane().add(teamLabel);
		
		JLabel moneyLabel = new JLabel("Money: $" + manager.getMoneyString());
		moneyLabel.setVerticalAlignment(SwingConstants.TOP);
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		moneyLabel.setBounds(35, 132, 200, 22);
		frmMainScreen.getContentPane().add(moneyLabel);
		
		JLabel weekLabel = new JLabel("Week: " + manager.getWeek());
		weekLabel.setHorizontalAlignment(SwingConstants.LEFT);
		weekLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		weekLabel.setBounds(270, 132, 113, 14);
		frmMainScreen.getContentPane().add(weekLabel);
		
		JLabel weeksLeftLabel = new JLabel("Total weeks: " + manager.getTotalWeeks());
		weeksLeftLabel.setHorizontalAlignment(SwingConstants.LEFT);
		weeksLeftLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		weeksLeftLabel.setBounds(418, 132, 140, 14);
		frmMainScreen.getContentPane().add(weeksLeftLabel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buttonPanel.setBounds(0, 168, 595, 441);
		frmMainScreen.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton clubButton = new JButton("Go to the club");
		clubButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clubButton.setBounds(97, 16, 400, 75);
		clubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("Club");
			}
		});
		buttonPanel.add(clubButton);
		
		JButton stadiumButton = new JButton("Go to the stadium");
		stadiumButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		stadiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.canCompete()) {
					finishedWindow("Stadium");
				} else {
					Component cantCompete = null;
					JOptionPane.showMessageDialog(cantCompete,
						    "To compete your main roster needs 5 players with stamina",
						    "Check your roster!",
						    JOptionPane.WARNING_MESSAGE);					
				}
				
			}
		});
		stadiumButton.setBounds(97, 98, 400, 75);
		buttonPanel.add(stadiumButton);
		
		JButton marketButton = new JButton("Visit the market");
		marketButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("Market");
			}
		});
		marketButton.setBounds(97, 180, 400, 75);
		buttonPanel.add(marketButton);
		

				
		JButton byeButton = new JButton("Take a bye");
		byeButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		if (manager.getWeek() == manager.getTotalWeeks()) {
			byeButton.setText("Finish game");
		}		
		byeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (manager.getWeek() == manager.getTotalWeeks()) {
					Component ByeFrame = null;
					int n = JOptionPane.showConfirmDialog(ByeFrame, 
							"Ready to finish the game?", 
							"End game", JOptionPane.YES_NO_OPTION);		
					if (n == 0) {
						finishedWindow("Bye");
					
					}
				} else {
				Component ByeFrame = null;
				int n = JOptionPane.showConfirmDialog(ByeFrame, 
						"Ready to move to next week?", 
						"Take a bye", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					finishedWindow("Bye");
					manager.launchTrainingScreen();
					Random random = new Random();
					int chance = random.nextInt(4);
					RandomEvent event = RandomEvent.generateRandomEvent(manager, chance);
					Component eventFrame = null;
					if (event != null) {
					switch(event.getType()) {
						case "Starter Boost":
							JOptionPane.showMessageDialog(eventFrame,
								    event.getMessage(),
								    "Event - Stat boost for a starter",
								    JOptionPane.INFORMATION_MESSAGE);
							break;
						 
						case "Reserve Boost":
							JOptionPane.showMessageDialog(eventFrame,
								    event.getMessage(),
								    "Event - Stat boost for a reserve",
								    JOptionPane.INFORMATION_MESSAGE);
						    break;
						case "Athlete Quit":
							JOptionPane.showMessageDialog(eventFrame,
								    event.getMessage(),
								    "Event - Athlete retires",
								    JOptionPane.INFORMATION_MESSAGE);
						case "Athlete Joins":
							JOptionPane.showMessageDialog(eventFrame,
								    event.getMessage(),
								    "Event - Athlete joins",
								    JOptionPane.INFORMATION_MESSAGE);
							
					}						
					}
					}					
				}
			}
		});
		byeButton.setBounds(97, 262, 400, 75);
		buttonPanel.add(byeButton);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quitButton.setBounds(97, 344, 400, 75);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component quitFrame = null;
				int n = JOptionPane.showConfirmDialog(quitFrame, 
						"Are you sure? Doing so would make you lose all your progress.", "Quit", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					finishedWindow("Quit");
				}
			}
		});
		buttonPanel.add(quitButton);  
		

	}
}
