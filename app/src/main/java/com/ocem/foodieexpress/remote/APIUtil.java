package com.ocem.foodieexpress.remote;

public class APIUtil {

    private static final String baseURL = "http://192.168.137.1:8000/api/";

    public static FoodieService getFoodieService(){
        return RetrofitClient.getClient().create(FoodieService.class);

    }
}


