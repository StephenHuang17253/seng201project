package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import main.Athlete;
import main.GameManager;
import main.Item;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
/**
 * The Inventory page is where the player can view and use Items they have bought from the Market.
 * It is accessed from either the Club or the Market and the class tracks which screen it came from
 * so it can return to the correct one when the player presses 'Go Back'.
 * @author Stephen Huang
 * @author Jasmine Ong
 */
public class InventoryScreen {
	/**
	 * The InventoryScreen frame, contains all the UI elements.
	 */
	private JFrame frmInventoryScreen;
	/**
	 * The instance of GameManager that manages this screen.
	 */
	private GameManager manager;
	/**
	 * A string representing a record of which screen the player was in when they accessed the inventory.
	 */
	private String origin;
	/**
	 * The ArrayList which stores the Items objects owned by the player.
	 * Consider this list the inventory the screen is named after.
	 */
	private ArrayList<Item> inventory;
	
	/**
	 * Create the Application
	 * Takes an incoming manager and makes it the manager of this screen.
	 * @param incomingManager instance of GameManager that will manage this screen
	 * @param items ArrayList that is the inventory
	 * @param origin the screen from which the player accessed the inventory
	 */
	public InventoryScreen(GameManager incomingManager, ArrayList<Item> items, String origin) {
		this.origin = origin;
		inventory = items;
		manager = incomingManager;
		initialize();
		frmInventoryScreen.setLocationRelativeTo(null); 
		frmInventoryScreen.setVisible(true);
	}
	/**
	 * Close the start screen window.
	 */
	public void closeWindow() {
		frmInventoryScreen.dispose();
	}
	/**
	 * Close this instance of InventoryScreen using GameManager
	 * @param origin the previous screen
	 */
	public void finishedWindow(String origin) {
		manager.closeInventoryScreen(this, origin);
	}
	
