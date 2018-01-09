package com.thedancercodes.tutorial.recipes.ui.recipe;

/**
 * Created by TheDancerCodes on 09/01/2018.
 */

public interface RecipeContract {

    // View contract allows the Presenter to talk to the View
    interface View {
        void showRecipeNotFoundError();
        void setTitle(String title);
        void setDescription(String description);
        void setFavorite(boolean favorite);
    }

    // Listener contract allows the Presenter to talk to the View.
    interface Listener {

    }
}
