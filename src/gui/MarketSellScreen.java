package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import main.Athlete;
import main.GameManager;
import main.Item;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 * A variation of the Market that enables selling of items instead of purchases.
 * Swapping back and forth between the two modes is easy.
 * @author Stephen Huang
 *
 */
public class MarketSellScreen {

	/**
	 * The MarketSell frame in which all UI elemets are contained.
	 */
	private JFrame frmMarketSellScreen;
	/**
	 * The instance of GameManager which manages this screen.
	 */
	private GameManager manager;
	/**
	 * An ArrayList that will go on to hold the player's owned items.
	 */
	private ArrayList<Item> inventory;
	
	/**
	 * Create the application
	 * Takes an incoming manager and makes it the manager of the screen.
	 * Assign inventory to the list of items from GameManager.
	 * @param incomingManager the GameManager
	 * @param items the inventory from GameManager
	 */
	public MarketSellScreen(GameManager incomingManager, ArrayList<Item> items) { 
		manager = incomingManager;
		inventory = items;
		initialize();
		frmMarketSellScreen.setLocationRelativeTo(null);
		frmMarketSellScreen.setVisible(true);
	}
	/**
	 * Closes the market sell window
	 */
	public void closeWindow() {
		frmMarketSellScreen.dispose();
	}
	/**
	 * Closes this instance of MarketSellScreen using GameManager
	 */
	public void finishedWindow() {
		manager.closeMarketSellScreen(this);
	}
	
