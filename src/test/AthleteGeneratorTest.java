package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.Athlete;
import main.AthleteGenerator;

public class AthleteGeneratorTest {

    @Test
    public void testGenerateRandomAthlete() {
        Athlete athlete = AthleteGenerator.generateRandomAthlete(1, 20);
        assertNotNull(athlete);
        assertNotNull(athlete.getName());
        assertTrue(athlete.getOffence() >= 1 && athlete.getOffence() <= 20);
        assertTrue(athlete.getDefence() >= 1 && athlete.getDefence() <= 20);
        assertTrue(athlete.getContractPrice() >= 100000 && athlete.getContractPrice() <= 4000000);
    }

    @Test
    public void testGetRandomName() {
        String name = AthleteGenerator.getRandomName();
        assertNotNull(name);
    }

    @Test
    public void testGetRandomPosition() {
        String position = AthleteGenerator.getRandomPosition();
        assertNotNull(position);
    }

    @Test
    public void testGenerateTeam() {
        ArrayList<Athlete> team = AthleteGenerator.generateTeam();
        assertNotNull(team);
        assertEquals(5, team.size());
        for (Athlete athlete : team) {
            assertNotNull(athlete.getName());
            assertNotNull(athlete.getPosition());
        }
    }

    @Test
    public void testGenerateMarketAthletes() {
        ArrayList<Athlete> marketAthletes = AthleteGenerator.generateMarketAthletes(10);
        assertNotNull(marketAthletes);
        assertEquals(10, marketAthletes.size());
        for (Athlete athlete : marketAthletes) {
            assertNotNull(athlete.getName());
            assertEquals("Unassigned", athlete.getPosition());
        }
    }

    @Test
    public void testSetMinStat() {
        AthleteGenerator.setMinStat(10);
        Athlete athlete = AthleteGenerator.generateRandomAthlete(10, 20);
        assertNotNull(athlete);
        assertTrue(athlete.getOffence() >= 10 && athlete.getOffence() <= 20);
    }

    @Test
    public void testSetMaxStat() {
        AthleteGenerator.setMaxStat(15);
        Athlete athlete = AthleteGenerator.generateRandomAthlete(1, 15);
        assertNotNull(athlete);
        assertTrue(athlete.getDefence() >= 1 && athlete.getDefence() <= 15);
    }

    @Test
    public void testIncrementMinMaxStats() {
        AthleteGenerator.setMinStat(10);
        AthleteGenerator.setMaxStat(15);
        AthleteGenerator.incrementMinMaxStats();
        Athlete athlete = AthleteGenerator.generateRandomAthlete(11, 16);
        assertNotNull(athlete);
        assertTrue(athlete.getOffence() >= 11 && athlete.getOffence() <= 16);
        assertTrue(athlete.getDefence() >= 11 && athlete.getDefence() <= 16);
    }
}