package com.thedancercodes.tutorial.recipes.data.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by TheDancerCodes on 18/12/2017.
 */
public class RecipeStoreTest {
    @Test
    public void nullDirectory() {
        Context context = InstrumentationRegistry.getTargetContext();

        // Create a recipe store with the context and null as the directory.
        RecipeStore store = new RecipeStore(context, null);

        /**
         * GOAL:
         * We want to return a store that is not null, and contains no recipe.
         */

        // Asserting that the store is not null
        assertNotNull(store);

        // Asserting that the recipes are not null
        assertNotNull(store.recipes);

        // Asserting that the recipe store is empty
        assertEquals(0, store.recipes.size());
    }
}