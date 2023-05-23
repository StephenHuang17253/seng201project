package main;

import java.text.DecimalFormat;
/**
 * The Item class reprents the Purchasables at the Market which are not Athletes.
 * Items can be used to increase the stats of an Athlete. Items implements Purchasable
 * because Items can be bought and sold in the MarketScreen.
 * @author Stephen Huang
 * @author Jasmine Ong
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
     * @param name the Item's name
     * @param contractPrice the Item's price
     * @param description the Item's description
     * @param statToChange the stat the Item changes
     * @param changeAmount the amount the Item changes a stat
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
     * @return itemName string
     */
	public String getName() {
		return itemName;
	}
	
	/**
	 * Changes the Item's name to the given string
	 * @param name string
	 */
	public void setName(String name) {
		itemName = name;
	}
    
	/**
	 * Return contract price of Item.
	 * @return contractPrice int
	 */		
	public int getContractPrice() {
		return contractPrice;
	}
	/**
	 * Simple setter for Item's contract price.
	 * @param contractPrice int
	 */		
	public void setContractPrice(int contractPrice) {
		this.contractPrice = contractPrice;
	}
	/**
	 * Simple getter for Item's sell price.
	 * @return sellbackPrice int
	 */		
	public int getSellbackPrice() {
		return sellbackPrice;
	}
	/**
	 * Simple setter for Item's contract price.
	 * @param sellbackPrice int
	 */		
	public void setSellbackPrice(int sellbackPrice) {
		this.sellbackPrice = sellbackPrice;
	}
	/**
	 * Simple getter for an Item's description.
	 * @return description string
	 */		
	public String getDescription() {
		return description;
	}
	/**
	 * Simple setter for an Item's description.
	 * @param description string
	 */		
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Returns which Athlete stat the item can increase.
	 * @return statToChange string
	 */
	public String getStatToChange() {
		return statToChange;
	}
	/**
	 * Set the Athlete stat that the Item will change.
	 * @param stat string
	 */
	public void setStatToChange(String stat) {
		statToChange = (stat);
	}
	/**
	 * Get the amount to change the statistic by
	 * @return changeAmount int
	 */
	public int getChange() {
		return changeAmount;
	}
	/**
	 * Set the amount to change the statistic by
	 * @param amount int
	 */
	public void setChange(int amount) {
		this.changeAmount = amount;
	}

	/**
	 * String representation of an Item, used in the MarketScreen.
	 * @return string representation of an Item
	 */
	public String toString() {
		DecimalFormat formatter = new DecimalFormat("#,###");
		String contractString = formatter.format(contractPrice);
		
		return itemName + ", Price: $" + contractString + ", Description: " + description;
	}


}