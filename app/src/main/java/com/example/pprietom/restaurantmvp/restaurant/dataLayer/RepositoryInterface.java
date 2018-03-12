package com.example.pprietom.restaurantmvp.restaurant.dataLayer;

import com.example.pprietom.restaurantmvp.restaurant.dataLayer.data.Recipes;

/**
 * Created by Pabelpm on 12/03/2018.
 **/

public interface RepositoryInterface {
    void getRecipesFromFirebase(ResultGetRecipes resultGetRecipes);
    interface ResultGetRecipes {
        void getRecipesIsCorrect(Recipes recipes);
        void getRecipesIsWrong(Recipes recipes);
    }
}
