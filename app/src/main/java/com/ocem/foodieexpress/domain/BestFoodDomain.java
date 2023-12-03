package com.ocem.foodieexpress.domain;

public class BestFoodDomain   {
    private String title;
    protected String pic;
    private String restaurant;

    public BestFoodDomain(String title, String pic, String restaurant) {
        this.title = title;
        this.pic = pic;
        this.restaurant = restaurant;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getPic(){
        return pic;
    }

    public void setPic(String pic){
        this.pic = pic;
    }

    public String getRestaurant(){
        return restaurant;
    }

    public void setRestaurant(String restaurant){
        this.restaurant = restaurant;
    }
}