	/**
	 * Launch the application.
	 * @param args an array of command-line arguments for the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketSellScreen window = new MarketSellScreen();
					window.frmMarketSellScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MarketSellScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMarketSellScreen = new JFrame();
		frmMarketSellScreen.setTitle("KickHeroes - Market(Sell)");
		frmMarketSellScreen.setBounds(100, 100, 732, 799);
		frmMarketSellScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarketSellScreen.getContentPane().setLayout(null);
		
		JLabel marketSellLabel = new JLabel("The Market");
		marketSellLabel.setHorizontalAlignment(SwingConstants.CENTER);
		marketSellLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		marketSellLabel.setBounds(10, 11, 696, 52);
		frmMarketSellScreen.getContentPane().add(marketSellLabel);
		
		JLabel moneyLabel = new JLabel("Money: $" + manager.getMoneyString());
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		moneyLabel.setBounds(455, 84, 251, 39);
		frmMarketSellScreen.getContentPane().add(moneyLabel);
		
		JLabel sellPurchasablesText = new JLabel("Click to switch to buy Items and Athletes");
		sellPurchasablesText.setHorizontalAlignment(SwingConstants.CENTER);
		sellPurchasablesText.setBounds(10, 58, 696, 14);
		frmMarketSellScreen.getContentPane().add(sellPurchasablesText);
		
		JButton sellPurchasablesButton = new JButton("Buy Purchasables");
		sellPurchasablesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchMarketScreen();
			}
		});
		sellPurchasablesButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		sellPurchasablesButton.setBounds(269, 74, 176, 31);
		frmMarketSellScreen.getContentPane().add(sellPurchasablesButton);
		
		JPanel athletesSellPanel = new JPanel();
		athletesSellPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		athletesSellPanel.setBounds(10, 119, 696, 234);
		frmMarketSellScreen.getContentPane().add(athletesSellPanel);
		athletesSellPanel.setLayout(null);
		athletesSellPanel.setLayout(null);
		
		// Label
		JLabel athletesSellLabel = new JLabel("Athletes in Inventory");
		athletesSellLabel.setBounds(20, 11, 194, 20);
		athletesSellLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		athletesSellPanel.add(athletesSellLabel);
	
		//Create Athlete JList
		DefaultListModel<Athlete> inventoryAthleteModel = new DefaultListModel<Athlete>();
		inventoryAthleteModel.addAll(manager.getTeam().getMainRoster());
		inventoryAthleteModel.addAll(manager.getTeam().getReserveRoster());
		
		JList<Athlete> athletesList = new JList<Athlete>(inventoryAthleteModel);
		athletesList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		athletesList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		athletesList.setBounds(10, 51, 676, 172);
		
		//Give the JList to ScrollPane and Display
		JScrollPane athletesScrollPane = new JScrollPane(athletesList);
		athletesScrollPane.setBounds(10, 51, 676, 172);
		Container athletesContainer = athletesSellPanel;
		athletesContainer.add(athletesScrollPane);
		

		
		JLabel athleteSoldLabel = new JLabel("");
		athleteSoldLabel.setBounds(268, 23, 276, 14);
		athleteSoldLabel.setHorizontalAlignment(SwingConstants.CENTER);
		athleteSoldLabel.setForeground(new Color(255, 66, 66));
		athleteSoldLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		athletesSellPanel.add(athleteSoldLabel);
		
		JLabel athletesSellbackPriceLabel = new JLabel("Sellback price is half of purchase price");
		athletesSellbackPriceLabel.setBounds(20, 32, 191, 15);
		athletesSellPanel.add(athletesSellbackPriceLabel);
		athletesSellbackPriceLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		JButton athleteSellButton = new JButton("Sell player");
		athleteSellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete targetAthlete = athletesList.getSelectedValue();
				
				if (targetAthlete == null) {
					//Inform player that they have not selected an athlete.
					athleteSoldLabel.setText("");
					Component notSelectedWarning = null;
					JOptionPane.showMessageDialog(notSelectedWarning,
							"You haven't selected any athletes.", 
							"No athlete selected", JOptionPane.INFORMATION_MESSAGE);									
				}
				
				else {
					// Sell athlete if above condition/s are false.
					manager.sellAthlete(targetAthlete);
					inventoryAthleteModel.removeElement(targetAthlete);
					athletesList.setModel(inventoryAthleteModel);
					athleteSoldLabel.setText(targetAthlete.getName() + " sold for $" + manager.getMoneyFormat(targetAthlete.getSellbackPrice()));
					moneyLabel.setText("Money: $" + manager.getMoneyString());
				}
			}
		});		
		athleteSellButton.setBounds(554, 16, 132, 28);
		athleteSellButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		athletesSellPanel.add(athleteSellButton);	
		
		JPanel itemsSellPanel = new JPanel();
		itemsSellPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		itemsSellPanel.setBounds(10, 365, 696, 234);
		frmMarketSellScreen.getContentPane().add(itemsSellPanel);
		itemsSellPanel.setLayout(null);
		
		JLabel itemsSellLabel = new JLabel("Items in Inventory");
		itemsSellLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		itemsSellLabel.setBounds(20, 11, 194, 20);
		itemsSellPanel.add(itemsSellLabel);
		
		DefaultListModel<Item> inventoryItemListModel = new DefaultListModel<Item>();
		inventoryItemListModel.addAll(inventory);
		
		JList<Item> itemList = new JList<Item>(inventoryItemListModel);
		itemList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		itemList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		itemList.setBounds(10, 51, 676, 172);
		
		JScrollPane itemsScrollPane = new JScrollPane(itemList);
		itemsScrollPane.setBounds(10, 51, 676, 172);
		Container itemsContainer = itemsSellPanel;
		itemsContainer.add(itemsScrollPane);

		JLabel itemSoldLabel = new JLabel("");
		itemSoldLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemSoldLabel.setForeground(new Color(255, 66, 66));
		itemSoldLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		itemSoldLabel.setBounds(268, 23, 276, 14);
		itemsSellPanel.add(itemSoldLabel);
		
		JLabel itemSellbackPriceLabel = new JLabel("Sellback price is half of purchase price");
		itemSellbackPriceLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		itemSellbackPriceLabel.setBounds(20, 32, 191, 15);
		itemsSellPanel.add(itemSellbackPriceLabel);
		
		JButton itemSellButton = new JButton("Sell item");
		itemSellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item targetItem = itemList.getSelectedValue();
				
				if (targetItem == null) {
					// Inform player that they have not selected an item.
					itemSoldLabel.setText("");
					Component notSelectedWarning = null;
					JOptionPane.showMessageDialog(notSelectedWarning,
							"You have not selected a item.", 
							"No item selected", JOptionPane.INFORMATION_MESSAGE);									
				}
				else {
					// Sell athlete if above condition/s are false.
					manager.sellItem(targetItem);
					inventoryItemListModel.removeElement(targetItem);
					itemList.setModel(inventoryItemListModel);
					itemSoldLabel.setText(targetItem.getName() + " sold for $" + manager.getMoneyFormat(targetItem.getSellbackPrice()));
					moneyLabel.setText("Money: $" + manager.getMoneyString());
				}	
			}
		});
		itemSellButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		itemSellButton.setBounds(554, 16, 132, 28);
		itemsSellPanel.add(itemSellButton);		
		
		JButton inventoryButton = new JButton("Inventory");
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchInventoryScreen("SellMarket");
			}
		});
		inventoryButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryButton.setBounds(223, 610, 270, 60);
		frmMarketSellScreen.getContentPane().add(inventoryButton);
		
		JButton goBackButton = new JButton("Go Back");
		goBackButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		
		goBackButton.setBounds(223, 681, 270, 60);
		frmMarketSellScreen.getContentPane().add(goBackButton);
		
	}
}
