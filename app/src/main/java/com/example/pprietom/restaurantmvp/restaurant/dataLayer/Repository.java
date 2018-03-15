package com.example.pprietom.restaurantmvp.restaurant.dataLayer;

import android.util.Log;

import com.example.pprietom.restaurantmvp.restaurant.dataLayer.data.Recipes;
import com.example.pprietom.restaurantmvp.restaurant.dataLayer.data.RxFirebaseDataException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.reactivex.Observable;

/**
 * Created by Pabel on 12/03/2018.
 **/

public class Repository implements RepositoryInterface {
    private static final String TAG = Repository.class.getSimpleName();

    @Override
    public Observable<Recipes> getRecipesFromFirebase(String foodBooked) {
        return Observable.create(subscriber -> {
            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
            // Read from the database
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    Recipes recipes = dataSnapshot.getValue(Recipes.class);
                    Log.d(TAG, "Value is: " + recipes);
                    if (!subscriber.isDisposed()) {
                        subscriber.onNext(recipes);
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                    if (!subscriber.isDisposed()) {
                        subscriber.onError(new RxFirebaseDataException(error));
                    }
                }
            });
        });
    }
}