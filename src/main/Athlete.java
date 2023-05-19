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
	private String position;
	/**
	 * The Athlete's rating.
	 * Used to allow players to quickly gauge an athlete's offence/defence stats.
	 * S tier = 9-10 stats
	 * A tier = 7-8 stats
	 * B tier = 5-6 stats
	 * C tier = 3-4 stats
	 * D tier = 1-2 stats
	 * The ranges were determined like this to allow disparity within tiers.
	 * And to make athletes more unique.
	 */
	private String rating;
	/**
	 * The Athelete's health stat.
	 */		
	private int health;
	/**
	 * The Athelete's stamina stat.
	 */			
	private int stamina;
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
	
	

	/**
	 * Constructor for Athlete
	 */		
	public Athlete(String name, String rating, int health, int stamina, int offence, int defence, int contractPrice) {
		this.name = name;
		this.rating = rating;
		this.health = health;
		this.stamina = stamina;
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
	 * Simple getter for Athlete's name.
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
	 * Simple getter for Athlete's position.
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
	 * Simple getter for Athlete's stamina.
	 */			
	public int getStamina() {
		return stamina;
	}
	/**
	 * Simple setter for Athlete's stamina.
	 */		
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	/**
	 * Simple getter for Athlete's offence.
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
		
		return name + ", Tier: " + rating + ", Health: " + health + ", Stamina: " + stamina
				+ ", Offence: " + offence + ", Defence: " + defence + ", Contract: $" + priceString;
		
		//return name + ", " + rating + ", " + health + "-hp, " + stamina + "-stam, "
				 //+ offence + "-off, " + defence + "-def, $" + priceString;	
	}
	
	public String getShortString() {
		return name + ", " + rating + ", $" + contractPrice;
	}
	 
	/**
	 * Simple getter for Athlete's contract price.
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
	
	
	public static void main(String[] args) {
	}




}
