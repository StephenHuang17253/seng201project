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
	private ArrayList<Athlete> activeRoster = new ArrayList<Athlete>();
	private ArrayList<Athlete> reserveRoster;
	//DefaultListModel<Athlete> reserveRosterModel = new DefaultListModel<Athlete>();
	//private JList<Athlete> reserveRosterList = new JList<Athlete>();

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
		frmClubScreen.setBounds(100, 100, 796, 650);
		frmClubScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClubScreen.getContentPane().setLayout(null);
		
		JLabel teamLabel = new JLabel(manager.getTeamName() + " Sports Club");
		teamLabel.setBounds(181, 21, 417, 43);
		teamLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmClubScreen.getContentPane().add(teamLabel);
		
		JPanel activeRosterPanel = new JPanel();
		activeRosterPanel.setBounds(47, 95, 686, 162);
		activeRosterPanel.setLayout(null);
		activeRosterPanel.setBorder(new LineBorder(new Color(255, 66, 66), 1, true));
		frmClubScreen.getContentPane().add(activeRosterPanel);
		
		// Create a ListModel to store the active athletes in the JList
		DefaultListModel<Athlete> activeRosterModel = new DefaultListModel<Athlete>();
		// Add athletes to the ListModel
		// activeRosterModel.addAll(activeRoster)
		
		// Create a ListModel to store the reserve athletes in the JList
		DefaultListModel<Athlete> reserveRosterModel = new DefaultListModel<Athlete>();
		reserveRosterModel.addAll(reserveRoster);
		
		// Create the JList for reserve roster
		// Needed to be declared early to allow demote button to work.
		JList<Athlete> reserveRosterList = new JList<Athlete>(reserveRosterModel);
		// Create the JList for active roster 
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
		activeRosterChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveAthlete(activeRoster, activeRosterList.getSelectedValue(), reserveRoster);
				reserveRosterModel.addElement(activeRosterList.getSelectedValue());
				reserveRosterList.setModel(reserveRosterModel);				
				activeRosterModel.removeElement(activeRosterList.getSelectedValue());
				activeRosterList.setModel(activeRosterModel);

			}
		});
		activeRosterChangeButton.setBounds(120, 128, 89, 23);
		activeRosterPanel.add(activeRosterChangeButton);
		
		JLabel activeRosterChangedLabel = new JLabel("Athelete moved!");
		activeRosterChangedLabel.setForeground(new Color(255, 66, 66));
		activeRosterChangedLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		activeRosterChangedLabel.setBounds(20, 132, 110, 14);
		activeRosterPanel.add(activeRosterChangedLabel);
		
		JTextArea activeExplanationTextArea = new JTextArea();
		activeExplanationTextArea.setWrapStyleWord(true);
		activeExplanationTextArea.setText("The active roster can have 5 athletes. A full active roster is required to compete in matches.\r\n\r\nPress the demote button to move selected player into your reserves.\r\n");
		activeExplanationTextArea.setLineWrap(true);
		activeExplanationTextArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		activeExplanationTextArea.setEditable(false);
		activeExplanationTextArea.setBackground(SystemColor.menu);
		activeExplanationTextArea.setBounds(10, 39, 199, 87);
		activeRosterPanel.add(activeExplanationTextArea);
		
		JButton backButton = new JButton("Go back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setBounds(286, 535, 208, 54);
		frmClubScreen.getContentPane().add(backButton);
		
		JPanel reserveRosterPanel = new JPanel();
		reserveRosterPanel.setLayout(null);
		reserveRosterPanel.setBorder(new LineBorder(new Color(255, 66, 66), 1, true));
		reserveRosterPanel.setBounds(47, 268, 686, 256);
		frmClubScreen.getContentPane().add(reserveRosterPanel);
		

		reserveRosterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reserveRosterList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		reserveRosterList.setBorder(new LineBorder(new Color(255, 151, 151)));
		reserveRosterList.setBounds(219, 11, 457, 234);
		reserveRosterPanel.add(reserveRosterList);
		reserveRosterList.getSelectedValue();
		
		JLabel reserveRosterLabel = new JLabel("Reserve Roster");
		reserveRosterLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		reserveRosterLabel.setBounds(20, 11, 124, 23);
		reserveRosterPanel.add(reserveRosterLabel);
		
		JButton reserveRosterChangeButton = new JButton("Promote");
		reserveRosterChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveAthlete(reserveRoster, activeRosterList.getSelectedValue(), activeRoster);
				activeRosterModel.addElement(reserveRosterList.getSelectedValue());
				activeRosterList.setModel(activeRosterModel);				
				reserveRosterModel.removeElement(reserveRosterList.getSelectedValue());
				reserveRosterList.setModel(reserveRosterModel);

			}
		});
		reserveRosterChangeButton.setBounds(120, 210, 89, 23);
		reserveRosterPanel.add(reserveRosterChangeButton);
		
		JLabel reserveRosterChangeLabel = new JLabel("Athelete moved!");
		reserveRosterChangeLabel.setForeground(new Color(255, 66, 66));
		reserveRosterChangeLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		reserveRosterChangeLabel.setBounds(20, 214, 110, 14);
		reserveRosterPanel.add(reserveRosterChangeLabel);
		
		JTextArea reserveExplanationTextArea = new JTextArea();
		reserveExplanationTextArea.setWrapStyleWord(true);
		reserveExplanationTextArea.setText("Contains up to 15 players that haven't been selected to play in your next match.\r\n\r\nIt is recommened to have reserves incase your starting lineup gets injured or if someone leavees.\r\n\r\nPress the promote button to move selected player to your starting lineup.\r\n");
		reserveExplanationTextArea.setLineWrap(true);
		reserveExplanationTextArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		reserveExplanationTextArea.setEditable(false);
		reserveExplanationTextArea.setBackground(SystemColor.menu);
		reserveExplanationTextArea.setBounds(10, 45, 199, 154);
		reserveRosterPanel.add(reserveExplanationTextArea);
		
	}
	
	public void moveAthlete(ArrayList<Athlete> source, Athlete item, ArrayList<Athlete> destination) {
	    destination.add(item);
	    source.remove(item);
	}

}
