package com.thedancercodes.tutorial.recipes.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedancercodes.tutorial.recipes.R;
import com.thedancercodes.tutorial.recipes.data.local.RecipeStore;
import com.thedancercodes.tutorial.recipes.data.model.Recipe;

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
    public void onBindViewHolder(RecipeViewHolder holder, int position) {

        // Look in the Store, find the matching position of the Recipe and retrieve it
        final Recipe recipe = store.recipes.get(position);

        // Populate the ViewHolder
        holder.textView.setText(recipe.title);

    }

    @Override
    public int getItemCount() {
        return store.recipes.size();
    }
}
