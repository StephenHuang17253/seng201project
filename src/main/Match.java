package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import main.AthleteGenerator;
import java.util.Random;

/**
 * This class represents a Match between the player's team and another team of Athletes.
 * The outcome of a Match is determined by this class.
 * @author Stephen Huang
 * @author Jasmine Ong
 */
public class Match {
	/**
	 * The name of the opposing team
	 */
	private String opponentName;
	/**
	 * The player's score in the Match
	 * If they have a higher score than the opponent, they will win.
	 */
	private int playerScore;
	/**
	 * The opponent's score in the Match
	 * If this is higher than the player's, the player will lose.
	 */
	private int opponentScore;
	/**
	 * The amount of money that will be awarded to the player if they win.
	 */
	private int prizeMoney;
	/**
	 * The amount by which their season points will increase  if they win.
	 */
	private int pointGain;
	/**
	 * The outcome of the Match represented by a string
	 */
	private String outcome;
	/**
	 * The incoming GameManager, the class that runs this game (not match).
	 */
	private GameManager manager;
	
	/**
	 * Constructor for a Match, this object is displayed in the StadiumScreen
	 * as an option in a list of Matches.
	 * @param name string of the opponent team
	 * @param prize the amount awarded to player upon victory
	 * @param points the amount of season points gained upon victory
	 */
	public Match(String name, int prize, int points) {
		setName(name);
		setPrizeMoney(prize);
		setPointGain(points);
	}
	/**
	 * Return the name of the opposing team.
	 * Used by the MatchGenerator to assign a name to the team of athletes generated.
	 * @return opponentName string
	 */
	public String getName() {
		return opponentName;
	}
	/**
	 * Sets the name of the opposing team to the specified string.
	 * @param name
	 */
	private void setName(String name) {
		opponentName = name;
	}
	/**
	 * Returns the score of the player, used at the end of match to compare with opponent.
	 * @return playerScore int
	 */
	public int getPlayerScore() {
		return playerScore;
	}
	/**
	 * Set the player's score equal to the specified amount.
	 * @param playerScore the player's score
	 */
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	/**
	 * Get score of the opposing team, used at the end of match to compare with player.
	 * @return opponentScore int
	 */
	public int getOpponentScore() {
		return opponentScore;
	}
	/**
	 * Set the score of the opponent to the specified amount.
	 * @param opponentScore the opponent's score
	 */
	public void setOpponentScore(int opponentScore) {
		this.opponentScore = opponentScore;
	}
	/**
	 * Get the amount of money to be awarded in the event of a player win.
	 * @return prizeMoney int
	 */
	public int getPrizeMoney() {
		return prizeMoney;
	}
	/**
	 * Set prizeMoney equal to the int amount.
	 * @param amount int the number to set prizeMoney to
	 */
	public void setPrizeMoney(int amount) {
		this.prizeMoney = amount;
	}
	/**
	 * Returns a given amount of money in a new format.
	 * For example 1,000,000 rather than 1000000.
	 * Used to create a String for money that is more readable.
	 * @param amount int the number to be formatted
	 * @return money string with comma between every 3 digits
	 */
	public String createPrizeString(int amount) {
		DecimalFormat formatter = new DecimalFormat("#,###"); 
		return formatter.format(amount);		
	}	
	/**
	 * Returns the amount of season points to be awarded in the event of a player victory.
	 * @return int number of points
	 */
	public int getPointGain() {
		return pointGain;
	}
	/**
	 * Set the number of points to be awarded equal to an int pointGain
	 * @param pointGain int
	 */
	public void setPointGain(int pointGain) {
		this.pointGain = pointGain;
	}
	/**
	 * Gets the outcome of the Match, represented as a string
	 * @return outcome string
	 */
	public String getOutcome() {
		return outcome;
	}
	/**
	 * Sets the result of the Match to the string outcome
	 * @param outcome string
	 */
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	/**
	 * This method runs and determines the outcome of a Match.
	 * It takes information from the GameManager and uses AthleteGenerator to create the opposing team.
	 * Then each Athlete from the teams will face off against their respective position on the opposing team,
	 * for example Striker vs Striker.
	 * 
	 * @param incomingManager the GameManager
	 * @param match the Match
	 */
	public void runMatch(GameManager incomingManager, Match match) {
		manager = incomingManager;
		manager.checkAthletePositions();
		ArrayList<Athlete> playerTeam = manager.getMainRoster();
		ArrayList<Athlete> opponentTeam = AthleteGenerator.generateTeam();
		manager.setOpponentRoster(opponentTeam);
		manager.setOpponentName(match.getName());
		boolean noStamina = true;
		
		for (int i = 0; i < playerTeam.size(); i++) {
			// compare athletes
			String[] positions = {"Striker", "Left Wing", "Right Wing", "Defender", "Keeper"};
			
			Athlete playerAthlete = manager.getPlayerInPosition(positions[i]); // Find correct player for matchup
			Athlete opposingAthlete = opponentTeam.get(i);
			System.out.println(playerAthlete.getName() + " (" + playerAthlete.getProficiency() + ") vs (" + opposingAthlete.getProficiency() + ") " + opposingAthlete.getName()); 
			if (playerAthlete.getProficiency() >= opposingAthlete.getProficiency()) {		
				playerScore += 1;
				playerAthlete.setMatchUpResult("Won faceoff");
				playerAthlete.incrementWins();
				playerAthlete.changeStamina(-1);
			} else {
				opponentScore += 1;
				playerAthlete.setMatchUpResult("Lost faceoff");
				playerAthlete.incrementLosses();
				playerAthlete.changeStamina(-4); // Stamina loss is higher on defeat
				
			}
			
	        if (playerAthlete.getStamina() > 0) {
	            noStamina = false; // As long as one athlete has stamina it's okay.
	        }			
		}
		
		
	    if (noStamina) {
	        manager.setMatchOutcome(outcome);
	        match.setOutcome("Defeat (Stamina)");
	    } else if (playerScore > opponentScore) {
	        match.setOutcome("Victory");
	        manager.setMatchOutcome(outcome);
	        manager.updateSeasonPoints(pointGain);
	        manager.changeMoney(prizeMoney);
	        manager.changeMoneyEarned(prizeMoney);
	        manager.incrementGamesWon();
	    } else {
	        match.setOutcome("Defeat");
	        manager.setMatchOutcome(outcome);
	    }	
	    
	    manager.totalGamesPlayed();
	
	}	
	
	public String toString() {
		return "Play against " + opponentName + "  |  Reward: $" + createPrizeString(prizeMoney) + " & " + pointGain + " points.";
	}
	

	
}
