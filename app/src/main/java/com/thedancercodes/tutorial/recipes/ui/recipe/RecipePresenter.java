package com.thedancercodes.tutorial.recipes.ui.recipe;

import android.view.View;

import com.thedancercodes.tutorial.recipes.R;
import com.thedancercodes.tutorial.recipes.data.local.Favorites;
import com.thedancercodes.tutorial.recipes.data.local.RecipeStore;
import com.thedancercodes.tutorial.recipes.data.model.Recipe;

/**
 * Created by TheDancerCodes on 09/01/2018.
 */

public class RecipePresenter implements RecipeContract.Listener {
    private final RecipeStore store;
    private final RecipeContract.View view;
    private final Favorites favorites;
    private Recipe recipe;

    public RecipePresenter(RecipeStore store, RecipeContract.View view, Favorites favorites) {
        this.store = store;
        this.view = view;
        this.favorites = favorites;

    }

    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);

        // When we give it an invalid ID, the recipe will be null &
        // we need to make sure that we handle it properly.
        if (recipe == null) {
            view.showRecipeNotFoundError();
        } else {
            // else block to set title, description & selected state
            view.setTitle(recipe.title);
            view.setDescription(recipe.description);
            view.setFavorite(favorites.get(recipe.id)); // Get from favorites the value of a recipe
        }
    }

    public void toggleFavorite() {
        boolean result = favorites.toggle(recipe.id);

        // Update the UI by setting the state as favorite or not
        view.setFavorite(result);
    }
}
