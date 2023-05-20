package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

import main.Athlete;
import main.GameManager;
import main.Item;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class InventoryScreen {

	private JFrame frmInventoryScreen;
	private GameManager manager;
	private String origin;
	private ArrayList<Athlete> activeRoster;
	private ArrayList<Athlete> reserveRoster;
	private ArrayList<Item> inventory;
	
	public InventoryScreen(GameManager incomingManager, ArrayList<Item> items, String origin) {
		this.origin = origin;
		inventory = items;
		manager = incomingManager;
		initialize();
		frmInventoryScreen.setVisible(true);
	}
	
	public void closeWindow() {
		frmInventoryScreen.dispose();
	}
	
	public void finishedWindow(String origin) {
		manager.closeInventoryScreen(this, origin);
	}
	
	/**
	 * Launch the application.
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
		frmInventoryScreen.setTitle("VolleyballWorld - Inventory");
		frmInventoryScreen.setBounds(100, 100, 732, 744);
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
		
		JList inventoryAthleteList = new JList();
		inventoryAthleteList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		inventoryAthleteList.setBounds(10, 51, 676, 172);
		inventoryAthletePanel.add(inventoryAthleteList);
		
		JLabel inventoryAthletesLabel = new JLabel("Athletes");
		inventoryAthletesLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		inventoryAthletesLabel.setBounds(20, 18, 101, 14);
		inventoryAthletePanel.add(inventoryAthletesLabel);
		
		JLabel athleteStatsLabel = new JLabel("Athlete's Stats Increased by   !!");
		athleteStatsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		athleteStatsLabel.setForeground(new Color(255, 66, 66));
		athleteStatsLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		athleteStatsLabel.setBounds(161, 20, 493, 14);
		inventoryAthletePanel.add(athleteStatsLabel);
		
		JPanel inventoryItemPanel = new JPanel();
		inventoryItemPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		inventoryItemPanel.setBounds(10, 365, 696, 234);
		frmInventoryScreen.getContentPane().add(inventoryItemPanel);
		inventoryItemPanel.setLayout(null);
		
		DefaultListModel<Item> inventoryItemListModel = new DefaultListModel<Item>();
		inventoryItemListModel.addAll(inventory);
		
		JList<Item> inventoryItemList = new JList<Item>(inventoryItemListModel);
		inventoryItemList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		inventoryItemList.setBounds(10, 51, 676, 172);
		inventoryItemPanel.add(inventoryItemList);
		
		JLabel inventoryItemsLabel = new JLabel("Items");
		inventoryItemsLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		inventoryItemsLabel.setBounds(20, 18, 101, 14);
		inventoryItemPanel.add(inventoryItemsLabel);
		
		JButton useItemButton = new JButton("Use Item");
		useItemButton.setBounds(558, 13, 101, 28);
		inventoryItemPanel.add(useItemButton);
		useItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		useItemButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel itemUsedLabel = new JLabel("Item Used!");
		itemUsedLabel.setBounds(403, 20, 145, 14);
		inventoryItemPanel.add(itemUsedLabel);
		itemUsedLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		itemUsedLabel.setForeground(new Color(255, 66, 66));
		itemUsedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton backButton = new JButton("Go Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(origin);
			}
		});
		backButton.setBounds(223, 620, 270, 60);
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmInventoryScreen.getContentPane().add(backButton);
		
		JLabel lblNewLabel = new JLabel("Please select the athlete that you want to use your item on.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 100, 439, 14);
		frmInventoryScreen.getContentPane().add(lblNewLabel);
	}
}
