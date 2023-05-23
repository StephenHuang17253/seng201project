package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Athlete;

class AthleteTest {

    private Athlete athlete;

    @BeforeEach
    public void setUp() {
        athlete = new Athlete("Dalinar Kholin", 50, 40, 100);
    }

    @Test
    public void testGetName() {
        assertEquals("Dalinar Kholin", athlete.getName());
    }

    @Test
    public void testSetName() {
        athlete.setName("Jane Smith");
        assertEquals("Jane Smith", athlete.getName());
    }

    @Test
    public void testGetProficiency() {
        assertEquals(90, athlete.getProficiency());
    }

    @Test
    public void testGetPosition() {
        assertEquals("Unassigned", athlete.getPosition());
    }

    @Test
    public void testSetPosition() {
        athlete.setPosition("Striker");
        assertEquals("Striker", athlete.getPosition());
    }

    @Test
    public void testGetHealth() {
        assertEquals(10, athlete.getHealth());
    }

    @Test
    public void testSetHealth() {
        athlete.setHealth(8);
        assertEquals(8, athlete.getHealth());
    }

    @Test
    public void testChangeHealth() {
        athlete.changeHealth(-3);
        assertEquals(7, athlete.getHealth());
    }

    @Test
    public void testGetStamina() {
        assertEquals(10, athlete.getStamina());
    }

    @Test
    public void testSetStamina() {
        athlete.setStamina(6);
        assertEquals(6, athlete.getStamina());
    }

    @Test
    public void testChangeStamina() {
        athlete.changeStamina(-4);
        assertEquals(6, athlete.getStamina());
    }

    @Test
    public void testGetMaxStamina() {
        assertEquals(10, athlete.getMaxStamina());
    }

    @Test
    public void testSetMaxStamina() {
        athlete.setMaxStamina(12);
        assertEquals(12, athlete.getMaxStamina());
    }

    @Test
    public void testChangeMaxStamina() {
        athlete.changeMaxStamina(2);
        assertEquals(12, athlete.getMaxStamina());
    }

    @Test
    public void testGetOffence() {
        assertEquals(50, athlete.getOffence());
    }

    @Test
    public void testSetOffence() {
        athlete.setOffence(55);
        assertEquals(55, athlete.getOffence());
    }

    @Test
    public void testChangeOffence() {
        athlete.changeOffence(5);
        assertEquals(55, athlete.getOffence());
    }

    @Test
    public void testGetDefence() {
        assertEquals(40, athlete.getDefence());
    }

    @Test
    public void testSetDefence() {
        athlete.setDefence(45);
        assertEquals(45, athlete.getDefence());
    }

    @Test
    public void testChangeDefence() {
        athlete.changeDefence(5);
        assertEquals(45, athlete.getDefence());
    }

    @Test
    public void testToString() {
        String expectedString = "Dalinar Kholin, Unassigned (90), Offence: 50, Defence: 40, Health: 10, Stamina: 10, Contract: $100";
        assertEquals(expectedString, athlete.toString());
    }

    @Test
    public void testGetContractPrice() {
        assertEquals(100, athlete.getContractPrice());
    }

    @Test
    public void testSetContractPrice() {
        athlete.setContractPrice(150);
        assertEquals(150, athlete.getContractPrice());
    }

    @Test
    public void testGetSellbackPrice() {
        assertEquals(50, athlete.getSellbackPrice());
    }

    @Test
    public void testSetSellbackPrice() {
        athlete.setSellbackPrice(75);
        assertEquals(75, athlete.getSellbackPrice());
    }

    @Test
    public void testGetDescription() {
        assertEquals("A professional Futsal player. ", athlete.getDescription());
    }

    @Test
    public void testSetDescription() {
        athlete.setDescription("A skilled striker.");
        assertEquals("A skilled striker.", athlete.getDescription());
    }

    @Test
    public void testGetMatchUpResult() {
        assertNull(athlete.getMatchUpResult());
    }

    @Test
    public void testSetMatchUpResult() {
        athlete.setMatchUpResult("Win");
        assertEquals("Win", athlete.getMatchUpResult());
    }

    @Test
    public void testGetFaceOffWins() {
        assertEquals(0, athlete.getFaceOffWins());
    }

    @Test
    public void testSetFaceOffWins() {
        athlete.setFaceOffWins(5);
        assertEquals(5, athlete.getFaceOffWins());
    }

    @Test
    public void testIncrementWins() {
        athlete.incrementWins();
        assertEquals(1, athlete.getFaceOffWins());
    }

    @Test
    public void testGetFaceOffLosses() {
        assertEquals(0, athlete.getFaceOffLosses());
    }
    
    @Test
    public void testSetFaceOffLosses() {
        athlete.setFaceOffLosses(3);
        assertEquals(3, athlete.getFaceOffLosses());
    }

    @Test
    public void testIncrementLosses() {
        athlete.incrementLosses();
        assertEquals(1, athlete.getFaceOffLosses());
    }

}
