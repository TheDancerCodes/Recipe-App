package com.thedancercodes.tutorial.recipes.ui.recipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.thedancercodes.tutorial.recipes.R;
import com.thedancercodes.tutorial.recipes.data.local.RecipeStore;
import com.thedancercodes.tutorial.recipes.data.model.Recipe;

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

        // Find the views to display the title and the description.
        TextView titleView = (TextView) findViewById(R.id.title);
        TextView descriptionView = (TextView) findViewById(R.id.description);

         // GOAL: Retrieve the recipe from the store

        // Create a recipe store
        RecipeStore store = new RecipeStore(this, "recipes");

        // Retrieve from the store the ID that got passed in; Get the ID out of the intent
        String id = getIntent().getStringExtra(KEY_ID);

        // Retrieve recipe out of the store
        Recipe recipe = store.getRecipe(id);

        // When we give it an invalid ID, the recipe will be null &
        // we need to make sure that we handle it properly.
        if (recipe == null) {
            titleView.setVisibility(View.GONE);
            descriptionView.setText(R.string.recipe_not_found);
            return;
        }

        // Set title and description
        titleView.setText(recipe.title);
        descriptionView.setText(recipe.description);
    }
}
