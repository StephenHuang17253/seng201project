package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.GameManager;


import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
/**
 * This is the screen that opens when the game starts, it's a simple title screen
 * with a start button that takes you to the next screen.
 * @author Stephen Huang
 *
 */
public class StartScreen {
	/**
	 * The StartScreen frame in which all UI elemets are contained.
	 */
	private JFrame frmStartScreen;
	/**
	 * The instance of GameManager which manages this screen.
	 */
	private GameManager manager;

	
	/**
	 * Create the application.
	 * Takes an incoming manager and makes it the manager of the screen.
	 * @param incomingManager The manager for this screen
	 */
	public StartScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmStartScreen.setLocationRelativeTo(null);
		frmStartScreen.setVisible(true);
	}
	/**
	 * Close the start screen window.
	 */
	public void closeWindow() {
		frmStartScreen.dispose();
	}
	/**
	 * Close this instance of StartScreen using GameManager
	 */
	public void finishedWindow() {
		manager.closeStartScreen(this);
	}
		 
	/**
	 * Launch the application.
	 * @param args an array of command-line arguments for the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen();
					window.frmStartScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application
	 */
	public StartScreen() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStartScreen = new JFrame();
		frmStartScreen.setTitle("KickHeroes");
		frmStartScreen.setBounds(100, 100, 1018, 564);
		frmStartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStartScreen.getContentPane().setLayout(null);
		
		JLabel welcomeLabel = new JLabel(" Welcome to KickHeroes\r\n");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(10, 128, 982, 77);
		welcomeLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 50));
		frmStartScreen.getContentPane().add(welcomeLabel);
		
		JLabel startLabel = new JLabel("Press \"Start\" to play!");
		startLabel.setHorizontalAlignment(SwingConstants.CENTER);
		startLabel.setFont(new Font("Tahoma", Font.ITALIC, 25));
		startLabel.setBounds(374, 240, 253, 31);
		frmStartScreen.getContentPane().add(startLabel);
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		startButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		startButton.setBounds(337, 329, 328, 108);
		frmStartScreen.getContentPane().add(startButton);
		
		JLabel gameLabel = new JLabel("... a Futsal Club management sim");
		gameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		gameLabel.setFont(new Font("Rockwell", Font.PLAIN, 16));
		gameLabel.setBounds(588, 203, 273, 22);
		frmStartScreen.getContentPane().add(gameLabel);
	}
}
