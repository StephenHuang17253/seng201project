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
import javax.swing.border.LineBorder;

import items.DefensiveCoach;
import items.Nutritionist;
import items.OffensiveCoach;
import items.Trainer;

import javax.swing.JList;

public class MarketScreen {

	private JFrame frmMarketScreen;
	private GameManager manager;
	private ArrayList<Athlete> athletes = new ArrayList<>();
	private ArrayList<Item> items = new ArrayList<>();
	

	public MarketScreen(GameManager incomingManager) {
		manager = incomingManager;
		
		athletes.add(new Athlete("Shinsuke Kita", "S", 10, 10, 10, 10, 2000000));
		athletes.add(new Athlete("Ren Omimi", "A", 10, 8, 8, 8, 850000));
		athletes.add(new Athlete("Rintaro Suna", "A", 10, 7, 7, 7, 700000));
		athletes.add(new Athlete("Atsumu Miya", "B", 10, 6, 5, 5, 300000));
		athletes.add(new Athlete("Hitoshi Ginjima", "C", 10, 4, 4, 4, 250000));
		
		items.add(new Trainer());
		items.add(new Nutritionist());
		items.add(new OffensiveCoach());
		items.add(new DefensiveCoach());
		
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
		frmMarketScreen.setTitle("Market");
		frmMarketScreen.setBounds(100, 100, 931, 628);
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
		backButton.setBounds(322, 504, 270, 60);
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
		
		JButton athletePurchaseButton = new JButton("Purchase");
		athletePurchaseButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		athletePurchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		athletePurchaseButton.setBounds(60, 124, 94, 28);
		athletePanel.add(athletePurchaseButton);
		
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
		
		JLabel athleteBoughtText = new JLabel("Athlete Bought!");
		athleteBoughtText.setHorizontalAlignment(SwingConstants.CENTER);
		athleteBoughtText.setBounds(10, 111, 194, 14);
		athletePanel.add(athleteBoughtText);
		athleteBoughtText.setForeground(new Color(255, 66, 66));
		athleteBoughtText.setFont(new Font("Tahoma", Font.BOLD, 11));
		
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
		
		JButton itemPurchaseButton = new JButton("Purchase");
		itemPurchaseButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		itemPurchaseButton.setBounds(60, 124, 94, 28);
		itemPanel.add(itemPurchaseButton);
		
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
		
		JLabel itemBoughtText = new JLabel("Item Bought!");
		itemBoughtText.setHorizontalAlignment(SwingConstants.CENTER);
		itemBoughtText.setForeground(new Color(255, 66, 66));
		itemBoughtText.setFont(new Font("Tahoma", Font.BOLD, 11));
		itemBoughtText.setBounds(10, 111, 194, 14);
		itemPanel.add(itemBoughtText);
		
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
	}
}
