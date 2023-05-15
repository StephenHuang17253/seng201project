package main;

import java.util.Scanner;
import java.util.ArrayList;

public class CommandLineGame {
    private int week;
    private String teamName;
    private String difficulty;
    private int numOfWeeks;
    private int money;
    private ArrayList<Athlete> athletes;
    
    public CommandLineGame() {
        week = 1;
        money = 10000;
        athletes = new ArrayList<Athlete>();
    }

	public void setUpGame() {
    	// Game Setup
    	
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the game!");
		String teamNameQues = "";
		System.out.println("\nTeam name must be between 3 - 15 characters.");
		System.out.print("Enter your team name: ");
		
		while (teamNameQues.length() < 3 || teamNameQues.length() > 15) {
			teamNameQues = userInput.nextLine();
			if (teamNameQues.length() < 3) {
				System.out.println("Your team name is too short. Please enter another name.");
				System.out.print("Enter your team name: ");
				teamNameQues = userInput.nextLine();
			}
			
			if (teamNameQues.length() > 15) {
				System.out.println("Your team name is too long. Please enter another name.");
				System.out.print("Enter your team name: ");
				teamNameQues = userInput.nextLine();
			}
			
			if (teamNameQues.length() >= 3 & teamNameQues.length() <= 15) {
				teamName = teamNameQues;
			}
		}

		System.out.println("\nEnter an integer between 5 and 15: ");
		System.out.print("Enter season length: ");		
		int seasonLength = 0;
		while (seasonLength < 5 || seasonLength > 15) {	
						
			seasonLength = userInput.nextInt();
			if (seasonLength >= 5 & seasonLength <= 15) {
				numOfWeeks = seasonLength;
			} else {
			System.out.print("Invalid input, try again (5-15): ");
			}
		}

		System.out.println("\nPick a difficulty.");
		System.out.println("1. Normal");
		System.out.println("2. Hard");
		System.out.print("Enter your choice (1-2): ");
		int difficultyChoice = 0;
		while (difficultyChoice < 1 || difficultyChoice > 2) {	
			difficultyChoice = userInput.nextInt();
			if (difficultyChoice == 1) {
				difficulty = "Normal";
			} else if (difficultyChoice == 2) {
				difficulty = "Hard";
			} else {
			System.out.print("Invalid input, try again (1-2): ");
			}
		}
		
		System.out.println("\nWelcome " + teamName + " to the 2023 Season of Kick Heroes!\n");
		System.out.println("Chosen season length: " + numOfWeeks + " weeks long");
		System.out.println("Chosen difficulty: " + difficulty);
		 	

		// Athlete setup
		Athlete steve = new Athlete("Steve", "Defender", 10, 10, 10, 10, 200000);
		Athlete dave = new Athlete("Dave", "Midfielder", 10, 10, 10, 10, 200000);
		Athlete jasmine = new JasmineOng();
		athletes.add(steve);
		athletes.add(dave);
		athletes.add(jasmine);
		
        // Once the game is ready, we can start!		
        startGame();
        // System.out.println("The season has begun.");

    }
    
    public void startGame() {

        // Main game loop
        while (true) {
        	System.out.println("------------------------------------------------------------------");        	
            System.out.println("Week " + week);
            System.out.println("Current Balance: $" + getMoney());
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Go to Club");
            System.out.println("2. Go to Stadium");
            System.out.println("3. Visit Market");
            System.out.println("4. Take a bye (skip to week)");
            System.out.println("5. Quit\n");

            int choice = getUserInput(1, 5);

            switch (choice) {
                case 1:
                    goClub();
                    return;
                case 2:
                    goStadium();
                    break;
                case 3:
                	visitMarket();
                    break;
                case 4:
                    takeBye();
                    break;
                case 5:
                    System.out.println("Thanks for playing!");
                    return;
            
            }
        }
    }
    

    
    public void addAthletes(Athlete athlete) {
    	athletes.add(athlete);
    	
    }

    public void goClub() {
        // TODO: Auto-generated method stub
    	System.out.println("\nTeam Name: " + teamName);
    	System.out.println("Team Roster: ");
    	for (Athlete athlete: athletes) {
    		//System.out.println(" - " + athlete.getName() + ", " + athlete.getPosition());
    		System.out.println(" - " + athlete.getSummary());
    	}
    	
    	while (true) {
	     	System.out.println("\nWhat would you like to do here?");
	    	System.out.println("1. View inventory");
	    	System.out.println("2. Return");
	    	
	    	int choice = getUserInput(1, 2);
	    	
	    	if (choice == 1) {
	    		System.out.println("Inventory is empty.");
	    	}
	    	
	    	if (choice == 2) {
	    		startGame();
	    		break;
	    	}
    	}

    	
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

	
	
	// For the main loop
    private int getUserInput(int minChoice, int maxChoice) {
        Scanner mainInput = new Scanner(System.in);
		int choice;
		do {
		    System.out.print("Enter your choice (Between " + minChoice + "-" + maxChoice + "): ");
		    choice = mainInput.nextInt();
		} while (choice < minChoice || choice > maxChoice);
		return choice;
	}
   
    public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
    

	public static void main(String[] args) {
		CommandLineGame game = new CommandLineGame();
		game.setUpGame();
		
	}
}

