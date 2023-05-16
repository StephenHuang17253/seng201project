package main;

import gui.SetupScreen;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import gui.MainScreen;
import gui.StartScreen;

/**
 * Game Manager class.
 * This class contains and keeps track of the game.
 * @author Stephen Huang and Jasmine Ong
 */
public class GameManager {

	/**
	 * The current week number.
	 */
    private int week;
    /**
     * The total number of weeks.
     */
    private int totalWeeks;
    /**
     * The team name.
     */
    private String teamName;
    /**
     * The game difficulty.
     */
    private String difficulty;
    /**
     * The player's money.
     */
    private int money;
	private String name;
	private SetupScreen setupWindow;
	private ArrayList<Athlete> teamRoster = new ArrayList<>();

	 
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}

	public void launchStartScreen() {
		StartScreen startWindow = new StartScreen(this);
	}
	
	public void closeStartScreen(StartScreen startWindow) {
		startWindow.closeWindow();
		launchSetupScreen();
	}

	public void launchMainScreen() {
		MainScreen mainWindow = new MainScreen(this);
	}
	
	public void closeMainScreen(MainScreen mainWindow) {
		mainWindow.closeWindow();
	}		
	
	public void launchSetupScreen() {
		setupWindow = new SetupScreen(this);
	}
	

	public void closeSetUpScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
		launchMainScreen();
	}
	
	public void setUpGame(String name, int numWeeks, String difficulty, List<Athlete> startAthletes, int teamCost) {
		
		this.week = 1;
		this.totalWeeks = numWeeks;
		this.difficulty = difficulty;
		boolean validName = false;
		boolean validTeam = false;
		boolean validMoney = false;
		
		if (difficulty == "Normal") {
			// Normal difficulty starts with 5 million.
			this.money = 7000000;
		} else {
			// Hard diffuclty starts with only 2 million.
			this.money = 3500000;
		}		
		
		if (teamCost < money) {
			validMoney = true;
		} else {
			setupWindow.setListWarningLabel("Your team is too expensive!");
		}
		
		if ((name.length() < 3 || name.length() > 15 || !noSpecialChar(name))) {
			setupWindow.setNameWarningLabel("Invalid name, please check the length and remove any special characters.");
		} else {
			setupWindow.setNameWarningLabel("");
			validName = true;
			
			// Just to check if selecting athletes works.
			//for(int i = 0; i < teamRoster.size(); i++) {   
			    //System.out.print(("\n" + teamRoster.get(i)));
			} 	
		
		if (startAthletes.size() < 5) {
			setupWindow.setListWarningLabel("Please select at least 5 athletes!");
		} else {
			setupWindow.setListWarningLabel("");
			validTeam = true;
		}
		
		if ((validTeam && validName && validMoney)) {
			teamName = name;
			money -= teamCost;
			this.teamRoster.addAll(startAthletes);
			closeSetUpScreen(setupWindow);
		}
		
	}		
			
			

	
	
	public boolean noSpecialChar(String teamName)
	{
	    return teamName.matches("[a-zA-Z ]+");
	}	
	
	public String getTeamName() {
		return teamName;
	}
	
	public String getMoneyString() {
		DecimalFormat formatter = new DecimalFormat("#,###"); 
		return formatter.format(money);
	}
	
	public int getWeek() {
		return week;
	}
	
	public int getTotalWeeks() {
		return totalWeeks;
	}
	
	public static void main(String[] args) {
		GameManager manager = new GameManager();
		manager.launchStartScreen();
	}


}
