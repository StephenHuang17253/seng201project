package items;

import main.Item;
/**
 * An Item that increases an Athlete's defence stat.
 * Represents specialised equipment designed to improve an Athlete's skill
 * @author Stephen Huang
 *
 */
public class DefenceTrainingEquipment extends Item{
	/**
	 * Constructor for DefenceTrainingEquipment
	 */
	public DefenceTrainingEquipment() {
		super("Defence Training Equipment", 100000, "Improve an athlete's defence stat by 1.", "Defence", 1);
	}

}