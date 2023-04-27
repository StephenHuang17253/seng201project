package main;

import java.util.Scanner;

public class GameEnvironment {
    private int week;
    private String teamName;
    private String difficulty;
    private int numOfWeeks;

    public GameEnvironment() {
        week = 1;
    }

    public void setUpGame() {
    	// Game Setup

		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the game!");
		
		System.out.println("\nTeam name must be between 3 - 15 characters.");
		System.out.print("Enter your team name: ");
		teamName = userInput.nextLine();

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
		
		System.out.println("\nWelcome " + teamName + " to the 2023 Season of the League Championship Series.\n");
		System.out.println("Chosen season length: " + numOfWeeks + " weeks long");
		System.out.println("Chosen difficulty: " + difficulty);
		 	
        // Once the game is ready, we can start!
        startGame();

    }
    
    public void startGame() {
        System.out.println("The season has begun.");


        // Main game loop
        while (true) {
        	System.out.println("------------------------------------------------------------------");        	
            System.out.println("Week " + week);
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Season overview (money, current week, weeks remaining)");
            System.out.println("2. Manage club");
            System.out.println("3. Go to Stadium");
            System.out.println("4. Visit market");
            System.out.println("5. Take a bye (skip to week)");
            System.out.println("6. Quit\n");

            int choice = getUserInput(1, 6);

            switch (choice) {
            	case 1:
            		viewOverview();
            		break;
                case 2:
                    viewTeam();
                    break;
                case 3:
                    goStadium();
                    break;
                case 4:
                    visitMarket();
                    break;
                case 5:
                    takeBye();
                    break;
                case 6:
                    System.out.println("Thanks for playing!");
                    return;
            }
        }
    }
    

    public void viewOverview() {
		// TODO Auto-generated method stub
		System.out.println("viewOverview() has not been implemented.");
	}

    private void viewTeam() {
        // TODO: Auto-generated method stub
    	System.out.println("viewTeam() has not been implemented.");
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
    

	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.setUpGame();
		
	}
}
