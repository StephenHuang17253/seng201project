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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	 * Create the application.
	 */	
	public MainScreen() {
		initialize();
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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainScreen = new JFrame();
		frmMainScreen.setBounds(100, 100, 611, 648);
		frmMainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainScreen.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("KickHeroes");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		titleLabel.setBounds(197, 24, 200, 35);
		frmMainScreen.getContentPane().add(titleLabel);
		
		JLabel teamLabel = new JLabel(manager.getTeamName() + " Sports Club");
		teamLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamLabel.setBounds(175, 83, 244, 22);
		frmMainScreen.getContentPane().add(teamLabel);
		
		JLabel moneyLabel = new JLabel("Money: $" + manager.getMoneyString());
		moneyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		moneyLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		moneyLabel.setBounds(35, 132, 200, 14);
		frmMainScreen.getContentPane().add(moneyLabel);
		
		JLabel weeksLeftLabel = new JLabel("Total weeks: " + manager.getTotalWeeks());
		weeksLeftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weeksLeftLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		weeksLeftLabel.setBounds(418, 132, 140, 14);
		frmMainScreen.getContentPane().add(weeksLeftLabel);
		
		JLabel weekLabel = new JLabel("Week: " + manager.getWeek());
		weekLabel.setHorizontalAlignment(SwingConstants.LEFT);
		weekLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		weekLabel.setBounds(270, 132, 113, 14);
		frmMainScreen.getContentPane().add(weekLabel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buttonPanel.setBounds(0, 168, 595, 441);
		frmMainScreen.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton btnClub = new JButton("Go to the club");
		btnClub.setBounds(97, 16, 400, 75);
		btnClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("Club");
			}
		});
		buttonPanel.add(btnClub);
		
		JButton btnStadium = new JButton("Go to the stadium");
		btnStadium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("Stadium");
			}
		});
		btnStadium.setBounds(97, 98, 400, 75);
		buttonPanel.add(btnStadium);
		
		JButton btnMarket = new JButton("Visit the market");
		btnMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("Market");
			}
		});
		btnMarket.setBounds(97, 180, 400, 75);
		buttonPanel.add(btnMarket);
		
		JButton btnBye = new JButton("Take a bye ");
		btnBye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO 
			}
		});
		btnBye.setBounds(97, 262, 400, 75);
		buttonPanel.add(btnBye);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(97, 344, 400, 75);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("Quit");
			}
		});
		buttonPanel.add(btnQuit);  
		

	}
}
