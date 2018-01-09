package com.thedancercodes.tutorial.recipes.ui.recipe;

import android.view.View;

import com.thedancercodes.tutorial.recipes.R;
import com.thedancercodes.tutorial.recipes.data.local.RecipeStore;
import com.thedancercodes.tutorial.recipes.data.model.Recipe;

/**
 * Created by TheDancerCodes on 09/01/2018.
 */

public class RecipePresenter {
    private final RecipeStore store;
    private final RecipeContract.View view;
    private Recipe recipe;

    public RecipePresenter(RecipeStore store, RecipeContract.View view) {
        this.store = store;
        this.view = view;
    }

    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);

        // When we give it an invalid ID, the recipe will be null &
        // we need to make sure that we handle it properly.
        if (recipe == null) {
            view.showRecipeNotFoundError();
        }
    }
}
