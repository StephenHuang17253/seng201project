package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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

public class MarketSellScreen {

	private JFrame frmMarketSellScreen;
	private GameManager manager;
	private ArrayList<Item> inventory;
	
	public MarketSellScreen(GameManager incomingManager, ArrayList<Item> items) {
		manager = incomingManager;
		inventory = items;
		initialize();
		frmMarketSellScreen.setVisible(true);
	}

	public void closeWindow() {
		frmMarketSellScreen.dispose();
	}
	
	public void finishedWindow() {
		manager.closeMarketSellScreen(this);
	}
	
	/**
	 * Launch the application.
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
		moneyLabel.setBounds(455, 83, 235, 39);
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
		inventoryAthleteModel.addAll(manager.getMainRoster());
		inventoryAthleteModel.addAll(manager.getReserveRoster());
		
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
		athleteSoldLabel.setBounds(350, 23, 194, 14);
		athleteSoldLabel.setHorizontalAlignment(SwingConstants.CENTER);
		athleteSoldLabel.setForeground(new Color(255, 66, 66));
		athleteSoldLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
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
					athleteSoldLabel.setText(targetAthlete.getName() + " sold for " + targetAthlete.getSellbackPrice());
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
		
		JButton itemSellButton = new JButton("Sell");
		itemSellButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		itemSellButton.setBounds(554, 16, 132, 28);
		itemsSellPanel.add(itemSellButton);
		
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

		JLabel itemBoughtLabel = new JLabel("");
		itemBoughtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemBoughtLabel.setForeground(new Color(255, 66, 66));
		itemBoughtLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		itemBoughtLabel.setBounds(350, 23, 194, 14);
		itemsSellPanel.add(itemBoughtLabel);
		
		JLabel itemSellbackPriceLabel = new JLabel("Sellback price is half of purchase price");
		itemSellbackPriceLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		itemSellbackPriceLabel.setBounds(20, 32, 191, 15);
		itemsSellPanel.add(itemSellbackPriceLabel);
		
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
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(32, 53, 58, 44);
		frmMarketSellScreen.getContentPane().add(textArea);
		
	}
}
