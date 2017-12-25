package com.thedancercodes.tutorial.recipes.data.local;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by TheDancerCodes on 25/12/2017.
 */

public class SharedPreferencesFavorites {
    private final SharedPreferences pref;

    public SharedPreferencesFavorites(Context context) {
        pref = context.getSharedPreferences("favorites.xml", Context.MODE_PRIVATE);
    }

    // GET -> To retrieve what was previously stored
    public boolean get(String id) {
        return pref.getBoolean(id, false);
    }

    // PUT -> To store a new value
    public void put(String id, boolean favorite) {
        SharedPreferences.Editor editor = pref.edit();

        if (favorite) {
            editor.putBoolean(id, true);
        } else {
            editor.remove(id);
        }
        editor.apply();
    }

    // TOGGLE -> A convenience method that retrieves the old value, flip it for true to false or
    // vice versa, put it inside the store & then return the value so that we can display it.
    public boolean toggle(String id) {
        boolean favorite = get(id);
        put(id, !favorite);
        return !favorite;
    }
}
