package main;

import java.text.DecimalFormat;

/**
 * The Athlete class represents a Futsal player in the game.
 * It implements the Purchasable interface because Athletes can be bought and sold on the market.
 * @author Stephen Huang
 */
public class Athlete implements Purchasable{


	/**
	 * The Athlete's name.
	 */	
	private String name;
	/**
	 * The Athlete's proficiency is the combination of an athlete's offence and defence.
	 * It represents an Athlete's overall skill and capability in a match.
	 * This is used in match calculations.
	 */	
	private int proficiency;
	/**
	 * The Athlete's proficiency is the combination of an athlete's offence and defence.
	 * It represents an Athlete's overall skill and capability in a match.
	 * This is used in match calculations.
	 */
	/**
	 * The Athlete's position on the team.
	 * Represents the role they play on the starting lineup
	 * such as "Striker" or "Defender."
	 */	
	private String position;
	/**
	 * The Athlete's health stat.
	 */		
	private int health;
	/**
	 * The Athlete's current stamina stat.
	 */			
	private int stamina;
	/**
	 * The Athlete's maximum stamina stat.
	 */
	private int maxStamina;
	/**
	 * The Athlete's offence stat.
	 * Along with defence, it is used to determine an Athlete's capability in a match.
	 */			
	private int offence;
	/**
	 * The Athlete's defence stat.
	 * Along with offence, it is used to determine an Athlete's capabiltiy in a match.
	 */		
	private int defence;
	/**
	 * The Athlete's contract price.
	 * How much it costs to purchase the Athlete.
	 */		
	private int contractPrice;
	/**
	 * The Athlete's sell back price.
	 * How muc his gained from selling the Athlete.
	 */		
	private int sellbackPrice;
	/**
	 * The Athlete's description.
	 */	
	private String description;
	/**
	 * During matches, Athletes of the same position on either team will be compared
	 * to determine the winner of a 'faceoff' or 'matchup'. 
	 * This field stores the result of it. The team who wins more faceoffs wins the match.
	 */
	private String faceOffResult;
	/**
	 * The total number of faceoffs they have won.
	 * This is recorded to later determine a team's best Athlete.
	 */
	private int faceOffWins;
	/**
	 * The total number of faceoffs they have lost.
	 * Repeated losses increases a player's chance of retirement.
	 */
	private int faceOffLosses;
	
	

	/**
	 * Constructor for Athlete
	 */		
	public Athlete(String name, int offence, int defence, int contractPrice) {
		setName(name);
		setHealth(10); // Default health = 10
		setMaxStamina(10); // Default stamina = 10
		setStamina(maxStamina);
		setOffence(offence);
		setDefence(defence);
		setContractPrice(contractPrice);
		setSellbackPrice(contractPrice / 2);
		setDescription("A professional Futsal player. ");
		getProficiency();
		setPosition("Unassigned");
		//setPosition(AthleteGenerator.getRandomPosition());

	}
	

	/**
	 * Returns the Athlete's name.
	 * @return a string of the Athlete's name
	 */		
	public String getName() {
		return name;
	}
	/**
	 * Simple setter for Athlete's name.
	 */		
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns Athlete proficiency. Since Athlete stats can change often throughout the game.
	 * this method calculates it each time to ensure it is accurate. This is important because this stat
	 * will be used in match determination.
	 * @return proficiency
	 */
	public int getProficiency() {
		int offence = getOffence();
		int defence = getDefence();
		proficiency = offence + defence;
		return proficiency;
	}
		
	/**
	 * Simple getter for Athlete's position.
	 * @return string position
	 */		
	public String getPosition() {
		return position;
	}

	/**
	 * Simple setter for Athlete's position.
	 */	
	public void setPosition(String position) {
		this.position = position;
	}


