package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.Athlete;
import main.GameManager;

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
import javax.swing.JList;

public class MarketScreen {

	private JFrame frmMarketScreen;
	private GameManager manager;
	private ArrayList<Athlete> athletes = new ArrayList<>();

	public MarketScreen(GameManager incomingManager) {
		manager = incomingManager;
		athletes.add(new Athlete("Shinsuke Kita", "S", 10, 10, 10, 10, 2000000));
		athletes.add(new Athlete("Ren Omimi", "A", 10, 8, 8, 8, 850000));
		athletes.add(new Athlete("Rintaro Suna", "A", 10, 7, 7, 7, 700000));
		athletes.add(new Athlete("Atsumu Miya", "B", 10, 6, 5, 5, 300000));
		athletes.add(new Athlete("Hitoshi Ginjima", "C", 10, 4, 4, 4, 250000));
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
		frmMarketScreen.setBounds(100, 100, 796, 567);
		frmMarketScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarketScreen.getContentPane().setLayout(null);
		
		JLabel marketLabel = new JLabel("The Market");
		marketLabel.setHorizontalAlignment(SwingConstants.CENTER);
		marketLabel.setBounds(290, 11, 199, 52);
		marketLabel.setFont(new Font("Century", Font.PLAIN, 26));
		frmMarketScreen.getContentPane().add(marketLabel);
		
		JButton backButton = new JButton("Go back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setBounds(286, 447, 208, 54);
		frmMarketScreen.getContentPane().add(backButton);
		
		JPanel athletePanel = new JPanel();
		athletePanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		athletePanel.setBounds(47, 74, 686, 162);
		frmMarketScreen.getContentPane().add(athletePanel);
		athletePanel.setLayout(null);
		
		// Create a ListModel to store the athletes in the JList
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		// Add the existing athletes to the ListModel
		athleteListModel.addAll(athletes);
		
		JList<Athlete> athleteList = new JList<Athlete>(athleteListModel);
		athleteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		athleteList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		athleteList.setBorder(new LineBorder(new Color(186, 207, 248)));
		athleteList.setBounds(219, 11, 457, 140);
		athletePanel.add(athleteList);
		
		JLabel athletesForSaleLabel = new JLabel("Athletes For Sale!");
		athletesForSaleLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		athletesForSaleLabel.setBounds(20, 11, 124, 23);
		athletePanel.add(athletesForSaleLabel);
		
		JButton athletePurchaseButton = new JButton("Purchase");
		athletePurchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		athletePurchaseButton.setBounds(111, 121, 89, 23);
		athletePanel.add(athletePurchaseButton);
		
		JLabel athleteExplainationText1 = new JLabel("Please select your purchase on the");
		athleteExplainationText1.setBounds(10, 61, 211, 14);
		athletePanel.add(athleteExplainationText1);
		
		JLabel athleteExplainationText2 = new JLabel("right and click the button below");
		athleteExplainationText2.setBounds(11, 81, 198, 14);
		athletePanel.add(athleteExplainationText2);
		
		JLabel athleteBoughtText = new JLabel("Athlete Bought!");
		athleteBoughtText.setForeground(new Color(255, 66, 66));
		athleteBoughtText.setFont(new Font("Tahoma", Font.BOLD, 11));
		athleteBoughtText.setBounds(10, 125, 88, 14);
		athletePanel.add(athleteBoughtText);
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		itemPanel.setBounds(47, 262, 686, 162);
		frmMarketScreen.getContentPane().add(itemPanel);
		itemPanel.setLayout(null);
		
		JLabel itemsForSaleLabel = new JLabel("Items For Sale!");
		itemsForSaleLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		itemsForSaleLabel.setBounds(20, 11, 104, 23);
		itemPanel.add(itemsForSaleLabel);
		
		JButton itemPurchaseButton = new JButton("Purchase");
		itemPurchaseButton.setBounds(111, 121, 89, 23);
		itemPanel.add(itemPurchaseButton);
		
		JLabel itemExplainationText1 = new JLabel("Please select your purchase on the");
		itemExplainationText1.setBounds(10, 61, 211, 14);
		itemPanel.add(itemExplainationText1);
		
		JLabel itemExplainationText2 = new JLabel("right and click the button below");
		itemExplainationText2.setBounds(11, 81, 178, 14);
		itemPanel.add(itemExplainationText2);
		
		JLabel itemBoughtText = new JLabel("Item Bought!");
		itemBoughtText.setForeground(new Color(255, 66, 66));
		itemBoughtText.setFont(new Font("Tahoma", Font.BOLD, 11));
		itemBoughtText.setBounds(20, 125, 74, 14);
		itemPanel.add(itemBoughtText);
		
		JList itemList = new JList();
		itemList.setBorder(new LineBorder(new Color(186, 207, 248)));
		itemList.setBounds(219, 11, 457, 140);
		itemPanel.add(itemList);
	}
}
