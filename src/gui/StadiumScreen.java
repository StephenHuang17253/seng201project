package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;

import main.GameManager;
import main.Match;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
/**
 * This screen presents the player with a list of available Matches to play and shows their total season points earned thus far.
 * It will check if the player's roster is eligible to compete and inform them if that is not the case.
 * If the player is able to compete and they choose a Match to play, the MatchScreen will open while the Stadium closes for now.
 * @author Stephen Huang
 *
 */
public class StadiumScreen {
	/**
	 * The StadiumScreen frame in which all UI elements are contained.
	 */
	private JFrame frmStadium;
	/**
	 * The instance of GameManager which manages this screen.
	 */
	private GameManager manager; 
	/**
	 * A JTextArea that provides some explanations on the screen.
	 */
	private JTextArea explanationText;
	/**
	 * An ArrayList of Match objects representing the available games to compete in.
	 */
	private ArrayList<Match> matches = new ArrayList<>();

	/**
	 * Create the application.
	 * Takes an incoming manager and makes it the manager of the screen.
	 * @param incomingManager The manager for this screen
	 */
	public StadiumScreen(GameManager incomingManager) {
		manager = incomingManager;
		matches = manager.getWeeklyMatches(); 
		initialize();
		frmStadium.setVisible(true);
	}
	/**
	 * Close the stadium screen window.
	 */
	public void closeWindow() { 
		frmStadium.dispose();
	}
	/**
	 * Close this instance of StadiumScreen using GameManager
	 */	
	public void finishedWindow() {
		manager.closeStadiumScreen(this);
	}
	
	/**
	 * Create the application.
	 */
	public StadiumScreen() {
		initialize();
	}
	
	/**
	 * Launch the application. 
	 * @param args an array of command-line arguments for the application
	 * 
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					StadiumScreen window = new StadiumScreen();
					window.frmStadium.setVisible(true);
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
		frmStadium = new JFrame();
		frmStadium.setTitle("KickHeroes - Stadium");
		frmStadium.setBounds(100, 100, 700, 514);
		frmStadium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStadium.getContentPane().setLayout(null);
		
		// Create a ListModel to store the matches in the Jlist
		DefaultListModel<Match> matchListModel = new DefaultListModel<Match>();
		// Add the existing matches to the ListModel
		matchListModel.addAll(matches);
		
		JList<Match> matchList = new JList<Match>(matchListModel);
		matchList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		matchList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		matchList.setBounds(142, 142, 508, 158);
		matchList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		frmStadium.getContentPane().add(matchList);
		
		JLabel listLabel = new JLabel("Available matches");
		listLabel.setLabelFor(matchList);
		listLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 18));
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);
		listLabel.setBounds(142, 114, 127, 21);
		frmStadium.getContentPane().add(listLabel);
		
		explanationText = new JTextArea();
		explanationText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		explanationText.setEditable(false);
		explanationText.setWrapStyleWord(true);
		explanationText.setLineWrap(true);
		explanationText.setText("You can select a match to play.\r\n\r\nVictory is rewarded with money and season points.\r\n");
		explanationText.setBackground(new Color(240, 240, 240));
		explanationText.setBounds(19, 171, 113, 109);
		frmStadium.getContentPane().add(explanationText);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		titlePanel.setBounds(-18, 0, 712, 99);
		frmStadium.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel stadiumLabel = new JLabel("The Stadium");
		stadiumLabel.setBounds(246, 25, 220, 43);
		titlePanel.add(stadiumLabel);
		stadiumLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		stadiumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel seasonPointsLabel = new JLabel("Season points: " + manager.getSeasonPoints());
		seasonPointsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		seasonPointsLabel.setBounds(38, 74, 151, 25);
		titlePanel.add(seasonPointsLabel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 317, 684, 158);
		frmStadium.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton playButton = new JButton("Play selected match");
		playButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		playButton.setBounds(207, 0, 270, 60);
		buttonPanel.add(playButton);
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Match targetMatch = matchList.getSelectedValue();
				if (targetMatch == null) {
					Component noMatchSelected = null;
					JOptionPane.showMessageDialog(noMatchSelected,  
							"You have not selected a match.", 
							"No match selected.", JOptionPane.INFORMATION_MESSAGE);				
				} else if (manager.canCompete() != true) {
					Component cantCompete = null;
					JOptionPane.showMessageDialog(cantCompete, 
							"At least one of your main players is injured.\nGo make a substitution to play.", 
							"Can't compete!", JOptionPane.INFORMATION_MESSAGE);			 				
				} else {
					System.out.println(targetMatch);
					matches.remove(targetMatch);
					manager.launchMatchScreen(targetMatch);
					matchListModel.removeElement(targetMatch);
					matchList.setModel(matchListModel);
					finishedWindow();					
				}
				
			}

		});		
		
		JButton backButton = new JButton("Go back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBounds(207, 71, 270, 60);
		buttonPanel.add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				manager.launchMainScreen();
			}
		});

	}
}
