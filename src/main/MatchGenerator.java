package main;

import java.util.ArrayList;
import java.util.Random;

/**
 * The MatchGenerator class handles the random generation of Matches to be shown in the StadiumScreen.
 * The outcome of a Match itself is decided in the Match class.
 * @author Stephen Huang
 *
 */
public class MatchGenerator {
	
	/**
	 * A list of names that the generator will pick from when creating a Match.
	 */
	private static final String[] NAMES = {
		    "Karasuno Sports Club", "Shiratorizawa Academy", "Inarizaki F.C.", "Aoba Johsai F.C.", "The Stags", "The Spartans",
		    "Elevate F.C.", "Escalation Sports Club", "Team Vitality", "Golden Guardians", "Paris Saint-Germain F.C.", "Evil Geniuses",
		    "Team Liquid", "Natus Vincere", "The Eagles", "The Bulls", "The Dreams", "F.C. Renegades", "Team Bliss", "The Chiefs F.C.",
		    "Radiants F.C.", "Windrunners"

		};

	/**
	 * This method generates a single Match object.
	 * It randomly picks a name and a prize amount.
	 * @return Match object
	 */
	public static Match generateMatch() {
		Random random = new Random();
		String name = pickOpponentName(random);
    	int minPrize = 1000000;
    	int maxPrize = 4000000;
		int prize = random.nextInt(maxPrize - minPrize + 1) + minPrize;
		int points = 10;
		return new Match(name, prize, points);
	}
	/**
	 * This method generates between 3-5 Matches to create a list of Matches to return so
	 * they may be displayed in the StadiumScreen for the player to choose from.
	 * The generator generates matches until the randomly determined amount have been created.
	 * During this, the names of Matches are checked to ensure that no two Matches in the list will
	 * be the same.
	 * @return ArrayList of Match objects
	 */
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
	
	/**
	 * Called by generateMatch to assign a name from the pool of names.
	 * @param random
	 * @return the name at the index of the list
	 */
	private static String pickOpponentName(Random random) {
        int index = random.nextInt(NAMES.length);
        return NAMES[index];
    }		
	
}
