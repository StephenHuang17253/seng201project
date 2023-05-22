package main;

import gui.SetupScreen;
import gui.StadiumScreen;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import gui.ClubScreen;
import gui.EndScreen;
import gui.MainScreen;
import gui.MarketScreen;
import gui.MarketSellScreen;
import gui.MatchScreen;
import gui.StartScreen;
import gui.InventoryScreen;
import gui.TrainingScreen;
import items.DefensiveCoach;
import items.Nutritionist;
import items.OffensiveCoach;
import items.Trainer;

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
     * The club's money.
     */
    private int money;
    /**
     * The club's season points.
     */
    private int seasonPoints;
    /**
     * The window for setting up the game.
     */
	private SetupScreen setupWindow;
	/**
	 * The player's main roster (starting lineup) of athletes.
	 */
	private ArrayList<Athlete> mainRoster = new ArrayList<>();
	/**
	 * The player's reserve athletes.
	 */
	private ArrayList<Athlete> reserveRoster = new ArrayList<>();
	
	private Athlete teamStriker;
	private Athlete teamLeftWing;
	private Athlete teamRightWing;
	private Athlete teamDefender;
	private Athlete teamKeeper;
	
	private ArrayList<Athlete> opponentRoster = new ArrayList<>();	
	private String opponentTeamName;
	
	private ArrayList<Athlete> marketAthletes = new ArrayList<>();
	private ArrayList<Item> marketItems = new ArrayList<>();
	private ArrayList<Item> inventory = new ArrayList<>();	
	
	private String matchOutcome;
	private ArrayList<Match> weeklyMatches = new ArrayList<>();
	
	

	 
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
	 * @param next the next screen
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

			launchMarketScreen();
		}
		
		if (next == "Bye") {
			takeBye();
			
			if (week > totalWeeks || !getCanContinue()){
				launchEndScreen();
			} 
		} 
		
		if (next == "Quit") {

		}
	}		

	public boolean getCanContinue() {
		int totalAthletes = getMainRoster().size() + getReserveRoster().size();
		if (totalAthletes < 5 && getMoney() < 100000) {
			return false;
		} else {
			return true;
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
		refreshWeek();
		launchMainScreen();
	}
	
	public void launchStadiumScreen() {
		StadiumScreen stadiumWindow = new StadiumScreen(this);
	}
	
	public void closeStadiumScreen(StadiumScreen stadiumWindow) {
		stadiumWindow.closeWindow();
	}
	
	public void launchClubScreen() {
		ClubScreen clubWindow = new ClubScreen(this);
	}
	
	public void closeClubScreen(ClubScreen clubWindow) {
		clubWindow.closeWindow();
		launchMainScreen();
	}
	
	public void launchMarketScreen() {
		MarketScreen marketWindow = new MarketScreen(this);
	}
	
	public void closeMarketScreen(MarketScreen marketWindow) {
		marketWindow.closeWindow();
		launchMainScreen();
	}
	
	public void launchTrainingScreen() {
		TrainingScreen trainingWindow = new TrainingScreen(this);		
	}
	
	public void closeTrainingScreen(TrainingScreen trainingWindow) {
		trainingWindow.closeWindow();
		launchMainScreen();
	}
	
	public void launchMarketSellScreen() {
		MarketSellScreen marketSellWindow = new MarketSellScreen(this, inventory);
	}
	
	public void closeMarketSellScreen(MarketSellScreen marketSellWindow) {
		marketSellWindow.closeWindow();
		launchMainScreen();
	}
	
	public void launchInventoryScreen(String originScreen) {
		InventoryScreen inventoryWindow = new InventoryScreen(this, inventory, originScreen);
	}
	
	public void closeInventoryScreen(InventoryScreen inventoryWindow, String origin) {
		if (origin == "Market") {
			inventoryWindow.closeWindow();
			launchMarketScreen();
		}
		
		if (origin == "Club") {
			inventoryWindow.closeWindow();
			launchClubScreen();
		}
		
		if (origin == "SellMarket") {
			inventoryWindow.closeWindow();
			launchMarketSellScreen();
		}
	}
	
	public void launchMatchScreen(Match match) {
		match.runMatch(this, match);
		MatchScreen matchWindow = new MatchScreen(this, match);
		matchOutcome = match.getOutcome();
		System.out.println(match.getOutcome());
	}
		
	public void closeMatchScreen(MatchScreen matchWindow) {
		matchWindow.closeWindow();
		
	}
		
	public void launchEndScreen() {
		EndScreen endWindow = new EndScreen(this);
	}
	
	public void closeEndScreen(EndScreen endWindow) {
		endWindow.closeWindow();
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
		
		if (difficulty == "Normal: start with $7.0M") {
			// Normal difficulty starts with 7.0 million.
			this.money = 7000000;
		} else {
			// Hard difficulty starts with only 3.5 million.
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
			this.reserveRoster.addAll(startAthletes);
			for (Athlete athlete : startAthletes) {
				AthleteGenerator.takenNames.add(athlete.getName());
			}
			closeSetUpScreen(setupWindow);
		}
		
	}		
			
	public void takeBye() {
		incrementWeek();
		refreshWeek();	
		ArrayList<Athlete> allAthletes = new ArrayList<>();
		allAthletes.addAll(getMainRoster());
		allAthletes.addAll(getReserveRoster());
		allAthletes.addAll(getOpponentRoster());
		for (Athlete athlete : allAthletes) {
			athlete.setStamina(athlete.getMaxStamina());		
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
	 * Method returns the player's money for use in calculations.
	 * @return int for money
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * Changes the player's money by the incoming amount.
	 * @param int amount that money will be changed by.
	 */
	public void changeMoney(int amount) {
		money += amount;
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
	 * Allowing other classes to use it if they have a manager.
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
	
	public void incrementWeek() {
		week += 1;

	}
	
	/**
	 * Simple getter for the total number of weeks.
	 * @return int for the total number of weeks.
	 */
	public int getTotalWeeks() {
		return totalWeeks;
	}
	
	public int getSeasonPoints() {
		return seasonPoints;
	}
	
	public void updateSeasonPoints(int points) {
		seasonPoints += points;
	}
	
	public ArrayList<Athlete> getMainRoster() {
		return mainRoster;
		
	}
	
	public ArrayList<Athlete> getReserveRoster() {
		return reserveRoster;
	}
	
	public ArrayList<Athlete> getOpponentRoster() {
		return opponentRoster;
	}
	
	public void setOpponentRoster(ArrayList<Athlete> opponents) {
		opponentRoster = opponents;
	}
	
	public String getOpponentName() {
		return opponentTeamName;
	}
	
	public void setOpponentName(String name) {
		opponentTeamName = name;
	}
		
	public String getMatchOutcome() {
		return matchOutcome;
	}
	
	public void setMatchOutcome(String outcome) {
		matchOutcome = outcome;
	}
	
	public boolean canCompete() {

		if (mainRoster.size() == 5) {
		    for (Athlete athlete : mainRoster) {
		        if (athlete.getStamina() < 1) {
		            return false;
		        }
		    }
		    return true;
		}
		return false;		
	}
	
	public void checkAthletePositions() {
		teamStriker = null;
		teamLeftWing = null;
		teamRightWing = null;
		teamDefender = null;
		teamKeeper = null;
		// Find Athlete positions.
		for (Athlete athlete : getMainRoster()) {
			
			switch(athlete.getPosition()) {
			 	case "Striker":
			 		teamStriker = athlete;
			 		break;
			 	case "Left Wing":
			 		teamLeftWing = athlete;
			 		break;
			 	case "Right Wing":
			 		teamRightWing = athlete;
			 		break;
			    case "Defender":
			    	teamDefender = athlete;
			    	break;
			    case "Keeper":
			    	teamKeeper = athlete;
			    	break;
			}
		}	
	}
	
	public Athlete getPlayerInPosition(String position) {
		
		Athlete athlete = null;
		
		switch(position) {
	 	case "Striker":
	 		athlete = teamStriker;
	 		break;
	 	case "Left Wing":
	 		athlete = teamLeftWing;
	 		break;
	 	case "Right Wing":
	 		athlete = teamRightWing;
	 		break;
	    case "Defender":
	    	athlete = teamDefender;
	    	break;
	    case "Keeper":
	    	athlete = teamKeeper;
	    	break;
		}		
		return athlete;
		
	}
	
	public void promoteAthlete(Athlete athlete, String position) {
		System.out.println(athlete.getName() + " has been moved to main roster");
		athlete.setPosition(position);
	    mainRoster.add(athlete);
	    reserveRoster.remove(athlete);
	}	
	
	public void demoteAthlete(Athlete athlete) {
		System.out.println(athlete.getName() + " has been moved to reserves");
		mainRoster.remove(athlete);
		athlete.setPosition("Unassigned");
	    reserveRoster.add(athlete);
	    
	 
	}
	
	public void draftMainAthlete(Athlete athlete, String position) {
		//AthleteGenerator.takenNames.add(athlete.getName());
		
		athlete.setPosition(position);
		mainRoster.add(athlete);
		money -= athlete.getContractPrice();
		marketAthletes.remove(athlete);
		if (mainRoster.contains(athlete)) {
			System.out.println(athlete.getName() + "has been drafted to active roster.");
		}
		
	}
	
	public void draftReserveAthlete(Athlete athlete) {
		reserveRoster.add(athlete);
		money -= athlete.getContractPrice();
		marketAthletes.remove(athlete);
		if (reserveRoster.contains(athlete)) {
			System.out.println(athlete.getName() + "has been drafted to reserves.");
		}
	}
	
	public void purchaseItem(Item item) {
		inventory.add(item);
		money -= item.getContractPrice();
		marketItems.remove(item);
		System.out.println(item.getName() + " was added to club inventory.");
	}

	public void sellAthlete(Athlete targetAthlete) {
		changeMoney(targetAthlete.getSellbackPrice());
		if (reserveRoster.contains(targetAthlete)) {
			reserveRoster.remove(targetAthlete);
		} else if (mainRoster.contains(targetAthlete) ) {
			mainRoster.remove(targetAthlete); 
		}
		
	}
		
	public void sellItem(Item item) {
		changeMoney(item.getSellbackPrice()); 
		inventory.remove(item);
	}
		
		
	
	public ArrayList<Athlete> getMarketAthletes() {
		return marketAthletes;
	}
	
	public void setMarketAthletes(ArrayList<Athlete> marketAthletes) {
		this.marketAthletes = marketAthletes;
	}
	
	public ArrayList<Item> getMarketItems() {
		return marketItems;
	}
	
	public void setMarketItems(ArrayList<Item> marketItems) {
		this.marketItems = marketItems;
	}
	
	public ArrayList<Match> getWeeklyMatches() {
		return weeklyMatches;
	}
	
	public void setWeeklyMatches(ArrayList<Match> matches) {
		this.weeklyMatches = matches;
	}	
	
	public void refreshWeek() {
		// Refresh taken names before generating new athletes.
		refreshTakenNames(); 
		ArrayList<Item> newItems = new ArrayList<>();
		newItems.add(new Trainer());
		newItems.add(new Nutritionist());
		newItems.add(new OffensiveCoach());
		newItems.add(new DefensiveCoach());
		setMarketItems(newItems);
		setMarketAthletes(AthleteGenerator.generateMarketAthletes(5));
		setWeeklyMatches(MatchGenerator.generateWeeklyMatches());
	}
	
    public void refreshTakenNames() {
    	ArrayList<Athlete> allAthletes = new ArrayList<>();
    	allAthletes.addAll(getMainRoster());
    	allAthletes.addAll(getReserveRoster());
    	for (Athlete athlete : allAthletes) {
    		String name = athlete.getName();
    		if (!AthleteGenerator.takenNames.contains(name)) {
    			AthleteGenerator.takenNames.add(name);
    		}
    	}
    }	
	
		
	public void greatlyIncreaseStats(Athlete athlete) {
		athlete.setDefence(athlete.getDefence()+2);
		athlete.setHealth(athlete.getHealth()+2);
		athlete.setOffence(athlete.getOffence()+2);
		athlete.setStamina(athlete.getStamina()+2);
	}
	
	public void itemIncreaseAthleteStats(Athlete athlete, Item item) {
		
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
