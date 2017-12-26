package com.thedancercodes.tutorial.recipes.data.local;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TheDancerCodes on 26/12/2017.
 */

public class InMemoryFavorites implements Favorites {

    // Using a HashMap to implement Favorites as an in-memory structure.
    private final Map<String, Boolean> map = new HashMap<>();

    @Override
    public boolean get(String id) {

        // Use the HashMap to retrieve some value for this ID out of our map.
        Boolean value = map.get(id);
        return value == null ? false : value;
    }

    @Override
    public boolean toggle(String id) {
        boolean value = get(id);
        map.put(id, !value);
        return !value;
    }

    public void put(String id, boolean value) {
        map.put(id, value);
    }
}
