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
import javax.swing.ListModel;

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
		frmClubScreen.setTitle("KickHeroes - Club Screen");
		frmClubScreen.setBounds(100, 100, 1115, 817);
		frmClubScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClubScreen.getContentPane().setLayout(null);
		
		JLabel teamLabel = new JLabel(manager.getTeamName() + " Sports Club");
		teamLabel.setBounds(10, 25, 1070, 55);
		teamLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmClubScreen.getContentPane().add(teamLabel);
		
		JPanel activeRosterPanel = new JPanel();
		activeRosterPanel.setBounds(240, 111, 696, 234);
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
		activeRosterList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		activeRosterList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		activeRosterList.setBounds(10, 51, 676, 172);
		activeRosterPanel.add(activeRosterList);
		
		JLabel activeRosterLabel = new JLabel("Active Roster");
		activeRosterLabel.setBounds(20, 18, 217, 23);
		activeRosterPanel.add(activeRosterLabel);
		activeRosterLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton activeRosterChangeButton = new JButton("Demote");
		activeRosterChangeButton.setBounds(554, 16, 132, 28);
		activeRosterPanel.add(activeRosterChangeButton);
		
		JLabel activeRosterChangedLabel = new JLabel("");
		activeRosterChangedLabel.setBounds(326, 24, 217, 14);
		activeRosterPanel.add(activeRosterChangedLabel);
		activeRosterChangedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		activeRosterChangedLabel.setForeground(new Color(255, 66, 66));
		activeRosterChangedLabel.setFont(new Font("Tahoma", Font.BOLD, 11));		
		activeRosterList.getSelectedValue();
		
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
				
		JButton backButton = new JButton("Go back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getReserveRoster().size() > 5) {
					Component fullReservesWarning = null;
					JOptionPane.showMessageDialog(fullReservesWarning, "You have too many players in reserves, add some to your starting lineup", 
							"Reserves full", JOptionPane.WARNING_MESSAGE);
					
				} else if (manager.getMainRoster().size() < 5) {
					Component fullRosterWarning = null;
					JOptionPane.showMessageDialog(fullRosterWarning, "Your main roster does not have enough players to compete. "
							+ "\nPromote some reserves.", 
							"Main roster full", JOptionPane.WARNING_MESSAGE);
				} else {
					finishedWindow();	
				}
			}
		});
		backButton.setBounds(414, 707, 270, 60);
		frmClubScreen.getContentPane().add(backButton);
		
		JPanel reserveRosterPanel = new JPanel();
		reserveRosterPanel.setLayout(null);
		reserveRosterPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		reserveRosterPanel.setBounds(240, 356, 696, 269);
		frmClubScreen.getContentPane().add(reserveRosterPanel);
		

		reserveRosterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reserveRosterList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reserveRosterList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		reserveRosterList.setBounds(10, 52, 676, 196);
		reserveRosterPanel.add(reserveRosterList);
		
		JLabel reserveRosterLabel = new JLabel("Reserve Roster");
		reserveRosterLabel.setBounds(20, 18, 217, 23);
		reserveRosterPanel.add(reserveRosterLabel);
		reserveRosterLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton reserveRosterChangeButton = new JButton("Promote");
		reserveRosterChangeButton.setBounds(554, 16, 132, 28);
		reserveRosterPanel.add(reserveRosterChangeButton);
		reserveRosterChangeButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel reserveRosterChangeLabel = new JLabel("");
		reserveRosterChangeLabel.setBounds(326, 24, 217, 14);
		reserveRosterPanel.add(reserveRosterChangeLabel);
		reserveRosterChangeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reserveRosterChangeLabel.setForeground(new Color(255, 66, 66));
		reserveRosterChangeLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		reserveRosterChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getMainRoster().size() >= 5) {
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
		reserveRosterList.getSelectedValue();
		
		JButton inventoryButton = new JButton("Inventory");
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchInventoryScreen("Club");
			}
		});
		inventoryButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryButton.setBounds(414, 636, 270, 60);
		frmClubScreen.getContentPane().add(inventoryButton);
		
		JPanel activeRosterExplainationPanel = new JPanel();
		activeRosterExplainationPanel.setLayout(null);
		activeRosterExplainationPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		activeRosterExplainationPanel.setBounds(933, 111, 147, 234);
		frmClubScreen.getContentPane().add(activeRosterExplainationPanel);
		
		JTextArea activeExplanationTextArea = new JTextArea();
		activeExplanationTextArea.setBounds(10, 11, 127, 212);
		activeRosterExplainationPanel.add(activeExplanationTextArea);
		activeExplanationTextArea.setWrapStyleWord(true);
		activeExplanationTextArea.setText("Press the demote button to move selected player into your reserves.\r\n\r\n\r\n\r\n\r\nThe active roster can have 5 athletes. A full active roster is required to compete in matches.\r\n\r\n\r\n\r\n\r\n");
		activeExplanationTextArea.setLineWrap(true);
		activeExplanationTextArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		activeExplanationTextArea.setEditable(false);
		activeExplanationTextArea.setBackground(SystemColor.menu);
		
		JPanel reserveRosterExplainationPanel = new JPanel();
		reserveRosterExplainationPanel.setLayout(null);
		reserveRosterExplainationPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		reserveRosterExplainationPanel.setBounds(933, 355, 147, 270);
		frmClubScreen.getContentPane().add(reserveRosterExplainationPanel);
		
		JButton btnNewButton = new JButton("Right Side Hitter");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 11, 127, 32);
		reserveRosterExplainationPanel.add(btnNewButton);
		
		JButton btnMiddleBlocker = new JButton("Middle Blocker");
		btnMiddleBlocker.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMiddleBlocker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMiddleBlocker.setBounds(10, 54, 127, 32);
		reserveRosterExplainationPanel.add(btnMiddleBlocker);
		
		JButton btnOpposite = new JButton("Opposite");
		btnOpposite.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOpposite.setBounds(10, 97, 127, 32);
		reserveRosterExplainationPanel.add(btnOpposite);
		
		JButton btnSetter = new JButton("Setter");
		btnSetter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSetter.setBounds(10, 140, 127, 32);
		reserveRosterExplainationPanel.add(btnSetter);
		
		JButton btnLibero = new JButton("Libero");
		btnLibero.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLibero.setBounds(10, 183, 127, 32);
		reserveRosterExplainationPanel.add(btnLibero);
		
		JButton btnOutsideHitter = new JButton("Outside Hitter");
		btnOutsideHitter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOutsideHitter.setBounds(10, 226, 127, 32);
		reserveRosterExplainationPanel.add(btnOutsideHitter);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		panel.setBounds(22, 111, 222, 234);
		frmClubScreen.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Position");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 23, 116, 17);
		panel.add(lblNewLabel);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		list.setBounds(10, 51, 202, 172);
		panel.add(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		panel_1.setBounds(22, 356, 222, 269);
		frmClubScreen.getContentPane().add(panel_1);
		

		
		JTextArea reserveExplanationTextArea = new JTextArea();
		reserveExplanationTextArea.setBounds(10, 11, 202, 247);
		panel_1.add(reserveExplanationTextArea);
		reserveExplanationTextArea.setWrapStyleWord(true);
		reserveExplanationTextArea.setText("Press the promote button to move selected player to your starting lineup.\r\n\r\n\r\nContains up to 5 players that haven't been selected to play in your next match.\r\n\r\n\r\nIt is recommended to have reserves incase your starting lineup gets injured or if someone leaves.\r\n\r\n\r\n");
		reserveExplanationTextArea.setLineWrap(true);
		reserveExplanationTextArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		reserveExplanationTextArea.setEditable(false);
		reserveExplanationTextArea.setBackground(SystemColor.menu);
		
	}
}
