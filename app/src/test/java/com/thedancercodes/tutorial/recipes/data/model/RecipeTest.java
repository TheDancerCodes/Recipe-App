package com.thedancercodes.tutorial.recipes.data.model;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by TheDancerCodes on 15/12/2017.
 */
public class RecipeTest {
    @Test
    public void water() {
        // Use getResourceAsStream -> to obtain an info stream for recipes/water.txt
        InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/water.txt");

        // Create a Recipe
        Recipe recipe = Recipe.readFromStream(stream);

        // Assert that the recipe returned is not null.
        assertNotNull(recipe);

        // Assert that the id, title & description is what we are expecting
        assertEquals("water", recipe.id);
        assertEquals("Water", recipe.title);
        assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe.description);
    }

    /*
      A test method for the multi-line description test case.
     */
    @Test
    public void mixed() {
        InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/mixed.txt");
        Recipe recipe = Recipe.readFromStream(stream);
        assertNotNull(recipe);
        assertEquals("punch", recipe.id);
        assertEquals("Punch", recipe.title);
        assertEquals(
                "Juice of 3 lemons\n" +
                "1 orange\n" +
                "1 pint grape juice\n" +
                "1 cup sugar\n" +
                "1 cup water\n" +
                "1 pine apple juice\n" +
                "Mix all together and strain. Add large piece of ice.", recipe.description);
    }

}