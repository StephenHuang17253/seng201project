package items;

import main.Item;
/**
 * An Item that increases an Athlete's offence stat.
 * Represents specialised equipment designed to improve an Athlete's offensive capability.
 * @author Stephen Huang
 *
 */
public class OffenceTrainingEquipment extends Item{
	/**
	 * Constructor for OffenceTrainingEquipment
	 */
	public OffenceTrainingEquipment() {
		super("Offensive Training Equipment", 100000, "Improve an athlete's offence stat by 1.", "Offence", 1);
	}

}