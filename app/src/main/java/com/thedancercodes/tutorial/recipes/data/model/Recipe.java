package com.thedancercodes.tutorial.recipes.data.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by nabwera on 15/12/2017.
 */

public class Recipe {

    private static final String ID_PREFIX = "id=";
    private static final String TITLE_PREFIX = "title=";
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
     * <p>
     * <p>
     * IDEA:
     * 1) Read from the input stream,
     * 2) Parse all the text,
     * 3) Assign them into fields: id, title and description
     * 4) Create a Recipe with the private constructor
     */
    public static Recipe readFromStream(InputStream stream) {
        // Initialize local variables
        String id = null;
        String title = null;
        StringBuilder descStringBuilder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        // Read out of the reader line by line
        try {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {

                // checking that the line starts with the prefix `id=`
                if (line.startsWith(ID_PREFIX)) {
                    // We want to skip the whole prefix and extract the rest of the line
                    id = line.substring(ID_PREFIX.length());
                    continue;
                }

                // checking that the line starts with the prefix `title=`
                if (line.startsWith(TITLE_PREFIX)) {
                    // We want to skip the whole prefix and extract the rest of the line
                    title = line.substring(TITLE_PREFIX.length());
                    continue;
                }

                // By default, when readLine() is called, the trailing new line character "\n"
                // is stripped. So we need to put it back in.
                if (descStringBuilder.length() > 0) { // > 0 means it is not the first line
                    descStringBuilder.append("\n");
                }

                // Assign the value of the remaining lines into the descBuilder to be used in the description
                descStringBuilder.append(line);

            }
        } catch (IOException e) {
            // e.printStackTrace();
            return null;
        }


        return new Recipe(id, title, descStringBuilder.toString());
    }
}
