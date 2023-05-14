package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class MarketScreen {

	private JFrame frmTheMarket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketScreen window = new MarketScreen();
					window.frmTheMarket.setVisible(true);
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
		frmTheMarket = new JFrame();
		frmTheMarket.setTitle("Market");
		frmTheMarket.setBounds(100, 100, 450, 300);
		frmTheMarket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheMarket.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("The Market");
		lblNewLabel.setBounds(155, 11, 103, 24);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 17));
		frmTheMarket.getContentPane().add(lblNewLabel);
	}
}
