package com.thedancercodes.tutorial.recipes.ui.recipe;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.thedancercodes.tutorial.recipes.R;
import com.thedancercodes.tutorial.recipes.data.local.InMemoryFavorites;
import com.thedancercodes.tutorial.recipes.injection.TestRecipeApplication;

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
        activityRule.launchActivity(null);

        // Check that it shows 'recipe not found'
        onView(withId(R.id.description))
                .check(matches(withText(R.string.recipe_not_found)));

        // Check that that the title is not displayed
        onView(withId(R.id.title))
                .check(matches(not(isDisplayed())));
    }

    @Test
    public void clickToFavorite() {
        // To load a valid recipe, pass an intent to the ActivityRule
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, "creamed_carrots");
        activityRule.launchActivity(intent);

        // Verify that title view starts off with not selected, and
        // changes to selected when you click on it.
        onView(withId(R.id.title))
                .check(matches(withText("Creamed Carrots")))
                .check(matches(not(isSelected())))
                .perform(click())
                .check(matches(isSelected()));
    }

}