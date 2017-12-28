package com.thedancercodes.tutorial.recipes.test;

import android.support.annotation.StringRes;
import android.support.test.rule.ActivityTestRule;

import com.thedancercodes.tutorial.recipes.R;

/**
 * Created by TheDancerCodes on 28/12/2017.
 */

public class RecipeRobot extends ScreenRobot<RecipeRobot> {

    // Launch an activity without an intent
    public RecipeRobot launch(ActivityTestRule rule) {
        rule.launchActivity(null);
        return this;
    }

    // Verify that the title view is hidden
    public RecipeRobot noTitle() {
        return checkIsHidden(R.id.title);
    }

    public RecipeRobot description(@StringRes int stringId) {
        return checkViewHasText(R.id.description, stringId);
    }
}
