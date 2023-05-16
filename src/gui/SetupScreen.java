package gui;

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

import main.Athlete;
import main.GameManager;

import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class SetupScreen {

	private JFrame frmSetupScreen;
	// The input field for the team name
	private JTextField teamNameField;
	private GameManager manager;
	// ArrayList to contain Athletes
	private ArrayList<Athlete> startAthletes = new ArrayList<>();
	private JLabel nameWarningLabel;
	private JLabel listWarningLabel;

	
	/**
	 * Takes an incoming manager and makes it the manager of the screen.
	 * @param incomingManager The manager for this screen
	 */
	public SetupScreen(GameManager incomingManager) {
		manager = incomingManager;
		startAthletes.add(new Athlete("Ross Bacani", "S", 10, 9, 9, 9, 1500000));
		startAthletes.add(new Athlete("Raoul Bacani", "S", 10, 9, 9, 9, 1500000));
		startAthletes.add(new Athlete("Yousif Abdellatif", "A", 10, 8, 8, 7, 700000));
		startAthletes.add(new Athlete("Robert Dalziel", "A", 10, 7, 8, 7, 700000));
		startAthletes.add(new Athlete("Vincent Chen", "A", 10, 7, 7, 7, 600000));
		startAthletes.add(new Athlete("Ryan Schaare", "B", 10, 5, 6, 5, 300000));
		startAthletes.add(new Athlete("Max Richards", "B", 10, 6, 5, 5, 300000));
		startAthletes.add(new Athlete("Yul Nam", "B", 10, 5, 5, 6, 300000));
		startAthletes.add(new Athlete("Jackson Williams", "B", 10, 5, 5, 6, 350000));
		startAthletes.add(new Athlete("Kelso du Mez", "C", 10, 4, 4, 4, 200000)); 
		initialize();
		frmSetupScreen.setVisible(true);
	}
	
	/**
	 * Create the application.
	 */	
	public SetupScreen() {
		initialize();
	}
	
	public void closeWindow() {
		frmSetupScreen.dispose();
	}
		
	public void finishedWindow() {
		manager.closeSetUpScreen(this);
	}
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
					window.frmSetupScreen.setVisible(true);
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
		frmSetupScreen = new JFrame();
		frmSetupScreen.setTitle("Game Setup");
		frmSetupScreen.setBounds(100, 100, 771, 635);
		frmSetupScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetupScreen.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("KickHeroes");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(298, 21, 159, 29);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		frmSetupScreen.getContentPane().add(titleLabel);
		
		JLabel teamNameLabel = new JLabel("What is your team name?");
		teamNameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		teamNameLabel.setBounds(46, 90, 159, 14);
		frmSetupScreen.getContentPane().add(teamNameLabel);
		
		teamNameField = new JTextField();
		teamNameField.setBounds(250, 87, 478, 20);
		teamNameField.setToolTipText("");
		frmSetupScreen.getContentPane().add(teamNameField);
		teamNameField.setColumns(10);
		
		JLabel seasonLengthLabel = new JLabel("Choose season length (weeks)");
		seasonLengthLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		seasonLengthLabel.setBounds(46, 146, 188, 14);
		frmSetupScreen.getContentPane().add(seasonLengthLabel);
		
		JSlider difficultySlider = new JSlider();
		difficultySlider.setBounds(244, 136, 484, 37);
		difficultySlider.setPaintLabels(true);
		difficultySlider.setPaintTicks(true);
		difficultySlider.setMajorTickSpacing(1);
		difficultySlider.setMinimum(5);
		difficultySlider.setMaximum(15);
		frmSetupScreen.getContentPane().add(difficultySlider);
		
		JLabel difficultyLabel = new JLabel("Choose difficulty");
		difficultyLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		difficultyLabel.setBounds(46, 196, 169, 14);
		frmSetupScreen.getContentPane().add(difficultyLabel);
		
		JLabel startingAthletesLabel = new JLabel("Draft starting athletes");
		startingAthletesLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		startingAthletesLabel.setBounds(46, 322, 159, 14);
		frmSetupScreen.getContentPane().add(startingAthletesLabel);
		
		JLabel nameLengthLabel = new JLabel("(Between 3 to 15 characters)");
		nameLengthLabel.setBounds(364, 107, 204, 14);
		frmSetupScreen.getContentPane().add(nameLengthLabel);
		
		// Create a ListModel to store the athletes in the JList
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		// Add the existing athletes to the ListModel
		athleteListModel.addAll(startAthletes);
		
		// Create the JList
		JList<Athlete> athleteList = new JList<Athlete>(athleteListModel);
		athleteList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		athleteList.setToolTipText("");
		athleteList.setBounds(250, 305, 478, 206);
		athleteList.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmSetupScreen.getContentPane().add(athleteList);
		athleteList.getSelectedValue();		
		
		JComboBox<Object> difficultyChoice = new JComboBox<Object>();
		difficultyChoice.setToolTipText("Difficulty determines your starting money and athletes.");
		difficultyChoice.setBounds(250, 192, 478, 22);
		difficultyChoice.setModel(new DefaultComboBoxModel<Object>(new String[] {"Normal", "Hard"}));
		frmSetupScreen.getContentPane().add(difficultyChoice);
		
		JTextPane listExplanation = new JTextPane();
		listExplanation.setBackground(new Color(240, 240, 240));
		listExplanation.setEditable(false);
		listExplanation.setText("Hold down CTRL while clicking to select multiple athletes.\r\n\r\nPick at least 5.\r\n\r\nNormal difficulty: start with $7.0M\r\n\r\nHard difficulty: start with $3.5M");
		listExplanation.setBounds(46, 352, 169, 185);
		frmSetupScreen.getContentPane().add(listExplanation);
		
		JTextArea difficultyExplanation = new JTextArea();
		difficultyExplanation.setBackground(new Color(240, 240, 240));
		difficultyExplanation.setFont(new Font("Tahoma", Font.PLAIN, 11));
		difficultyExplanation.setWrapStyleWord(true);
		difficultyExplanation.setLineWrap(true);
		difficultyExplanation.setText("Normal: Your club starts in a comfortable position, able to afford strong athletes.\r\n\r\nHard: Your club has fallen upon hard times, you will have to spend every dollar wisely.");
		difficultyExplanation.setBounds(46, 223, 221, 73);
		frmSetupScreen.getContentPane().add(difficultyExplanation);
		
		nameWarningLabel = new JLabel("");
		nameWarningLabel.setForeground(Color.RED);
		nameWarningLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		nameWarningLabel.setBounds(217, 63, 399, 20);
		frmSetupScreen.getContentPane().add(nameWarningLabel);
		
		listWarningLabel = new JLabel("");
		listWarningLabel.setForeground(Color.RED);
		listWarningLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		listWarningLabel.setBounds(461, 522, 204, 14);
		frmSetupScreen.getContentPane().add(listWarningLabel);		
		
		JButton finishSetup = new JButton("Finish setup");
		finishSetup.setBounds(310, 522, 134, 43);
		finishSetup.setFont(new Font("Tahoma", Font.BOLD, 12));
		finishSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setUpGame(teamNameField.getText(), difficultySlider.getValue(), difficultyChoice.getSelectedItem().toString(), athleteList.getSelectedValuesList());
			}
		});
		frmSetupScreen.getContentPane().add(finishSetup);
		
		JLabel listHeaderLabel = new JLabel("Name, Rating, Health, Stamina, Offence, Defence, Price");
		listHeaderLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		listHeaderLabel.setBounds(270, 280, 346, 14);
		frmSetupScreen.getContentPane().add(listHeaderLabel);

		
		
	}
	
	public void setNameWarningLabel(String warningText) {
			nameWarningLabel.setText(warningText);
		}

	
	public void setListWarningLabel(String warningText) {

			listWarningLabel.setText(warningText);
		}

}
