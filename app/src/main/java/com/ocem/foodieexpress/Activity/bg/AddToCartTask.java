package com.ocem.foodieexpress.Activity.bg;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.ocem.foodieexpress.model.Cart.CartItem;
import com.ocem.foodieexpress.remote.FoodieService;

import retrofit2.Call;
import retrofit2.Response;

public class AddToCartTask extends AsyncTask<Void, Void, Boolean> {

    private Context context;
    private FoodieService foodieService;
    private String token;
    private int menuId;
    private String productName;
    private String restaurantName;
    private String price;
    private int quantity;

    public interface AddToCartCallback {
        void onAddToCartComplete(boolean success);
    }

    private AddToCartCallback callback;

    public AddToCartTask(Context context, FoodieService foodieService, String token, int menuId, String productName, String restaurantName, String price, int quantity, AddToCartCallback callback) {
        this.context = context;
        this.foodieService = foodieService;
        this.token = token;
        this.menuId = menuId;
        this.productName = productName;
        this.restaurantName = restaurantName;
        this.price = price;
        this.quantity = quantity;
        this.callback = callback;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            Call<Void> addToCartCall = foodieService.addToCart("Bearer " + token, menuId, productName, restaurantName, price, quantity);
            Response<Void> response = addToCartCall.execute();

            return response.isSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    protected void onPostExecute(Boolean successful) {
        if (callback != null) {
            callback.onAddToCartComplete(successful);
        }

//    @Override
//    protected void onPostExecute(Boolean successful) {
//        if (successful) {
//            // Item added successfully.
//            Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show();
//        } else {
//            // Handle different response status codes here.
//            Toast.makeText(context, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
//        }
    }
}
