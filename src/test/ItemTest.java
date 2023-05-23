package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Item;

public class ItemTest {
	
    private Item item;

    @BeforeEach
    public void setUp() {
        item = new Item("Offence Test", 500, "Increases offence by 10", "Offence", 10);
    }

    @Test
    public void testGetName() {
        String itemName = item.getName();
        assertEquals("Offence Test", itemName);
    }

    @Test
    public void testSetName() {
        item.setName("Defence Test");
        String itemName = item.getName();
        assertEquals("Defence Test", itemName);
    }

    @Test
    public void testGetContractPrice() {
        int contractPrice = item.getContractPrice();
        assertEquals(500, contractPrice);
    }

    @Test
    public void testSetContractPrice() {
        item.setContractPrice(700);
        int contractPrice = item.getContractPrice();
        assertEquals(700, contractPrice);
    }

    @Test
    public void testGetSellbackPrice() {
        int sellbackPrice = item.getSellbackPrice();
        assertEquals(250, sellbackPrice);
    }

    @Test
    public void testSetSellbackPrice() {
        item.setSellbackPrice(300);
        int sellbackPrice = item.getSellbackPrice();
        assertEquals(300, sellbackPrice);
    }

    @Test
    public void testGetDescription() {
        String description = item.getDescription();
        assertEquals("Increases strength by 10", description);
    }

    @Test
    public void testSetDescription() {
        item.setDescription("Increases defence by 5");
        String description = item.getDescription();
        assertEquals("Increases defence by 5", description);
    }

    @Test
    public void testGetStatToChange() {
        String statToChange = item.getStatToChange();
        assertEquals("Offence", statToChange);
    }

    @Test
    public void testSetStatToChange() {
        item.setStatToChange("Defence");
        String statToChange = item.getStatToChange();
        assertEquals("Defence", statToChange);
    }

    @Test
    public void testGetChange() {
        int changeAmount = item.getChange();
        assertEquals(10, changeAmount);
    }

    @Test
    public void testSetChange() {
        item.setChange(5);
        int changeAmount = item.getChange();
        assertEquals(5, changeAmount);
    }

    @Test
    public void testToString() {
        String itemString = item.toString();
        assertEquals("Offence Test, Price: $500, Description: Increases Offence by 10", itemString);
    }
}