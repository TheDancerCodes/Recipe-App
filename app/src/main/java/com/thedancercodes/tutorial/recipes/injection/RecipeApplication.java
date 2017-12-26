package com.thedancercodes.tutorial.recipes.injection;

import android.app.Application;

import com.thedancercodes.tutorial.recipes.data.local.Favorites;
import com.thedancercodes.tutorial.recipes.data.local.SharedPreferencesFavorites;

/**
 * Created by TheDancerCodes on 26/12/2017.
 */

public class RecipeApplication extends Application {
    private Favorites favorites = null;

    public Favorites getFavorites() {
        // Initialize favorites variable if null
        if (favorites == null) {
            favorites = new SharedPreferencesFavorites(this);
        }
        return favorites;
    }
}
