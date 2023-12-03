package com.ocem.foodieexpress.Activity;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.adapter.CartListAdapter;
import com.ocem.foodieexpress.model.Cart.CartItem;
import com.ocem.foodieexpress.model.Cart.CartResponse;
import com.ocem.foodieexpress.remote.APIUtil;
import com.ocem.foodieexpress.remote.FoodieService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class My_Cart extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<CartItem> cartItemList = new ArrayList<>();
    private CartListAdapter cartListAdapter;
    private FoodieService foodieService;
    private String token;
    private TextView tvSubtotal, tvDeliveryPrice, tvTaxPrice, tvTotalPrice;
    private Button btnConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);


        recyclerView = findViewById(R.id.cart_recyclerView);
        tvSubtotal = findViewById(R.id.tvsubprice);
        tvDeliveryPrice = findViewById(R.id.tvdeliveryprice);
        tvTaxPrice = findViewById(R.id.tvtaxprice);
        tvTotalPrice = findViewById(R.id.tvtotalprice);


        SharedPreferences sharedPreferences = getSharedPreferences("LOGIN", MODE_PRIVATE);
        token = sharedPreferences.getString("TOKEN", "");

        foodieService = APIUtil.getFoodieService();

        new FetchCartItemsTask().execute();

        btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCart();
            }
        });

    }
    // AsyncTask to fetch cart items in the background
    private class FetchCartItemsTask extends AsyncTask<Void, Void, Void> {
        private String errorMessage;

        @Override
        protected Void doInBackground(Void... voids) {
            Call<CartResponse> cartDataCall = foodieService.getCartData("Bearer " + token);
            cartDataCall.enqueue(new Callback<CartResponse>() {
                @Override
                public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                    if (response.isSuccessful()) {
                        CartResponse cartResponse = response.body();
                        cartItemList = new ArrayList<>(cartResponse.getData().getCartItems());
                        calculateAndDisplayPrices();
                        setupRecyclerView();
                    } else {
                        errorMessage = "Failed to fetch cart data";
                    }
                }

                @Override
                public void onFailure(Call<CartResponse> call, Throwable t) {
                    errorMessage = "Network Error";
                }
            });
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (errorMessage != null) {
                Toast.makeText(My_Cart.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setupRecyclerView() {
        cartListAdapter = new CartListAdapter(cartItemList, getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cartListAdapter);
    }
    private void calculateAndDisplayPrices() {
        double subtotal = 0;
        for (CartItem cartItem : cartItemList) {
            subtotal += Double.parseDouble(cartItem.getPrice()) * cartItem.getQuantity();
        }

        double deliveryCharge = 100;
        double taxPercentage = 0.13; // 15% VAT

        double tax = subtotal * taxPercentage;
        double total = subtotal + deliveryCharge + tax;

        tvSubtotal.setText(String.format("Rs %.2f", subtotal));
        tvDeliveryPrice.setText(String.format("Rs %.2f", deliveryCharge));
        tvTaxPrice.setText(String.format("Rs %.2f", tax));
        tvTotalPrice.setText(String.format("Rs %.2f", total));
    }
    private void clearCart() {
        cartItemList.clear();
        cartListAdapter.notifyDataSetChanged(); // Notify the adapter that data has changed
        calculateAndDisplayPrices(); // Recalculate and update the prices
    }
}


















//package com.ocem.foodieexpress.Activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import com.ocem.foodieexpress.R;
//import com.ocem.foodieexpress.adapter.CartListAdapter;
//import com.ocem.foodieexpress.domain.CartItem;
//
//import java.util.ArrayList;
//
//public class My_Cart extends AppCompatActivity {
//
//    private RecyclerView recyclerview;
//
//    private ArrayList<CartItem> cartItemList = new ArrayList<>();
//
//    private CartListAdapter cartListAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_cart);
//
//        cartItemList = new ArrayList<>();
//
//        recyclerview = findViewById(R.id.cart_recyclerView);
//
//        Intent intent = getIntent();
//        String productName = intent.getStringExtra("productName");
//        String restaurantName = intent.getStringExtra("restaurantName");
//        String price = intent.getStringExtra("price");
//        String quantity = intent.getStringExtra("quantity");
//
//        CartItem cartItem = new CartItem("oreomilkshake", productName, restaurantName, "+", "-", quantity, price);
//
//        cartItemList.add(cartItem);
//
//        cartListAdapter = new CartListAdapter(cartItemList, getApplicationContext());
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerview.setLayoutManager(layoutManager);
//        recyclerview.setAdapter(cartListAdapter);
//
////        cartItemList = new ArrayList<>();
////        recyclerview = findViewById(R.id.cart_recyclerView);
//
////        setCategoryinfo();
//        setAdapter();
//    }
//
//    private void setAdapter() {
//        cartListAdapter  = new CartListAdapter(cartItemList,getApplicationContext());
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerview.setLayoutManager(layoutManager);
//        recyclerview.setAdapter(cartListAdapter);
//    }
////
////    private void setCategoryinfo() {
////        cartItemList.add(new CartItem("oreomilkshake","Oreo MilkShake",
////                "Mimosa Pizza","+","-","1","Nrs 350"));
////    }
//}
























//package com.ocem.foodieexpress.Activity;
//
//import android.os.Bundle;
//import android.widget.TextView;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import com.ocem.foodieexpress.R;
//import com.ocem.foodieexpress.adapter.CartListAdapter;
//import com.ocem.foodieexpress.model.Cart.CartItem;
//
//import java.util.ArrayList;
//
//public class My_Cart extends AppCompatActivity {
//
//    private RecyclerView recyclerView;
//    private CartListAdapter cartListAdapter;
//    private ArrayList<CartItem> cartItemList;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_cart);
//
//        cartItemList = new ArrayList<>();
//        recyclerView = findViewById(R.id.cart_recyclerView);
//
//        // Retrieve data from the previous activity
//        String productName = getIntent().getStringExtra("productName");
//        String restaurantName = getIntent().getStringExtra("restaurantName");
//        String price = getIntent().getStringExtra("price");
//        String quantityStr = getIntent().getStringExtra("quantity");
//
//        double itemPrice = Double.parseDouble(price);
//        int itemQuantity = Integer.parseInt(quantityStr);
//        double itemSubtotal = itemPrice * itemQuantity;
//
//        // Create a CartItem and add it to the list
//        CartItem cartItem = new CartItem(productName, restaurantName, price, "+", "-", itemQuantity, String.valueOf(itemSubtotal));
//        cartItemList.add(cartItem);
//
//        cartListAdapter = new CartListAdapter(cartItemList, this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(cartListAdapter);
//
//        // Calculate and display subtotal, tax, and total
//        double subtotal = calculateSubtotal(cartItemList);
//        double vatRate = 0.15; // 15% VAT rate
//        double tax = subtotal * vatRate;
//        double total = subtotal + tax;
//
//        TextView tvSubtotal = findViewById(R.id.tvsubprice);
//        TextView tvTaxPrice = findViewById(R.id.tvtaxprice);
//        TextView tvTotalPrice = findViewById(R.id.tvtotalprice);
//
//        tvSubtotal.setText("Subtotal: $" + String.format("%.2f", subtotal));
//        tvTaxPrice.setText("VAT (15%): $" + String.format("%.2f", tax));
//        tvTotalPrice.setText("Total: $" + String.format("%.2f", total));
//    }
//
//    private double calculateSubtotal(ArrayList<CartItem> cartItems) {
//        double subtotal = 0.0;
//        for (CartItem item : cartItems) {
//            subtotal += Double.parseDouble(item.getTotal());
//        }
//        return subtotal;
//    }
//}
//
//
//
//
//
//
//
////package com.ocem.foodieexpress.Activity;
////
////import androidx.appcompat.app.AppCompatActivity;
////import androidx.recyclerview.widget.LinearLayoutManager;
////import androidx.recyclerview.widget.RecyclerView;
////
////import android.content.Intent;
////import android.os.Bundle;
////import android.widget.TextView;
////
////import com.ocem.foodieexpress.R;
////import com.ocem.foodieexpress.adapter.CartListAdapter;
////import com.ocem.foodieexpress.domain.CartItem;
////import com.ocem.foodieexpress.model.Cart.CartItem;
////
////import java.util.ArrayList;
////
////public class My_Cart extends AppCompatActivity {
////
////    private RecyclerView recyclerview;
////
////    private ArrayList<CartItem> cartItemList;
////
////    private CartListAdapter cartListAdapter;
////
////
////
////
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_my_cart);
////
////        cartItemList = new ArrayList<>();
////
////        recyclerview = findViewById(R.id.cart_recyclerView);
////
////
////        Intent intent = getIntent();
////        String productName = intent.getStringExtra("productName");
////        String restaurantName = intent.getStringExtra("restaurantName");
////        String priceStr = intent.getStringExtra("price");
////        String quantityStr = intent.getStringExtra("quantity");
////
////        double price = Double.parseDouble(priceStr);
////        int quantity = Integer.parseInt(quantityStr);
////
////        double total = price * quantity;
////
////        CartItem cartItem = new CartItem("oreomilkshake", productName, restaurantName, "+", "-", quantityStr, priceStr, total);
////
////        cartItemList.add(cartItem);
////
////        cartListAdapter = new CartListAdapter(cartItemList, getApplicationContext());
////        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
////        recyclerview.setLayoutManager(layoutManager);
////        recyclerview.setAdapter(cartListAdapter);
////
//////        cartItemList = new ArrayList<>();
//////        recyclerview = findViewById(R.id.cart_recyclerView);
////
////        double subtotal = calculateSubtotal(cartItemList);
////        TextView tvSubtotal = findViewById(R.id.tvsubprice);
////        tvSubtotal.setText("Subtotal: $" + String.format("%.2f", subtotal));
////
//////        setCategoryinfo();
//////        setAdapter();
////    }
////
////    private double calculateSubtotal(ArrayList<CartItem> cartItems) {
////        double subtotal = 0.0;
////        for (CartItem item : cartItems) {
////            subtotal += item.getTotalPrice();
////        }
////
////
//////    private void setAdapter() {
//////        cartListAdapter  = new CartListAdapter(cartItemList,getApplicationContext());
//////        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//////        recyclerview.setLayoutManager(layoutManager);
//////        recyclerview.setAdapter(cartListAdapter);
//////    }
////
//////    private void setCategoryinfo() {
//////        cartItemList.add(new CartItem("oreomilkshake","Oreo MilkShake",
//////                "Mimosa Pizza","+","-","1","Nrs 350"));
//////    }
////}