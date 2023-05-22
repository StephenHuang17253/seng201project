package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import main.AthleteGenerator;
import java.util.Random;

public class Match {

	private String opponentName;
	private int playerScore;
	private int opponentScore;
	private int prizeMoney;
	private int pointGain;
	private String outcome;
	private GameManager manager;
	private static final String[] NAMES = {
		    "Karasuno Sports Club", "Shiratorizawa Academy", "Inarizaki F.C.", "Aoba Johsai F.C.", "The Stags", "The Spartans",
		    "Elevate F.C.", "Escalation Sports Club", "Team Vitality", "Golden Guardians", "Paris Saint-Germain F.C.", "Evil Geniuses",
		    "Team Liquid", "Natus Vincere", "The Eagles", "The Bulls", "The Dreams", "F.C. Renegades", "Team Bliss", "The Chiefs F.C.",
		    "Radiants F.C.", "Windrunners"
		    // Add more teams here as needed
		};
	
	
	public Match(String name, int prize, int points) {
		setName(name);
		setPrizeMoney(prize);
		setPointGain(points);
	}
	
	public String getName() {
		return opponentName;
	}
	
	private void setName(String name) {
		opponentName = name;
	}
	
	public int getPlayerScore() {
		return playerScore;
	}
	
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	
	public int getOpponentScore() {
		return opponentScore;
	}
	
	public void setOpponentScore(int opponentScore) {
		this.opponentScore = opponentScore;
	}
	
	public int getPrizeMoney() {
		return prizeMoney;
	}
	
	public void setPrizeMoney(int prizeMoney) {
		this.prizeMoney = prizeMoney;
	}
	
	public String createPrizeString(int amount) {
		DecimalFormat formatter = new DecimalFormat("#,###"); 
		return formatter.format(amount);		
	}	
	
	public int getPointGain() {
		return pointGain;
	}
	
	public void setPointGain(int pointGain) {
		this.pointGain = pointGain;
	}
	
	public String getOutcome() {
		return outcome;
	}
	
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	
	public void runMatch(GameManager incomingManager, Match match) {
		manager = incomingManager;
		manager.checkAthletePositions();
		ArrayList<Athlete> playerTeam = manager.getMainRoster();
		ArrayList<Athlete> opponentTeam = AthleteGenerator.generateTeam(5);
		manager.setOpponentRoster(opponentTeam);
		manager.setOpponentName(match.getName());
		//System.out.println(manager.getMainRoster());
		//System.out.println(manager.getOpponentRoster());
		boolean noStamina = true; // Track if all player's athletes have 0 stamina
		
		
		
		
		for (int i = 0; i < playerTeam.size(); i++) {
			// compare athletes
			String[] positions = {"Striker", "Left Wing", "Right Wing", "Defender", "Keeper"};
			
			Athlete playerAthlete = manager.getPlayerInPosition(positions[i]);
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
	        manager.totalMoneyEarned(prizeMoney);
	        manager.totalGamesWon();
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
