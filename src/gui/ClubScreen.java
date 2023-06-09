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
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.ListModel;

/**
 * ClubScreen class.
 * The screen where the player manages their team and athletes.
 * Allows players to promote players to and from the main roster.
 * Designate position roles to athletes. 
 * The inventory can also be accessed from here.
 * @author Stephen Huang and Jasmine Ong
 */
public class ClubScreen {
	/**
	 * The ClubScreen frame in which all UI elements are contained.
	 */
	private JFrame frmClubScreen;
	/**
	 * The instance of GameManager which manages this screen.
	 */
	private GameManager manager;
	/**
	 * A warning label accessible outside of Club so that it may be changed more conveniently.
	 */
	public static JLabel warningLabel;

	/**
	 * Takes an incoming manager and makes it the manager of the screen.
	 * Initializes the screen and make ClubScreen visible.
	 * @param incomingManager is the manager for this screen.
	 */
	public ClubScreen(GameManager incomingManager) {  
		manager = incomingManager;
		initialize();
		frmClubScreen.setLocationRelativeTo(null);
		frmClubScreen.setVisible(true);
	}
	
	/**
	 * Closes the ClubScreen Window
	 */
	public void closeWindow() {
		frmClubScreen.dispose();
	}
	/**
	 * Close this instance of ClubScreen using GameManager
	 */
	public void finishedWindow() {
		manager.closeClubScreen(this);
	}
	
	/**
	 * Launch the application.
	 * @param args array of command-line arguments for the application
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
	 * Create the application.
	 */
	public ClubScreen() {
		initialize();
	}		
	
