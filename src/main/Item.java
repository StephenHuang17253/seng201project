package main;

public class Item implements Purchasable {

    private int contractPrice;
    private int sellbackPrice;
    private String description;
    // Need to add stat boosts next

    public Item() {

    }

	public void purchase(int contractPrice, int sellbackPrice, String description) {
		this.setContractPrice(contractPrice);
		this.setSellbackPrice(sellbackPrice);
		this.setDescription(description);
		
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



}