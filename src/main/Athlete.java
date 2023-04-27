package main;

public class Athlete implements Purchasable{

	private String name;
	private int health;
	private int stamina;
	private int offence;
	private int defence;
	private int contractPrice;
	private int sellbackPrice;
	private String description;
	
	
	public Athlete(String name, int health, int stamina, int offence, int defence) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.health = health;
		this.stamina = stamina;
		this.offence = offence;
		this.defence = defence;
	}

	public void purchase(int contractPrice, int sellbackPrice, String description) {
		this.setContractPrice(contractPrice);
		this.setSellbackPrice(sellbackPrice);
		this.setDescription(description);
		
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
	public int getOffence() {
		return offence;
	}

	public void setOffence(int offence) {
		this.offence = offence;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public String toString() {
		return "Athlete Stats" + "\nName: " + name + "\nHealth: " + health + "/100" + "\nStamina: " + stamina + "/10"
				+ "\nOffence: " + offence + "/10" + "\nDefence: " + defence + "/10";
				
	}
	
	public int getContractPrice() {
		return contractPrice;
	}

	public void setContractPrice(int contractPrice) {
		this.contractPrice = contractPrice;
	}

	public int getSellbackPrice() {
		return sellbackPrice;
	}

	public void setSellbackPrice(int sellbackPrice) {
		this.sellbackPrice = sellbackPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JasmineOng jasmine = new JasmineOng();
		System.out.println(jasmine);
	}


}
