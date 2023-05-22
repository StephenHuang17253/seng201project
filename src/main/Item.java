package main;

import java.text.DecimalFormat;

public class Item implements Purchasable {

    private int contractPrice;
    private int sellbackPrice;
    private String itemName;
    private String description;
    private String statChanged;
    private int amount;

    public Item(String name, int buyPrice, String description, String stat, int amount) {
		itemName = name;
		setDescription(description);
		setContractPrice(buyPrice);
		sellbackPrice = buyPrice / 2;
		setStatChanged(stat);
		setChange(amount);

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
	 * Simple getter for Item's description.
	 */		
	public String getDescription() {
		return description;
	}
	/**
	 * Simple setter for Item's contract price.
	 */		
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Simple getter for which Athlete stat the item increases.
	 */
	public String getStatChanged() {
		return statChanged;
	}
	
	public void setStatChanged(String stat) {
		statChanged = (stat);
	}
	
	public int getChange() {
		return amount;
	}

	public void setChange(int amount) {
		this.amount = amount;
	}

	public String toString() {
		DecimalFormat formatter = new DecimalFormat("#,###");
		String contractString = formatter.format(contractPrice);
		
		return itemName + ", Price: $" + contractString + ", Description: " + description;
	}


}