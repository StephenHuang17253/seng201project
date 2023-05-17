package main;

import gui.SetupScreen;
import gui.StadiumScreen;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import gui.ClubScreen;
import gui.MainScreen;
import gui.StartScreen;

/**
 * Game Manager class.
 * Contains and keeps track of the game.
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
    /**
     * The window for setting up the game.
     */
	private SetupScreen setupWindow;
	/**
	 * The player's team of athletes.
	 */
	private ArrayList<Athlete> teamRoster = new ArrayList<>();

	 
	/**
	 * Method to launch the start screen.
	 */
	public void launchStartScreen() {
		StartScreen startWindow = new StartScreen(this);
	}
	/**
	 * Method to close the start screen and open the setup.
	 * @param startWindow the start frame
	 */
	public void closeStartScreen(StartScreen startWindow) {
		startWindow.closeWindow();
		launchSetupScreen();
	}
	/**
	 * Method to launch the main game screen.
	 */
	public void launchMainScreen() {
		MainScreen mainWindow = new MainScreen(this);
	}
	/**
	 * Method to close the main game screen when it's not needed.
	 * @param mainWindow the main screen
	 */
	public void closeMainScreen(MainScreen mainWindow, String next) {
		mainWindow.closeWindow();
		
		if (next == "Stadium") {
			launchStadiumScreen();
		}
		
		if (next == "Club") {
			launchClubScreen();
		}
		
		if (next == "Market") {
			//TODO
		}
		
		if (next == "Quit") {
			//TODO
		}
	}		
	/**
	 * Method to launch the setup screen.
	 */
	public void launchSetupScreen() {
		setupWindow = new SetupScreen(this);
	}
	/**
	 * Method to clsoe the setup screen when ready.
	 * @param setupWindow the setup screen
	 */
	public void closeSetUpScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
		launchMainScreen();
	}
	
	public void launchStadiumScreen() {
		StadiumScreen stadiumWindow = new StadiumScreen(this);
	}
	
	public void closeStadiumScreen(StadiumScreen stadiumWindow) {
		stadiumWindow.closeWindow();
		launchMainScreen();
	}
	
	public void launchClubScreen() {
		ClubScreen clubWindow = new ClubScreen(this);
	}
	
	public void closeClubScreen(ClubScreen clubWindow) {
		clubWindow.closeWindow();
		launchMainScreen();
	}
	
	
	/**
	 * Method to set up the game.
	 * Gets the team name, number of weeks, difficulty, starting athletes, and money.
	 * @param name the team name chosen by the player.
	 * @param numWeeks the length of the season in weeks.
	 * @param difficultyChoice the player's chosen difficulty.
	 * @param startAthletes the starting roster of athletes.
	 * @param teamCost the cost of that roster, this value is deducted from starting money.
	 */
	public void setUpGame(String name, int numWeeks, String difficultyChoice, List<Athlete> startAthletes, int teamCost) {
		this.week = 1;
		this.totalWeeks = numWeeks;
		this.difficulty = difficultyChoice;
		boolean validName = false;
		boolean validTeam = false;
		boolean validMoney = false;
		
		if (difficulty == "Normal") {
			// Normal difficulty starts with 7.0 million.
			this.money = 7000000;
		} else {
			// Hard diffuclty starts with only 3.5 million.
			this.money = 3500000;
		}		
		
		if (teamCost < money) {
			setupWindow.setListCostWarningLabel("");
			validMoney = true;
		} else {
			setupWindow.setListCostWarningLabel("Your team is too expensive!");
		}
		
		if ((name.length() < 3 || name.length() > 15 || !noSpecialChar(name))) {
			setupWindow.setNameWarningLabel("Invalid name, please check the length and remove any special characters.");
		} else {
			setupWindow.setNameWarningLabel("");
			validName = true;
			
			// Check if selecting athletes works.
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
			
	
	
	/**
	 * Method that can be used to check for (lack of) special characters. 
	 * If team name matches regex [a-zA-Z], then it will not have special characters.
	 * @param teamName
	 * @return boolean for match
	 */
	public boolean noSpecialChar(String teamName)
	{
	    return teamName.matches("[a-zA-Z ]+");
	}	
	/**
	 * Simple getter for the team name.
	 * @return String for name of team
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * Method returns the player's money in a more suitable format as a string.
	 * @return String for money format
	 */
	public String getMoneyString() {
		DecimalFormat formatter = new DecimalFormat("#,###"); 
		return formatter.format(money);
	}
	/**
	 * Same as above but instead of the team money, it takes an amount as a parameter.
	 */
	public String getMoneyFormat(int amount) {
		DecimalFormat formatter = new DecimalFormat("#,###"); 
		return formatter.format(amount);		
	}
	/**
	 * Simple getter for the current week.
	 * @return int for the current week number.
	 */
	public int getWeek() {
		return week;
	}
	/**
	 * Simple getter for the total number of weeks.
	 * @return int for the total number of weeks.
	 */
	public int getTotalWeeks() {
		return totalWeeks;
	}
	
	/**
	 * Main game method.
	 * Begins by game by instantiating GameManager and calling launchStartScreen();  
	 * @param args
	 */
	public static void main(String[] args) {
		GameManager manager = new GameManager();
		manager.launchStartScreen();
	}


}
