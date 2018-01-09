package com.thedancercodes.tutorial.recipes.ui.recipe;

import com.thedancercodes.tutorial.recipes.data.local.RecipeStore;
import com.thedancercodes.tutorial.recipes.data.model.Recipe;

/**
 * Created by TheDancerCodes on 09/01/2018.
 */

public class RecipePresenter {
    private final RecipeStore store;
    private Recipe recipe;

    public RecipePresenter(RecipeStore store) {
        this.store = store;
    }

    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);
    }
}
