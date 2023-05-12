package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetupScreen {

	private JFrame frmSetupScreen;
	// The input field for the team name
	private JTextField teamName;
	private static GameManager manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen(manager);
					window.frmSetupScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmSetupScreen.setVisible(true);
	}

	public void closeWindow() {
		frmSetupScreen.dispose();
	}
		
	public void finishedWindow() {
		manager.closeSetUpScreen(this);
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetupScreen = new JFrame();
		frmSetupScreen.setTitle("Game Setup");
		frmSetupScreen.setBounds(100, 100, 632, 437);
		frmSetupScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetupScreen.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("KickHeroes");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		titleLabel.setBounds(46, 21, 159, 29);
		frmSetupScreen.getContentPane().add(titleLabel);
		
		JLabel lblTeamName = new JLabel("What is your team name?");
		lblTeamName.setBounds(46, 90, 159, 14);
		frmSetupScreen.getContentPane().add(lblTeamName);
		
		teamName = new JTextField();
		teamName.setToolTipText("");
		teamName.setBounds(250, 87, 300, 20);
		frmSetupScreen.getContentPane().add(teamName);
		teamName.setColumns(10);
		
		JLabel lblSeasonLength = new JLabel("Choose season length (weeks)");
		lblSeasonLength.setBounds(46, 146, 188, 14);
		frmSetupScreen.getContentPane().add(lblSeasonLength);
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(5);
		slider.setMaximum(15);
		slider.setBounds(244, 136, 306, 37);
		frmSetupScreen.getContentPane().add(slider);
		
		JLabel lblDifficulty = new JLabel("Choose difficulty");
		lblDifficulty.setBounds(46, 217, 169, 14);
		frmSetupScreen.getContentPane().add(lblDifficulty);
		
		JButton finishSetup = new JButton("Finish setup");
		finishSetup.setFont(new Font("Tahoma", Font.BOLD, 12));
		finishSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		finishSetup.setBounds(250, 330, 134, 43);
		frmSetupScreen.getContentPane().add(finishSetup);
		
		JLabel lblStartingAthletes = new JLabel("Pick starting athletes");
		lblStartingAthletes.setBounds(46, 271, 159, 14);
		frmSetupScreen.getContentPane().add(lblStartingAthletes);
		
		JButton startingAthletes = new JButton("Pick");
		startingAthletes.setBounds(250, 267, 89, 23);
		frmSetupScreen.getContentPane().add(startingAthletes);
		
		JLabel lblNameLength = new JLabel("(Between 3 to 15 characters)");
		lblNameLength.setBounds(364, 107, 204, 14);
		frmSetupScreen.getContentPane().add(lblNameLength);
		
		JToggleButton tglbtnNormal = new JToggleButton("Normal");
		tglbtnNormal.setBounds(250, 213, 121, 23);
		frmSetupScreen.getContentPane().add(tglbtnNormal);
		
		JToggleButton tglbtnHard = new JToggleButton("Hard");
		tglbtnHard.setBounds(403, 213, 121, 23);
		frmSetupScreen.getContentPane().add(tglbtnHard);
	}
}
