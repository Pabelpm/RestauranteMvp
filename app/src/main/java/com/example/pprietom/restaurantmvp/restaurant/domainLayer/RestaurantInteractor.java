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

    /**
     * This method return the recipe for your peticion
     *
     * @param cookFood the name of recipe that you want
     */
    @Override
    public void cookFood(final String cookFood) {
        RepositoryInterface.ResultGetRecipes resultGetRecipes = new RepositoryInterface.ResultGetRecipes() {
            @Override
            public void getRecipesIsCorrect(Recipes recipes) {
                restaurantPresenter.foodBookedResponse(thereIsTheRecipe(cookFood,recipes));
            }

            @Override
            public void getRecipesIsWrong(Recipes recipes) {
                restaurantPresenter.foodBookedResponse("We could not access the database");
            }
        };
        repository.getRecipesFromFirebase(resultGetRecipes);
    }

    private String thereIsTheRecipe(String cookFood, Recipes recipes){
        for (Recipe recipe : recipes.getRecipes()) {
            if(recipe.getName().equals(cookFood)){
                return recipe.getValue();
            }
        }
        return "Sorry we havent this recipe.";
    }
}
