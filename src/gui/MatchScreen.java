package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import main.GameManager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class MatchScreen {

	private JFrame frmMatchScreen;
	private GameManager manager;


	public MatchScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmMatchScreen.setVisible(true);
		
	}
	
	public void closeWindow() {
		frmMatchScreen.dispose();
	}
	
	public void finishedWindow() {
		manager.closeMatchScreen(this); 
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchScreen window = new MatchScreen();
					window.frmMatchScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MatchScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMatchScreen = new JFrame();
		frmMatchScreen.setTitle("Match");
		frmMatchScreen.setBounds(100, 100, 727, 541);
		frmMatchScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatchScreen.getContentPane().setLayout(null);
		
		JLabel headerLabel = new JLabel("<Dynamic> vs <Dynamic>");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		headerLabel.setBounds(201, 33, 309, 22);
		frmMatchScreen.getContentPane().add(headerLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 94, 212, 380);
		frmMatchScreen.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel positionLabel1 = new JLabel("Striker");
		positionLabel1.setBounds(10, 51, 103, 14);
		panel.add(positionLabel1);
		
		JLabel positionLabel2 = new JLabel("Left Wing");
		positionLabel2.setBounds(10, 116, 103, 14);
		panel.add(positionLabel2);
		
		JLabel positionLabel3 = new JLabel("Right Wing");
		positionLabel3.setBounds(10, 181, 103, 14);
		panel.add(positionLabel3);
		
		JLabel positionLabel4 = new JLabel("Defender");
		positionLabel4.setBounds(10, 246, 103, 14);
		panel.add(positionLabel4);
		
		JLabel positionLabel5 = new JLabel("Keeper");
		positionLabel5.setBounds(10, 311, 103, 14);
		panel.add(positionLabel5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(470, 94, 212, 380);
		frmMatchScreen.getContentPane().add(panel_1);
		
		JLabel positionLabel1_1 = new JLabel("Striker");
		positionLabel1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		positionLabel1_1.setBounds(99, 52, 103, 14);
		panel_1.add(positionLabel1_1);
		
		JLabel positionLabel2_1 = new JLabel("Left Wing");
		positionLabel2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		positionLabel2_1.setBounds(99, 117, 103, 14);
		panel_1.add(positionLabel2_1);
		
		JLabel positionLabel3_1 = new JLabel("Right Wing");
		positionLabel3_1.setHorizontalAlignment(SwingConstants.TRAILING);
		positionLabel3_1.setBounds(99, 182, 103, 14);
		panel_1.add(positionLabel3_1);
		
		JLabel positionLabel4_1 = new JLabel("Defender");
		positionLabel4_1.setHorizontalAlignment(SwingConstants.TRAILING);
		positionLabel4_1.setBounds(99, 247, 103, 14);
		panel_1.add(positionLabel4_1);
		
		JLabel positionLabel5_1 = new JLabel("Keeper");
		positionLabel5_1.setHorizontalAlignment(SwingConstants.TRAILING);
		positionLabel5_1.setBounds(99, 312, 103, 14);
		panel_1.add(positionLabel5_1);
	}
}
