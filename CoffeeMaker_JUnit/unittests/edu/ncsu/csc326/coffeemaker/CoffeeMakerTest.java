package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;

/**
 * 
 * @author Sarah Heckman
 *
 * Unit tests for CoffeeMaker class.
 */
public class CoffeeMakerTest extends TestCase {
	
	private CoffeeMaker cm;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
    private Recipe recipe;

    protected void setUp() throws Exception {
		cm = new CoffeeMaker();
		
		//Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");
		
		//Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("20");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");
		
		//Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate("0");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("3");
		r3.setAmtSugar("1");
		r3.setPrice("100");
		
		//Set up for r4
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setAmtChocolate("4");
		r4.setAmtCoffee("0");
		r4.setAmtMilk("1");
		r4.setAmtSugar("1");
		r4.setPrice("65");

		super.setUp();
	}

	// positive test cases -- Arjun Krishna Babu
	public void test_MakeCoffee_positive() throws Exception {
        /*  Test makeCoffee() method with money less than, equal to, and
            greater than the price of the beverage
         */

	    // set the inventory
        cm.setInventory_chocolate(100);
        cm.setInventory_coffee(100);
        cm.setInventory_milk(100);
        cm.setInventory_sugar(100);

        // setup for a sample recipe
        recipe = new Recipe();
        recipe.setName("Coffee");
        recipe.setAmtChocolate("1");
        recipe.setAmtCoffee("2");
        recipe.setAmtMilk("3");
        recipe.setAmtMilk("4");
        recipe.setPrice("50");


        cm.addRecipe(recipe);

	    // exact money. Should return 0
	    assertEquals(0, cm.makeCoffee(0, 50));

	    // more money. Should return balance.
        assertEquals(10, cm.makeCoffee(0, 60));

        // Insufficient money. Should return what was originally paid
        assertEquals(20, cm.makeCoffee(0, 20));
    }

    // positive test -- Arjun Krishna Babu
    public void test_purchase_inventoryDecrement() throws Exception {
        /*  Test that the inventory values get decremented after purchasing items */

        // set inventory values
        cm.setInventory_chocolate(100);
        cm.setInventory_coffee(100);
        cm.setInventory_milk(100);
        cm.setInventory_sugar(100);

        // setup a sample recipe
        // setup for a sample recipe
        recipe = new Recipe();
        recipe.setName("Coffee");
        recipe.setAmtChocolate("10");
        recipe.setAmtCoffee("20");
        recipe.setAmtMilk("30");
        recipe.setAmtSugar("40");
        recipe.setPrice("50");

        cm.addRecipe(recipe);

        int change = cm.makeCoffee(0, 50);

        // check if inventory values were decremented
        assertEquals(100-10, cm.getInventory_chocolate());
        assertEquals(100-20, cm.getInventory_coffee());
        assertEquals(100-30, cm.getInventory_milk());
        assertEquals(100-40, cm.getInventory_sugar());
    }
}
