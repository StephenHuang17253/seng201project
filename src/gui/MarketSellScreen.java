package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import main.GameManager;
import javax.swing.JList;

public class MarketSellScreen {

	private JFrame frmMarketSellScreen;
	private GameManager manager;
	
	public MarketSellScreen(GameManager incomingManager) {
		manager = incomingManager;
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
		frmMarketSellScreen.setTitle("VolleyballWorld - Market(Sell)");
		frmMarketSellScreen.setBounds(100, 100, 732, 799);
		frmMarketSellScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarketSellScreen.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("The Market");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(10, 11, 696, 52);
		frmMarketSellScreen.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Click to switch to buy Items and Athletes");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(259, 58, 204, 14);
		frmMarketSellScreen.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sell Purchasables");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(269, 74, 176, 31);
		frmMarketSellScreen.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		panel.setBounds(10, 119, 696, 234);
		frmMarketSellScreen.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("Sell");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1_1.setBounds(554, 16, 132, 28);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Athletes in Inventory");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(20, 18, 194, 20);
		panel.add(lblNewLabel_2);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setBounds(10, 51, 676, 172);
		panel.add(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		panel_1.setBounds(10, 365, 696, 234);
		frmMarketSellScreen.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1_1_1 = new JButton("Sell");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1_1_1.setBounds(554, 16, 132, 28);
		panel_1.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Items in Inventory");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(20, 18, 194, 20);
		panel_1.add(lblNewLabel_2_1);
		
		JList list_1 = new JList();
		list_1.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list_1.setBounds(10, 51, 676, 172);
		panel_1.add(list_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Inventory");
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1_1.setBounds(223, 610, 270, 60);
		frmMarketSellScreen.getContentPane().add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Go Back");
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1_1_1.setBounds(223, 681, 270, 60);
		frmMarketSellScreen.getContentPane().add(btnNewButton_1_1_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Money: $<dynamic>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(506, 84, 200, 39);
		frmMarketSellScreen.getContentPane().add(lblNewLabel_3);
		
	}
}
