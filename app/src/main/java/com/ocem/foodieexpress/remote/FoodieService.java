package com.ocem.foodieexpress.remote;

import com.ocem.foodieexpress.model.BestFood.BestFoodResponse;
import com.ocem.foodieexpress.model.Cart.CartItem;
import com.ocem.foodieexpress.model.Cart.CartResponse;
import com.ocem.foodieexpress.model.HomeBestOfferResponse;
import com.ocem.foodieexpress.model.HomeRestaurantResponse;
import com.ocem.foodieexpress.model.HomeSliderResponse;
import com.ocem.foodieexpress.model.Restaurant.RestaurantResponse;
import com.ocem.foodieexpress.model.RestaurantType;
import com.ocem.foodieexpress.model.EmailVerification;
import com.ocem.foodieexpress.model.ForgotPassword;
import com.ocem.foodieexpress.model.Login;
import com.ocem.foodieexpress.model.Register;
import com.ocem.foodieexpress.model.ResetPassword;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoodieService {

    @POST("login")
    Call<Login> validateUser(@Query("email") String email, @Query("password") String password);

    @POST("register")
    Call<Register> registerUser(@Query("name") String name, @Query("email") String email, @Query("password") String password);

    @POST("email-verification")
    Call<EmailVerification> verifyEmail(@Header("Authorization")String token,@Query("email") String email, @Query("otp") String otp);

    @POST("password/forget-password")
    Call<ForgotPassword> verifyGmail(@Query("email") String email);

    @POST("password/reset")
    Call<ResetPassword> resetPassword(@Query("email") String email,@Query("otp") String otp,@Query("password") String password);

    @GET("homeRestaurant/index")
    Call<HomeRestaurantResponse> getHomeRestaurantType();

    @GET("bestOffer/index")
    Call<HomeBestOfferResponse> getHomeBestOffer();

    @GET("restaurantType/index")
    Call<RestaurantType> getRestaurantType();

    @GET("restaurant/index")
    Call<RestaurantResponse> getRestaurant();

    @GET("getslider")
    Call<HomeSliderResponse> getslider();

    @GET("bestFood/index")
    Call<BestFoodResponse> getBestFood();

    @POST("cart/{menuId}")
    Call<Void> addToCart(@Header("Authorization") String authToken, @Path("menuId") int menuId,
                         @Query("productName") String productName, @Query("restaurantName") String restaurantName,
                         @Query("price") String price, @Query("quantity") int quantity);

    @GET("cart")
    Call<CartResponse> getCartData(@Header("Authorization") String authorization);
}

