package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import main.Athlete;

public class AthleteGenerator {
	private static final String[] NAMES = {
		    "John Smith", "Alice Johnson", "Michael Williams", "Emma Jones", "David Brown", "Olivia Davis",
		    "James Miller", "Sophia Wilson", "Robert Moore", "Isabella Taylor", "Daniel Anderson", "Mia Thomas",
		    "William Jackson", "Charlotte White", "Joseph Harris", "Amelia Martin", "Henry Thompson", "Evelyn Garcia",
		    "Alexander Martinez", "Abigail Robinson", "Andrew Clark", "Harper Rodriguez", "Benjamin Lewis", "Emily Lee",
		    "Samuel Walker", "Elizabeth Hall", "Matthew Allen", "Avery Young", "Jackson King", "Sofia Wright", "Jasmine Ong",
		    "Yu Nishinoya", "Asahi Azumane", "Hisashi Kinoshita", "Tobio Kageyama", "Shoyo Hinata", "Kei Tsukishima",
		    "Wakatoshi Ushijima", "Toru Oikawa", "Shinsuke Kita", "Hitoshi Ginjima", "Atsumu Miya", "Osamu Miya",
		    "Martin Larssen", "Yiliang Peng", "Rasmus Winther", "Mihael Mehle", "Sergen Celik", "Chen Ze-Bin",
		    "Peng Li-Xun", "Zeng Qi", "Zhao Jia-Hao", "Luo Wen-Jun", "Stephen Huang", "Park Jae-hyuk", 
		    "Choi Woo-je", "Mun Hyeon-jun", "Lee Sang-hyeok", "Lee Min-heyong", "Ryu Min-seok", "Kim Hyuk-kyu"
		    
		    // Add more names here as needed
		};
    static ArrayList<String> takenNames = new ArrayList<>();	
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
        String[] positions = { "Striker", "Left Wing", "Right Wing", "Defender", "Keeper" }; 
        ArrayList<String> generatedNames = takenNames; // This way we don't use up the name if the athlete is not drafted. 
		int i = 0;
		
        while (team.size() < teamSize) {
            Athlete athlete = generateRandomAthlete();
            String name = athlete.getName();

            
            if (!generatedNames.contains(name)) {
            	
            	String position = positions[i];
            	athlete.setPosition(position);
                team.add(athlete);
                generatedNames.add(name);
                i += 1;
            }
        }
        return team;
    }    
    
    public static void main(String[] args) {
        //Athlete athlete = generateRandomAthlete();
        //System.out.println(athlete);
        ArrayList<Athlete> team = generateTeam(5);
        for (Athlete player : team) {
        	
            System.out.println(player.getPosition() + ": " + player);
            
        }
    }
}




