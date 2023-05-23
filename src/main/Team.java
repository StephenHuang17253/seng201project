package main;

import java.util.ArrayList;

/**
 * The Team class stores the player's athletes and handles logic related 
 * to the team, its rosters, and its athletes.
 * @author Stephen Huang
 *
 */
public class Team {
	/**
	 * The player's team's name.
	 */
	private String teamName;
	/**
	 * The player's main roster (starting lineup) of athletes.
	 */
	private ArrayList<Athlete> mainRoster = new ArrayList<>();
	/**
	 * The player's reserve athletes.
	 */
	private ArrayList<Athlete> reserveRoster = new ArrayList<>();
	/**
	 * Stores the Athlete playing the Striker position.
	 */
	private Athlete teamStriker;
	/**
	 * Stores the Athlete playing the Left Wing position.
	 */
	private Athlete teamLeftWing;
	/**
	 * Stores the Athlete playing the Right Wing position.
	 */
	private Athlete teamRightWing;
	/**
	 * Stores the Athlete playing the Defender position.
	 */
	private Athlete teamDefender;
	/**
	 * Stores the Athlete playing the Keeper position.
	 */
	private Athlete teamKeeper;
	/**
	 * Stores the Athlete with the most matchup wins.
	 * matchup or faceoff wins refer to beating their assigned opponent in matches.
	 */
	private Athlete bestAthlete;

	/**
	 * Constructs a Team object with the name chosen by player.
	 *
	 * @param name the team name
	 */
	public Team(String name) {
		teamName = name;
	}
	
	
	/**
	 * Returns the name of the team.
	 * @return String for name of team
	 */
	public String getTeamName() {
		return teamName;
	}
	
	/**
	 * Returns the starting lineup of Athletes,
	 * the 5 players that have positions assigned.
	 * These are the players who will compete in matches.
	 * @return ArrayList of Athlete objects, representing main roster of players
	 */
	public ArrayList<Athlete> getMainRoster() {
		return mainRoster;
		
	}
	/**
	 * Returns the reserve roster of players.
	 * @return reserveRoster the reserves
	 */
	public ArrayList<Athlete> getReserveRoster() {
		return reserveRoster;
	}
	
	/**
	 * This method removes a particular athlete from reserves and adds them to the main roster.
	 * @param athlete the player being promoted
	 * @param position the position they're being assigned to play
	 */
	public void promoteAthlete(Athlete athlete, String position) {
		athlete.setPosition(position);
	    mainRoster.add(athlete);
	    reserveRoster.remove(athlete);
	}	
	/**
	 * This method removes the specified athlete from the main roster and changes their position
	 * to "Unassigned". They are then added to the reserve roster.
	 * @param athlete the Athlete being demoted
	 */
	public void demoteAthlete(Athlete athlete) {
		mainRoster.remove(athlete);
		athlete.setPosition("Unassigned");
	    reserveRoster.add(athlete);
	}

	/**
	 * This method goes through the active roster and
	 * finds the athlete playing each position.
	 */
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
	
	/**
	 * Returns the athlete playing a particular position.
	 * @param position String
	 * @return athlete Athlete
	 */
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
	
	/**
	 * The Athlete with the highest number of matchup wins will be the player's best Athlete.
	 * Matchups refer to the comparison between two athletes in the same position during a match between teams.
	 * This method determines which athlete in the player's club has won the most of these.
	 * They will be displayed in the end game summary.
	 */
	public void determineBestAthlete() {
		
		ArrayList<Athlete> athletes = new ArrayList<>();
		athletes.addAll(getMainRoster());
		athletes.addAll(getReserveRoster());
		int highestWins = 0;
		for (Athlete athlete : athletes) {
			int wins = athlete.getFaceOffWins();
			if (wins > highestWins) {
				highestWins = wins;
				bestAthlete = athlete;
			}
			
		}

	}
	/**
	 * Used in the EndScreen to get and display the best Athlete.
	 * @return bestAthlete the athlete with the most highest matchup wins
	 */
	public Athlete getBestAthlete( ) {
		return bestAthlete;
	}
	
	
		
	
}

