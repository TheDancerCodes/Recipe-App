package com.thedancercodes.tutorial.recipes.data.local;

/**
 * Created by TheDancerCodes on 26/12/2017.
 */

public interface Favorites {

    // Add the signature for get and toggle
    boolean get(String id);
    boolean toggle(String id);
}
