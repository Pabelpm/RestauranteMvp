package com.example.pprietom.restaurantmvp.restaurant;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pprietom.restaurantmvp.R;

public class BossActivity extends AppCompatActivity implements BossRestaurantView, View.OnClickListener {
    static final String TAG = BossActivity.class.getSimpleName();

    /*****VARIABLES******/
    //region Variables
    private EditText ed_food_like_want;
    private TextView tv_food_cooked;

    private RestaurantPresenter restaurantPresenter;
    //endregion

    /*****LIFE CYCLE******/
    //region Life Cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        getReferences(); //Todo Buternkife and then with kt is not necesary

        restaurantPresenter = new RestaurantPresenterImp(this);
    }
    //endregion

    /******ON CLICKS******/
    //region OnClicks
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_book_your_food:
                restaurantPresenter.bookYourFood(ed_food_like_want.getText().toString());
                break;

            default:
                Snackbar.make(getWindow().getDecorView().getRootView(), "Click not detected", Snackbar.LENGTH_LONG).show();
        }
    }

    //endregion

    /*********ACCESS VIEW**********/
    //region
    @Override
    public void setRecipeCooked(int recipeCooked) {
        tv_food_cooked.setText(getString(recipeCooked));
    }

    @Override
    public void setRecipeError(int recipeError) {
        tv_food_cooked.setText(getString(recipeError));
    }

    @Override
    public void setEditextEmptyError(int recipeError) {
        ed_food_like_want.setError(getString(recipeError));
    }
    //endRegion

    /******AUXILIAR ******/
    //region Auxiliar
    private void getReferences() {
        ed_food_like_want = (EditText) findViewById(R.id.ed_food_like_want);
        tv_food_cooked = (TextView) findViewById(R.id.tv_food_cooked);
        findViewById(R.id.bt_book_your_food).setOnClickListener(this);
    }
    //endregion
}
