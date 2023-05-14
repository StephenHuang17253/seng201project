package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class SetupScreen {

	private JFrame frmSetupScreen;
	// The input field for the team name
	private JTextField teamName;
	private static GameManager manager;
	// ArrayList to contain Athletes
	private ArrayList<Athlete> athletes = new ArrayList<>();

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
		athletes.add(new Athlete("Ross Bacani", "Striker", 10, 10, 5, 10));
		athletes.add(new Athlete("Raoul Bacani", "Defender", 10, 5, 10, 10));
		athletes.add(new Athlete("Jasmine Ong", "Keeper", 10, 1, 10, 10));
		athletes.add(new Athlete("Yousif Abdellatif", "Midfielder", 10, 7, 7, 10));
		athletes.add(new Athlete("Robert Dalziel", "Midfielder", 10, 7, 7, 10));	
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
		frmSetupScreen.setBounds(100, 100, 632, 521);
		frmSetupScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetupScreen.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("KickHeroes");
		titleLabel.setBounds(46, 21, 159, 29);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		frmSetupScreen.getContentPane().add(titleLabel);
		
		JLabel lblTeamName = new JLabel("What is your team name?");
		lblTeamName.setBounds(46, 90, 159, 14);
		frmSetupScreen.getContentPane().add(lblTeamName);
		
		teamName = new JTextField();
		teamName.setBounds(250, 87, 300, 20);
		teamName.setToolTipText("");
		frmSetupScreen.getContentPane().add(teamName);
		teamName.setColumns(10);
		
		JLabel lblSeasonLength = new JLabel("Choose season length (weeks)");
		lblSeasonLength.setBounds(46, 146, 188, 14);
		frmSetupScreen.getContentPane().add(lblSeasonLength);
		
		JSlider slider = new JSlider();
		slider.setBounds(244, 136, 306, 37);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(5);
		slider.setMaximum(15);
		frmSetupScreen.getContentPane().add(slider);
		
		JLabel lblDifficulty = new JLabel("Choose difficulty");
		lblDifficulty.setBounds(46, 196, 169, 14);
		frmSetupScreen.getContentPane().add(lblDifficulty);
		
		JButton finishSetup = new JButton("Finish setup");
		finishSetup.setBounds(250, 428, 134, 43);
		finishSetup.setFont(new Font("Tahoma", Font.BOLD, 12));
		finishSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		frmSetupScreen.getContentPane().add(finishSetup);
		
		JLabel lblStartingAthletes = new JLabel("Pick starting athletes");
		lblStartingAthletes.setBounds(46, 262, 159, 14);
		frmSetupScreen.getContentPane().add(lblStartingAthletes);
		
		JLabel lblNameLength = new JLabel("(Between 3 to 15 characters)");
		lblNameLength.setBounds(364, 107, 204, 14);
		frmSetupScreen.getContentPane().add(lblNameLength);
		
		// Create a ListModel to store the athletes in the JList
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		// Add the existing athletes to the ListModel
		athleteListModel.addAll(athletes);
		
		// Create the JList
		JList<Athlete> athleteList = new JList<Athlete>(athleteListModel);
		athleteList.setToolTipText("Name, Position, Health, Offence, Defence, Stamina");
		athleteList.setBounds(250, 260, 300, 157);
		athleteList.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmSetupScreen.getContentPane().add(athleteList);
		athleteList.getSelectedValue();		
		
		JComboBox<Object> difficultyChoice = new JComboBox<Object>();
		difficultyChoice.setBounds(250, 192, 159, 22);
		difficultyChoice.setModel(new DefaultComboBoxModel<Object>(new String[] {"Normal", "Hard"}));
		frmSetupScreen.getContentPane().add(difficultyChoice);
		
		JLabel lblListLabel = new JLabel("Hover over athlete for tooltip");
		lblListLabel.setBounds(383, 235, 204, 14);
		frmSetupScreen.getContentPane().add(lblListLabel);
		
		JTextPane txtpnHoldDownCtrl = new JTextPane();
		txtpnHoldDownCtrl.setText("Hold down CTRL while clicking to select multiple athletes");
		txtpnHoldDownCtrl.setBounds(46, 307, 159, 37);
		frmSetupScreen.getContentPane().add(txtpnHoldDownCtrl);

	}
}
