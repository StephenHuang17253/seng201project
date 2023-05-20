package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class AthleteGenerator {
	private static final String[] NAMES = {
		    "John Smith", "Alice Johnson", "Michael Williams", "Emma Jones", "David Brown", "Olivia Davis",
		    "James Miller", "Sophia Wilson", "Robert Moore", "Isabella Taylor", "Daniel Anderson", "Mia Thomas",
		    "William Jackson", "Charlotte White", "Joseph Harris", "Amelia Martin", "Henry Thompson", "Evelyn Garcia",
		    "Alexander Martinez", "Abigail Robinson", "Andrew Clark", "Harper Rodriguez", "Benjamin Lewis", "Emily Lee",
		    "Samuel Walker", "Elizabeth Hall", "Matthew Allen", "Avery Young", "Jackson King", "Sofia Wright"
		    // Add more names here as needed
		};
    private static int minStat = 1;
    private static int maxStat = 20;

    public static Athlete generateRandomAthlete() {
    	
        Random random = new Random();
        String name = getRandomName(random);
        int offence = random.nextInt(maxStat - minStat + 1) + minStat;
        int defence = random.nextInt(maxStat - minStat + 1) + minStat;
        int minContractPrice;
        int maxContractPrice;
        int statSum = offence + defence;
        
        if (statSum >= 30) {  
        	minContractPrice = 1000000;
        	maxContractPrice = 2000000;
        	
        	} else if (statSum >= 20  && statSum <= 30) {  
            	minContractPrice = 500000;
            	maxContractPrice = 900000;
        	}  
        	else{  
        		minContractPrice = 100000;
        		maxContractPrice = 500000;
        	}  
        
        int contractPrice = random.nextInt(maxContractPrice - minContractPrice + 1) + minContractPrice;

        return new Athlete(name, offence, defence, contractPrice);
    }

    private static String getRandomName(Random random) {
        int index = random.nextInt(NAMES.length);
        return NAMES[index];
    }

    public static ArrayList<Athlete> generateTeam(int teamSize) {
        ArrayList<Athlete> team = new ArrayList<>();
        ArrayList<String> takenNames = new ArrayList<>();

        while (team.size() < teamSize) {
            Athlete athlete = generateRandomAthlete();
            String name = athlete.getName();

            if (!takenNames.contains(name)) {
                team.add(athlete);
                takenNames.add(name);
            }
        }
        return team;
    }    
    
    public static void main(String[] args) {
        Athlete athlete = generateRandomAthlete();
        System.out.println(athlete);
        
        ArrayList<Athlete> team = generateTeam(5);
        for (Athlete player : team) {
            System.out.println(player);
        }
    }
}




