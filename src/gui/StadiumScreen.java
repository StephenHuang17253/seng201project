package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;

import main.GameManager;
import main.Match;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class StadiumScreen {

	private JFrame frmStadium;
	private GameManager manager;
	private JLabel stadiumLabel;
	private JLabel listLabel;
	private JButton backButton;
	private JButton playButton;
	private JTextArea explanationText;
	private ArrayList<Match> matches = new ArrayList<>();
	private JPanel panel;
	private JPanel panel_1;

	 
	public StadiumScreen(GameManager incomingManager) {
		manager = incomingManager;
		matches.add(new Match("The Eagles", 1000000, 5));
		matches.add(new Match("The Bulls", 1500000, 7));
		matches.add(new Match("Natus Vincere Sports Club", 2000000, 8));
		matches.add(new Match("Shiratorizawa", 3500000, 9));
		matches.add(new Match("Karasuno Sports Club", 4000000, 10));
		initialize();
		frmStadium.setVisible(true);
	}
	
	/**
	 * Launch the application. 
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					StadiumScreen window = new StadiumScreen();
					window.frmStadium.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StadiumScreen() {
		initialize();
	}

	public void closeWindow() {
		frmStadium.dispose();
	}
	
	public void finishedWindow() {
		manager.closeStadiumScreen(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStadium = new JFrame();
		frmStadium.setTitle("Stadium");
		frmStadium.setBounds(100, 100, 700, 514);
		frmStadium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStadium.getContentPane().setLayout(null);
		
		stadiumLabel = new JLabel("The Stadium");
		stadiumLabel.setBounds(239, 40, 206, 30);
		stadiumLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		stadiumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmStadium.getContentPane().add(stadiumLabel);
		
		// Create a ListModel to store the matches in the Jlist
		DefaultListModel<Match> matchListModel = new DefaultListModel<Match>();
		// Add the existing matches to the ListModel
		matchListModel.addAll(matches);
		
		JList<Match> matchList = new JList<Match>(matchListModel);
		matchList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		matchList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		matchList.setBounds(142, 147, 400, 138);
		matchList.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		frmStadium.getContentPane().add(matchList);
		
		listLabel = new JLabel("Available matches");
		listLabel.setLabelFor(matchList);
		listLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);
		listLabel.setBounds(278, 114, 123, 14);
		frmStadium.getContentPane().add(listLabel);
		
		explanationText = new JTextArea();
		explanationText.setFont(new Font("Tahoma", Font.PLAIN, 11));
		explanationText.setEditable(false);
		explanationText.setWrapStyleWord(true);
		explanationText.setLineWrap(true);
		explanationText.setText("You can select a match to play.\r\n\r\nVictory is rewarded with money and season points.\r\n");
		explanationText.setBackground(new Color(240, 240, 240));
		explanationText.setBounds(10, 160, 133, 125);
		frmStadium.getContentPane().add(explanationText);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 684, 99);
		frmStadium.getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 286, 684, 189);
		frmStadium.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		playButton = new JButton("Play selected match");
		playButton.setBounds(142, 35, 400, 60);
		panel_1.add(playButton);
		
		backButton = new JButton("Go back");
		backButton.setBounds(142, 106, 400, 60);
		panel_1.add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
	}
}
