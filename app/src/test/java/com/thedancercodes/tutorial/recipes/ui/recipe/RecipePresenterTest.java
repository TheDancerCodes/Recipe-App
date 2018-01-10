package com.thedancercodes.tutorial.recipes.ui.recipe;

import com.thedancercodes.tutorial.recipes.data.local.Favorites;
import com.thedancercodes.tutorial.recipes.data.local.RecipeStore;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by TheDancerCodes on 09/01/2018.
 */
public class RecipePresenterTest {

    // Declare variables
    private RecipeStore store;
    private Favorites favorites;
    private RecipeContract.View view;
    private RecipePresenter presenter;

    @Before
    public void setup() {

        // Instantiate/ setup RecipeStore, Favorites & RecipeContract.View objects
        store = Mockito.mock(RecipeStore.class);
        favorites = Mockito.mock(Favorites.class);
        view = Mockito.mock(RecipeContract.View.class);

        // Instantiate the Presenter object
        presenter = new RecipePresenter(store, view, favorites);
    }

    @Test
    public void recipeNotFound() {

        // ARRANGE -> Return a null object when getRecipe() function is called
        Mockito.when(store.getRecipe(Mockito.anyString())).thenReturn(null);

        // ACT -> Load the non-existent recipe
        presenter.loadRecipe("no_such_recipe");

        // ASSERT -> Verify that the showRecipeNotFound() error function is called.
        Mockito.verify(view, Mockito.times(1)).showRecipeNotFoundError();
    }

    // Test the toggleFavorite() function without loading a recipe first.
    @Test(expected = IllegalStateException.class)
    public void toggleWithoutLoad() {
        presenter.toggleFavorite();
    }
}