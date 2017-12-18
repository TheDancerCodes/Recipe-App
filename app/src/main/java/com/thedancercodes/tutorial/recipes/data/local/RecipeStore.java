package com.thedancercodes.tutorial.recipes.data.local;

import android.content.Context;
import android.content.res.AssetManager;

import com.thedancercodes.tutorial.recipes.data.model.Recipe;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheDancerCodes on 18/12/2017.
 */

public class RecipeStore {
    // Recipes member variable
    public final List<Recipe> recipes = new ArrayList<>();

    public RecipeStore(Context context, String directory) {

        // Assigning getAssetStreams to a local variable
        List<InputStream> streams = getAssetStreams(context.getAssets(), directory);

        // Iterate through list of streams and create recipes
        for (InputStream stream : streams) {
            Recipe recipe = Recipe.readFromStream(stream);

            // Add to list of recipes if not null
            if (recipe != null) {
                recipes.add(recipe);
            }
        }
    }

    // Getting a list of input streams
    private static List<InputStream> getAssetStreams(AssetManager manager, String directory) {

        // Take the return value of the getFilenames helper function and assign it to a variable
        String[] filenames = getFilenames(manager, directory);

        // Initialize the List of input streams
        List<InputStream> streams = new ArrayList<>();

        // Loop through the filenames and try create recipes from each of them
        for (String filename : filenames) {

            // Create a file from the directory and filename
            File file = new File(directory, filename);

            // Pass File to the asset manager to get an input stream & use it in the return value
            try {
                InputStream stream = manager.open(file.getPath());
                if (stream != null) {
                    streams.add(stream);
                }
            } catch (IOException e) {
            }
        }

        // The list of input streams that we are returning
        return streams;
    }

    // Find all files with recipes
    private static String[] getFilenames(AssetManager manager, String directory) {
        // If the directory is null, we return an array containing nothing instead of null,
        // so that it doesn't crash
        if (directory == null) {
            return new String[0];
        }

        // Returns the list of Strings which contains all the files
        try {
            return manager.list(directory);
        } catch (IOException e) {
            return new String[0];
        }
    }
}
