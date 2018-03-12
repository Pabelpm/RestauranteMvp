package com.example.pprietom.restaurantmvp.restaurant;

/**
 * Created by Pabel on 09/03/2018.
 **/

public interface RestaurantInteractorInterface {
    interface ResultFoodBookedListener {
        void foodBookedIsCorrect(int s);
        void foodBookedIsWrong(int s);

    }
    void cookFood(String cookFood, ResultFoodBookedListener resultFoodBookedListener);
}
