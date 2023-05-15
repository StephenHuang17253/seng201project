package main;

import java.util.Scanner;
import java.util.ArrayList;

public class GameEnvironment {
    private int week;
    private String teamName;
    private String difficulty;
    private int numOfWeeks;
    private int money;
    private ArrayList<Athlete> athletes;
    
    public GameEnvironment() {
        week = 1;
        money = 10000;
        athletes = new ArrayList<Athlete>();
    }

	public void setUpGame() {
    	// Game Setup
    	
		 	

		// Athlete setup
		Athlete steve = new Athlete("Steve", "Defender", 10, 10, 10, 10, 100);
		Athlete dave = new Athlete("Dave", "Midfielder", 10, 10, 10, 10, 100);
		Athlete jasmine = new JasmineOng();
		athletes.add(steve);
		athletes.add(dave);
		athletes.add(jasmine);
		
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
		game.setUpGame();
		
	}
}
