package main;

import java.util.ArrayList;
import java.util.Random;


public class MatchGenerator {
	
	private static final String[] NAMES = {
		    "Karasuno Sports Club", "Shiratorizawa Academy", "Inarizaki F.C.", "Aoba Johsai F.C.", "The Stags", "The Spartans",
		    "Elevate F.C.", "Escalation Sports Club", "Team Vitality", "Golden Guardians", "Paris Saint-Germain F.C.", "Evil Geniuses",
		    "Team Liquid", "Natus Vincere", "The Eagles", "The Bulls", "The Dreams", "F.C. Renegades", "Team Bliss", "The Chiefs F.C.",
		    "Radiants F.C.", "Windrunners"
		    // Add more teams here as needed
		};

	public static Match generateMatch() {
		Random random = new Random();
		String name = pickOpponentName(random);
    	int minPrize = 1000000;
    	int maxPrize = 4000000;
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
	
}
