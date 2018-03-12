package com.example.pprietom.restaurantmvp.restaurant;

import com.example.pprietom.restaurantmvp.R;

/**
 * Created by Pabel on 09/03/2018.
 **/

public class RestaurantPresenterImp implements RestaurantPresenter {

    /*****VARIABLES******/
    //region Variables
    private BossRestaurantView bossRestaurantView;
    private RestaurantInteractor restaurantInteractor;
    //endregion

    RestaurantPresenterImp(BossRestaurantView bossRestaurantView) {
        this.bossRestaurantView = bossRestaurantView;
        this.restaurantInteractor = new RestaurantInteractorImp();
    }

    @Override
    public void bookYourFood(String s) {
        //If the booking of the food send the error to de interface and return
        if (!checkBookFoodIsCorrect(s)) {
            returnError(s);
            return;
        }

        restaurantInteractor.cookFood(s, new RestaurantInteractor.ResultFoodBookedListener() {
            @Override
            public void foodBookedIsCorrect(int foodCooked) {
                bossRestaurantView.setRecipeCooked(foodCooked);
            }

            @Override
            public void foodBookedIsWrong(int foodNotCooked) {
                bossRestaurantView.setRecipeError(foodNotCooked);
            }
        });
    }


    /*+++++++++++++Axuliar+++++++++++*/
    //region

    /**
     * This method ckeck that there are a minim food for cook
     *
     * @param bookFood get from the Editext food that user had writen
     * @return if is correct the booking
     */
    private boolean checkBookFoodIsCorrect(String bookFood) {
        return numberOfWords(bookFood) > 1;
    }

    /**
     * This method set the response Error on the Interface
     *
     * @param s string that have writen the user.
     */
    private void returnError(String s) {
        if (numberOfWords(s) == 0) {
            bossRestaurantView.setEditextEmptyError(R.string.error_sentence_empty);
        } else {
            bossRestaurantView.setRecipeError(R.string.error_words);
        }
    }

    /**
     * This method return the number of words of a sentence
     * TODO ¿Could be a Extension of String in kt?
     */
    private int numberOfWords(String sentence) {
        String trim = sentence.trim();
        if (trim.isEmpty())
            return 0;
        return trim.split("\\s+").length;
    }
    //endregion
}
