package items;

import main.Item;
/**
 * An Item that increases an Athlete's offence stat.
 * Represents the hiring of an experienced professional to train an Athlete's offensive skills.
 * @author Stephen Huang
 *
 */
public class OffensiveCoach extends Item{
	/**
	 * Constructor for OffensiveCoach
	 */
	public OffensiveCoach() {
		super("Offensive Coach", 200000, "Improve an athlete's offence stat by 2.", "Offence", 2);
		
	}

}
