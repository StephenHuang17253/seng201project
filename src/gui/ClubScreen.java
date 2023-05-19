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
	//DefaultListModel<Athlete> reserveRosterModel = new DefaultListModel<Athlete>();
	//private JList<Athlete> reserveRosterList = new JList<Athlete>();

	public ClubScreen(GameManager incomingManager, ArrayList<Athlete> starting, ArrayList<Athlete> reserves) {
		manager = incomingManager;
		activeRoster = starting;
		reserveRoster = reserves;
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
		frmClubScreen.setBounds(100, 100, 1005, 700);
		frmClubScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClubScreen.getContentPane().setLayout(null);
		
		JLabel teamLabel = new JLabel(manager.getTeamName() + " Sports Club");
		teamLabel.setVerticalAlignment(SwingConstants.TOP);
		teamLabel.setBounds(10, 29, 969, 55);
		teamLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmClubScreen.getContentPane().add(teamLabel);
		
		JPanel activeRosterPanel = new JPanel();
		activeRosterPanel.setBounds(42, 95, 905, 184);
		activeRosterPanel.setLayout(null);
		activeRosterPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		frmClubScreen.getContentPane().add(activeRosterPanel);
		
		// Create a ListModel to store the active athletes in the JList
		DefaultListModel<Athlete> activeRosterModel = new DefaultListModel<Athlete>();
		// Add athletes to the ListModel
		activeRosterModel.addAll(activeRoster);
		
		// Create a ListModel to store the reserve athletes in the JList
		DefaultListModel<Athlete> reserveRosterModel = new DefaultListModel<Athlete>();
		reserveRosterModel.addAll(reserveRoster);
		
		// Create the JList for reserve roster
		// Needed to be declared early to allow demote button to work.
		JList<Athlete> reserveRosterList = new JList<Athlete>(reserveRosterModel);
		// Create the JList for active roster 
		JList<Athlete> activeRosterList = new JList<Athlete>(activeRosterModel);
		activeRosterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		activeRosterList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		activeRosterList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		activeRosterList.setBounds(237, 11, 658, 162);
		activeRosterPanel.add(activeRosterList);
		activeRosterList.getSelectedValue();
		
		JLabel activeRosterLabel = new JLabel("Active Roster");
		activeRosterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		activeRosterLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		activeRosterLabel.setBounds(10, 11, 217, 23);
		activeRosterPanel.add(activeRosterLabel);
		
		JButton activeRosterChangeButton = new JButton("Demote");
		activeRosterChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.demoteAthlete(activeRosterList.getSelectedValue());
				reserveRosterModel.addElement(activeRosterList.getSelectedValue());
				reserveRosterList.setModel(reserveRosterModel);				
				activeRosterModel.removeElement(activeRosterList.getSelectedValue());
				activeRosterList.setModel(activeRosterModel);

			}
		});
		activeRosterChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		activeRosterChangeButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		activeRosterChangeButton.setBounds(70, 145, 94, 28);
		activeRosterPanel.add(activeRosterChangeButton);
		
		JTextArea activeExplanationTextArea = new JTextArea();
		activeExplanationTextArea.setWrapStyleWord(true);
		activeExplanationTextArea.setText("The active roster can have 5 athletes. A full active roster is required to compete in matches.\r\n\r\nPress the demote button to move selected player into your reserves.\r\n");
		activeExplanationTextArea.setLineWrap(true);
		activeExplanationTextArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		activeExplanationTextArea.setEditable(false);
		activeExplanationTextArea.setBackground(SystemColor.menu);
		activeExplanationTextArea.setBounds(10, 33, 217, 101);
		activeRosterPanel.add(activeExplanationTextArea);
		
		JLabel activeRosterChangedLabel = new JLabel("Athelete moved!");
		activeRosterChangedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		activeRosterChangedLabel.setBounds(10, 131, 217, 14);
		activeRosterPanel.add(activeRosterChangedLabel);
		activeRosterChangedLabel.setForeground(new Color(255, 66, 66));
		activeRosterChangedLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton backButton = new JButton("Go back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setBounds(359, 578, 270, 60);
		frmClubScreen.getContentPane().add(backButton);
		
		JPanel reserveRosterPanel = new JPanel();
		reserveRosterPanel.setLayout(null);
		reserveRosterPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		reserveRosterPanel.setBounds(42, 298, 905, 256);
		frmClubScreen.getContentPane().add(reserveRosterPanel);
		

		reserveRosterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reserveRosterList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		reserveRosterList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		reserveRosterList.setBounds(237, 11, 658, 234);
		reserveRosterPanel.add(reserveRosterList);
		reserveRosterList.getSelectedValue();
		
		JLabel reserveRosterLabel = new JLabel("Reserve Roster");
		reserveRosterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reserveRosterLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		reserveRosterLabel.setBounds(10, 11, 217, 23);
		reserveRosterPanel.add(reserveRosterLabel);
		
		JButton reserveRosterChangeButton = new JButton("Promote");
		reserveRosterChangeButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		reserveRosterChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.promoteAthlete(reserveRosterList.getSelectedValue());
				activeRosterModel.addElement(reserveRosterList.getSelectedValue());
				activeRosterList.setModel(activeRosterModel);				
				reserveRosterModel.removeElement(reserveRosterList.getSelectedValue());
				reserveRosterList.setModel(reserveRosterModel);

			}
		});
		reserveRosterChangeButton.setBounds(70, 210, 94, 28);
		reserveRosterPanel.add(reserveRosterChangeButton);
		
		JLabel reserveRosterChangeLabel = new JLabel("Athelete moved!");
		reserveRosterChangeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reserveRosterChangeLabel.setForeground(new Color(255, 66, 66));
		reserveRosterChangeLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		reserveRosterChangeLabel.setBounds(10, 196, 217, 14);
		reserveRosterPanel.add(reserveRosterChangeLabel);
		
		JTextArea reserveExplanationTextArea = new JTextArea();
		reserveExplanationTextArea.setWrapStyleWord(true);
		reserveExplanationTextArea.setText("Contains up to 15 players that haven't been selected to play in your next match.\r\n\r\nIt is recommened to have reserves incase your starting lineup gets injured or if someone leavees.\r\n\r\nPress the promote button to move selected player to your starting lineup.\r\n");
		reserveExplanationTextArea.setLineWrap(true);
		reserveExplanationTextArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		reserveExplanationTextArea.setEditable(false);
		reserveExplanationTextArea.setBackground(SystemColor.menu);
		reserveExplanationTextArea.setBounds(10, 33, 217, 154);
		reserveRosterPanel.add(reserveExplanationTextArea);
		
	}
	

}
