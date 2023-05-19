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
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

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
		frmClubScreen.setBounds(100, 100, 796, 560);
		frmClubScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClubScreen.getContentPane().setLayout(null);
		
		JLabel teamLabel = new JLabel(manager.getTeamName() + " Sports Club");
		teamLabel.setBounds(248, 21, 285, 29);
		teamLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmClubScreen.getContentPane().add(teamLabel);
		
		JPanel activeRosterPanel = new JPanel();
		activeRosterPanel.setBounds(47, 69, 686, 162);
		activeRosterPanel.setLayout(null);
		activeRosterPanel.setBorder(new LineBorder(new Color(255, 66, 66), 2, true));
		frmClubScreen.getContentPane().add(activeRosterPanel);
		
		JList<Athlete> activeRosterList = new JList<Athlete>((ListModel) null);
		activeRosterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		activeRosterList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		activeRosterList.setBorder(new LineBorder(new Color(255, 151, 151)));
		activeRosterList.setBounds(219, 11, 457, 140);
		activeRosterPanel.add(activeRosterList);
		
		JLabel activeRosterLabel = new JLabel("Active Roster");
		activeRosterLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		activeRosterLabel.setBounds(20, 11, 124, 23);
		activeRosterPanel.add(activeRosterLabel);
		
		JButton activeRosterChangeButton = new JButton("Change?");
		activeRosterChangeButton.setBounds(120, 121, 89, 23);
		activeRosterPanel.add(activeRosterChangeButton);
		
		JLabel activeRosterChangeExplainationText1 = new JLabel(".....");
		activeRosterChangeExplainationText1.setBounds(10, 61, 211, 14);
		activeRosterPanel.add(activeRosterChangeExplainationText1);
		
		JLabel activeRosterChangeExplainationText2 = new JLabel(".....");
		activeRosterChangeExplainationText2.setBounds(11, 81, 198, 14);
		activeRosterPanel.add(activeRosterChangeExplainationText2);
		
		JLabel activeRosterChangedText = new JLabel("Athelete Changed!");
		activeRosterChangedText.setForeground(new Color(255, 66, 66));
		activeRosterChangedText.setFont(new Font("Tahoma", Font.BOLD, 11));
		activeRosterChangedText.setBounds(10, 125, 104, 14);
		activeRosterPanel.add(activeRosterChangedText);
		
		JButton backButton = new JButton("Go back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setBounds(283, 456, 208, 54);
		frmClubScreen.getContentPane().add(backButton);
		
		JPanel reserveRosterPanel = new JPanel();
		reserveRosterPanel.setLayout(null);
		reserveRosterPanel.setBorder(new LineBorder(new Color(255, 66, 66), 2, true));
		reserveRosterPanel.setBounds(47, 253, 686, 162);
		frmClubScreen.getContentPane().add(reserveRosterPanel);
		
		JList<Athlete> reserveRosterList = new JList<Athlete>((ListModel) null);
		reserveRosterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reserveRosterList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		reserveRosterList.setBorder(new LineBorder(new Color(255, 151, 151)));
		reserveRosterList.setBounds(219, 11, 457, 140);
		reserveRosterPanel.add(reserveRosterList);
		
		JLabel reserveRosterText = new JLabel("Reserve Roster");
		reserveRosterText.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		reserveRosterText.setBounds(20, 11, 124, 23);
		reserveRosterPanel.add(reserveRosterText);
		
		JButton reserveRosterChangeButton = new JButton("Purchase");
		reserveRosterChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		reserveRosterChangeButton.setBounds(120, 121, 89, 23);
		reserveRosterPanel.add(reserveRosterChangeButton);
		
		JLabel reserveRosterChangeExplainationText1 = new JLabel("...");
		reserveRosterChangeExplainationText1.setBounds(10, 61, 211, 14);
		reserveRosterPanel.add(reserveRosterChangeExplainationText1);
		
		JLabel reserveRosterChangeExplainationText2 = new JLabel("...");
		reserveRosterChangeExplainationText2.setBounds(11, 81, 198, 14);
		reserveRosterPanel.add(reserveRosterChangeExplainationText2);
		
		JLabel reserveRosterChangeLabel = new JLabel("Athelete Changed!");
		reserveRosterChangeLabel.setForeground(new Color(255, 66, 66));
		reserveRosterChangeLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		reserveRosterChangeLabel.setBounds(10, 125, 104, 14);
		reserveRosterPanel.add(reserveRosterChangeLabel);
		
	}

}
