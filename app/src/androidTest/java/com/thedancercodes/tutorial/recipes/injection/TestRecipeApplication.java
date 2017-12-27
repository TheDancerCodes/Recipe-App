package com.thedancercodes.tutorial.recipes.injection;

import com.thedancercodes.tutorial.recipes.data.local.Favorites;
import com.thedancercodes.tutorial.recipes.data.local.InMemoryFavorites;

/**
 * Created by TheDancerCodes on 27/12/2017.
 */

public class TestRecipeApplication extends RecipeApplication {

    private final Favorites favorites = new InMemoryFavorites();

    @Override
    public Favorites getFavorites() {
        return favorites;
    }
}
