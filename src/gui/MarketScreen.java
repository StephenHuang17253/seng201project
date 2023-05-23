package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.Athlete;
import main.GameManager;
import main.Item;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.border.LineBorder;

import items.DefensiveCoach;
import items.Nutritionist;
import items.OffensiveCoach;
import items.Trainer;

import javax.swing.JList;
import javax.swing.JOptionPane;
/**
 * The screen that displays Athletes and Items for sale and allows the player to make purchases/sales.
 * Also allows the player to access the inventory so they can more quickly access their new Items.
 * @author steph
 *
 */
public class MarketScreen {
	/**
	 * The MarketScreen frame in which all UI elements are contained.
	 */
	private JFrame frmMarketScreen;
	/**
	 * The instance of GameManger which manages this screen.
	 */
	private GameManager manager;
	/**
	 * Initialise an ArrayList to hold this week's generated Athlete objects
	 */
	private ArrayList<Athlete> athletesForSale = new ArrayList<>();
	/**
	 * Initialise an ArrayList to hold this week's Item objects
	 */
	private ArrayList<Item> itemsForSale = new ArrayList<>();
	
	/**
	 * Create the application
	 * Takes an incoming manager and makes it the manager of the screen
	 * Set the athletesForSale equal to this week's list of generated Athletes
	 * Set the ItemsForSale equal to a restock of Items
	 * @param incomingManager the GameManager
	 */
	public MarketScreen(GameManager incomingManager) {
		manager = incomingManager;
		athletesForSale = manager.getMarketAthletes();
		itemsForSale = manager.getMarketItems();
		initialize();
		frmMarketScreen.setLocationRelativeTo(null);
		frmMarketScreen.setVisible(true);
	}	 
	/**
	 * Closes the market window
	 */
	public void closeWindow() {
		frmMarketScreen.dispose();
	}
	/**
	 * Closes this instance of MarketScreen using GameManager
	 */
	public void finishedWindow() {
		manager.closeMarketScreen(this);
	}
	
	
	/**
	 * Launch the application.
	 * @param args an array of command-line arguments for the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketScreen window = new MarketScreen();
					window.frmMarketScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** 
	 * Create the application.
	 */
	public MarketScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMarketScreen = new JFrame();
		frmMarketScreen.setTitle("KickHeroes - Market(Buy)");
		frmMarketScreen.setBounds(100, 100, 732, 799);
		frmMarketScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarketScreen.getContentPane().setLayout(null);
		
		JLabel moneyLabel = new JLabel("Money: $" + manager.getMoneyString());
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		moneyLabel.setBounds(455, 84, 251, 39);
		frmMarketScreen.getContentPane().add(moneyLabel);
		
