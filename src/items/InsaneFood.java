package items;

import main.Item;
/**
 * An Item that increases an Athlete's stamina stat.
 * Represents very expensive and nutritious meals purchased for the Athlete.
 * @author Stephen Huang
 *
 */
public class InsaneFood extends Item{
	/**
	 * Constructor for InsaneFood
	 */
	public InsaneFood() {
		super("Curated Diet Plan", 75000, "Unbelievably expensive food. Increases stamina by 1.", "Stamina", 1);
	}

}
