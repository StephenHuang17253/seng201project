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
		opponentName = name;
		prizeMoney = prize;
		pointGain = points;
	}

	public static Match generateMatch() {
		Random random = new Random();
		String name = pickOpponentName(random);
    	int minPrize = 1000000;
    	int maxPrize = 3000000;
		int prize = random.nextInt(maxPrize - minPrize + 1) + minPrize;
		int points = 10;
		return new Match(name, prize, points);
	}
	
	public static ArrayList<Match> generateWeeklyMatches() {
		Random random = new Random();
		int minMatches = 3;
		int maxMatches = 5;
		int numMatches = random.nextInt(maxMatches - minMatches + 1) + minMatches;
        ArrayList<Match> matches = new ArrayList<>();
        ArrayList<String> takenNames = new ArrayList<>();
        while (matches.size() < numMatches) {
            Match match = generateMatch();
            String name = match.getName();

            
            if (!takenNames.contains(name)) {
            	
                matches.add(match);
                takenNames.add(name);
            }
        }
        return matches;
		
	}
	

	private static String pickOpponentName(Random random) {
        int index = random.nextInt(NAMES.length);
        return NAMES[index];
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
		ArrayList<Athlete> playerTeam = manager.getMainRoster();
		ArrayList<Athlete> opponentTeam = AthleteGenerator.generateTeam(5);
		manager.setOpponentRoster(opponentTeam);
		manager.setOpponentName(match.getName());
		System.out.println(manager.getMainRoster());
		System.out.println(manager.getOpponentRoster());
		for (int i = 0; i < playerTeam.size(); i++) {
			// compare athletes
			Athlete playerAthlete = playerTeam.get(i);
			Athlete opposingAthlete = opponentTeam.get(i);
			System.out.println(playerAthlete.getName() + " (" + playerAthlete.getProficiency() + ") vs (" + opposingAthlete.getProficiency() + ") " + opposingAthlete.getName()); 
			if (playerAthlete.getProficiency() >= opposingAthlete.getProficiency()) {
				
				playerScore += 1;
				playerAthlete.setMatchUpResult("Won faceoff");
				playerAthlete.updateStamina(-1);
			} else {
				opponentScore += 1;
				playerAthlete.setMatchUpResult("Lost faceoff");
				playerAthlete.updateStamina(-2); // Stamina loss is higher on defeat
				
			}
			
		}
		
		if (playerScore > opponentScore) {
			//manager.changeMoney(match.getPrizeMoney());
			//return "Victory";
			match.setOutcome("Victory");
			manager.setMatchOutcome(outcome);
			manager.updateSeasonPoints(pointGain);
			manager.changeMoney(prizeMoney);
			
		} else if (playerScore == opponentScore) {
			//return "Draw";
			match.setOutcome("Draw");
			manager.setMatchOutcome(outcome);
			
		}
		else {
			match.setOutcome("Defeat");
			manager.setMatchOutcome(outcome);
			//return "Defeat";
		}
	
	}	
	
	public String toString() {
		return " Play against " + opponentName + "  |  Reward: $" + createPrizeString(prizeMoney) + " & " + pointGain + " points.";
	}
	

	
}
