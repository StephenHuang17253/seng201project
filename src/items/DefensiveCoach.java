package items;

import main.Item;
/**
 * An Item that increases an Athlete's defence stat.
 * Represents the hiring of a Coach who works to improve an Athlete's skill
 * @author Stephen Huang
 *
 */
public class DefensiveCoach extends Item{
	/**
	 * Constructor for a DefensiveCoach
	 */
	public DefensiveCoach() {
		super("Defensive Coach", 200000, "Improve an athlete's defence stat by 2.", "Defence", 2);
	}

}
