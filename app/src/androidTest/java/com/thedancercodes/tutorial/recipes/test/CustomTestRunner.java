package com.thedancercodes.tutorial.recipes.test;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import com.thedancercodes.tutorial.recipes.injection.TestRecipeApplication;

/**
 * Created by TheDancerCodes on 27/12/2017.
 */

public class CustomTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws
            InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, TestRecipeApplication.class.getName(), context);
    }
}
