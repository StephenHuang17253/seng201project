package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.GameManager;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JList;

public class MarketScreen {

	private JFrame frmMarketScreen;
	private GameManager manager;

	public MarketScreen(GameManager incomingManager) {
		manager = incomingManager;
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		panel.setBounds(47, 74, 686, 162);
		frmMarketScreen.getContentPane().add(panel);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(186, 207, 248)));
		list.setBounds(219, 11, 457, 140);
		panel.add(list);
		
		JLabel lblNewLabel = new JLabel("Athletes For Sale!");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		lblNewLabel.setBounds(20, 11, 124, 23);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Purchase");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(111, 121, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Please select your purchase on the");
		lblNewLabel_1.setBounds(10, 61, 211, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("right and click the button below");
		lblNewLabel_2.setBounds(11, 81, 198, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Athlete Bought!");
		lblNewLabel_3.setForeground(new Color(255, 66, 66));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 125, 88, 14);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		panel_1.setBounds(47, 262, 686, 162);
		frmMarketScreen.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblItemsForSale = new JLabel("Items For Sale!");
		lblItemsForSale.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		lblItemsForSale.setBounds(20, 11, 104, 23);
		panel_1.add(lblItemsForSale);
		
		JButton btnNewButton_1 = new JButton("Purchase");
		btnNewButton_1.setBounds(111, 121, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Please select your purchase on the");
		lblNewLabel_1_1.setBounds(10, 61, 211, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("right and click the button below");
		lblNewLabel_2_1.setBounds(11, 81, 178, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Item Bought!");
		lblNewLabel_3_1.setForeground(new Color(255, 66, 66));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(20, 125, 74, 14);
		panel_1.add(lblNewLabel_3_1);
		
		JList list_1 = new JList();
		list_1.setBorder(new LineBorder(new Color(186, 207, 248)));
		list_1.setBounds(219, 11, 457, 140);
		panel_1.add(list_1);
	}
}
