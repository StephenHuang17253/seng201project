package gui;

import java.awt.EventQueue;
import java.awt.Font;

import main.GameManager;
import main.Athlete;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClubScreen {

	private JFrame frmClubScreen;
	private GameManager manager;

	public ClubScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmClubScreen.setVisible(true);
	}
	
	public void closeWindow() {
		frmClubScreen.dispose();
	}
	
	public void finishedWindow() {
		manager.closeClubScreen(this);
	}
	
	/**
	 * Create the application.
	 */
	public ClubScreen() {
		initialize();
	}	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubScreen window = new ClubScreen();
					window.frmClubScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClubScreen = new JFrame();
		frmClubScreen.setBounds(100, 100, 684, 588);
		frmClubScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClubScreen.getContentPane().setLayout(null);
		
		JLabel teamLabel = new JLabel(manager.getTeamName() + " Sports Club");
		teamLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamLabel.setBounds(136, 37, 396, 29);
		frmClubScreen.getContentPane().add(teamLabel);		
		
		JButton backButton =  new JButton("Go back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setBounds(159, 438, 350, 50);
		frmClubScreen.getContentPane().add(backButton);
		
	}

}
