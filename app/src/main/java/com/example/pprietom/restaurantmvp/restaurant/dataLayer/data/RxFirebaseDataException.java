package com.example.pprietom.restaurantmvp.restaurant.dataLayer.data;

import android.support.annotation.NonNull;

import com.google.firebase.database.DatabaseError;

/**
 * Created by Pabel on 15/03/2018.
 **/

public class RxFirebaseDataException extends Exception {

    protected DatabaseError error;

    public RxFirebaseDataException(@NonNull DatabaseError error) {
        this.error = error;
    }

    public DatabaseError getError() {
        return error;
    }

    @Override
    public String toString() {
        return "RxFirebaseDataException{" +
                "error=" + error +
                '}';
    }
}
