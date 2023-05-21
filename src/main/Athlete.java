package main;

import java.text.DecimalFormat;

/**
 * The Athlete class
 * handles the athletes in our game.
 */
public class Athlete implements Purchasable{


	/**
	 * The Athlete's name.
	 */	
	private String name;
	/**
	 * The Athelete's position on the team.
	 */		
	private int proficiency;
	/**
	 * The Athlete's proficiency is the average of an athlete's offence and defence.
	 * This is used in match calculations.
	 */
	private String position = "unassigned";
	/**
	 * The Athelete's health stat.
	 */		
	private int health;
	/**
	 * The Athelete's current stamina stat.
	 */			
	private int stamina;
	/**
	 * The athlete's maximum stamina stat.
	 */
	private int maxStamina;
	/**
	 * The Athelete's offence stat.
	 */			
	private int offence;
	/**
	 * The Athelete's defence stat.
	 */		
	private int defence;
	/**
	 * The Athelete's contract price.
	 */		
	private int contractPrice;
	/**
	 * The Athelete's sell back price.
	 */		
	private int sellbackPrice;
	/**
	 * The Athelete's description.
	 */	
	private String description;
	
	private String faceoffResult;
	
	

	/**
	 * Constructor for Athlete
	 */		
	public Athlete(String name, int offence, int defence, int contractPrice) {
		this.name = name;
		this.proficiency = (offence + defence);
		this.health = 10; // Default health
		this.maxStamina = 10; // Default stamina
		this.stamina = maxStamina;
		this.offence = offence;
		this.defence = defence;
		this.contractPrice = contractPrice;
		

	}


	/**
	 * Purchase method for Athlete.
	 * Doesn't do anything right now.
	 */		
	public void purchase(int contractPrice, int sellbackPrice, String description) {
		this.setContractPrice(contractPrice);
		this.setSellbackPrice(sellbackPrice);
		this.setDescription(description);
		
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
	 * Simple getter for Athlete proficiency
	 * Will be used to determine faceoff winner in matches.
	 * @return proficiency
	 */
	public int getProficiency() {
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
	 * Simple setter for Athlete's name.
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
	 * Simple incrementer for Athlete's current stamina.
	 */		
	public void updateStamina(int amount) {
		this.stamina += amount;
	}
	/**
	 * Simple getter for Athlete's maximum stamina.
	 * @return int MaxStamina.
	 */
	public int getMaxStamina() {
		return maxStamina;
	}
	/**
	 * Updates Athlete's maximum stamina by amount
	 * @param int amount
	 */
	public void updateMaxStamina(int amount) {
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
	 * Athlete's toString, handles printing Athletes.
	 */	
	public String toString() {
		DecimalFormat formatter = new DecimalFormat("#,###");
		String priceString = formatter.format(contractPrice);
		
		return name + ", Proficiency: " + proficiency + ", Health: " + health + ", Stamina: " + stamina
				+ ", Offence: " + offence + ", Defence: " + defence + ", Contract: $" + priceString;
		
		//return name + ", " + position + ", " + "Proficiency: " + proficiency + ", Health: " + health + ", Stamina: " + stamina
		//		+ ", Offence: " + offence + ", Defence: " + defence + ", Contract: $" + priceString;
	}
	
	public String getShortString() {
		return name + ", " + proficiency + ", $" + contractPrice;
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
	 * Simple setter for Athlete's contract price.
	 */		
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getMatchUpResult() {
		return faceoffResult;
	}
	
	public void setMatchUpResult(String result) {
		this.faceoffResult = result;
	}
	
	public static void main(String[] args) {
	}




}
