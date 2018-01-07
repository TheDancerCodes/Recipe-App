package com.thedancercodes.tutorial.recipes.test;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.thedancercodes.tutorial.recipes.R;
import com.thedancercodes.tutorial.recipes.data.local.InMemoryFavorites;
import com.thedancercodes.tutorial.recipes.injection.TestRecipeApplication;
import com.thedancercodes.tutorial.recipes.ui.recipe.RecipeActivity;

import org.junit.Before;

/**
 * Created by TheDancerCodes on 28/12/2017.
 */

public class RecipeRobot extends ScreenRobot<RecipeRobot> {

    private final InMemoryFavorites favorites;

    public RecipeRobot() {
        TestRecipeApplication app = (TestRecipeApplication)
                InstrumentationRegistry.getTargetContext().getApplicationContext();

        // Initialize favorites
        favorites = (InMemoryFavorites) app.getFavorites();

        favorites.clear();
    }

    // Launch an activity without an intent
    public RecipeRobot launch(ActivityTestRule rule) {
        rule.launchActivity(null);
        return this;
    }

    // Launch an activity with an intent
    public RecipeRobot launch(ActivityTestRule rule, String id) {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, id);
        rule.launchActivity(intent);
        return this;
    }

    // Verify that the title view is hidden
    public RecipeRobot noTitle() {
        return checkIsHidden(R.id.title);
    }

    public RecipeRobot description(@StringRes int stringId) {
        return checkViewHasText(R.id.description, stringId);
    }

    public RecipeRobot setFavorite(String id) {
        favorites.put(id, true);
        return this;
    }

    public RecipeRobot isFavorite() {
        return checkIsSelected(R.id.title);
    }
}
