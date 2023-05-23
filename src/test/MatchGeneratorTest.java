package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Match;
import main.MatchGenerator;

import java.util.ArrayList;

class MatchGeneratorTest {

    @Test
    public void testGenerateMatch() {
        Match match = MatchGenerator.generateMatch();
        assertNotNull(match);
        assertNotNull(match.getName());
        assertTrue(match.getPrizeMoney() >= 1000000 && match.getPrizeMoney() <= 4000000);
        assertEquals(10, match.getPointGain());
    }

    @Test
    public void testGenerateWeeklyMatches() {
        ArrayList<Match> matches = MatchGenerator.generateWeeklyMatches();
        assertNotNull(matches);
        assertTrue(matches.size() >= 3 && matches.size() <= 5);

        ArrayList<String> matchNames = new ArrayList<>();
        for (Match match : matches) {
            assertNotNull(match);
            assertNotNull(match.getName());
            assertTrue(match.getPrizeMoney() >= 1000000 && match.getPrizeMoney() <= 4000000);
            assertEquals(10, match.getPointGain());

            String name = match.getName();
            assertFalse(matchNames.contains(name));
            matchNames.add(name);
        }
    }
}