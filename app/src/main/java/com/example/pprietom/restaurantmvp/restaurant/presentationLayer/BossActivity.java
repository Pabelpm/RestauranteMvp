package com.example.pprietom.restaurantmvp.restaurant.presentationLayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pprietom.restaurantmvp.R;
import com.google.firebase.FirebaseApp;


public class BossActivity extends AppCompatActivity implements BossView {
    private static final String TAG = BossActivity.class.getSimpleName();

    /*****VARIABLES******/
    //region Variables
    private EditText ed_food_like_want;
    private TextView tv_food_cooked;

    private Button bt_subscription_book_your_food;

    private RestaurantPresenterInterface restaurantPresenterInterface;
    //endregion

    /*****LIFE CYCLE******/
    //region Life Cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        getReferences(); //Todo Buternkife and then with kt is not necesary
        FirebaseApp.initializeApp(this);

        restaurantPresenterInterface = new RestaurantPresenter(this);
    }
    //endregion

    /******ON CLICKS******/

    //endregion


    /*********ACCESS VIEW**********/
    //region
    @Override
    public void setRecipeCooked(String recipeCooked) {
        tv_food_cooked.setText(recipeCooked);
    }

    @Override
    public void setRecipeError(int recipeError) {
        tv_food_cooked.setText(getString(recipeError));
    }

    @Override
    public void setEditextEmptyError(int recipeError) {
        ed_food_like_want.setError(getString(recipeError));
    }

    @Override
    public View getFoodButton() {
        return bt_subscription_book_your_food;
    }

    @Override
    public String getTextFromEditext() {
        Log.e(TAG, "saco el valor del editext "+ ed_food_like_want.getText().toString() );
        return ed_food_like_want.getText().toString();
    }


    //endRegion

    /******AUXILIAR ******/
    //region Auxiliar
    private void getReferences() {
        ed_food_like_want = (EditText) findViewById(R.id.ed_food_like_want);
        tv_food_cooked = (TextView) findViewById(R.id.tv_food_cooked);
        bt_subscription_book_your_food = (Button) findViewById(R.id.bt_book_your_food);
    }
    //endregion
}
