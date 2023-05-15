package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextPane;

public class MainScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 611, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KickHeroes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(197, 30, 200, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMoneyLabel = new JLabel("Money: ");
		lblMoneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoneyLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMoneyLabel.setBounds(67, 132, 74, 14);
		frame.getContentPane().add(lblMoneyLabel);
		
		JLabel lblWeekLabel = new JLabel("Remaining weeks:");
		lblWeekLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeekLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWeekLabel.setBounds(388, 132, 140, 14);
		frame.getContentPane().add(lblWeekLabel);
		
		JLabel lblCurrentWeek = new JLabel("Week:");
		lblCurrentWeek.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentWeek.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCurrentWeek.setBounds(208, 132, 113, 14);
		frame.getContentPane().add(lblCurrentWeek);
		
		JButton btnClub = new JButton("Go to the club");
		btnClub.setBounds(227, 180, 140, 23);
		frame.getContentPane().add(btnClub);
		
		JButton btnStadium = new JButton("Go to the stadium");
		btnStadium.setBounds(227, 240, 140, 23);
		frame.getContentPane().add(btnStadium);
		
		JButton btnMarket = new JButton("Visit the market");
		btnMarket.setBounds(227, 300, 140, 23);
		frame.getContentPane().add(btnMarket);
		
		JButton btnBye = new JButton("Take a bye ");
		btnBye.setBounds(227, 360, 140, 23);
		frame.getContentPane().add(btnBye);
		
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.setBounds(227, 420, 140, 23);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtrTeamname = new JTextArea();
		txtrTeamname.setEditable(false);
		txtrTeamname.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtrTeamname.setText("Good luck (insert team name)");
		txtrTeamname.setBackground(new Color(240, 240, 240));
		txtrTeamname.setBounds(194, 85, 218, 22);
		frame.getContentPane().add(txtrTeamname);
	}
}
