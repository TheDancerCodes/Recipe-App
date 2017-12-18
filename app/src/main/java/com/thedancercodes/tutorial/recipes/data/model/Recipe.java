package com.thedancercodes.tutorial.recipes.data.model;

import java.io.InputStream;

/**
 * Created by nabwera on 15/12/2017.
 */

public class Recipe {

    public final String id;
    public final String title;
    public final String description;


    // The constructor should be private because we are making a static factory method to parse
    // the recipe and create it.
    private Recipe(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }


    /**
     * The static method is `readFromStream`
     *
     *
     * IDEA:
     *   1) Read from the input stream,
     *   2) Parse all the text,
     *   3) Assign them into fields: id, title and description
     *   4) Create a Recipe with the private constructor
      */
    public static Recipe readFromStream(InputStream stream) {
        // Initialize local variables
        String id = null;
        String title = null;
        StringBuilder descStringBuilder = new StringBuilder();

        return new Recipe(id, title, descStringBuilder.toString());
    }
}
