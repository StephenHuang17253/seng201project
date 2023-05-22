package main;

import java.util.ArrayList;
import java.util.Random;


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
		    "Choi Woo-je", "Mun Hyeon-jun", "Lee Sang-hyeok", "Lee Min-heyong", "Ryu Min-seok", "Kim Hyuk-kyu",
		    "Robert Dalziel", "Yousif Abdellatif", "Ross Bacani", "Raoul Bacani", "James Li", "Steven Ye",
		    "Iason Emiliya", "Ai Hoshino", "Ruby Hoshino", "Aqua Hoshino", "Kana Arima", "Miyako Saitou",
		    "Taishi Gotanda", "Minami Kotobuki", "Frill Shiranui", "Yuki Sumi", "Akane Kurokawa", "Gabriel Korey",
		    "Jake Peralta", "Rosa Diaz", "Amy Santiago", "Gina Linetti", "Ray Holt", "Charles Boyle",
		    "Doug Judy", "Cassian Andor", "Kino Loy", "Vel Sartha", "Luthen Rael", "Bix Caleen", 
		    "Bond Forger", "Anya Forger", "Loid Forger", "Yor Forger", "Damian Desmond", "Yuri Briar",
		    "Henry Henderson", "Becky Blackbell", "Fiona Frost", "Boba Fett", "Cara Dune", "Paul Atreides",
		    "Aoi Akane", "Dalinar Kholin", "Shallan Davar", "Sylvia Sherwood", "Tanjiro Kamado", "Nezuko Kamado",
		    "Eren Jaegar", "Mikasa Ackerman", "Armin Arlert", "Levi Ackerman", "Krista Lenz", "Hange Zoe",
		    "Sasha Blouse", "Erwin Smith", "Jean Kirstein", "Connie Springer", "Ymir Fritz", "Annie Leonheart",
		    "Reiner Braun", "Bertolt Hoover", "Zeke Jaegar", "Grisha Jaegar", "Carla Jaegar", "Kenny Ackerman",
		    "Ken Kaneki", "Touka Kirishima", "Violet Evergarden", "Erica Brown", "Claudia Hodgins", "Shoya Ishida",
		    "Miki Kawai", "Shouko Nishimiya", "Fio Piccolo", "Sophie Hatter", "Chihiro Ogino", "Harry Potter",
		    "Steve Rogers", "Sherlock Holmes", "Tony Stark", "Bruce Wayne", "Clark Kent", "Thor Odinson",
		    "Peter Parker", "Loki Laufeyson", "Briar Rose", "Katniss Everdeen", "Peeta Mellark", "Gale Hawthorne",
		    "Haymitch Abernathy", "Primrose Everdeen", "Finnick Odair", "Johanna Mason", "Effie Trinket", "Annie Cresta",
		    "Blake Cooper", "Max Mayfield", "Will Byers", "Steve Harrington", "Jim Hopper", "Lara Jean",
		    "John Ambrose", "Yumeko Jabami", "Midari Ikishima", "Runa Yomozuki", "Kirari Momobami", "Mary Saotome",
		    "Ryota Suzui", "Sayaka Igarashi", "Yumemi Yumemite", "Kaede Manyuda", "Itsuki Sumeragi", "Enid Sinclair",
		    "Xavier Thorpe", "Morticia Addams", "Kohaku Nushi", "Frodo Baggins", "Meiko Honma", "Taki Tachi",
		    "Naruko Anjo", "Jinta Yadomi", "Sakura Yamauchi", "Haruki Shiga", "Mitsuha Miya", "Toono Takaki"
		    
		    
		    
		    // Add more names here as needed
		};
	private static final String[] POSITIONS = {"Striker", "Left Wing", "Right Wing", "Defender", "Keeper"};
    static ArrayList<String> takenNames = new ArrayList<>();	
    
    private static int minStat = 1;
    private static int maxStat = 20;

    public static Athlete generateRandomAthlete(int min, int max) {
    	
    	
        Random random = new Random();
        String name = getRandomName();
        int offence = random.nextInt(max - min + 1) + min;
        int defence = random.nextInt(max - min + 1) + min;
        int minContractPrice;
        int maxContractPrice;
        int statSum = offence + defence;
        
        if (statSum >= 35) {  
        	minContractPrice = 2000000;
        	maxContractPrice = 4000000;
        	
	    	} else if (statSum >= 30  && statSum <= 35) {   
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

    public static String getRandomName() {
    	Random random = new Random();
        int index = random.nextInt(NAMES.length);
        return NAMES[index];
    }

    public static String getRandomPosition() {
    	Random random = new Random();
    	int index = random.nextInt(POSITIONS.length);
    	return POSITIONS[index];
    }
    
    
    public static ArrayList<Athlete> generateTeam(int teamSize) {
        ArrayList<Athlete> team = new ArrayList<>();
        ArrayList<String> generatedNames = new ArrayList<>();
        // Don't need to permanently add to takenNames if athlete can't be purchased.
        // Only need to prevent duplicate names on opponent rosters.
		generatedNames.addAll(takenNames);    
		
		int i = 0;
		
        while (team.size() < teamSize) {
        	
            Athlete athlete = generateRandomAthlete(minStat, maxStat);
            String name = athlete.getName();

            
            if (!generatedNames.contains(name)) {
            	
            	String position = POSITIONS[i];
            	athlete.setPosition(position);
                team.add(athlete);
                generatedNames.add(name);
                i += 1;
            }
            
        }
        return team;
    }    
    

    
    /**
     * Generates a list of athletes that can be bought from the market.
     * @param amount the number of athletes
     * @return marketAthletes an array list of athletes
     */
    public static ArrayList<Athlete> generateMarketAthletes(int amount) {
        ArrayList<Athlete> marketAthletes = new ArrayList<>();
        ArrayList<String> generatedNames = new ArrayList<>();
		generatedNames.addAll(takenNames); // This way we don't use up the name if the athlete is not part of club. 
        
		
        while (marketAthletes.size() < amount) {
            Athlete athlete = generateRandomAthlete(minStat, maxStat);
            String name = athlete.getName();

            
            if (!generatedNames.contains(name)) {
            	
            	// Athletes in market or setup won't have positions because they are not on a starting lineup
            	athlete.setPosition("Unassigned"); 
                marketAthletes.add(athlete);
                generatedNames.add(name);
            }
        }
        return marketAthletes;
    }    
        
    public static void setMinStat (int amount) {
    	minStat = amount;
    }
    
    public static void setMaxStat (int amount) {
    	maxStat = amount;
    }    
    
    public static void incrementMinMaxStats() {
    	minStat += 1;
    	maxStat += 1;
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




