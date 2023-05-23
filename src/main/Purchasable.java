package main;
/**
 * The Purchasable interface describes objects which can be purchased or
 * sold from the Market. Thus objects which implement Purchasable must
 * have a name to display, a price, and a toString for representation.
 * @author Stephen Huang
 *
 */
public interface Purchasable {

	/**
	 * Purchasables must implement a getter for their name so that
	 * methods from outside such as the Market or Manager are able to
	 * get its name.
	 * @return name the Purchasable object's name.
	 */
	String getName();
	/**
	 * An object that implements Purchasable must have a price so that
	 * it can be purchased.
	 * @return int contractPrice
	 */
	int getContractPrice();
	/**
	 * An object that implements Purchasable can also be sold so it needs 
	 * a getter for its sell price.
	 * @return int sellbackPrice
	 */
	int getSellbackPrice();
	
	/**
	 * An object that implements Purchasable must hae a price so that it
	 * can be represented in the MarketScreen 
	 * @return string represention of Purchasable
	 */
	String toString();
	
	

}
