package items;

import main.Item;
/**
 * An Item that increases an Athlete's health stat.
 * Represents the hiring of a professional to improve an Athlete's health.
 * @author Stephen Huang
 *
 */
public class Nutritionist extends Item{
	/**
	 * Constructor for Nutritionist
	 */
	public Nutritionist() {
		super("Nutritionist", 75000, "Improve an athlete's health stat by 1.", "Health", 1);
	}

}
