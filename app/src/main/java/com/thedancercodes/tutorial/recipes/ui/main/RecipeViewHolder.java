package com.thedancercodes.tutorial.recipes.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by TheDancerCodes on 20/12/2017.
 */

public class RecipeViewHolder extends RecyclerView.ViewHolder {
    public final TextView textView;

    public RecipeViewHolder(View itemView) {
        super(itemView);

        textView = (TextView) itemView;
    }
}
