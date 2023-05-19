package gui;

import java.awt.EventQueue;
import java.awt.Font;

import main.GameManager;
import main.Athlete;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class ClubScreen {

	private JFrame frmClubScreen;
	private GameManager manager;
	private ArrayList<Athlete> activeRoster;
	private ArrayList<Athlete> reserveRoster;

	public ClubScreen(GameManager incomingManager, ArrayList<Athlete> incomingRoster) {
		manager = incomingManager;
		reserveRoster = incomingRoster;
		initialize();
		frmClubScreen.setVisible(true);
	}
	
	public void closeWindow() {
		frmClubScreen.dispose();
	}

	public void finishedWindow() {
		manager.closeClubScreen(this);
	}
	
	/**
	 * Create the application.
	 */
	public ClubScreen() {
		initialize();
	}	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubScreen window = new ClubScreen();
					window.frmClubScreen.setVisible(true);
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
		frmClubScreen = new JFrame();
		frmClubScreen.setTitle("Club Screen");
		frmClubScreen.setBounds(100, 100, 796, 560);
		frmClubScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClubScreen.getContentPane().setLayout(null);
		
		JLabel teamLabel = new JLabel(manager.getTeamName() + " Sports Club");
		teamLabel.setBounds(248, 21, 285, 29);
		teamLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmClubScreen.getContentPane().add(teamLabel);
		
		JPanel activeRosterPanel = new JPanel();
		activeRosterPanel.setBounds(47, 69, 686, 162);
		activeRosterPanel.setLayout(null);
		activeRosterPanel.setBorder(new LineBorder(new Color(255, 66, 66), 2, true));
		frmClubScreen.getContentPane().add(activeRosterPanel);
		
		// Create a ListModel to store the active athletes in the JList
		DefaultListModel<Athlete> activeRosterModel = new DefaultListModel<Athlete>();
		// Add athletes to the ListModel
		// activeRosterModel.addAll(activeRoster)
		
		// Create the JList
		JList<Athlete> activeRosterList = new JList<Athlete>(activeRosterModel);
		activeRosterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		activeRosterList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		activeRosterList.setBorder(new LineBorder(new Color(255, 151, 151)));
		activeRosterList.setBounds(219, 11, 457, 140);
		activeRosterPanel.add(activeRosterList);
		activeRosterList.getSelectedValue();
		
		JLabel activeRosterLabel = new JLabel("Active Roster");
		activeRosterLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		activeRosterLabel.setBounds(20, 11, 124, 23);
		activeRosterPanel.add(activeRosterLabel);
		
		JButton activeRosterChangeButton = new JButton("Demote");
		activeRosterChangeButton.setBounds(120, 121, 89, 23);
		activeRosterPanel.add(activeRosterChangeButton);
		
		JLabel activeRosterChangedText = new JLabel("Athelete moved!");
		activeRosterChangedText.setForeground(new Color(255, 66, 66));
		activeRosterChangedText.setFont(new Font("Tahoma", Font.BOLD, 11));
		activeRosterChangedText.setBounds(10, 125, 110, 14);
		activeRosterPanel.add(activeRosterChangedText);
		
		JTextArea txtrPressTheDemote = new JTextArea();
		txtrPressTheDemote.setWrapStyleWord(true);
		txtrPressTheDemote.setText("You need 5 players on your active roster to compete in matches.\r\n\r\nPress the demote button to move a player into your reserves.\r\n\r\n(Maximum of 5 players in active roster.");
		txtrPressTheDemote.setLineWrap(true);
		txtrPressTheDemote.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrPressTheDemote.setEditable(false);
		txtrPressTheDemote.setBackground(SystemColor.menu);
		txtrPressTheDemote.setBounds(10, 45, 199, 78);
		activeRosterPanel.add(txtrPressTheDemote);
		
		JButton backButton = new JButton("Go back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setBounds(283, 456, 208, 54);
		frmClubScreen.getContentPane().add(backButton);
		
		JPanel reserveRosterPanel = new JPanel();
		reserveRosterPanel.setLayout(null);
		reserveRosterPanel.setBorder(new LineBorder(new Color(255, 66, 66), 2, true));
		reserveRosterPanel.setBounds(47, 253, 686, 162);
		frmClubScreen.getContentPane().add(reserveRosterPanel);
		
		// Create a ListModel to store the athletes in the JList
		DefaultListModel<Athlete> reserveRosterModel = new DefaultListModel<Athlete>();
		reserveRosterModel.addAll(reserveRoster);
		
		// Create the JList
		JList<Athlete> reserveRosterList = new JList<Athlete>(reserveRosterModel);
		reserveRosterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reserveRosterList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		reserveRosterList.setBorder(new LineBorder(new Color(255, 151, 151)));
		reserveRosterList.setBounds(219, 11, 457, 140);
		reserveRosterPanel.add(reserveRosterList);
		
		JLabel reserveRosterText = new JLabel("Reserve Roster");
		reserveRosterText.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		reserveRosterText.setBounds(20, 11, 124, 23);
		reserveRosterPanel.add(reserveRosterText);
		
		JButton reserveRosterChangeButton = new JButton("Promote");
		reserveRosterChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		reserveRosterChangeButton.setBounds(120, 121, 89, 23);
		reserveRosterPanel.add(reserveRosterChangeButton);
		
		JLabel reserveRosterChangeLabel = new JLabel("Athelete moved");
		reserveRosterChangeLabel.setForeground(new Color(255, 66, 66));
		reserveRosterChangeLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		reserveRosterChangeLabel.setBounds(10, 125, 110, 14);
		reserveRosterPanel.add(reserveRosterChangeLabel);
		
		JTextArea reserveExplanationTextArea = new JTextArea();
		reserveExplanationTextArea.setWrapStyleWord(true);
		reserveExplanationTextArea.setText("Press the promote button to move a player to your starting lineup.\r\n");
		reserveExplanationTextArea.setLineWrap(true);
		reserveExplanationTextArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		reserveExplanationTextArea.setEditable(false);
		reserveExplanationTextArea.setBackground(SystemColor.menu);
		reserveExplanationTextArea.setBounds(10, 64, 199, 46);
		reserveRosterPanel.add(reserveExplanationTextArea);
		
	}

}
