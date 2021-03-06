package com.thedancercodes.tutorial.recipes.test;

import android.support.annotation.IdRes;
import android.support.annotation.StringRes;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

/**
 * Created by TheDancerCodes on 28/12/2017.
 */

public abstract class ScreenRobot<T extends ScreenRobot> {
    public T checkIsHidden(@IdRes int... viewIds) { // The parameter is a list of IDs

        // Use for loop to check that each viewId is not displayed
        for (int viewId : viewIds) {
            onView(withId(viewId))
                    .check(matches(not(isDisplayed())));
        }

        // Return the robot itself to make it fluid
        return (T) this;
    }

    public T checkViewHasText(@IdRes int viewId, @StringRes int stringId) {
        onView(withId(viewId))
                .check(matches(withText(stringId)));
        return (T) this;
    }

    public T checkIsSelected(@IdRes int... viewIds) { // The parameter is a list of IDs

        // Use for loop to check that each viewId is selected
        for (int viewId : viewIds) {
            onView(withId(viewId))
                    .check(matches(isSelected()));
        }

        // Return the robot itself to make it fluid
        return (T) this;
    }
}
