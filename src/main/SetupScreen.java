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
		
		JLabel lblNewLabel = new JLabel("KickHeroes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(46, 21, 159, 29);
		frmSetupScreen.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("What is your team name?");
		lblNewLabel_1.setBounds(46, 90, 159, 14);
		frmSetupScreen.getContentPane().add(lblNewLabel_1);
		
		teamName = new JTextField();
		teamName.setToolTipText("");
		teamName.setBounds(250, 87, 300, 20);
		frmSetupScreen.getContentPane().add(teamName);
		teamName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Choose season length (weeks)");
		lblNewLabel_2.setBounds(46, 146, 169, 14);
		frmSetupScreen.getContentPane().add(lblNewLabel_2);
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(5);
		slider.setMaximum(15);
		slider.setBounds(244, 136, 306, 37);
		frmSetupScreen.getContentPane().add(slider);
		
		JLabel lblNewLabel_3 = new JLabel("Choose difficulty");
		lblNewLabel_3.setBounds(46, 217, 169, 14);
		frmSetupScreen.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("Finish setup");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnNewButton_2.setBounds(250, 350, 121, 23);
		frmSetupScreen.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Pick starting athletes");
		lblNewLabel_4.setBounds(46, 271, 159, 14);
		frmSetupScreen.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("Pick");
		btnNewButton_3.setBounds(250, 267, 89, 23);
		frmSetupScreen.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("(Between 3 to 15 characters)");
		lblNewLabel_5.setBounds(364, 107, 204, 14);
		frmSetupScreen.getContentPane().add(lblNewLabel_5);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Normal");
		tglbtnNewToggleButton.setBounds(250, 213, 121, 23);
		frmSetupScreen.getContentPane().add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Hard");
		tglbtnNewToggleButton_1.setBounds(403, 213, 121, 23);
		frmSetupScreen.getContentPane().add(tglbtnNewToggleButton_1);
	}
}
