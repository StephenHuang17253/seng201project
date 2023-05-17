package main;

import java.text.DecimalFormat;

public class Match {

	private String matchName;
	private int playerScore;
	private int opponentScore;
	private int prizeMoney;
	private int pointGain;
	private GameManager manager;
	
	public Match (String opponentName, int prize, int points) {
		matchName = opponentName;
		prizeMoney = prize;
		pointGain = points;
		
		
	}
	
	public String getMatchName() {
		return matchName;
	}
	
	public int getPlayerScore() {
		return playerScore;
	}
	
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	
	public int getOpponentScore() {
		return opponentScore;
	}
	
	public void setOpponentScore(int opponentScore) {
		this.opponentScore = opponentScore;
	}
	
	public int getPrizeMoney() {
		return prizeMoney;
	}
	
	public void setPrizeMoney(int prizeMoney) {
		this.prizeMoney = prizeMoney;
	}
	
	public String getPrizeString(int amount) {
		DecimalFormat formatter = new DecimalFormat("#,###"); 
		return formatter.format(amount);		
	}	
	
	public int getPointGain() {
		return pointGain;
	}
	
	public void setPointGain(int pointGain) {
		this.pointGain = pointGain;
	}
	
	public String toString() {
		
		return " " + matchName + "  |  Match Reward: $" + getPrizeString(prizeMoney) + " and " + pointGain + " points.";
		
	}
	
}
