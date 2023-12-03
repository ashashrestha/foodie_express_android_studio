package com.ocem.foodieexpress.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodieResponse {
    @SerializedName("foodie")
    @Expose
    private List<Foodie> foodie;

    public List<Foodie> getFoodie(){
        return foodie;
    }
    public void setFoodie(List<Foodie>foodie){
        this.foodie = foodie;
    }
}
