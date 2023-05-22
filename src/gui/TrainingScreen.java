package gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import main.Athlete;
import main.GameManager;
import main.Item;
import javax.swing.JButton;

public class TrainingScreen {

	private JFrame frmTrainingScreen;
	private GameManager manager;
	private ArrayList<Athlete> athletes = new ArrayList<>();
	
	public TrainingScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmTrainingScreen.setVisible(true);
	}

	public void closeWindow() {
		frmTrainingScreen.dispose();
	}
	
	public void finishedWindow() {
		manager.closeTrainingScreen(this);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingScreen window = new TrainingScreen();
					window.frmTrainingScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TrainingScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTrainingScreen = new JFrame();
		frmTrainingScreen.setBounds(100, 100, 715, 350);
		frmTrainingScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel athletesTrainingPanel = new JPanel();
		athletesTrainingPanel.setBorder(new LineBorder(new Color(130, 169, 242), 2, true));
		athletesTrainingPanel.setBounds(10, 119, 696, 234);
		frmTrainingScreen.getContentPane().add(athletesTrainingPanel);
		athletesTrainingPanel.setLayout(null);
		athletesTrainingPanel.setLayout(null);
		
		// Label
		JLabel trainingCenterLabel = new JLabel("Training Center");
		trainingCenterLabel.setBounds(20, 26, 194, 20);
		trainingCenterLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		athletesTrainingPanel.add(trainingCenterLabel);
		
		DefaultListModel<Athlete> inventoryAthleteModel = new DefaultListModel<Athlete>();
		inventoryAthleteModel.addAll(manager.getMainRoster());
		inventoryAthleteModel.addAll(manager.getReserveRoster());
		
		JList<Athlete> athletesTrainingList = new JList<Athlete>(inventoryAthleteModel);
		athletesTrainingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		athletesTrainingList.setBorder(new LineBorder(new Color(186, 207, 248), 2));
		athletesTrainingList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		athletesTrainingList.setBounds(10, 51, 676, 172);
		
		//Give the JList to ScrollPane and Display
		JScrollPane athletesTrainingScrollPane = new JScrollPane(athletesTrainingList);
		athletesTrainingScrollPane.setBounds(10, 51, 679, 172);
		Container athletesContainer = athletesTrainingPanel;
		athletesContainer.add(athletesTrainingScrollPane);
		
		JButton takeByeButton = new JButton("Done");
		takeByeButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		takeByeButton.setBounds(223, 234, 270, 60);
		athletesTrainingPanel.add(takeByeButton);
		
		JLabel lblNewLabel = new JLabel("Choose an athlete to significantly improve their stats.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(224, 31, 332, 15);
		athletesTrainingPanel.add(lblNewLabel);
		takeByeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Athlete targetAthlete = athletesTrainingList.getSelectedValue();
				if (targetAthlete == null) {
					// Inform player that they have not selected an athlete.
					Component notSelectedWarning = null;
					JOptionPane.showMessageDialog(notSelectedWarning,
							"You have not selected an athlete.", 
							"No athlete selected", JOptionPane.INFORMATION_MESSAGE);
				}
				else {  
					manager.greatlyIncreaseStats(targetAthlete);
					finishedWindow();
					Component newWeekFrame = null;
					JOptionPane.showMessageDialog(newWeekFrame, 
							"Stadium and Market have refreshed." + 
							"\nAthletes' Stamina refreshed." +
							"\n" + targetAthlete.getName() + "'s stats increased.", 
							"New week", JOptionPane.INFORMATION_MESSAGE);
				}  		
			}
		
		});
	}
}