	/**
	 * Launch the application.
	 * @param args array of command-line arguments for the application

	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryScreen window = new InventoryScreen();
					window.frmInventoryScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InventoryScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInventoryScreen = new JFrame();
		frmInventoryScreen.setTitle("KickHeroes - Inventory");
		frmInventoryScreen.setBounds(100, 100, 732, 799);
		frmInventoryScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventoryScreen.getContentPane().setLayout(null);
		
		JLabel inventoryLabel = new JLabel("Inventory");
		inventoryLabel.setBounds(10, 27, 696, 43);
		inventoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		frmInventoryScreen.getContentPane().add(inventoryLabel);
		
		JPanel inventoryAthletePanel = new JPanel();
		inventoryAthletePanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		inventoryAthletePanel.setBackground(new Color(240, 240, 240));
		inventoryAthletePanel.setBounds(10, 119, 696, 234);
		frmInventoryScreen.getContentPane().add(inventoryAthletePanel);
		inventoryAthletePanel.setLayout(null);
		
		DefaultListModel<Athlete> inventoryAthleteModel = new DefaultListModel<Athlete>();
		inventoryAthleteModel.addAll(manager.getTeam().getMainRoster());
		inventoryAthleteModel.addAll(manager.getTeam().getReserveRoster());
		
		JList<Athlete> inventoryAthleteList = new JList<Athlete>(inventoryAthleteModel);
		inventoryAthleteList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		inventoryAthleteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		inventoryAthleteList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		inventoryAthleteList.setBounds(10, 51, 676, 203);
		inventoryAthleteList.setModel(inventoryAthleteModel);
		
		JScrollPane inventoryAthleteScrollPane = new JScrollPane(inventoryAthleteList);
		inventoryAthleteScrollPane.setBounds(10, 51, 676, 172);
		Container inventoryAthleteContainer = inventoryAthletePanel;
		inventoryAthleteContainer.add(inventoryAthleteScrollPane);
		
		JLabel inventoryAthletesLabel = new JLabel("Athletes");
		inventoryAthletesLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		inventoryAthletesLabel.setBounds(20, 18, 194, 20);
		inventoryAthletePanel.add(inventoryAthletesLabel);
		
		JLabel athleteStatsLabel = new JLabel("");
		athleteStatsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		athleteStatsLabel.setForeground(new Color(255, 66, 66));
		athleteStatsLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		athleteStatsLabel.setBounds(166, 20, 364, 14);
		inventoryAthletePanel.add(athleteStatsLabel);
		
		JPanel inventoryItemPanel = new JPanel();
		inventoryItemPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		inventoryItemPanel.setBounds(10, 365, 696, 234);
		frmInventoryScreen.getContentPane().add(inventoryItemPanel);
		inventoryItemPanel.setLayout(null);
		
		DefaultListModel<Item> inventoryModel = new DefaultListModel<Item>();
		inventoryModel.addAll(inventory);
		
		JList<Item> inventoryItemList = new JList<Item>(inventoryModel);
		inventoryItemList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		inventoryItemList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		inventoryItemList.setBounds(10, 51, 676, 203);
		
		JScrollPane inventoryItemScrollPane = new JScrollPane(inventoryItemList);
		inventoryItemScrollPane.setBounds(10, 51, 676, 172);
		Container inventoryItemContainer = inventoryItemPanel;
		inventoryItemContainer.add(inventoryItemScrollPane);
		
		JLabel inventoryItemsLabel = new JLabel("Items");
		inventoryItemsLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		inventoryItemsLabel.setBounds(20, 18, 194, 20);
		inventoryItemPanel.add(inventoryItemsLabel);
		
		JLabel itemUsedLabel = new JLabel("");
		itemUsedLabel.setBounds(166, 23, 364, 14);
		inventoryItemPanel.add(itemUsedLabel);
		itemUsedLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		itemUsedLabel.setForeground(new Color(255, 66, 66));
		itemUsedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton useItemButton = new JButton("Use Item");
		useItemButton.setBounds(554, 16, 132, 28);
		inventoryItemPanel.add(useItemButton);
		useItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete targetAthlete = inventoryAthleteList.getSelectedValue();
				Item usedItem = inventoryItemList.getSelectedValue();
				if ((targetAthlete == null)&&(usedItem == null)) {
					// Inform player that they have not selected an athlete.
					Component notSelectedWarning = null;
					JOptionPane.showMessageDialog(notSelectedWarning,
							"You have not selected an athlete or an item.", 
							"No athlete or item selected", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (targetAthlete == null) {
					// Inform player that they have not selected an athlete.
					Component notSelectedWarning = null;
					JOptionPane.showMessageDialog(notSelectedWarning,
							"You have not selected an athlete.", 
							"No athlete selected", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (usedItem == null) {
					// Inform player that they have not selected an item.
					Component notSelectedWarning = null;
					JOptionPane.showMessageDialog(notSelectedWarning,
							"You have not selected a item.", 
							"No item selected", JOptionPane.INFORMATION_MESSAGE);									
				}
				else {
					manager.useItem(targetAthlete, usedItem);
					itemUsedLabel.setText(usedItem.getName() + " Used!");
					athleteStatsLabel.setText(targetAthlete.getName() + "'s "+ usedItem.getStatToChange() + " stat increased by " + usedItem.getChange());
					inventoryModel.removeElement(usedItem);
					inventoryItemList.setModel(inventoryModel);
					inventoryAthleteList.setModel(inventoryAthleteModel);
				}

			}
		});
		useItemButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton backButton = new JButton("Go Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(origin);
			}
		});
		backButton.setBounds(223, 649, 270, 60);
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmInventoryScreen.getContentPane().add(backButton);
		
		JLabel lblNewLabel = new JLabel("Please select the athlete that you want to use your item on.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 100, 439, 14);
		frmInventoryScreen.getContentPane().add(lblNewLabel);
	}
}
