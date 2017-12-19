package com.thedancercodes.tutorial.recipes.data.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.thedancercodes.tutorial.recipes.data.model.Recipe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by TheDancerCodes on 18/12/2017.
 */
public class RecipeStoreTest {

    /**
     * GOAL:
     * We want to return a store that is not null, and contains no recipe.
     */
    @Test
    public void nullDirectory() {
        Context context = InstrumentationRegistry.getTargetContext();

        // Create a recipe store with the context and null as the directory.
        RecipeStore store = new RecipeStore(context, null);

        // Asserting that the store is not null
        assertNotNull(store);

        // Asserting that the recipes are not null
        assertNotNull(store.recipes);

        // Asserting that the recipe store is empty
        assertEquals(0, store.recipes.size());
    }


    /**
     * GOAL:
     * We want to return a store that is not null, and
     * Verify the count of the number of recipes in the assets folder.
     */
    @Test
    public void count() {
        Context context = InstrumentationRegistry.getTargetContext();

        // Create a recipe store with the context and recipes as the directory.
        RecipeStore store = new RecipeStore(context, "recipes");

        // Asserting that the store is not null
        assertNotNull(store);

        // Asserting that the recipes are not null
        assertNotNull(store.recipes);

        // Asserting that the recipe store has 4 recipes
        assertEquals(4, store.recipes.size());
    }

    /**
     * GOAL:
     * We want to verify the that we can retrieve a recipe by its ID.
     */
    @Test
    public void getChocolatePudding() {
        Context context = InstrumentationRegistry.getTargetContext();

        // Create a recipe store with the context and recipes as the directory.
        RecipeStore store = new RecipeStore(context, "recipes");

        // Get the Recipe
        Recipe recipe = store.getRecipe("chocolate_pudding");

        // Asserting that the recipe is not null
        assertNotNull(recipe);

        // Verify the recipe ID is what we expect
        assertEquals("chocolate_pudding", recipe.id);

        // Verify the recipe title is what we expect
        assertEquals("Chocolate Pudding", recipe.title);

    }
}