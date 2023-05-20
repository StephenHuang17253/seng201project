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
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class ClubScreen {

	private JFrame frmClubScreen;
	private GameManager manager;
	//private ArrayList<Athlete> activeRoster;
	//private ArrayList<Athlete> reserveRoster;
	//DefaultListModel<Athlete> reserveRosterModel = new DefaultListModel<Athlete>();
	//private JList<Athlete> reserveRosterList = new JList<Athlete>();

	public ClubScreen(GameManager incomingManager) {
		manager = incomingManager;
		//activeRoster = starting;
		//reserveRoster = reserves;
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
		frmClubScreen.setTitle("VolleyballWorld - Club Screen");
		frmClubScreen.setBounds(100, 100, 1005, 784);
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
		activeRosterModel.addAll(manager.getMainRoster());
		
		// Create a ListModel to store the reserve athletes in the JList
		DefaultListModel<Athlete> reserveRosterModel = new DefaultListModel<Athlete>();
		reserveRosterModel.addAll(manager.getReserveRoster());
		
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
		
		JLabel activeRosterChangedLabel = new JLabel("");
		activeRosterChangedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		activeRosterChangedLabel.setBounds(10, 131, 217, 14);
		activeRosterPanel.add(activeRosterChangedLabel);
		activeRosterChangedLabel.setForeground(new Color(255, 66, 66));
		activeRosterChangedLabel.setFont(new Font("Tahoma", Font.BOLD, 11));		
		JButton activeRosterChangeButton = new JButton("Demote");
		
		activeRosterChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete targetAthlete = activeRosterList.getSelectedValue();
				manager.demoteAthlete(targetAthlete);
				reserveRosterModel.addElement(targetAthlete);
				reserveRosterList.setModel(reserveRosterModel);				
				activeRosterModel.removeElement(targetAthlete);
				activeRosterList.setModel(activeRosterModel);
				activeRosterChangedLabel.setText(targetAthlete.getName() + " benched");

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
		activeExplanationTextArea.setText("The active roster can have 6 athletes. A full active roster is required to compete in matches.\r\n\r\nPress the demote button to move selected player into your reserves.\r\n");
		activeExplanationTextArea.setLineWrap(true);
		activeExplanationTextArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		activeExplanationTextArea.setEditable(false);
		activeExplanationTextArea.setBackground(SystemColor.menu);
		activeExplanationTextArea.setBounds(10, 33, 217, 101);
		activeRosterPanel.add(activeExplanationTextArea);
		

		
		JButton backButton = new JButton("Go back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getReserveRoster().size() > 5) {
					Component fullReservesWarning = null;
					JOptionPane.showMessageDialog(fullReservesWarning, "You have too many players in reserves, add some to your starting lineup", 
							"Reserves full", JOptionPane.WARNING_MESSAGE);
					
				} else if (manager.getMainRoster().size() < 6) {
					Component fullRosterWarning = null;
					JOptionPane.showMessageDialog(fullRosterWarning, "Your main roster does not have enough players to compete. "
							+ "\nPromote some reserves.", 
							"Main roster full", JOptionPane.WARNING_MESSAGE);
				} else {
					finishedWindow();	
				}
			}
		});
		backButton.setBounds(359, 651, 270, 60);
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
		
		JLabel reserveRosterChangeLabel = new JLabel("");
		reserveRosterChangeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reserveRosterChangeLabel.setForeground(new Color(255, 66, 66));
		reserveRosterChangeLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		reserveRosterChangeLabel.setBounds(10, 196, 217, 14);
		reserveRosterPanel.add(reserveRosterChangeLabel);		
		
		JButton reserveRosterChangeButton = new JButton("Promote");
		reserveRosterChangeButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		reserveRosterChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getMainRoster().size() >= 6) {
					Component fullRosterWarning = null;
					JOptionPane.showMessageDialog(fullRosterWarning, "Can't promote player - main roster already has 6.", 
							"Main roster full", JOptionPane.WARNING_MESSAGE);
				} else {
				Athlete targetAthlete = reserveRosterList.getSelectedValue();	
				manager.promoteAthlete(targetAthlete); 
				activeRosterModel.addElement(targetAthlete);
				activeRosterList.setModel(activeRosterModel);				
				reserveRosterModel.removeElement(targetAthlete);
				reserveRosterList.setModel(reserveRosterModel);	
				reserveRosterChangeLabel.setText(targetAthlete.getName() + " promoted");
				}
			}
		});
		reserveRosterChangeButton.setBounds(70, 210, 94, 28);
		reserveRosterPanel.add(reserveRosterChangeButton);
		

		
		JTextArea reserveExplanationTextArea = new JTextArea();
		reserveExplanationTextArea.setWrapStyleWord(true);
		reserveExplanationTextArea.setText("Contains up to 5 players that haven't been selected to play in your next match.\r\n\r\nIt is recommened to have reserves incase your starting lineup gets injured or if someone leavees.\r\n\r\nPress the promote button to move selected player to your starting lineup.\r\n");
		reserveExplanationTextArea.setLineWrap(true);
		reserveExplanationTextArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		reserveExplanationTextArea.setEditable(false);
		reserveExplanationTextArea.setBackground(SystemColor.menu);
		reserveExplanationTextArea.setBounds(10, 33, 217, 154);
		reserveRosterPanel.add(reserveExplanationTextArea);
		
		JButton inventoryButton = new JButton("Inventory");
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchInventoryScreen("Club");
			}
		});
		inventoryButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryButton.setBounds(359, 580, 270, 60);
		frmClubScreen.getContentPane().add(inventoryButton);
		
	}
	

}
