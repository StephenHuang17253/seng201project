package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartScreen {

	private JFrame frmKickheroes;
	private static GameManager manager;
	private JLabel lblWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen(manager);
					window.frmKickheroes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmKickheroes.setVisible(true);
	}

	public void closeWindow() {
		frmKickheroes.dispose();
	}
	
	public void finishedWindow() {
		manager.closeStartScreen(this);
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKickheroes = new JFrame();
		frmKickheroes.setTitle("KickHeroes");
		frmKickheroes.setBounds(100, 100, 1018, 604);
		frmKickheroes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKickheroes.getContentPane().setLayout(null);
		
		lblWelcome = new JLabel("Welcome to KickHeroes ");
		lblWelcome.setBounds(141, 132, 829, 164);
		lblWelcome.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 52));
		frmKickheroes.getContentPane().add(lblWelcome);
		
		JLabel lblStart = new JLabel("Press \"Start\" to play!");
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStart.setBounds(401, 281, 233, 49);
		frmKickheroes.getContentPane().add(lblStart);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnStart.setBounds(347, 356, 287, 106);
		frmKickheroes.getContentPane().add(btnStart);
	}
}
