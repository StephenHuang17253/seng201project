package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Match;

public class MatchTest {
	
    private Match match;

    @BeforeEach
    public void setUp() {
        match = new Match("Karasuno", 1000, 10);
    }

    @Test
    public void testGetName() {
        String name = match.getName();
        assertEquals("Karasuno", name);
    }

    @Test
    public void testSetName() {
        match.setName("Shiratorizawa Academy");
        String name = match.getName();
        assertEquals("Shiratorizawa Academy", name);
    }

    @Test
    public void testGetPlayerScore() {
        int playerScore = match.getPlayerScore();
        assertEquals(0, playerScore);
    }

    @Test
    public void testSetPlayerScore() {
        match.setPlayerScore(3);
        int playerScore = match.getPlayerScore();
        assertEquals(3, playerScore);
    }

    @Test
    public void testGetOpponentScore() {
        int opponentScore = match.getOpponentScore();
        assertEquals(0, opponentScore);
    }

    @Test
    public void testSetOpponentScore() {
        match.setOpponentScore(2);
        int opponentScore = match.getOpponentScore();
        assertEquals(2, opponentScore);
    }

    @Test
    public void testGetPrizeMoney() {
        int prizeMoney = match.getPrizeMoney();
        assertEquals(1000, prizeMoney);
    }

    @Test
    public void testSetPrizeMoney() {
        match.setPrizeMoney(2000);
        int prizeMoney = match.getPrizeMoney();
        assertEquals(2000, prizeMoney);
    }

    @Test
    public void testCreatePrizeString() {
        String formattedPrize = match.createPrizeString(1000000);
        assertEquals("1,000,000", formattedPrize);
    }

    @Test
    public void testGetPointGain() {
        int pointGain = match.getPointGain();
        assertEquals(10, pointGain);
    }

    @Test
    public void testSetPointGain() {
        match.setPointGain(20);
        int pointGain = match.getPointGain();
        assertEquals(20, pointGain);
    }

    @Test
    public void testGetOutcome() {
        String outcome = match.getOutcome();
        assertNull(outcome);
    }

    @Test
    public void testSetOutcome() {
        match.setOutcome("Victory");
        String outcome = match.getOutcome();
        assertEquals("Victory", outcome);
    }

}