		JButton sellPurchasablesButton = new JButton("Sell Purchasables");
		sellPurchasablesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchMarketSellScreen();
			}
		});
		sellPurchasablesButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		sellPurchasablesButton.setBounds(269, 74, 176, 31);
		frmMarketScreen.getContentPane().add(sellPurchasablesButton);
		
		JLabel marketLabel = new JLabel("The Market");
		marketLabel.setHorizontalAlignment(SwingConstants.CENTER);
		marketLabel.setBounds(10, 11, 696, 52);
		marketLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		frmMarketScreen.getContentPane().add(marketLabel);
		
		JButton backButton = new JButton("Go back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setBounds(223, 681, 270, 60);
		frmMarketScreen.getContentPane().add(backButton);
		
		JPanel athletePanel = new JPanel();
		athletePanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		athletePanel.setBounds(10, 119, 696, 234);
		frmMarketScreen.getContentPane().add(athletePanel);
		athletePanel.setLayout(null);
		
		
		// Create a ListModel to store the athletes in the JList
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		// Add the existing athletes to the ListModel
		athleteListModel.addAll(athletesForSale);
		
		JList<Athlete> athleteList = new JList<Athlete>(athleteListModel);
		athleteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		athleteList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		athleteList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		athleteList.setBounds(10, 51, 676, 172);
		athleteList.getSelectedValue();
		
		//Give the JList to ScrollPane and Display
		JScrollPane athleteScrollPane = new JScrollPane(athleteList);
		athleteScrollPane.setBounds(10, 51, 676, 172);
		Container athleteContainer = athletePanel;
		athleteContainer.add(athleteScrollPane);
		
		JLabel athleteBoughtLabel = new JLabel("");
		athleteBoughtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		athleteBoughtLabel.setBounds(173, 24, 234, 14);
		athletePanel.add(athleteBoughtLabel);
		athleteBoughtLabel.setForeground(new Color(255, 66, 66));
		athleteBoughtLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel athletesForSaleLabel = new JLabel("Athletes For Sale!");
		athletesForSaleLabel.setBounds(20, 18, 194, 20);
		athletePanel.add(athletesForSaleLabel);
		athletesForSaleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		JButton draftMainAthleteButton = new JButton("Draft to main");
		draftMainAthleteButton.setBounds(412, 16, 132, 28);
		athletePanel.add(draftMainAthleteButton);
		draftMainAthleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Athlete targetAthlete = athleteList.getSelectedValue();
				int athleteSum = manager.getMainRoster().size() + manager.getReserveRoster().size();
				
			
				if (targetAthlete == null) {
					// Inform player that they haven't selected an athlete.
					Component notSelectedWarning = null;
					JOptionPane.showMessageDialog(notSelectedWarning,
							"You have not selected an athlete.", 
							"No athlete selected", JOptionPane.INFORMATION_MESSAGE);
				
					} else if (athleteSum == 10) {
						// Warn player that they have too many athletes
						Component fullClubWarning = null;
						JOptionPane.showMessageDialog(fullClubWarning,
								"Your club has too many athletes.", 
								"Can't have more than 10 players", JOptionPane.WARNING_MESSAGE);
					
					} else if (manager.getMoney() < targetAthlete.getContractPrice()) {  
						// Warn player if they can't afford the athlete
						Component costWarning = null;
						JOptionPane.showMessageDialog(costWarning,
								"You can't afford this.", 
								"Insufficent funds", JOptionPane.WARNING_MESSAGE);
					//} else if (manager.getMainRoster().size() == 5) { 
						// Warn player that reserves are full
						//Component fullRosterWarning = null;
						//JOptionPane.showMessageDialog(fullRosterWarning,
								//"Main roster already has 5 athletes.", 
								//"Main roster full", JOptionPane.WARNING_MESSAGE);
					}  

					else{  
						// Draft athlete if all above the conditions are false
				        String[] options = { "Striker", "Left Wing", "Right Wing", "Defender", "Keeper" };

				        Component pickPosition = null;
						int selectedPosition = JOptionPane.showOptionDialog(pickPosition,
				                "Which position would you like to assign to the athlete?",
				                "Drafting to active roster",
				                JOptionPane.DEFAULT_OPTION,
				                JOptionPane.QUESTION_MESSAGE,
				                null,
				                options,
				                options[0]);
						// Need to account for player closing the dialog
				        if (selectedPosition >= 0) {
				            String position = options[selectedPosition];
				            System.out.println("Assigned position: " + position);
				            Object draftMessage = null;
				            // Update Game
				    		manager.checkAthletePositions();
				    		Athlete previousPlayer = manager.getPlayerInPosition(position);
				    		if (previousPlayer != null) {
				    			manager.demoteAthlete(previousPlayer);
				    			draftMessage = targetAthlete.getName() + " assigned as " + position + 
				    					"\n" + previousPlayer.getName() + " benched.";
				    		} else {
				    			draftMessage = targetAthlete.getName() + " has been drafted as a " + position;
				    		}
							manager.draftMainAthlete(targetAthlete, position);
							
							
							// Update UI
							athleteListModel.removeElement(targetAthlete);
							athleteList.setModel(athleteListModel);
							athleteBoughtLabel.setText(targetAthlete.getName() + " drafted to main.");
							moneyLabel.setText("Money: $" + manager.getMoneyString());		
							
							// Inform player of replacement
			    			Component draftFrame = null;
							JOptionPane.showMessageDialog(draftFrame,
									draftMessage,
									"Athlete drafted", JOptionPane.INFORMATION_MESSAGE);
							
							
				        }

					} 
				
			}
		});	
		draftMainAthleteButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton draftReserveAthleteButton = new JButton("Draft to reserves");
		draftReserveAthleteButton.setBounds(554, 16, 132, 28);
		athletePanel.add(draftReserveAthleteButton);
		draftReserveAthleteButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		draftReserveAthleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Athlete targetAthlete = athleteList.getSelectedValue();
				int totalAthletes = manager.getMainRoster().size() + manager.getReserveRoster().size();
				
				if (targetAthlete == null) {
					// Inform player that they have not selected an athlete.
					Component notSelectedWarning = null;
					JOptionPane.showMessageDialog(notSelectedWarning,
							"You have not selected an athlete.", 
							"No athlete selected", JOptionPane.INFORMATION_MESSAGE);
					
					} else if (totalAthletes == 10){
					// Warn player that they have too many athletes.
					Component fullClubWarning = null;
					JOptionPane.showMessageDialog(fullClubWarning,
							"Your club has too many athletes.", 
							"Can't have more than 10 players", JOptionPane.WARNING_MESSAGE);
					

					} else if (manager.getMoney() < targetAthlete.getContractPrice()) {  
						// Warn player if they can't afford the athlete.
						Component costWarning = null;
						JOptionPane.showMessageDialog(costWarning,
								"You can't afford this.", 
								"Insufficent funds", JOptionPane.WARNING_MESSAGE);
					  
					} else if (manager.getReserveRoster().size() >= 5) {
						// Warn player that reserves are full.
						Component fullRosterWarning = null;
						JOptionPane.showMessageDialog(fullRosterWarning,
								"Reserve roster already has 5 athletes.", 
								"Reserves full", JOptionPane.WARNING_MESSAGE);
					}  

					else {  
						// Draft athlete if all above the conditions are false
						manager.draftReserveAthlete(targetAthlete);
						athleteListModel.removeElement(targetAthlete);
						athleteList.setModel(athleteListModel);
						athleteBoughtLabel.setText(targetAthlete.getName() + " drafted to reserves.");
						moneyLabel.setText("Money: $" + manager.getMoneyString());
					}  		
			}
		});

		JPanel itemPanel = new JPanel();
		itemPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		itemPanel.setBounds(10, 365, 696, 234);
		frmMarketScreen.getContentPane().add(itemPanel);
		itemPanel.setLayout(null);
		
		// Create a ListModel to store the items in the JList
		DefaultListModel<Item> itemListModel = new DefaultListModel<Item>();
		// Add the existing items to the ListModel
		itemListModel.addAll(itemsForSale);
		
		JList<Item> itemList = new JList<Item>(itemListModel);
		itemList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		itemList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		itemList.setBounds(10, 51, 676, 172);
		itemList.getSelectedValue();
		
		//Give the JList to ScrollPane and Display
		JScrollPane itemScrollPane = new JScrollPane(itemList);
		itemScrollPane.setBounds(10, 51, 676, 172);
		Container itemContainer = itemPanel;
		itemContainer.add(itemScrollPane);
		
		JLabel itemBoughtLabel = new JLabel("");
		itemBoughtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemBoughtLabel.setForeground(new Color(255, 66, 66));
		itemBoughtLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		itemBoughtLabel.setBounds(268, 24, 276, 14);
		itemPanel.add(itemBoughtLabel);
		
		JLabel itemsForSaleLabel = new JLabel("Items For Sale!");
		itemsForSaleLabel.setBounds(20, 18, 194, 20);
		itemPanel.add(itemsForSaleLabel);
		itemsForSaleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton itemPurchaseButton = new JButton("Purchase");
		itemPurchaseButton.setBounds(554, 16, 132, 28);
		itemPanel.add(itemPurchaseButton);
		itemPurchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Item targetItem = itemList.getSelectedValue();
			    if (targetItem != null && manager.getMoney() >= targetItem.getContractPrice()) {
			        manager.purchaseItem(targetItem);
			        itemListModel.removeElement(targetItem);
			        itemList.setModel(itemListModel);
			        itemBoughtLabel.setText(targetItem.getName() + " Bought for" + manager.getMoneyFormat(targetItem.getContractPrice()));
			        moneyLabel.setText("Money: $" + manager.getMoneyString());
			    } else {
			        Component purchaseWarning = null;
			        if (targetItem == null) {
			            JOptionPane.showMessageDialog(purchaseWarning, "No item selected.", 
			                    "No Item Selected", JOptionPane.WARNING_MESSAGE);
			        } else {
			            JOptionPane.showMessageDialog(purchaseWarning, "You can't afford this.",
			                    "Insufficient Funds", JOptionPane.WARNING_MESSAGE);
			        }
			    }
			}
		});
		
		itemPurchaseButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton inventoryButton = new JButton("Inventory");
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchInventoryScreen("Market");
			}
		});
		inventoryButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryButton.setBounds(223, 610, 270, 60);
		frmMarketScreen.getContentPane().add(inventoryButton);
		
		JLabel sellPurchasablesText = new JLabel("Click to switch to sell Items and Athletes");
		sellPurchasablesText.setHorizontalAlignment(SwingConstants.CENTER);
		sellPurchasablesText.setBounds(10, 58, 696, 14);
		frmMarketScreen.getContentPane().add(sellPurchasablesText);		
	}
}
