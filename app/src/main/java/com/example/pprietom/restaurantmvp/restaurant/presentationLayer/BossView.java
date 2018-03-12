package com.example.pprietom.restaurantmvp.restaurant.presentationLayer;

/**
 * Created by Pabel on 09/03/2018.
 **/

public interface BossView {
    void setRecipeCooked(String recipeCooked);

    void setRecipeError(int recipeError);

    void setEditextEmptyError(int recipeError);
}
