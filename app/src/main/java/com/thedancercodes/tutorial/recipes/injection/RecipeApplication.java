package com.thedancercodes.tutorial.recipes.injection;

import android.app.Application;

import com.thedancercodes.tutorial.recipes.data.local.Favorites;
import com.thedancercodes.tutorial.recipes.data.local.SharedPreferencesFavorites;

/**
 * Created by TheDancerCodes on 26/12/2017.
 */

public class RecipeApplication extends Application {
    private Favorites favorites = null;

    // This function will return a latently-initialised SharedPreferencesFavorites
    // NB: This way it is only going to be initialised when someone uses it.
    public Favorites getFavorites() {
        // Initialize favorites variable if null
        if (favorites == null) {
            favorites = new SharedPreferencesFavorites(this);
        }
        return favorites;
    }
}
