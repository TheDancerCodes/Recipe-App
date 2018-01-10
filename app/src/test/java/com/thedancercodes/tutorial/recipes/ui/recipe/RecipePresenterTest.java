package com.thedancercodes.tutorial.recipes.ui.recipe;

import com.thedancercodes.tutorial.recipes.data.local.Favorites;
import com.thedancercodes.tutorial.recipes.data.local.RecipeStore;
import com.thedancercodes.tutorial.recipes.data.model.Recipe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.InputStream;

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

    @Test
    public void loadWaterAndFavorite() {
        // Use getResourceAsStream -> to obtain an info stream for recipes/water.txt
        InputStream stream = RecipePresenterTest.class.getResourceAsStream("/recipes/water.txt");

        // Create a Recipe
        Recipe recipe = Recipe.readFromStream(stream);

        // ASSIGN -> Return a recipe object when getRecipe() function is called
        Mockito.when(store.getRecipe(Mockito.anyString())).thenReturn(recipe);

        // ASSIGN -> return true when toggleFavorite() is called, flipping from the default false.
        Mockito.when(favorites.toggle(Mockito.anyString())).thenReturn(true);

        // ACT -> Load the recipe with id "water"
        presenter.loadRecipe("water");

        // ACT -> Toggle recipe to a favorite
        presenter.toggleFavorite();

        // ASSERT -> Verify that Presenter calls setFavorite() on the view with the correct variable
        ArgumentCaptor<Boolean> captor = ArgumentCaptor.forClass(Boolean.class);

        // ASSERT -> Verify that the view setFavorite() function is called twice and
        // the values that we call it with is stored in the captor.
        Mockito.verify(view, Mockito.times(2)).setFavorite(captor.capture());

        // ASSERT -> Verify the values captured by the captor.
        // We started off as not favorite recipe, so it should be false.
        assertFalse(captor.getAllValues().get(0));

        // The second value captured by the captor is true because it happens after toggleFavorite()
        // is called and the Presenter would call setFavorite() with true to update the UI.
        assertTrue(captor.getAllValues().get(1));

    }
}