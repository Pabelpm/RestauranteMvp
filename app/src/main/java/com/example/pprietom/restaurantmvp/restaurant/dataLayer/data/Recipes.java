
package com.example.pprietom.restaurantmvp.restaurant.dataLayer.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

public class Recipes implements Serializable
{

    @SerializedName("recipes")
    @Expose
    private List<Recipe> recipes = null;
    private final static long serialVersionUID = -759828342517461937L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Recipes() {
    }

    /**
     * 
     * @param recipes
     */
    public Recipes(List<Recipe> recipes) {
        super();
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("recipes", recipes).toString();
    }

}
