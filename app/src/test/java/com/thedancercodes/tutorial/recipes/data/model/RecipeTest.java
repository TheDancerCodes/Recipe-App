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
    }

}