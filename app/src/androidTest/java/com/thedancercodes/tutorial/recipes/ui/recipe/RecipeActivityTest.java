package com.thedancercodes.tutorial.recipes.ui.recipe;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.thedancercodes.tutorial.recipes.R;
import com.thedancercodes.tutorial.recipes.data.local.InMemoryFavorites;
import com.thedancercodes.tutorial.recipes.injection.TestRecipeApplication;
import com.thedancercodes.tutorial.recipes.test.RecipeRobot;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * Created by TheDancerCodes on 26/12/2017.
 */
public class RecipeActivityTest {

    private static final String CARROTS_ID = "creamed_carrots";
    @Rule
    public ActivityTestRule<RecipeActivity> activityRule
            = new ActivityTestRule<>(RecipeActivity.class, true, false);

    private InMemoryFavorites favorites;

    @Before
    public void clearFavorites() {
        TestRecipeApplication app = (TestRecipeApplication)
                InstrumentationRegistry.getTargetContext().getApplicationContext();

        // Initialize favorites
        favorites = (InMemoryFavorites) app.getFavorites();

        favorites.clear();
    }


    @Test
    public void recipeNotFound() {
        // Launch an activity without an intent
        new RecipeRobot()
                .launch(activityRule)
                .noTitle()  // Check that that the title is not displayed
                .description(R.string.recipe_not_found);  // Check that it shows 'recipe not found'
    }

    // A test method to verify that when we click on the title, it will save it as favorite.
    @Test
    public void clickToFavorite() {

        launchRecipe(CARROTS_ID);

        // Verify that title view starts off with not selected, and
        // changes to selected when you click on it.
        onView(withId(R.id.title))
                .check(matches(withText("Creamed Carrots")))
                .check(matches(not(isSelected())))
                .perform(click())
                .check(matches(isSelected()));
    }

    // A test method for the case where a recipe is already a favorite.
    @Test
    public void alreadyFavorite() {

        favorites.put(CARROTS_ID, true);

        launchRecipe(CARROTS_ID);

        onView(withId(R.id.title))
                .check(matches(isSelected()));
    }

    private void launchRecipe(String id) {
        // To load a valid recipe, pass an intent to the ActivityRule
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, id);
        activityRule.launchActivity(intent);
    }

}