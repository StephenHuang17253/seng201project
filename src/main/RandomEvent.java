package main;

import java.util.ArrayList;
import java.util.Random;

/**
 * The RandomEvent class represents, generates and handles a RandomEvent.
 * When the player takes a bye to progress to the next week, there is a random chance of
 * a RandomEvent occuring. The outcome of that event is determined by this class.
 * @author Stephen Huang
 *
 */
public class RandomEvent {
	/**
	 * The event which occured, for example "Athlete quits" or "Random starter got a stat boost"
	 */
	private String event;
	/**
	 * The specific Athlete affected by the event.
	 */
	private Athlete athlete;
	/**
	 * The message that goes along with the event, to be passed to a Dialogbox in UI so
	 * that the player may be informed of what occured.
	 */
	private String message;
	
	/**
	 * The RandomEvent constructor creates a RandomEvent with the specified parameters.
	 * @param event the event which occured, for example "Athlete quits."
	 * @param athlete the specific Athlete affected by the event.
	 * @param message the message that goes along with the event, to inform player.
	 */
	public RandomEvent(String event, Athlete athlete, String message) {
        this.event = event;
        this.athlete = athlete;
        this.message = message;
	}
	/**
	 * This method generates a RandomEvent after taking information from the GameManager
	 * and a probability.
	 * @param manager the GameManager
	 * @param chance a probabiltiy to use
	 * @return
	 */
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
			int startBoostChance = random.nextInt(100);
			if (mainRoster.size() > 0 && startBoostChance < 10) {
				Athlete athlete = mainRoster.get(random.nextInt(mainRoster.size()));
				athlete.changeOffence(random.nextInt(1, 11));
				athlete.changeDefence(random.nextInt(1, 11));
				athlete.changeHealth(random.nextInt(1, 11));
				athlete.changeMaxStamina(random.nextInt(1, 11));
				System.out.println(athlete.getName() + "has been showing incredible results in practice matches! Their stats have improved.");
				String message = (athlete.getName() + "has been showing incredible results in practice matches! Their stats have improved.");
				eventType = "Starter Boost";
				eventGenerated = new RandomEvent(eventType, athlete, message);
				break;				
			}

	
		case 1:
			// Random reserve stat boost
			int reserveBoostChance = random.nextInt(100); 
			if (reserves.size() > 0 && reserveBoostChance < 15) {
				Athlete athlete = mainRoster.get(random.nextInt(mainRoster.size()));
				athlete.changeOffence(random.nextInt(1, 11));
				athlete.changeDefence(random.nextInt(1, 11));
				athlete.changeHealth(random.nextInt(1, 11));
				athlete.changeMaxStamina(random.nextInt(1, 11));
				System.out.println(athlete.getName() + " has been showing incredible results in practice matches! Their stats have improved.");
				String message = athlete.getName() + " has been showing incredible results in practice matches! Their stats have improved.";
				eventType = "Starter Boost";
				eventGenerated = new RandomEvent(eventType, athlete, message);
			}
			break;
	
		case 2:
			// Athlete quits
			for (Athlete athlete : reserves) {
				if (random.nextInt(100) + (athlete.getFaceOffLosses() / 2) >= 125) {
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
			int randomJoinChance = random.nextInt(100);
			if (reserves.size() < 5 && randomJoinChance < 8) {
				Athlete newAthlete = AthleteGenerator.generateRandomAthlete(15, 30);
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
	
	/**
	 * Get the type of the event so we know what happened
	 * @return event string of what occured
	 */
    public String getType() {
        return event;
    }
    /**
     * Get the athlete that was affected
     * @return athlete Athlete that was affected
     */
    public Athlete getAthlete() {
        return athlete;
    }
    /**
     * Get the related message so we can inform the player of what occured.
     * @return message string informing what happened
     */
    public String getMessage() {
        return message;
    }
 
    
}
	
