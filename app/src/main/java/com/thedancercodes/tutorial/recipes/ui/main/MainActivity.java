package com.thedancercodes.tutorial.recipes.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.thedancercodes.tutorial.recipes.R;
import com.thedancercodes.tutorial.recipes.data.local.RecipeStore;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hook up the RecyclerView in MainActivity to display Recipes
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recipes);

        // Recipe Store that we can use in the Adapter
        RecipeStore store = new RecipeStore(this, "recipes");

        // Create Adapter and set it to the RecyclerView
        RecipeAdapter adapter = new RecipeAdapter(store);
        recyclerView.setAdapter(adapter);

        // FixedSize means each item has the same width and height
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}