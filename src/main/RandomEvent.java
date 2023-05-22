package main;

import java.util.ArrayList;
import java.util.Random;

public class RandomEvent {
	private String event;
	private Athlete athlete;
	private String message;
	
	public RandomEvent(String event, Athlete athlete, String message) {
        this.event = event;
        this.athlete = athlete;
        this.message = message;
	}
	
	public static RandomEvent generateRandomEvent(GameManager manager, int chance) {
		
		RandomEvent eventGenerated = null;
		String eventType = null;
		Random random = new Random();
		
		ArrayList<Athlete> reserves = manager.getReserveRoster();
		ArrayList<Athlete> mainRoster = manager.getMainRoster();
		ArrayList<Athlete> allAthletes = new ArrayList<>();
		allAthletes.addAll(mainRoster);
		allAthletes.addAll(reserves);
		
		switch (chance) {
		case 0:
			// Random starter stat boost
			if (mainRoster.size() > 0) {
				Athlete athlete = mainRoster.get(random.nextInt(mainRoster.size()));
				athlete.changeOffence(random.nextInt(1, 11));
				athlete.changeDefence(random.nextInt(1, 11));
				athlete.changeHealth(random.nextInt(1, 11));
				athlete.changeMaxStamina(random.nextInt(1, 11));
				System.out.println(athlete.getName() + "has been showing incredible results in practice matches! His stats have improved.");
				String message = (athlete.getName() + "has been showing incredible results in practice matches! His stats have improved.");
				eventType = "Starter Boost";
				eventGenerated = new RandomEvent(eventType, athlete, message);
				break;				
			}

	
		case 1:
			// Random reserve stat boost
			if (reserves.size() > 0) {
				Athlete athlete = mainRoster.get(random.nextInt(mainRoster.size()));
				athlete.changeOffence(random.nextInt(1, 11));
				athlete.changeDefence(random.nextInt(1, 11));
				athlete.changeHealth(random.nextInt(1, 11));
				athlete.changeMaxStamina(random.nextInt(1, 11));
				System.out.println(athlete.getName() + " has been showing incredible results in practice matches! His stats have improved.");
				String message = athlete.getName() + " has been showing incredible results in practice matches! His stats have improved.";
				eventType = "Starter Boost";
				eventGenerated = new RandomEvent(eventType, athlete, message);
			}
			break;
	
		case 2:
			// Athlete quits
			for (Athlete athlete : reserves) {
				if (random.nextInt(5) * (athlete.getFaceOffLosses() / 2) >= 55) {
					manager.getReserveRoster().remove(athlete);
					System.out.println(athlete.getName() + " has decided to retire after repeated poor performances.");
					String message = athlete.getName() + " has decided to retire after repeated poor performances.";
					eventType = "Athlete Quit";
					eventGenerated = new RandomEvent(eventType, athlete, message);
					break;
				}
			}
			break;
	
		case 3:
			// New Athlete joins
			int probability = random.nextInt(50);
			if (reserves.size() < 5) {
				Athlete newAthlete = AthleteGenerator.generateRandomAthlete();
				manager.getReserveRoster().add(newAthlete);
				System.out.println("An up and coming talent has joined your team!");
				String message = "An up and coming talent has joined your team!\n" + newAthlete.getName() + " has been added to reserves.";
				eventType = "Athlete Joins";
				eventGenerated = new RandomEvent(eventType, newAthlete, message);
			}
			
			break;
	
		}
		
		return eventGenerated;		
	}
	
    public String getType() {
        return event;
    }

    public Athlete getAthlete() {
        return athlete;
    }
    
    public String getMessage() {
        return message;
    }
 
    
}
	
