package com.thedancercodes.tutorial.recipes.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedancercodes.tutorial.recipes.R;
import com.thedancercodes.tutorial.recipes.data.local.RecipeStore;
import com.thedancercodes.tutorial.recipes.data.model.Recipe;
import com.thedancercodes.tutorial.recipes.ui.recipe.RecipeActivity;

/**
 * Created by TheDancerCodes on 20/12/2017.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private final RecipeStore store;

    public RecipeAdapter(RecipeStore store) {

        // Assigning store to a field
        this.store = store;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Inflate a view for each of the items in the RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false);

        return new RecipeViewHolder(view);
    }

    // onBindViewHolder binds data to an inflated view
    @Override
    public void onBindViewHolder(final RecipeViewHolder holder, int position) {

        // Look in the Store, find the matching position of the Recipe and retrieve it
        final Recipe recipe = store.recipes.get(position);

        // Populate the ViewHolder
        holder.textView.setText(recipe.title);

        // Set onClickListener to launch Recipe Activity to display the recipe description
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Ensure RecipeActivity is launched with the proper Recipe ID
                Context context = holder.textView.getContext();
                Intent intent = new Intent(context, RecipeActivity.class);

                // Add Recipe ID to this intent
                intent.putExtra(RecipeActivity.KEY_ID, recipe.id);

                // Launch Activity
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return store.recipes.size();
    }
}