	/**
	 * Simple getter for Athlete's health.
	 * @return int health
	 */		
	public int getHealth() {
		return health;
	}
	/**
	 * Simple setter for Athlete's health.
	 */		
	public void setHealth(int health) {
		this.health = health;
	}
	/**
	 * Changes an Athlete's health by the given amount.
	 */
	public void changeHealth(int amount) {
		this.health += amount;
	}
	/**
	 * Simple getter for Athlete's current stamina.
	 * @return int stamina
	 */			
	public int getStamina() {
		return stamina;
	}
	/**
	 * Simple setter for Athlete's current stamina.
	 */
	public void setStamina(int amount) {
		stamina = amount;
	}
	/**
	 * Changes current stamina by a given amount.
	 * If stamina goes lower than zero, set to zero.
	 */		
	public void changeStamina(int amount) {
		this.stamina += amount;
		if (stamina <= 0) {
			setStamina(0);
		}
	}
	/**
	 * Simple getter for Athlete's maximum stamina.
	 * @return int MaxStamina.
	 */
	public int getMaxStamina() {
		return maxStamina;
	}
	/**
	 * Simple setter for Athlete's maximum stamina
	 * @param int i
	 */
	public void setMaxStamina(int i) {
		maxStamina = i;
	}
	/**
	 * Updates Athlete's maximum stamina by amount
	 * @param int amount
	 */
	public void changeMaxStamina(int amount) {
		maxStamina += amount;
	}
	/**
	 * Simple getter for Athlete's offence.
	 * @return int offence
	 */			
	public int getOffence() {
		return offence;
	}
	/**
	 * Simple setter for Athlete's offence.
	 */		
	public void setOffence(int offence) {
		this.offence = offence;
	}
	/**
	 * Changes offence by a given amount.
	 * @param int amount 
	 */
	public void changeOffence(int amount) {
		this.offence += amount;
	}
	
	/**
	 * Simple getter for Athlete's defence.
	 * @return int defence
	 */	
	public int getDefence() {
		return defence;
	}
	/**
	 * Simple setter for Athlete's defence.
	 */	
	public void setDefence(int defence) {
		this.defence = defence;
	} 
	/**
	 * Changes defence by a given amount.
	 * @param int amount 
	 */
	public void changeDefence(int amount) {
		this.defence += amount;
	}	
	
	/**
	 * Athlete's toString, handles printing Athletes.
	 */	
	public String toString() {
		DecimalFormat formatter = new DecimalFormat("#,###");
		String priceString = formatter.format(contractPrice);
		
		return name + ", " + position + " (" + getProficiency() + ")" + ", Offence: " + offence + ", Defence: " + defence
				+ ", Health: " + health + ", Stamina: " + stamina + ", Contract: $" + priceString;
	}
	
	/**
	 * Simple getter for Athlete's contract price.
	 * @return int contractPrice
	 */		
	public int getContractPrice() {
		return contractPrice;
	}
	/**
	 * Simple setter for Athlete's contract price.
	 */		
	public void setContractPrice(int contractPrice) {
		this.contractPrice = contractPrice;
	}
	/**
	 * Simple getter for Athlete's sell price.
	 * The sellback price is half of the purchase price.
	 * @return int sellbackPrice
	 */		
	public int getSellbackPrice() {
		return sellbackPrice;
	}
	/**
	 * Simple setter for Athlete's contract price.
	 */		
	public void setSellbackPrice(int sellbackPrice) {
		this.sellbackPrice = sellbackPrice;
	}
	/**
	 * Simple getter for Athlete's description.
	 * @return string description
	 */		
	public String getDescription() {
		return description;
	}
	/**
	 * Simple setter for Athlete's description.
	 */		
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Gets the result of their last matchup/faceoff.
	 * Called in other classes to check if the Athlete won.
	 * @return faceOffResult string
	 */
	public String getMatchUpResult() {
		return faceOffResult;
	}
	/**
	 * When a match is calculated this method is used to set the Athlete's faceoff result.
	 * @param result String
	 */
	public void setMatchUpResult(String result) {
		this.faceOffResult = result;
	}
	/**
	 * Returns an Athlete's total number of faceoff wins.
	 * @return faceOffWins int
	 */
	public int getFaceOffWins() {
		return faceOffWins;
	}
	/**
	 * Sets an Athlete's total number of faceoff wins equal to the specified amount.
	 * @param faceOffWins
	 */
	public void setFaceOffWins(int faceOffWins) {
		this.faceOffWins = faceOffWins;
	}	
	/**
	 * Increases the number of faceoff wins by 1.
	 * Called when an Athlete wins their position matchup in a Match calculation.
	 */
	public void incrementWins() {
		faceOffWins += 1;
	}	
	
	/**
	 * Return the number of faceoff losses.
	 * Called in a RandomEvent calculation to influence the chance an athlete retires.
	 * An Athlete who loses a lot has a chance of retiring.
	 * @return 
	 */
	public int getFaceOffLosses() {
		return faceOffLosses;
	}
	/**
	 * Set the Athlete's number of faceoff losses
	 * @param faceOffLosses
	 */
	public void setFaceOffLosses(int faceOffLosses) {
		this.faceOffLosses = faceOffLosses;
	}	
	
	/**
	 * Increases Athlete's the amount of faceoff losses by one.
	 * Called when they lose their matchup during a game.
	 */
	public void incrementLosses() {
		faceOffLosses += 1;
	}	
	
	public static void main(String[] args) {
	}









}
