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

    // positive test case -- Arjun Krishna Babu
    public void testAddInventory_positive_2()   {
        try {
            cm.addInventory("0", "0", "0", "0");
        } catch (InventoryException e)  {
            fail("InventoryException for addInventory(0,0,0,0)");
        }
    }

    // positive test case -- Arjun Krishna Babu
    public void testAddInventory_positive_3()   {
        // add to inventory twice, and see if the values in inventory add up

        final int INITIAL_UNITS = 15;

        final String[] chocolate = {"1", "2"};
        final String[] coffee = {"3", "4"};
        final String[] milk = {"5", "6"};
        final String[] sugar = {"7", "8"};

        Inventory inventory = new Inventory();
        try {
            inventory.addChocolate(chocolate[0]);
            inventory.addCoffee(coffee[0]);
            inventory.addMilk(milk[0]);
            inventory.addSugar(sugar[0]);

            inventory.addChocolate(chocolate[1]);
            inventory.addCoffee(coffee[1]);
            inventory.addMilk(milk[1]);
            inventory.addSugar(sugar[1]);

        } catch (InventoryException e)  {
            fail("InventoryException in positive test case was not expected");
        }

        final int TOT_EXP_CHOCOLATE = INITIAL_UNITS + Integer.parseInt(chocolate[0]) + Integer.parseInt(chocolate[1]);
        final int TOT_EXP_COFFEE = INITIAL_UNITS + Integer.parseInt(coffee[0]) + Integer.parseInt(coffee[1]);
        final int TOT_EXP_MILK = INITIAL_UNITS + Integer.parseInt(milk[0]) + Integer.parseInt(milk[1]);
        final int TOT_EXP_SUGAR = INITIAL_UNITS + Integer.parseInt(sugar[0]) + Integer.parseInt(sugar[1]);

        assertEquals(TOT_EXP_CHOCOLATE, inventory.getChocolate());
        assertEquals(TOT_EXP_COFFEE, inventory.getCoffee());
        assertEquals(TOT_EXP_MILK, inventory.getMilk());
        assertEquals(TOT_EXP_SUGAR, inventory.getSugar());
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

    // negative test case -- Arjun Krishna Babu
    public void testAddInventory_negative_2()   {
        // attempt to add non-integer values to inventory
        try {
            cm.addInventory("1.2", "3.4", "5.6", "7.8");
            fail("InventoryException should be thrown for addInventory(1.2, 3.4, 5.6, 7.8)");
        } catch (InventoryException e)  {
            // success if thrown
        }
    }
}
