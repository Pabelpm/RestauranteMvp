package com.example.pprietom.restaurantmvp.restaurant.dataLayer;

import com.example.pprietom.restaurantmvp.restaurant.dataLayer.data.Recipes;

import io.reactivex.Observable;

/**
 * Created by Pabelpm on 12/03/2018.
 **/

public interface RepositoryInterface {
    Observable<Recipes> getRecipesFromFirebase(String foodbooked);
}
