package main;

import java.util.Scanner;
import java.util.ArrayList;

/** 
 * Game Environment class.
 * Now redundant I think, will delete later. (Replaced by GameManager)
 * @author Stephen Huang and Jasmine Ong
 */
public class GameEnvironment {
	/**
	 * The current week number.
	 */
    private int week;
    /**
     * The total number of weeks.
     */
    private int numOfWeeks;
    /**
     * The team name.
     */
    private String teamName;
    /**
     * The game difficulty.
     */
    private String difficulty;
    /**
     * The player's money.
     */
    private int money;
    /**
     * The player's athletes.
     */
    private ArrayList<Athlete> athletes;
    
    public GameEnvironment() {
        week = 1;
        money = 10000;
        athletes = new ArrayList<Athlete>();
    }

	public void setUpGame(String teamName, int numOfWeeks, String difficulty, int money) {
    	// Game Setup
    	
		this.numOfWeeks = numOfWeeks;
		

		 	

		// Athlete setup

		
        // Once the game is ready, we can start!		


    }
    
    public void startGame() {
		//
    }
    
 
    
    public void addAthletes(Athlete athlete) {
    	athletes.add(athlete);
    	
    }

    public void goClub() {
        // TODO: Auto-generated method stub
    	

    	
    }    
    
	public void takeBye() {
		// TODO Auto-generated method stub
		System.out.println("takeBye() has not been implemented.");
	}

	public void visitMarket() {
		// TODO Auto-generated method stub
		System.out.println("visitMarket() has not been implemented.");		
	}

	public void goStadium() {
		// TODO Auto-generated method stub
		System.out.println("goStadium() has not been implemented.");	
		
	}
   
    public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
    

	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		
	}
}
