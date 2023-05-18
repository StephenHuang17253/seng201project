package main;

import java.text.DecimalFormat;

public class Item implements Purchasable {

    private int contractPrice;
    private int sellbackPrice;
    private String itemName;
    private String description;
    // Need to add stat boosts next

    public Item() {

    }

	public void purchase(String name, String description, int buyPrice, int sellPrice) {
		
		itemName = name;
		this.description = description;
		contractPrice = buyPrice;
		sellbackPrice = sellPrice;
		
	}	
	/**
	 * Simple getter for Item's contract price.
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

	public String toString() {
		DecimalFormat formatter = new DecimalFormat("#,###");
		String contractString = formatter.format(contractPrice);
		
		return itemName + ", Price: $" + contractString + ", Description: " + description;
	}

	@Override
	public void purchase(int contractPrice) {
		// TODO Auto-generated method stub
		
	}

}