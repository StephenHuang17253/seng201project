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
import javax.swing.ListSelectionModel;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;

import items.DefensiveCoach;
import items.Nutritionist;
import items.OffensiveCoach;
import items.Trainer;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class MarketScreen {

	private JFrame frmMarketScreen;
	private GameManager manager;
	private ArrayList<Athlete> athletes = new ArrayList<>();
	private ArrayList<Item> items = new ArrayList<>();
	

	public MarketScreen(GameManager incomingManager) {
		manager = incomingManager;
		athletes = manager.getMarketAthletes();
		items = manager.getMarketItems();
		initialize();
		frmMarketScreen.setVisible(true);
	}	 
	
	public void closeWindow() {
		frmMarketScreen.dispose();
	}
	
	public void finishedWindow() {
		manager.closeMarketScreen(this);
	}
	
	
	/**
	 * Launch the application.
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
		frmMarketScreen.setTitle("VolleyballWorld - Market");
		frmMarketScreen.setBounds(100, 100, 931, 704);
		frmMarketScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarketScreen.getContentPane().setLayout(null);
		
		JLabel marketLabel = new JLabel("The Market");
		marketLabel.setHorizontalAlignment(SwingConstants.CENTER);
		marketLabel.setBounds(358, 25, 199, 52);
		marketLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		frmMarketScreen.getContentPane().add(marketLabel);
		
		JButton backButton = new JButton("Go back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setBounds(322, 578, 270, 60);
		frmMarketScreen.getContentPane().add(backButton);
		
		JPanel athletePanel = new JPanel();
		athletePanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		athletePanel.setBounds(35, 101, 844, 184);
		frmMarketScreen.getContentPane().add(athletePanel);
		athletePanel.setLayout(null);
		
		// Create a ListModel to store the athletes in the JList
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		// Add the existing athletes to the ListModel
		athleteListModel.addAll(athletes);
		
		JList<Athlete> athleteList = new JList<Athlete>(athleteListModel);
		athleteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		athleteList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		athleteList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		athleteList.setBounds(214, 11, 620, 162);
		athletePanel.add(athleteList);
		
		JLabel athletesForSaleLabel = new JLabel("Athletes For Sale!"); 
		athletesForSaleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		athletesForSaleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		athletesForSaleLabel.setBounds(10, 27, 194, 20);
		athletePanel.add(athletesForSaleLabel);
		athleteList.getSelectedValue();
		
		JLabel athleteExplainationText1 = new JLabel("Please select your purchase on the");
		athleteExplainationText1.setHorizontalAlignment(SwingConstants.CENTER);
		athleteExplainationText1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		athleteExplainationText1.setBounds(10, 58, 194, 14);
		athletePanel.add(athleteExplainationText1);
		
		JLabel athleteExplainationText2 = new JLabel("right and click the button below");
		athleteExplainationText2.setHorizontalAlignment(SwingConstants.CENTER);
		athleteExplainationText2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		athleteExplainationText2.setBounds(10, 75, 194, 14);
		athletePanel.add(athleteExplainationText2);
		
		JLabel athleteBoughtLabel = new JLabel("");
		athleteBoughtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		athleteBoughtLabel.setBounds(10, 96, 194, 14);
		athletePanel.add(athleteBoughtLabel);
		athleteBoughtLabel.setForeground(new Color(255, 66, 66));
		athleteBoughtLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton draftMainAthleteButton = new JButton("Draft to main");
		
		draftMainAthleteButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		draftMainAthleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Athlete targetAthlete = athleteList.getSelectedValue();
				
				if (manager.getMainRoster().size() + manager.getReserveRoster().size() >= 11) {
					// Warn player that they have too many athletes
					Component fullClubWarning = null;
					JOptionPane.showMessageDialog(fullClubWarning,
							"Your club has too many athletes.", 
							"Can't have more than 11 players", JOptionPane.WARNING_MESSAGE);
					

					}else if (manager.getMoney() < targetAthlete.getContractPrice()) {  
						// Warn player if they can't afford the athlete
						Component costWarning = null;
						JOptionPane.showMessageDialog(costWarning,
								"You can't afford this.", 
								"Insufficent funds", JOptionPane.WARNING_MESSAGE);
					}  
					else if (manager.getMainRoster().size() >= 6) {
						// Warn player that reserves are full
						Component fullRosterWarning = null;
						JOptionPane.showMessageDialog(fullRosterWarning,
								"Main roster already has 6.", 
								"Main roster full", JOptionPane.WARNING_MESSAGE);
					}  

					else{  
						// Draft athlete if all above the conditions are false
						manager.draftMainAthlete(targetAthlete);
						athleteListModel.removeElement(targetAthlete);
						athleteList.setModel(athleteListModel);
						athleteBoughtLabel.setText(targetAthlete.getName() + " drafted to main.");
					} 
				
			}
		});
		draftMainAthleteButton.setBounds(38, 110, 132, 28);
		athletePanel.add(draftMainAthleteButton);
		
		JButton draftReserveAthleteButton = new JButton("Draft to reserves");
		draftReserveAthleteButton.setBounds(38, 145, 132, 28);
		athletePanel.add(draftReserveAthleteButton);
		draftReserveAthleteButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		draftReserveAthleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Athlete targetAthlete = athleteList.getSelectedValue();
				
				if (manager.getMainRoster().size() + manager.getReserveRoster().size() >= 11) {
					// Warn player that they have too many athletes
					Component fullClubWarning = null;
					JOptionPane.showMessageDialog(fullClubWarning,
							"Your club has too many athletes.", 
							"Can't have more than 11 players", JOptionPane.WARNING_MESSAGE);
					

					}else if (manager.getMoney() < targetAthlete.getContractPrice()) {  
						// Warn player if they can't afford the athlete
						Component costWarning = null;
						JOptionPane.showMessageDialog(costWarning,
								"You can't afford this.", 
								"Insufficent funds", JOptionPane.WARNING_MESSAGE);
					}  
					else if (manager.getReserveRoster().size() >= 5) {
						// Warn player that reserves are full
						Component fullRosterWarning = null;
						JOptionPane.showMessageDialog(fullRosterWarning,
								"Reserve roster already has 5.", 
								"Reserves full", JOptionPane.WARNING_MESSAGE);
					}  

					else{  
						// Draft athlete if all above the conditions are false
						manager.draftReserveAthlete(targetAthlete);
						athleteListModel.removeElement(targetAthlete);
						athleteList.setModel(athleteListModel);
						athleteBoughtLabel.setText(targetAthlete.getName() + " drafted to reserves.");
					}  		
			}
		});
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		itemPanel.setBounds(35, 296, 844, 184);
		frmMarketScreen.getContentPane().add(itemPanel);
		itemPanel.setLayout(null);
		
		JLabel itemsForSaleLabel = new JLabel("Items For Sale!");
		itemsForSaleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemsForSaleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		itemsForSaleLabel.setBounds(10, 27, 194, 20);
		itemPanel.add(itemsForSaleLabel);
		
		JLabel itemExplainationText1 = new JLabel("Please select your purchase on the");
		itemExplainationText1.setHorizontalAlignment(SwingConstants.CENTER);
		itemExplainationText1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itemExplainationText1.setBounds(10, 58, 194, 14);
		itemPanel.add(itemExplainationText1);
		
		JLabel itemExplainationText2 = new JLabel("right and click the button below");
		itemExplainationText2.setHorizontalAlignment(SwingConstants.CENTER);
		itemExplainationText2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itemExplainationText2.setBounds(10, 75, 194, 14);
		itemPanel.add(itemExplainationText2);
		
		// Create a ListModel to store the items in the JList
		DefaultListModel<Item> itemListModel = new DefaultListModel<Item>();
		// Add the existing items to the ListModel
		itemListModel.addAll(items);
		
		JList<Item> itemList = new JList<Item>(itemListModel);
		itemList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		itemList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		itemList.setBounds(214, 11, 620, 162);
		itemPanel.add(itemList);
		itemList.getSelectedValue();
		
		JLabel itemBoughtLabel = new JLabel("");
		itemBoughtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemBoughtLabel.setForeground(new Color(255, 66, 66));
		itemBoughtLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		itemBoughtLabel.setBounds(10, 111, 194, 14);
		itemPanel.add(itemBoughtLabel);
		
		JButton itemPurchaseButton = new JButton("Purchase");
		itemPurchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getMoney() > itemList.getSelectedValue().getContractPrice()) {
					Item targetItem = itemList.getSelectedValue();
					manager.purchaseItem(itemList.getSelectedValue());
					itemListModel.removeElement(itemList.getSelectedValue());
					itemList.setModel(itemListModel);
					itemBoughtLabel.setText(targetItem.getName() + " Bought!");
					
				} else {
					Component insufficentFundsWarning = null;
					JOptionPane.showMessageDialog(insufficentFundsWarning, "You can't afford this. "
							+ "\nGo some win games.", 
							"Insufficient funds", JOptionPane.WARNING_MESSAGE);					
				}

				

				
			}
		});
		
		itemPurchaseButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		itemPurchaseButton.setBounds(60, 124, 94, 28);
		itemPanel.add(itemPurchaseButton);
		
		JButton inventoryButton = new JButton("Inventory");
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchInventoryScreen("Market");
			}
		});
		inventoryButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryButton.setBounds(322, 507, 270, 60);
		frmMarketScreen.getContentPane().add(inventoryButton);
	}
}
