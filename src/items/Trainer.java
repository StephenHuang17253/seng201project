package items;

import main.Item;
/**
 * An Item that increases an Athlete's stamina stat.
 * Represents the hiring of an experienced professional to train an Athlete's stamina.
 * @author Stephen Huang
 *
 */
public class Trainer extends Item{
	/**
	 * Constructor for Trainer
	 */
	public Trainer() {
		super("Trainer", 200000, "Improve an athlete's stamina by 2.", "Stamina", 2);
	}

}