	/**
	 * Initialize the contents of the frame.
	 */ 
	private void initialize() {
		frmClubScreen = new JFrame();
		frmClubScreen.setTitle("KickHeroes - Club Screen");
		frmClubScreen.setBounds(100, 100, 1115, 756);
		frmClubScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClubScreen.getContentPane().setLayout(null);
		
		JLabel teamLabel = new JLabel(manager.getTeamName() + " Sports Club");
		teamLabel.setBounds(10, 25, 1070, 55);
		teamLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmClubScreen.getContentPane().add(teamLabel);
		
		warningLabel = new JLabel("");
		warningLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		warningLabel.setForeground(new Color(255, 66, 66));
		warningLabel.setBounds(27, 91, 891, 14);
		frmClubScreen.getContentPane().add(warningLabel);
		manager.rosterWarnings();
		
		JPanel activeRosterPanel = new JPanel();
		activeRosterPanel.setBounds(240, 111, 696, 200);
		activeRosterPanel.setLayout(null);
		activeRosterPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		frmClubScreen.getContentPane().add(activeRosterPanel);
		
		// Create a ListModel to store the active athletes in the JList
		DefaultListModel<Athlete> activeRosterModel = new DefaultListModel<Athlete>();
		// Add athletes to the ListModel
		activeRosterModel.addAll(manager.getTeam().getMainRoster());
		
		JLabel activeRosterLabel = new JLabel("Active Roster");
		activeRosterLabel.setBounds(20, 18, 217, 23);
		activeRosterPanel.add(activeRosterLabel);
		activeRosterLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel activeRosterChangedLabel = new JLabel("");
		activeRosterChangedLabel.setBounds(148, 24, 538, 14);
		activeRosterPanel.add(activeRosterChangedLabel);
		activeRosterChangedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		activeRosterChangedLabel.setForeground(new Color(255, 66, 66));
		activeRosterChangedLabel.setFont(new Font("Tahoma", Font.BOLD, 12));		
		
				
		JButton backButton = new JButton("Go back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getTeam().getReserveRoster().size() > 5) {
	                Component fullReservesWarning = null;
	                JOptionPane.showMessageDialog(fullReservesWarning, "You have too many players in reserves. Please add some players to your starting lineup before leaving.", 
	                        "Reserves full", JOptionPane.WARNING_MESSAGE);
				}
				else {
					finishedWindow();
				}
			}
		});
		backButton.setBounds(414, 638, 270, 60);
		frmClubScreen.getContentPane().add(backButton);
		
		// Create a ListModel to store the reserve athletes in the JList
		DefaultListModel<Athlete> reserveRosterModel = new DefaultListModel<Athlete>();
		reserveRosterModel.addAll(manager.getTeam().getReserveRoster());
		
		// Create the JList for reserve roster
		// Needed to be declared early to allow demote button to work.
		JList<Athlete> reserveRosterList = new JList<Athlete>(reserveRosterModel);
		
		JPanel reserveRosterPanel = new JPanel();
		reserveRosterPanel.setLayout(null);
		reserveRosterPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		reserveRosterPanel.setBounds(240, 322, 696, 234);
		frmClubScreen.getContentPane().add(reserveRosterPanel);
		
		reserveRosterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reserveRosterList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reserveRosterList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		reserveRosterList.setBounds(10, 52, 676, 172);
		
		JScrollPane reserveListScrollPane = new JScrollPane(reserveRosterList);
		reserveListScrollPane.setBounds(10, 52, 676, 172);
		Container reserveListContainer = reserveRosterPanel;
		reserveListContainer.add(reserveListScrollPane);
		
		JLabel reserveRosterLabel = new JLabel("Reserve Roster");
		reserveRosterLabel.setBounds(20, 18, 217, 23);
		reserveRosterPanel.add(reserveRosterLabel);
		reserveRosterLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel reserveRosterChangeLabel = new JLabel("");
		reserveRosterChangeLabel.setBounds(148, 24, 538, 14);
		reserveRosterPanel.add(reserveRosterChangeLabel);
		reserveRosterChangeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reserveRosterChangeLabel.setForeground(new Color(255, 66, 66));
		reserveRosterChangeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		reserveRosterList.getSelectedValue();
		
		JButton inventoryButton = new JButton("Inventory");
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchInventoryScreen("Club");
			}
		});
		inventoryButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryButton.setBounds(414, 567, 270, 60);
		frmClubScreen.getContentPane().add(inventoryButton);
		
		JPanel activeRosterExplainationPanel = new JPanel();
		activeRosterExplainationPanel.setLayout(null);
		activeRosterExplainationPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		activeRosterExplainationPanel.setBounds(933, 111, 147, 200);
		frmClubScreen.getContentPane().add(activeRosterExplainationPanel);
		
		JTextArea activeExplanationTextArea = new JTextArea();
		activeExplanationTextArea.setBounds(10, 11, 127, 187);
		activeRosterExplainationPanel.add(activeExplanationTextArea);
		activeExplanationTextArea.setWrapStyleWord(true);
		activeExplanationTextArea.setText("Press the buttons below to assign a position to the selected reserve athlete.\r\n\r\nIf another athlete is already in that position, they will swap places.\r\n\r\n");
		activeExplanationTextArea.setLineWrap(true);
		activeExplanationTextArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		activeExplanationTextArea.setEditable(false);
		activeExplanationTextArea.setBackground(SystemColor.menu);
		
		JPanel reserveRosterExplainationPanel = new JPanel();
		reserveRosterExplainationPanel.setLayout(null);
		reserveRosterExplainationPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		reserveRosterExplainationPanel.setBounds(933, 322, 147, 234);
		frmClubScreen.getContentPane().add(reserveRosterExplainationPanel);
		
		
		Athlete teamStriker = null;
		Athlete teamLeftWing = null;
		Athlete teamRightWing = null;
		Athlete teamDefender = null;
		Athlete teamKeeper = null;
		// Find Athlete positions.
		for (Athlete athlete : manager.getTeam().getMainRoster()) {
			
			switch(athlete.getPosition()) {
			 	case "Striker":
			 		teamStriker = athlete;
			 		break;
			 	case "Left Wing":
			 		teamLeftWing = athlete;
			 		break;
			 	case "Right Wing":
			 		teamRightWing = athlete;
			 		break;
			    case "Defender":
			    	teamDefender = athlete;
			    	break;
			    case "Keeper":
			    	teamKeeper = athlete;
			    	break;
			}
		}		
		
		// Create a ListModel to store the Striker
		DefaultListModel<Athlete> strikerModel = new DefaultListModel<Athlete>();
		// Add Striker to the ListModel
		if (teamStriker != null) {
			strikerModel.addElement(teamStriker);
			
		}
		// Create the JList to hold Striker.
		JList<Athlete> strikerList = new JList<Athlete>(strikerModel);
		strikerList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		strikerList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		strikerList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		strikerList.setBounds(10, 62, 676, 24);
		activeRosterPanel.add(strikerList);
		
		// Create a ListModel to store the Left Wing
		DefaultListModel<Athlete> leftWingModel = new DefaultListModel<Athlete>();
		// Add Striker to the ListModel
		if (teamLeftWing != null) {
		    leftWingModel.addElement(teamLeftWing);
		}

		JList<Athlete> leftWingList = new JList<Athlete>(leftWingModel);
		leftWingList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		leftWingList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		leftWingList.setBounds(10, 83, 676, 24);
		activeRosterPanel.add(leftWingList);		
		
		// Create a ListModel to store the Right Wing
		DefaultListModel<Athlete> rightWingModel = new DefaultListModel<Athlete>();
		// Add Right Wing to the ListModel
		if (teamRightWing != null) {
		    rightWingModel.addElement(teamRightWing);
		}
		
		JList<Athlete> rightWingList = new JList<Athlete>(rightWingModel);
		rightWingList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rightWingList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		rightWingList.setBounds(10, 103, 676, 24);
		activeRosterPanel.add(rightWingList);

		// Create a ListModel to store the Defender
		DefaultListModel<Athlete> defenderModel = new DefaultListModel<Athlete>();
		// Add Defender to the ListModel
		if (teamDefender != null) {
		    defenderModel.addElement(teamDefender);
		}
		
		JList<Athlete> defenderList = new JList<Athlete>(defenderModel);
		defenderList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		defenderList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		defenderList.setBounds(10, 124, 676, 24);
		activeRosterPanel.add(defenderList);

		// Create a ListModel to store the Goalkeeper
		DefaultListModel<Athlete> keeperModel = new DefaultListModel<Athlete>();
		// Add Goalkeeper to the ListModel
		if (teamKeeper != null) {
		    keeperModel.addElement(teamKeeper);
		}

		JList<Athlete> keeperList = new JList<Athlete>(keeperModel);
		keeperList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		keeperList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		keeperList.setBounds(10, 145, 676, 24);
		activeRosterPanel.add(keeperList);	
		
		JButton strikerButton = new JButton("Striker");
		strikerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete targetAthlete = reserveRosterList.getSelectedValue();
				//targetAthlete.setPosition("Striker");
				manager.getTeam().promoteAthlete(targetAthlete, "Striker");
		        // Check if there is already an athlete in the strikerList
		        if (strikerModel.getSize() > 0) {
		            // Get the existing athlete in the strikerList
		            Athlete existingAthlete = strikerModel.getElementAt(0);
		            // Remove the existing athlete from the strikerList
		            strikerModel.removeElement(existingAthlete);
		            // Demote the existing athlete using GameManager
		            manager.getTeam().demoteAthlete(existingAthlete);
		            // Add the targetAthlete to the strikerList
		            strikerModel.addElement(targetAthlete);
		            // Update the strikerList model
		            strikerList.setModel(strikerModel);
		            // Add the existing athlete back to the reserves
		            reserveRosterModel.addElement(existingAthlete);
		            // Update the reserveList model
		            reserveRosterList.setModel(reserveRosterModel);
		            // Update the label with the replacement message
		            activeRosterChangedLabel.setText(existingAthlete.getName() + " replaced by " + targetAthlete.getName() + " as starting Striker.");
		        } else {
		            // If there is no athlete in the strikerList, simply add the targetAthlete
		            strikerModel.addElement(targetAthlete);
		            strikerList.setModel(strikerModel);
		            reserveRosterChangeLabel.setText(targetAthlete.getName() + " promoted to starting Striker.");
		        }
		        // Remove the targetAthlete from the reserveRosterList
		        reserveRosterModel.removeElement(targetAthlete);
		        reserveRosterList.setModel(reserveRosterModel);
		        manager.rosterWarnings();
		    }
		});
		strikerButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		strikerButton.setBounds(10, 11, 127, 32);
		reserveRosterExplainationPanel.add(strikerButton);
		
		// Left Wing Button
		JButton leftWingButton = new JButton("Left Wing");
		leftWingButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		leftWingButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Athlete targetAthlete = reserveRosterList.getSelectedValue();
		       // targetAthlete.setPosition("Left Wing");
		        manager.getTeam().promoteAthlete(targetAthlete, "Left Wing");
		        // Check if there is already an athlete in the leftWingList
		        if (leftWingModel.getSize() > 0) {
		            // Get the existing athlete in the leftWingList
		            Athlete existingAthlete = leftWingModel.getElementAt(0);
		            // Remove the existing athlete from the leftWingList
		            leftWingModel.removeElement(existingAthlete);
		            // Demote the existing athlete using GameManager
		            manager.getTeam().demoteAthlete(existingAthlete);
		            // Add the targetAthlete to the leftWingList
		            leftWingModel.addElement(targetAthlete);
		            // Update the leftWingList model
		            leftWingList.setModel(leftWingModel);
		            // Add the existing athlete back to the reserves
		            reserveRosterModel.addElement(existingAthlete);
		            // Update the reserveList model
		            reserveRosterList.setModel(reserveRosterModel);
		            // Update the label with the replacement message
		            activeRosterChangedLabel.setText(existingAthlete.getName() + " replaced by " + targetAthlete.getName() + " as starting Left Wing.");
		        } else {
		            // If there is no athlete in the leftWingList, simply add the targetAthlete
		            leftWingModel.addElement(targetAthlete);
		            leftWingList.setModel(leftWingModel);
		            reserveRosterChangeLabel.setText(targetAthlete.getName() + " promoted to starting Left Wing.");
		        }
		        // Remove the targetAthlete from the reserveRosterList
		        reserveRosterModel.removeElement(targetAthlete);
		        reserveRosterList.setModel(reserveRosterModel);
		        manager.rosterWarnings();
		    }
		});
		leftWingButton.setBounds(10, 54, 127, 32);
		reserveRosterExplainationPanel.add(leftWingButton);

		// Right Wing Button
		JButton rightWingButton = new JButton("Right Wing");
		rightWingButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rightWingButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Athlete targetAthlete = reserveRosterList.getSelectedValue();
		        //targetAthlete.setPosition("Right Wing");
		        manager.getTeam().promoteAthlete(targetAthlete, "Right Wing");
		        // Check if there is already an athlete in the rightWingList
		        if (rightWingModel.getSize() > 0) {
		            // Get the existing athlete in the rightWingList
		            Athlete existingAthlete = rightWingModel.getElementAt(0);
		            // Remove the existing athlete from the rightWingList
		            rightWingModel.removeElement(existingAthlete);
		            // Demote the existing athlete using GameManager
		            manager.getTeam().demoteAthlete(existingAthlete);
		            // Add the targetAthlete to the rightWingList
		            rightWingModel.addElement(targetAthlete);
		            // Update the rightWingList model
		            rightWingList.setModel(rightWingModel);
		            // Add the existing athlete back to the reserves
		            reserveRosterModel.addElement(existingAthlete);
		            // Update the reserveList model
		            reserveRosterList.setModel(reserveRosterModel);
		            // Update the label with the replacement message
		            activeRosterChangedLabel.setText(existingAthlete.getName() + " replaced by " + targetAthlete.getName() + " as starting Right Wing.");
		        } else {
		            // If there is no athlete in the rightWingList, simply add the targetAthlete
		            rightWingModel.addElement(targetAthlete);
		            rightWingList.setModel(rightWingModel);
		            reserveRosterChangeLabel.setText(targetAthlete.getName() + " promoted to starting Right Wing.");
		        }
		        // Remove the targetAthlete from the reserveRosterList
		        reserveRosterModel.removeElement(targetAthlete);
		        reserveRosterList.setModel(reserveRosterModel);
		        manager.rosterWarnings();
		    }
		});
		rightWingButton.setBounds(10, 97, 127, 32);
		reserveRosterExplainationPanel.add(rightWingButton);

		// Defender Button
		JButton defenderButton = new JButton("Defender");
		defenderButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		defenderButton.setBounds(10, 140, 127, 32);
		defenderButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Athlete targetAthlete = reserveRosterList.getSelectedValue();
		        //targetAthlete.setPosition("Defender");
		        manager.getTeam().promoteAthlete(targetAthlete, "Defender");
		        // Check if there is already an athlete in the defenderList
		        if (defenderModel.getSize() > 0) {
		            // Get the existing athlete in the defenderList
		            Athlete existingAthlete = defenderModel.getElementAt(0);
		            // Remove the existing athlete from the defenderList
		            defenderModel.removeElement(existingAthlete);
		            // Demote the existing athlete using GameManager
		            manager.getTeam().demoteAthlete(existingAthlete);
		            // Add the targetAthlete to the defenderList
		            defenderModel.addElement(targetAthlete);
		            // Update the defenderList model
		            defenderList.setModel(defenderModel);
		            // Add the existing athlete back to the reserves
		            reserveRosterModel.addElement(existingAthlete);
		            // Update the reserveList model
		            reserveRosterList.setModel(reserveRosterModel);
		            // Update the label with the replacement message
		            activeRosterChangedLabel.setText(existingAthlete.getName() + " replaced by " + targetAthlete.getName() + " as starting Defender.");
		        } else {
		            // If there is no athlete in the defenderList, simply add the targetAthlete
		            defenderModel.addElement(targetAthlete);
		            defenderList.setModel(defenderModel);
		            reserveRosterChangeLabel.setText(targetAthlete.getName() + " promoted to starting Defender.");
		        }
		        // Remove the targetAthlete from the reserveRosterList
		        reserveRosterModel.removeElement(targetAthlete);
		        reserveRosterList.setModel(reserveRosterModel);
		        manager.rosterWarnings();
		    }
		});
		reserveRosterExplainationPanel.add(defenderButton);

		// Keeper Button
		JButton keeperButton = new JButton("Keeper");
		keeperButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		keeperButton.setBounds(10, 183, 127, 32);
		keeperButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Athlete targetAthlete = reserveRosterList.getSelectedValue();
		        //targetAthlete.setPosition("Keeper");
		        manager.getTeam().promoteAthlete(targetAthlete, "Keeper");
		        // Check if there is already an athlete in the keeperList
		        if (keeperModel.getSize() > 0) {
		            // Get the existing athlete in the keeperList
		            Athlete existingAthlete = keeperModel.getElementAt(0);
		            // Remove the existing athlete from the keeperList
		            keeperModel.removeElement(existingAthlete);
		            // Demote the existing athlete using GameManager
		            manager.getTeam().demoteAthlete(existingAthlete);
		            // Add the targetAthlete to the keeperList
		            keeperModel.addElement(targetAthlete);
		            // Update the keeperList model
		            keeperList.setModel(keeperModel);
		            // Add the existing athlete back to the reserves
		            reserveRosterModel.addElement(existingAthlete);
		            // Update the reserveList model
		            reserveRosterList.setModel(reserveRosterModel);
		            // Update the label with the replacement message
		            activeRosterChangedLabel.setText(existingAthlete.getName() + " replaced by " + targetAthlete.getName() + " as starting Keeper.");
		        } else {
		            // If there is no athlete in the keeperList, simply add the targetAthlete
		            keeperModel.addElement(targetAthlete);
		            keeperList.setModel(keeperModel);
		            reserveRosterChangeLabel.setText(targetAthlete.getName() + " promoted to starting Keeper.");
		        }
		        // Remove the targetAthlete from the reserveRosterList
		        reserveRosterModel.removeElement(targetAthlete);
		        reserveRosterList.setModel(reserveRosterModel);
		        manager.rosterWarnings();
		    }
		});
		keeperButton.setBounds(10, 183, 127, 32);
		reserveRosterExplainationPanel.add(keeperButton);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		leftPanel.setBounds(22, 111, 222, 200);
		frmClubScreen.getContentPane().add(leftPanel);
		leftPanel.setLayout(null);
		
		JTextArea txtrTheActiveRoster = new JTextArea();
		txtrTheActiveRoster.setWrapStyleWord(true);
		txtrTheActiveRoster.setText("The active roster can have up to 5 athletes. \r\n\r\nA full active roster is required to compete in matches.\r\n\r\nFurthermore each starting athlete must have at least one stamina.\r\n\r\nAthletes with depleted stamina cannot compete.\r\n\r\n\r\n\r\n");
		txtrTheActiveRoster.setLineWrap(true);
		txtrTheActiveRoster.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrTheActiveRoster.setEditable(false);
		txtrTheActiveRoster.setBackground(SystemColor.menu);
		txtrTheActiveRoster.setBounds(10, 11, 202, 187);
		leftPanel.add(txtrTheActiveRoster);
		
		JPanel reservePanel = new JPanel();
		reservePanel.setLayout(null);
		reservePanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		reservePanel.setBounds(22, 322, 222, 234);
		frmClubScreen.getContentPane().add(reservePanel);
		

		
		JTextArea reserveExplanationText = new JTextArea();
		reserveExplanationText.setBounds(10, 55, 202, 161);
		reservePanel.add(reserveExplanationText);
		reserveExplanationText.setWrapStyleWord(true);
		reserveExplanationText.setText("Contains up to 5 players that haven't been selected to play in your next match.\r\n\r\nIt is recommended to have reserves incase your starting lineup gets injured or if someone leaves.\r\n\r\n\r\n");
		reserveExplanationText.setLineWrap(true);
		reserveExplanationText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		reserveExplanationText.setEditable(false);
		reserveExplanationText.setBackground(SystemColor.menu);
	
		
	}
}
