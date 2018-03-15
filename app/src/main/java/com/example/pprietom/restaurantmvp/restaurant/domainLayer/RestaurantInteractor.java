package com.example.pprietom.restaurantmvp.restaurant.domainLayer;

import com.example.pprietom.restaurantmvp.restaurant.dataLayer.Repository;
import com.example.pprietom.restaurantmvp.restaurant.dataLayer.RepositoryInterface;
import com.example.pprietom.restaurantmvp.restaurant.dataLayer.data.Recipe;
import com.example.pprietom.restaurantmvp.restaurant.dataLayer.data.Recipes;
import com.example.pprietom.restaurantmvp.restaurant.presentationLayer.RestaurantPresenter;

/**
 * Created by Pabel on 09/03/2018.
 **/

public class RestaurantInteractor implements RestaurantInteractorInterface {

    private Repository repository;
    private RestaurantPresenter restaurantPresenter;

    public RestaurantInteractor(RestaurantPresenter restaurantPresenter) {
        this.restaurantPresenter = restaurantPresenter;
        repository = new Repository();
    }
}
