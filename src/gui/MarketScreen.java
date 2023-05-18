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
		frmMarketScreen.setBounds(100, 100, 701, 499);
		frmMarketScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarketScreen.getContentPane().setLayout(null);
		
		JLabel marketLabel = new JLabel("The Market");
		marketLabel.setHorizontalAlignment(SwingConstants.CENTER);
		marketLabel.setBounds(238, 52, 208, 24);
		marketLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		frmMarketScreen.getContentPane().add(marketLabel);
		
		JButton backButton = new JButton("Go back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setBounds(238, 375, 208, 54);
		frmMarketScreen.getContentPane().add(backButton);
	}
}
