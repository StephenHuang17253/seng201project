package main;

public class GameManager {

	public String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void launchStartScreen() {
		StartScreen startWindow = new StartScreen(this);
	}
	
	public void closeStartScreen(StartScreen startWindow) {
		startWindow.closeWindow();
		launchSetupScreen();
	}
	
	public void launchSetupScreen() {
		SetupScreen setupWindow = new SetupScreen(this);
	}
	

	public void closeSetUpScreen(SetupScreen setupWindow) {
		// TODO Auto-generated method stub
		setupWindow.closeWindow();
	}
	
	public static void main(String[] args) {
		GameManager manager = new GameManager();
		manager.launchStartScreen();
	}	
}
