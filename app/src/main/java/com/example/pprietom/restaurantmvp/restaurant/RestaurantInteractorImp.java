package com.example.pprietom.restaurantmvp.restaurant;

import com.example.pprietom.restaurantmvp.R;
import com.example.pprietom.restaurantmvp.Recipes;

/**
 * Created by Pabel on 09/03/2018.
 **/

public class RestaurantInteractorImp implements RestaurantInteractor {

    /**
     * This method return the recipe for your peticion
     * @param cookFood  the name of recipe that you want
     * @param resultFoodBookedListener return the value
     */
    @Override
    public void cookFood(String cookFood, ResultFoodBookedListener resultFoodBookedListener) {

        switch (cookFood){
            case Recipes.HUEVOS_ROTOS:
                resultFoodBookedListener.foodBookedIsCorrect(R.string.recipe_huevos_rotos);
                break;
            default:
                resultFoodBookedListener.foodBookedIsWrong(R.string.recipe_not_exits);
        }
    }
}
