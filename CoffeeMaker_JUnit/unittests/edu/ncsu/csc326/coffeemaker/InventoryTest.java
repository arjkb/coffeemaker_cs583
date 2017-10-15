package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import junit.framework.TestCase;

public class InventoryTest extends TestCase {
    CoffeeMaker cm;
    Recipe r1;

    protected void setUp() throws Exception {
        cm = new CoffeeMaker();

        super.setUp();
    }

    // Positive Test Case -- Arjun Krishna Babu
    public void testAddInventory_positive_1()  {
        try {
            cm.addInventory("3", "4", "5", "6");
        } catch (InventoryException e) {
            fail("InventoryException for addInventory(3,4,5,6)");
        }
    }

    // Negative test case -- Arjun Krishna Babu
    public void testAddInventory_negative_1()  {
        try {
            cm.addInventory("-3", "-4", "-5", "-6");
            fail("InventoryException should be thrown for addInventory(-3, -4, -5, -6)");
        } catch (InventoryException e) {
            // success if thrown

        }
    }
}
