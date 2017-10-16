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

		// setup for a sample recipe
        recipe = new Recipe();
        recipe.setName("White Mocha");
        recipe.setAmtChocolate("1");
        recipe.setAmtCoffee("2");
        recipe.setAmtMilk("3");
        recipe.setAmtMilk("4");
        recipe.setPrice("50");
		
		super.setUp();
	}

	// positive test cases -- Arjun Krishna Babu
	public void test_MakeCoffee_positive()  {
	    // set the inventory
        cm.setInventory_chocolate(100);
        cm.setInventory_coffee(100);
        cm.setInventory_milk(100);
        cm.setInventory_sugar(100);

	    cm.addRecipe(recipe);

	    // exact money. Should return 0
	    assertEquals(0, cm.makeCoffee(0, 50));

    }
//	public void testMakeCoffee() {
//		cm.addRecipe(r1);
//		assertEquals(25, cm.makeCoffee(0, 75));
//	}

}
