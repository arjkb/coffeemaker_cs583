package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.util.Arrays;

import static org.junit.Assert.*;


public class RecipeTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private CoffeeMaker cm;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;

    @Before
    public void setUp() throws Exception {
        cm = new CoffeeMaker();

        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");

        r2 = new Recipe();
        r2.setName("Mocha");
        r2.setAmtChocolate("20");
        r2.setAmtCoffee("3");
        r2.setAmtMilk("1");
        r2.setAmtSugar("1");
        r2.setPrice("75");

        r3 = new Recipe();
        r3.setName("Latte");
        r3.setAmtChocolate("0");
        r3.setAmtCoffee("3");
        r3.setAmtMilk("3");
        r3.setAmtSugar("1");
        r3.setPrice("100");

        r4 = new Recipe();
        r4.setName("Hot Chocolate");
        r4.setAmtChocolate("4");
        r4.setAmtCoffee("0");
        r4.setAmtMilk("1");
        r4.setAmtSugar("1");
        r4.setPrice("65");
    }

    @Test
    public void test_AddRecipe_Hold3Recipes() {
        assertTrue(cm.addRecipe(r1));
        assertTrue(cm.addRecipe(r2));
        assertTrue(cm.addRecipe(r3));
        assertTrue(Arrays.asList(cm.getRecipes()).contains(r1));
        assertTrue(Arrays.asList(cm.getRecipes()).contains(r2));
        assertTrue(Arrays.asList(cm.getRecipes()).contains(r3));
    }

    @Test
    public void test_AddRecipe_RecipeOverflow(){
        assertTrue(cm.addRecipe(r1));
        assertTrue(cm.addRecipe(r2));
        assertTrue(cm.addRecipe(r3));
        assertFalse(cm.addRecipe(r4));
        assertFalse(Arrays.asList(cm.getRecipes()).contains(r4));
    }

    @Test
    public void test_AddRecipe_UniqueName(){
        assertTrue(cm.addRecipe(r1));
        r2.setName(r1.getName());
        assertFalse(cm.addRecipe(r2));
    }

    @Test
    public void test_AddRecipe_IntPrice() throws RecipeException {
        Recipe r = new Recipe();
        r.setName("Test");
        r.setAmtChocolate("1");
        r.setAmtCoffee("1");
        r.setAmtMilk("1");
        r.setAmtSugar("1");
        exception.expect(RecipeException.class);
        r.setPrice("5.50");
    }

    @Test
    public void test_AddRecipe_CompleteRecipe() throws RecipeException {
        Recipe r = new Recipe();

        r.setName("Test");
        assertFalse(cm.addRecipe(r));
        assertFalse(Arrays.asList(cm.getRecipes()).contains(r));

        r.setAmtChocolate("1");
        assertFalse(cm.addRecipe(r));
        assertFalse(Arrays.asList(cm.getRecipes()).contains(r));

        r.setAmtCoffee("1");
        assertFalse(cm.addRecipe(r));
        assertFalse(Arrays.asList(cm.getRecipes()).contains(r));

        r.setAmtMilk("1");
        assertFalse(cm.addRecipe(r));
        assertFalse(Arrays.asList(cm.getRecipes()).contains(r));

        r.setAmtSugar("1");
        assertFalse(cm.addRecipe(r));
        assertFalse(Arrays.asList(cm.getRecipes()).contains(r));

        r.setPrice("1");
        assertTrue(cm.addRecipe(r));
        assertTrue(Arrays.asList(cm.getRecipes()).contains(r));
    }

    @Test
    public void test_DelRecipe_ContainsRecipe() {
        assertTrue(cm.addRecipe(r1));
        assertEquals(r1.getName(),cm.deleteRecipe(0));
    }

    @Test
    public void test_DelRecipe_NoRecipe(){
        assertNull(cm.deleteRecipe(0));
    }

    @Test
    public void test_EditRecipe_DifNames(){
        assertTrue(cm.addRecipe(r1));
        Recipe r = new Recipe();
        r.setName(r1.getName() + "edited");
        assertEquals(r1.getName(), cm.editRecipe(0, r));
        Recipe rr = cm.getRecipes()[0];
        assertEquals(0, rr.getAmtChocolate());
        assertEquals(0, rr.getAmtCoffee());
        assertEquals(0, rr.getAmtMilk());
        assertEquals(0, rr.getAmtSugar());
        assertEquals(0, rr.getPrice());
    }

    @Test
    public void test_EditRecipe_SameNames(){
        assertTrue(cm.addRecipe(r1));
        Recipe r = new Recipe();
        r.setName(r1.getName() + "edited");
        assertNull(cm.editRecipe(0, r));
    }

    @Test
    public void test_EditRecipe_Empty(){
        assertNull(cm.editRecipe(0, r1));
    }

}
