package main;

import gui.SetupScreen;
import gui.StadiumScreen;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import gui.*;
import items.*;

/**
 * Game Manager class. 
 * The main class of the program.
 * Contains and keeps track of the game logic.
 * Game is played from this class.
 * @author Stephen Huang
 * @author Jasmine Ong
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
     * The team name, determined by the player.
     */
    private String teamName;
    /**
     * The game difficulty, used to determine starting money.
     */
    private String difficulty;
    /**
     * The club's money, used for purchasing from the market.
     */
    private int money;
    /**
     * The amount of money earned from winning matches.
     * Displayed in the end screen summary.
     */
    private int totalEarned;
    /**
     * The amount of games played.
     */
    private int totalGames;
    /**
     * The amount of games won.
     */
    private int totalGamesWon;
    /**
     * The club's season points.
     * Displayed in the end screen summary.
     */
    private int seasonPoints;
    /**
     * The window for setting up the game.
     */
	private SetupScreen setupWindow;
	/**
	 * Stores the player's athletes
	 * Contains the main and reserve rosters.
	 */
	private Team team;	
	/**
	 * Holds the roster of the current opponent of a match.
	 */
	private ArrayList<Athlete> opponentRoster = new ArrayList<>();	
	/**
	 * The name of the opponent team.
	 */
	private String opponentTeamName;
	/**
	 * An ArrayList list of Athletes available for sale in the MarketScreen.
	 */
	private ArrayList<Athlete> marketAthletes = new ArrayList<>();
	/**
	 * An ArrayList of Items available for sale in the MarketScreen.
	 */
	private ArrayList<Item> marketItems = new ArrayList<>();
	/**
	 * Stores the Items owned by the player.
	 */
	private ArrayList<Item> inventory = new ArrayList<>();	
	/**
	 * Stores a string representing outcome of match..
	 */
	private String matchOutcome;
	/**
	 * Stores this week's generated matches.
	 */
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
			else {
				if (getEnoughAthletes() == false) {
					launchEndScreen();
				}
				else {
					launchTrainingScreen();
				}
			}
		
		} 
		
		if (next == "Quit") {
			mainWindow.closeWindow();
		}
	}		

	/**
	 * If the player cannot field a starting lineup nor has enough money to afford one,
	 * the game will end on the next week.
	 * @return boolean
	 */
	public boolean getCanContinue() {
		int totalAthletes = getTeam().getMainRoster().size() + getTeam().getReserveRoster().size();
		if (totalAthletes < 5 && getMoney() < 100000) {
			return false;
		} else {
			return true;
		}			
	}
	
	/**
	 * Adds up the sizes of the starting lineup and reserves.
	 * @return boolean
	 */
	public boolean getEnoughAthletes() {
		int totalAthletes = getTeam().getMainRoster().size() + getTeam().getReserveRoster().size();
		if (totalAthletes < 5) {
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
	 * Method to close the setup screen when ready.
	 * Will call refreshWeek() to prepare the first week of matches and market items.
	 * Launches the main screen to begin the game.
	 * @param setupWindow the setup screen
	 */
	public void closeSetUpScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
		refreshWeek();
		launchMainScreen();
	}
	/**
	 * Launches the Stadium screen
	 * where the player will be able to view and play matches.
	 */
	public void launchStadiumScreen() {
		StadiumScreen stadiumWindow = new StadiumScreen(this);
	}
	/**
	 * Closes the stadium screen when it is no longer needed.
	 * @param stadiumWindow StadiumScreen
	 */
	public void closeStadiumScreen(StadiumScreen stadiumWindow) {
		stadiumWindow.closeWindow();
	}
	/**
	 * Launches the Club screen where the player manages their team and inventory.
	 * Here, the player is able to designate athletes to a position in the starting lineup.
	 * Athletes can be benched or promoted.
	 */
	public void launchClubScreen() {
		ClubScreen clubWindow = new ClubScreen(this);
	}
	/**
	 * Closes the Club screen
	 * @param clubWindow ClubScreen
	 */
	public void closeClubScreen(ClubScreen clubWindow) {
		clubWindow.closeWindow();
		launchMainScreen();
	}
	/**
	 * Launches the Market screen where the player will be able to buy and sell purchasebles.
	 * Purchaseables include Athletes and consumable Items.
	 */
	public void launchMarketScreen() {
		MarketScreen marketWindow = new MarketScreen(this);
	}
	/**
	 * Closes the Market screen and returns to the main menu.
	 * @param marketWindow MarketScreen
	 */
	public void closeMarketScreen(MarketScreen marketWindow) {
		marketWindow.closeWindow();
		launchMainScreen();
	}
	/**
	 * When the player takes a bye to move onto the next week, they are given the option
	 * to train one of their Athletes.
	 */
	public void launchTrainingScreen() {
		TrainingScreen trainingWindow = new TrainingScreen(this);		
	}
	/**
	 * Closes the Training Screen.
	 * @param trainingWindow TrainingScreen
	 */
	public void closeTrainingScreen(TrainingScreen trainingWindow) {
		trainingWindow.closeWindow();
		launchMainScreen();
	}
	/**
	 * The window of the Market that allows the player to sell instead of purchase items.
	 */
	public void launchMarketSellScreen() {
		MarketSellScreen marketSellWindow = new MarketSellScreen(this, inventory);
	}
	/**
	 * Closes the market and returns to the main menu.
	 * @param marketSellWindow MarketSellScreen
	 */
	public void closeMarketSellScreen(MarketSellScreen marketSellWindow) {
		marketSellWindow.closeWindow();
		launchMainScreen();
	}
	/**
	 * Launches the inventory screen which can be accessed from both the Market and the Club.
	 * As a result, it takes the parameter originScreen so it knows where to return to.
	 * @param originScreen the screen the inventory was accessed from
	 */
	public void launchInventoryScreen(String originScreen) {
		InventoryScreen inventoryWindow = new InventoryScreen(this, inventory, originScreen);
	}
	/**
	 * Thanks to the origin parameter, this method will open up the previous screen when the inventory the closes.
	 * @param inventoryWindow the inventory screen which displays the player's items
	 * @param origin the screen that the inventory was accessed from
	 */
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
	/**
	 * Launch the match screen and calls run match to determine the outcome
	 * After the outcome is determined, the GameManager stores it for use in other methods.
	 * @param match the game being palyed
	 */
	public void launchMatchScreen(Match match) {
		match.runMatch(this, match);
		MatchScreen matchWindow = new MatchScreen(this, match);
		matchOutcome = match.getOutcome();

	}
	/**
	 * Closes the match screen when the go back button is pressed.	
	 * @param matchWindow the screen where matches are played.
	 */
	public void closeMatchScreen(MatchScreen matchWindow) {
		matchWindow.closeWindow();
		
	}
	/**
	 * The end of the game	
	 */
	public void launchEndScreen() {
		EndScreen endWindow = new EndScreen(this);
	}
	
	/**
	 * Closes the final screen of the game
	 * @param endWindow EndScreen
	 */
	public void closeEndScreen(EndScreen endWindow) {
		endWindow.closeWindow();
	}
	
	/**
	 * Method to set up the game.
	 * Gets the team name, number of weeks, difficulty, starting athletes, and money.
	 * @param name the team name chosen by the player.
	 * @param numWeeks the length of the season in weeks.
	 * @param difficultyChoice the player's chosen difficulty. This will affect starting money.
	 * @param startAthletes the athletes available at setup.
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
			setMoney(7000000);
		} else {
			// Hard difficulty starts with only 3.5 million.
			setMoney(3500000);
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
			team = new Team(name);
			getTeam().getReserveRoster().addAll(startAthletes);
			for (Athlete athlete : startAthletes) {
				AthleteGenerator.takenNames.add(athlete.getName());
			}
			closeSetUpScreen(setupWindow);
		}
		
	}		

	/**
	 * Method that handles transitioning between weeks
	 * It increments the week number,
	 * Raises the stats for athlete generation, resulting in 	
	 */
	public void takeBye() {
		incrementWeek();
		AthleteGenerator.incrementMinMaxStats(); // Opponent teams get stronger each weak.
		refreshWeek();	
		getTeam().determineBestAthlete();
		ArrayList<Athlete> allAthletes = new ArrayList<>();
		allAthletes.addAll(getTeam().getMainRoster());
		allAthletes.addAll(getTeam().getReserveRoster());
		allAthletes.addAll(getOpponentRoster());
		for (Athlete athlete : allAthletes) {
			athlete.setStamina(athlete.getMaxStamina());		
		}

	}
	
	/**
	 * Method that can be used to check for (lack of) special characters. 
	 * If team name matches regex [a-zA-Z], then it will not have special characters.
	 * @param teamName String
	 * @return boolean for match
	 */
	public boolean noSpecialChar(String teamName)
	{
	    return teamName.matches("[a-zA-Z ]+");
	}	
	/**
	 * Returns the name of the team.
	 * @return String for name of team
	 */
	public String getTeamName() {
		return teamName;
	}
	
	/**
	 * Getter for team
	 * @return the team
	 */
	public Team getTeam() {
		return team;
	}
	/**
	 * Setter for team
	 * @param team the team to set
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	/**
	 * Returns the player's money for use in calculations.
	 * @return int for money
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * Sets the player's money to be equal to the int amount.
	 * @param amount
	 */
	private void setMoney(int amount) {
		money = amount;
	}	
	
	/**
	 * Changes the player's money by the incoming amount.
	 * @param amount int that money will be changed by.
	 */
	public void changeMoney(int amount) {
		money += amount;
	}
	/**
	 * Increases the total for money earnt from matches.
	 * This is being done so we can show it in the end summary.
	 * @param earned int the amount to increase total by
	 */
	public void changeMoneyEarned(int earned) {
		totalEarned += earned;
	}
	/**
	 * Returns the total amount of money earned from matches.
	 * This will be called in the end summary
	 * @return totalEarned int
	 */
	public int getMoneyEarned() {
		return totalEarned;
	}
	/**
	 * Method returns the player's money in a more suitable format as a string.
	 * For example 5,000,000 intead of 5000000
	 * @return String for money format
	 */
	public String getMoneyString() {
		DecimalFormat formatter = new DecimalFormat("#,###"); 
		return formatter.format(money);
	}
	/**
	 * Same as above but instead of the team money, it takes an amount as a parameter.
	 * Allowing it to be used in other cases.
	 * @param amount int
	 * @return String for money format
	 */
	public String getMoneyFormat(int amount) {
		DecimalFormat formatter = new DecimalFormat("#,###"); 
		return formatter.format(amount);		
	}
	/**
	 * The current week number.
	 * @return week the current week number.
	 */
	public int getWeek() {
		return week;
	}
	/**
	 * Increases the week by one.
	 */
	public void incrementWeek() {
		week += 1;

	}
	
	/**
	 * The chosen difficulty.
	 * @return difficulty the game difficulty.
	 */
	public String getDifficulty() {
		return difficulty;
	}
	
	/**
	 * Simple getter for the total number of weeks.
	 * @return totalWeeks the total number of weeks.
	 */
	public int getTotalWeeks() {
		return totalWeeks;
	}
	/**
	 * Season points are earned from matches and displayed in the stadium and the end of the game.
	 * @return seasonPoints int
	 */
	public int getSeasonPoints() {
		return seasonPoints;
	}
	
	/**
	 * Updates the season point count by the param points
	 * Receive extra 5 points per win on Hard difficulty!
	 * @param points int
	 */
	public void updateSeasonPoints(int points) {
		if (difficulty == "Normal: start with $7.0M") {
			seasonPoints += points;
		} else {
			seasonPoints += (5 + points);
		}
	}

	/**
	 * Returns the list of athletes that the main roster will compete against.
	 * @return opponentRoster ArrayList of opposing athletes
	 */
	public ArrayList<Athlete> getOpponentRoster() {
		return opponentRoster;
	}
	/**
	 * Sets the opponent roster to be the incoming list of opponents
	 * This list is randomly generated.
	 * @param opponents ArrayList of opposing athletes
	 */
	public void setOpponentRoster(ArrayList<Athlete> opponents) {
		opponentRoster = opponents;
	}
	/**
	 * Getter for the opponent team name
	 * Displayed in MatchScreen
	 * @return string opponentTeamName 
	 */
	public String getOpponentName() {
		return opponentTeamName;
	}
	/**
	 * Set the opponentTeam name to be equal to param name
	 * @param name string for the opponent team name
	 */
	public void setOpponentName(String name) {
		opponentTeamName = name;
	}
	/**
	 * Getter for the match outcome	
	 * For example "Victory"
	 * Used by other methods to check who won
	 * @return string matchOutcome
	 */
	public String getMatchOutcome() {
		return matchOutcome;
	}
	/**
	 * Set the outcome to be equal to the incoming string
	 * @param outcome string
	 */
	public void setMatchOutcome(String outcome) {
		matchOutcome = outcome;
	}
	/**
	 * Used to record the amount of games played
	 * Increases the count by one each time it is called
	 */
	public void totalGamesPlayed() {
		totalGames += 1;
	}
	/**
	 * Gets the number of games played
	 * @return totalGames int for number of played games
	 */
	public int getGamesPlayed() {
		return totalGames;
	}
	/**
	 * Increments the number of games won by one
	 */
	public void incrementGamesWon() {
		totalGamesWon += 1;
	}
	/**
	 * Get the number of games won by the player.
	 * @return totalGamesWon int
	 */
	public int getGamesWon() {
		return totalGamesWon;
	}
	/**
	 * This method checks if the player can still compete in matches
	 * If the starting lineup does not contain 5 players with stamina
	 * then the player cannot compete in a match.
	 * @return boolean
	 */
	public boolean canCompete() {

		if (getTeam().getMainRoster().size() == 5) {
		    for (Athlete athlete : getTeam().getMainRoster()) {
		        if (athlete.getStamina() < 1) {
		            return false;
		        }
		    }
		    return true;
		}
		return false;		
	}
	
	/**
	 * This method is used for purchasing athletes from the market and adding them to the starting lineup directly.
	 * It assigns a position, adds athlete to main roster, changes money and then removes this athlete from the list of athletes on the market.
	 * @param athlete the Athlete purchased
	 * @param position the Athlete's purchased
	 */
	public void draftMainAthlete(Athlete athlete, String position) {
		
		athlete.setPosition(position);
		getTeam().getMainRoster().add(athlete);
		changeMoney(-athlete.getContractPrice());
		marketAthletes.remove(athlete);
	}
	/**
	 * This method adds an athlete from the market to the reserves. Then the player's money is deducted by the athlete's contract price.
	 * Next this athlete is removed from the list of athletes for sale on the market.
	 * @param athlete Athlete
	 */
	public void draftReserveAthlete(Athlete athlete) {
		getTeam().getReserveRoster().add(athlete);
		changeMoney(-athlete.getContractPrice());
		marketAthletes.remove(athlete);
	}
	/**
	 * This method adds an item to the player's inventory and deducts the price from their money.
	 * After the purchase the item is removed from the list of purchasable items.
	 * @param item the Item being purchased
	 */
	public void purchaseItem(Item item) {
		inventory.add(item);
		changeMoney(-item.getContractPrice());
		marketItems.remove(item);

	}
	/**
	 * This method sells athletes by increasing the player money by the athletes sellback price.
	 * Then they will be removed from whichever roster contains them.
	 * @param targetAthlete the Athlete being sold
	 */
	public void sellAthlete(Athlete targetAthlete) {
		changeMoney(targetAthlete.getSellbackPrice());
		if (getTeam().getReserveRoster().contains(targetAthlete)) {
			getTeam().getReserveRoster().remove(targetAthlete);
		} else if (getTeam().getMainRoster().contains(targetAthlete) ) { 
			getTeam().getMainRoster().remove(targetAthlete); 
		}
		
	}
	/**
	 * Increases the player's money by the item's sell price and then removes it from inventory. 	
	 * @param item the Item being sold
	 */
	public void sellItem(Item item) {
		changeMoney(item.getSellbackPrice()); 
		inventory.remove(item);
	}
	/**
	 * Return the list of Athletes available on the market.	
	 * @return marketAthletes ArrayList of the Athletes for sale
	 */
	public ArrayList<Athlete> getMarketAthletes() {
		return marketAthletes;
	}
	/**
	 * Sets the list of Athletes available on the market.
	 * @param marketAthletes an ArrayList of Athlete objects
	 */
	public void setMarketAthletes(ArrayList<Athlete> marketAthletes) {
		this.marketAthletes = marketAthletes;
	}
	/**
	 * Return the list of Items available on the market.
	 * @return marketItems an ArrayList of Item objects
	 */
	public ArrayList<Item> getMarketItems() {
		return marketItems;
	}
	/**
	 * Set the list of items available on the market
	 * @param marketItems an ArrayList of Item objects
	 */
	public void setMarketItems(ArrayList<Item> marketItems) {
		this.marketItems = marketItems;
	}
	/**
	 * Return the list of weekly matches that can be played in the Stadium.
	 * @return weeklyMatches an ArrayList of Match objects
	 */
	public ArrayList<Match> getWeeklyMatches() {
		return weeklyMatches;
	}
	/**
	 * Set the list of weekly matches that can be played in the Stadium.
	 * @param matches an ArrayList of Match objects
	 */
	public void setWeeklyMatches(ArrayList<Match> matches) {
		this.weeklyMatches = matches;
	}	
	
	/**
	 * This method adds all the possible Items into an ArrayList and then returns it.
	 * Used to get the Items for sale on the Market.
	 * @return items ArrayList of Item objects
	 */
	public ArrayList<Item> getPossibleItems() {
		ArrayList<Item> items = new ArrayList<>();
		items.add(new DefensiveCoach());
		items.add(new OffensiveCoach());
		items.add(new Trainer());
		items.add(new DefenceTrainingEquipment());		
		items.add(new OffenceTrainingEquipment());		
		items.add(new InsaneFood());
		items.add(new Nutritionist());
		
		return items;
	}
	/**
	 * This method is used when the player takes a bye to refresh the game logic for the week.
	 * It refreshes the list of taken names that will be checked during athlete generation.
	 * It generates and sets a new list of athletes for the market, and matches for the stadium.
	 */
	public void refreshWeek() {
		// Refresh taken names before generating new athletes.
		refreshTakenNames(); 
		setMarketItems(getPossibleItems());
		setMarketAthletes(AthleteGenerator.generateMarketAthletes(5));
		setWeeklyMatches(MatchGenerator.generateWeeklyMatches());
	}
	/**
	 * This is called every week to update the list of taken names.
	 * When athletes are generated, they check this list to prevent duplicate athletes.
	 */
    public void refreshTakenNames() {
    	ArrayList<Athlete> allAthletes = new ArrayList<>();
    	allAthletes.addAll(getTeam().getMainRoster());
    	allAthletes.addAll(getTeam().getReserveRoster());
    	for (Athlete athlete : allAthletes) {
    		String name = athlete.getName();
    		if (!AthleteGenerator.takenNames.contains(name)) {
    			AthleteGenerator.takenNames.add(name);
    		}
    	}
    }	
	
	/**
	 * When the player takes a bye they get the option to train one of their athletes.
	 * This method increases each of their stats by 2.	
	 * @param athlete the Athlete to increase the stats of
	 */
	public void greatlyIncreaseStats(Athlete athlete) {
		athlete.changeOffence(2);
		athlete.changeDefence(2);
		athlete.changeHealth(2);
		athlete.changeMaxStamina(1); 
	}
	/**
	 * The player can use Items on their Athletes in the Inventory screen.
	 * Each Item can increase a specific stat. When this method is called the 
	 * items are removed and a partiucular stat of the Athlete will be increased.
	 * @param athlete the Athlete to increase the stats of
	 * @param item the Item to use on the Athlete
	 */
	public void useItem(Athlete athlete, Item item) {
		String stat = item.getStatToChange();
		int changeBy = item.getChange();
		switch (stat) {
		case "Offence":
			athlete.changeOffence(changeBy);
			break;
		case "Defence":
			athlete.changeDefence(changeBy);
			break;
		case "Health":
			athlete.changeHealth(changeBy);
			break;
		case "Stamina":
			athlete.changeMaxStamina(changeBy);
			athlete.changeStamina(changeBy);
			break;
		}
		inventory.remove(item);
	}
	/**
	 * Updates roster-related warnings in the ClubScreen
	 * This method exists to prevent make changing the label more convenient.
	 */
	public void rosterWarnings() {
		if (getTeam().getMainRoster().size() < 5) {
			if ((getTeam().getMainRoster().size() + getTeam().getReserveRoster().size() < 5)){
				ClubScreen.warningLabel.setText("You do not have enough players to compete! Go buy more Athletes in the market.");
			}
			else {
				ClubScreen.warningLabel.setText("Your main roster does not have enough players to compete! Promote some reserves.");
			}
		}
		else {
			ClubScreen.warningLabel.setText("");
		}
	}

	/**
	 * Main method.
	 * Begins the game by calling launchStartScreen();  
	 * @param args array of command-line arguments for the application
	 */
	public static void main(String[] args) {
		GameManager manager = new GameManager();
		manager.launchStartScreen();
	}


}
