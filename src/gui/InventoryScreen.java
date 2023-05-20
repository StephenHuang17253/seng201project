package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class InventoryScreen {

	private JFrame frmVolleyballworldInventory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryScreen window = new InventoryScreen();
					window.frmVolleyballworldInventory.setVisible(true);
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
		frmVolleyballworldInventory = new JFrame();
		frmVolleyballworldInventory.setTitle("VolleyballWorld - Inventory");
		frmVolleyballworldInventory.setBounds(100, 100, 600, 369);
		frmVolleyballworldInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVolleyballworldInventory.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inventory");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(10, 11, 564, 43);
		frmVolleyballworldInventory.getContentPane().add(lblNewLabel);
	}
}
