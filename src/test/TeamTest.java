package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Athlete;
import main.Team;

import java.util.ArrayList;

class TeamTest {

    private Team team;

    @BeforeEach
    public void setup() {
        team = new Team("Test Team");
    }

    @Test
    public void testGetTeamName() {
        assertEquals("Test Team", team.getTeamName());
    }

    @Test
    public void testGetMainRoster() {
        ArrayList<Athlete> mainRoster = team.getMainRoster();
        assertNotNull(mainRoster);
        assertTrue(mainRoster.isEmpty());
    }

    @Test
    public void testGetReserveRoster() {
        ArrayList<Athlete> reserveRoster = team.getReserveRoster();
        assertNotNull(reserveRoster);
        assertTrue(reserveRoster.isEmpty());
    }

    @Test
    public void testPromoteAthlete() {
        Athlete athlete = new Athlete("Stephen Huang", 10, 10, 10);
        team.getReserveRoster().add(athlete);
        team.promoteAthlete(athlete, "Striker");

        ArrayList<Athlete> mainRoster = team.getMainRoster();
        ArrayList<Athlete> reserveRoster = team.getReserveRoster();

        assertEquals(1, mainRoster.size());
        assertEquals(0, reserveRoster.size());
        assertEquals("Striker", athlete.getPosition());
    }

    @Test
    public void testDemoteAthlete() {
        Athlete athlete = new Athlete("Jasmine Ong", 10, 10 ,10);
        athlete.setPosition("Striker");
        team.getMainRoster().add(athlete);
        team.demoteAthlete(athlete);

        ArrayList<Athlete> mainRoster = team.getMainRoster();
        ArrayList<Athlete> reserveRoster = team.getReserveRoster();

        assertEquals(0, mainRoster.size());
        assertEquals(1, reserveRoster.size());
        assertEquals("Unassigned", athlete.getPosition());
    }

    @Test
    public void testCheckAthletePositions() {
        Athlete striker = new Athlete("John Smith", 10, 10 ,10);
        striker.setPosition("Striker");
        team.getMainRoster().add(striker);

        Athlete leftWing = new Athlete("Kaladin Stormblessed", 10, 10 ,10);
        leftWing.setPosition("Left Wing");
        team.getMainRoster().add(leftWing);

        Athlete rightWing = new Athlete("Shallan Davar", 10, 10 ,10);
        rightWing.setPosition("Right Wing");
        team.getMainRoster().add(rightWing);

        Athlete defender = new Athlete("Adolin Kholin", 10, 10 ,10);
        defender.setPosition("Defender");
        team.getMainRoster().add(defender);

        Athlete keeper = new Athlete("Tobio Kageyama", 10, 10 ,10);
        keeper.setPosition("Keeper");
        team.getMainRoster().add(keeper);

        team.checkAthletePositions();

        assertEquals(striker, team.getPlayerInPosition("Striker"));
        assertEquals(leftWing, team.getPlayerInPosition("Left Wing"));
        assertEquals(rightWing, team.getPlayerInPosition("Right Wing"));
        assertEquals(defender, team.getPlayerInPosition("Defender"));
        assertEquals(keeper, team.getPlayerInPosition("Keeper"));
    }

    @Test
    public void testGetPlayerInPosition() {
        Athlete athlete = new Athlete("Jasmine Ong", 10, 10, 10);
        
        athlete.setPosition("Striker");
        team.getMainRoster().add(athlete);

        Athlete player = team.getPlayerInPosition("Striker");
        assertEquals(athlete, player);
    }

}
        