package com.thedancercodes.tutorial.recipes.ui.recipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.thedancercodes.tutorial.recipes.R;
import com.thedancercodes.tutorial.recipes.data.local.Favorites;
import com.thedancercodes.tutorial.recipes.data.local.RecipeStore;
import com.thedancercodes.tutorial.recipes.data.local.SharedPreferencesFavorites;
import com.thedancercodes.tutorial.recipes.data.model.Recipe;
import com.thedancercodes.tutorial.recipes.injection.RecipeApplication;

/**
 * Created by TheDancerCodes on 21/12/2017.
 */

public class RecipeActivity extends AppCompatActivity implements RecipeContract.View {

    // Constant used to extract the value of the ID out of the intent in RecipeAdapter
    public static final String KEY_ID = "id";
    private TextView titleView;
    private TextView descriptionView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // TODO: (Step 1) Set up the UI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        // Find the views to display the title and the description.
        titleView = (TextView) findViewById(R.id.title);
        descriptionView = (TextView) findViewById(R.id.description);

        // TODO: (Step 2) Load recipe from store [DONE!]
        // GOAL: Retrieve the recipe from the store

        // Create a recipe store
        RecipeStore store = new RecipeStore(this, "recipes");

        // Retrieve from the store the ID that got passed in; Get the ID out of the intent
        String id = getIntent().getStringExtra(KEY_ID);

        // Retrieve recipe out of the store
        RecipePresenter presenter = new RecipePresenter(store, this);
        presenter.loadRecipe(id);

        // TODO: (Step 3) If recipe is null, show error. This is done in the Presenter. [DONE!]

        // TODO: (Step 4) If Recipe is not null, show recipe
        // Retrieve the Application
        RecipeApplication app = (RecipeApplication) getApplication();

        // Hooking up SharedPreferencesFavorites to the UI
        final Favorites favorites = app.getFavorites();

        // Receive from this favorites the value of our particular recipe
        boolean favorite = favorites.get(recipe.id);


        // Set title and description
        titleView.setText(recipe.title);
        titleView.setSelected(favorite);
        descriptionView.setText(recipe.description);

        // TODO: (Step 5) when title is clicked, toggle favorites
        // Set OnClickListener to toggle the favorite/ not favorite status
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = favorites.toggle(recipe.id);

                // Update the UI
                titleView.setSelected(result);
            }
        });

    }

    @Override
    public void showRecipeNotFoundError() {
        titleView.setVisibility(View.GONE);
        descriptionView.setText(R.string.recipe_not_found);
    }
}
