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

    public void testAddInventory()  {
        try {
            cm.addInventory("3", "4", "5", "6");
        } catch (InventoryException e) {
            fail("Inventory exception should not be thrown");
        }
    }
}
