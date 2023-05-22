package main;

import java.text.DecimalFormat;
/**
 * The Item class reprents the Purchasables at the Market which are not Athletes.
 * Items can be used to increase the stats of an Athlete. Items implements Purchasable
 * because Items can be bought and sold in the MarketScreen.
 * @author Stephen Huang
 * @Author Jasmine Ong
 */
public class Item implements Purchasable {
	/**
	 * The price of an Item. This will be deducted from the player's money upon purchase.
	 */
    private int contractPrice;
    /** 
	 * The sell back price of Item. This will be added to the player's money upon sale.
     * It is calculated to be half of the Item's initial contract price.
     */
    private int sellbackPrice;
    /**
     * The name of the Item.
     */
    private String itemName;
    /**
     * The Item's description, briefly describes its purpose and indicates
     * which Athlete stat it can increase.
     */
    private String description;
    /**
     * The Athlete stat an Item will change.
     */
    private String statToChange;
    /**
     * The amount that an Item will change an Athlete's stat by.
     */
    private int changeAmount;

    /**
     * Constructs an Item with the specified parameters.
     * @param name
     * @param contractPrice
     * @param description
     * @param statToChange
     * @param changeAmount
     */
    public Item(String name, int contractPrice, String description, String statToChange, int changeAmount) {
		itemName = name;
		setDescription(description);
		setContractPrice(contractPrice);
		sellbackPrice = contractPrice / 2;
		setStatToChange(statToChange);
		setChange(changeAmount);

    }
    
    /**
     * Return name of item.
     */
	public String getName() {
		return itemName;
	}
	
	/**
	 * Changes the Item's name to the given string
	 * @param name
	 */
	public void setName(String name) {
		itemName = name;
	}
    
	/**
	 * Return contract price of Item.
	 */		
	public int getContractPrice() {
		return contractPrice;
	}
	/**
	 * Simple setter for Item's contract price.
	 */		
	public void setContractPrice(int contractPrice) {
		this.contractPrice = contractPrice;
	}
	/**
	 * Simple getter for Item's sell price.
	 */		
	public int getSellbackPrice() {
		return sellbackPrice;
	}
	/**
	 * Simple setter for Item's contract price.
	 */		
	public void setSellbackPrice(int sellbackPrice) {
		this.sellbackPrice = sellbackPrice;
	}
	/**
	 * Simple getter for an Item's description.
	 */		
	public String getDescription() {
		return description;
	}
	/**
	 * Simple setter for an Item's description.
	 */		
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Returns which Athlete stat the item can increase.
	 */
	public String getStatToChange() {
		return statToChange;
	}
	/**
	 * Set the Athlete stat that the Item will change.
	 * @param stat
	 */
	public void setStatToChange(String stat) {
		statToChange = (stat);
	}
	/**
	 * Get the amount to change the statistic by
	 * @return
	 */
	public int getChange() {
		return changeAmount;
	}
	/**
	 * Set the amount to change the statistic by
	 * @param amount
	 */
	public void setChange(int amount) {
		this.changeAmount = amount;
	}

	/**
	 * String representation of an Item, used in the MarketScreen.
	 */
	public String toString() {
		DecimalFormat formatter = new DecimalFormat("#,###");
		String contractString = formatter.format(contractPrice);
		
		return itemName + ", Price: $" + contractString + ", Description: " + description;
	}


}