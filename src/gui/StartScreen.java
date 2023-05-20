package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.GameManager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class StartScreen {

	private JFrame frmStartScreen;
	private GameManager manager;
	private JLabel lblWelcome;

	
	/**
	 * Takes an incoming manager and makes it the manager of the screen.
	 * @param incomingManager The manager for this screen
	 */
	public StartScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmStartScreen.setVisible(true);
	}
	
	public void closeWindow() {
		frmStartScreen.dispose();
	}
	
	public void finishedWindow() {
		manager.closeStartScreen(this);
	}
		 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen();
					window.frmStartScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application
	 */
	public StartScreen() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStartScreen = new JFrame();
		frmStartScreen.setTitle("KickHeroes");
		frmStartScreen.setBounds(100, 100, 1018, 564);
		frmStartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStartScreen.getContentPane().setLayout(null);
		
		lblWelcome = new JLabel(" Welcome to VolleyballWorld");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(10, 107, 982, 77);
		lblWelcome.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 54));
		frmStartScreen.getContentPane().add(lblWelcome);
		
		JLabel lblStart = new JLabel("Press \"Start\" to play!");
		lblStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblStart.setFont(new Font("Tahoma", Font.ITALIC, 27));
		lblStart.setBounds(10, 207, 982, 32);
		frmStartScreen.getContentPane().add(lblStart);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnStart.setBounds(337, 329, 328, 108);
		frmStartScreen.getContentPane().add(btnStart);
	}
}
