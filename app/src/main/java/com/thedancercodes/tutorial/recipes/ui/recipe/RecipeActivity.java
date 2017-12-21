package com.thedancercodes.tutorial.recipes.ui.recipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.thedancercodes.tutorial.recipes.R;

/**
 * Created by TheDancerCodes on 21/12/2017.
 */

public class RecipeActivity extends AppCompatActivity {

    // Constant used to extract the value of the ID out of the intent in RecipeAdapter
    public static final String KEY_ID = "id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }
}
