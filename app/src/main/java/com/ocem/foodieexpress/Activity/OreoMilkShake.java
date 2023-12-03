package com.ocem.foodieexpress.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ocem.foodieexpress.Activity.bg.AddToCartTask;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.model.Cart.CartItem;
import com.ocem.foodieexpress.remote.FoodieService;
import com.ocem.foodieexpress.remote.RetrofitClient;

public class OreoMilkShake extends AppCompatActivity {
    private TextView tvOreo, tvMP, OreoOfferP;
    ImageView minus, plus, mimosapizza, mimosalogo;
    TextView tvquantity;

    Button addToCart;
    private FoodieService foodieService;
    private String token;
    private int menuId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oreo_milk_shake);

        // Initialize your views
        tvOreo = findViewById(R.id.tvOreo);
        tvMP = findViewById(R.id.tvMP);
        mimosapizza = findViewById(R.id.mimosapizza);
        OreoOfferP = findViewById(R.id.OreoOfferP);
        mimosalogo = findViewById(R.id.mimosalogo);
//        minus = findViewById(R.id.minus);
//        plus = findViewById(R.id.plus);
//        tvquantity = findViewById(R.id.tvQuantity);
//        addToCart = findViewById(R.id.btAddtocart);

        String title = getIntent().getStringExtra("title");
        String restaurant = getIntent().getStringExtra("restaurant");
        String imagePath = getIntent().getStringExtra("imagePath");
        String price = getIntent().getStringExtra("price");
        String logoPath = getIntent().getStringExtra("logoPath");
        menuId = getIntent().getIntExtra("menuId", 0);

        tvOreo.setText(title);
        tvMP.setText(restaurant);
        OreoOfferP.setText(price);

        Glide.with(this)
                .load("http://192.168.137.1:8000/images/" + imagePath)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(mimosapizza);

        Glide.with(this)
                .load("http://192.168.137.1:8000/images/" + logoPath)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(mimosalogo);

        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        tvquantity = findViewById(R.id.tvQuantity);
        addToCart = findViewById(R.id.btAddtocart);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentValue = tvquantity.getText().toString();
                int value = Integer.parseInt(currentValue);
                value++;
                tvquantity.setText(String.valueOf(value));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentValue = tvquantity.getText().toString();
                int value = Integer.parseInt(currentValue);
                value--;
                tvquantity.setText(String.valueOf(value));
            }
        });


        foodieService = RetrofitClient.getClient().create(FoodieService.class);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = tvOreo.getText().toString();
                String restaurantName = tvMP.getText().toString();
                String price = OreoOfferP.getText().toString();
                int quantity = Integer.parseInt(tvquantity.getText().toString());

                SharedPreferences sharedPreferences = getSharedPreferences("LOGIN", MODE_PRIVATE);
                token = sharedPreferences.getString("TOKEN", "");

                CartItem cartItem = new CartItem();
                cartItem.setMenuName(productName);
                cartItem.setRestaurantName(restaurantName);
                cartItem.setPrice(price);
                cartItem.setQuantity(quantity);


                AddToCartTask addToCartTask = new AddToCartTask(OreoMilkShake.this, foodieService, token, menuId, productName, restaurantName, price, quantity, new AddToCartTask.AddToCartCallback() {
                    @Override
                    public void onAddToCartComplete(boolean success) {
                        if (success) {
                            Toast.makeText(OreoMilkShake.this, "Added to Cart", Toast.LENGTH_SHORT).show();

                            Intent myCartIntent = new Intent(OreoMilkShake.this, My_Cart.class);
                            myCartIntent.putExtra("token", token);
                            startActivity(myCartIntent);
                        } else {
                            Toast.makeText(OreoMilkShake.this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                addToCartTask.execute();
            }
        });
//        ImageView imageView = findViewById(R.id.leftarrow);
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        }
    }
}





















//package com.ocem.foodieexpress.Activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.SpannableString;
//import android.text.style.StrikethroughSpan;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.bumptech.glide.Glide;
//import com.ocem.foodieexpress.R;
//import com.ocem.foodieexpress.fragment.HomeFragment;
//import com.ocem.foodieexpress.model.BestFood.BestFood;
//
//public class OreoMilkShake extends AppCompatActivity {
//    private TextView tvOreo,tvMP,OreoOfferP;
//    ImageView minus,plus,mimosapizza,mimosalogo;
//    TextView tvquantity;
//
//    Button addToCart;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_oreo_milk_shake);
//
//        tvOreo = findViewById(R.id.tvOreo);
//        tvMP = findViewById(R.id.tvMP);
//        mimosapizza = findViewById(R.id.mimosapizza);
//        OreoOfferP = findViewById(R.id.OreoOfferP);
//        mimosalogo = findViewById(R.id.mimosalogo);
//
//
//        // Retrieve the "title" extra from the Intent
//        String title = getIntent().getStringExtra("title");
//        String restaurant = getIntent().getStringExtra("restaurant");
//        String imagePath = getIntent().getStringExtra("imagePath");
//        String price = getIntent().getStringExtra("price");
//        String logoPath = getIntent().getStringExtra("logoPath");
//
//        // Set the "title" to the tvOreo TextView
//        tvOreo.setText(title);
//        tvMP.setText(restaurant);
//        OreoOfferP.setText(price);
//
//
//        Glide.with(this)
//                .load("http://192.168.0.104:8000/images/" + imagePath)
//                .placeholder(R.drawable.ic_launcher_foreground)
//                .error(R.drawable.ic_launcher_foreground)
//                .into(mimosapizza);
//
//        Glide.with(this)
//                .load("http://192.168.0.104:8000/images/" + logoPath)
//                .placeholder(R.drawable.ic_launcher_foreground)
//                .error(R.drawable.ic_launcher_foreground)
//                .into(mimosalogo);
//
//        minus = findViewById(R.id.minus);
//        plus = findViewById(R.id.plus);
//        tvquantity = findViewById(R.id.tvQuantity);
//        addToCart = findViewById(R.id.btAddtocart);
//
//        plus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentValue = tvquantity.getText().toString();
//                int value = Integer.parseInt(currentValue);
//                value++;
//                tvquantity.setText(String.valueOf(value));
//            }
//        });
//
//        minus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentValue = tvquantity.getText().toString();
//                int value = Integer.parseInt(currentValue);
//                value--;
//                tvquantity.setText(String.valueOf(value));
//            }
//        });
//
//        addToCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(OreoMilkShake.this, "Added to CartResponse", Toast.LENGTH_SHORT).show();
////                Intent intent = new Intent(OreoMilkShake.this, My_Cart.class);
////                startActivity(intent);
//
//                String productName = tvOreo.getText().toString();
//                String restaurantName = tvMP.getText().toString();
//                String price = OreoOfferP.getText().toString();
//                String quantity = tvquantity.getText().toString();
//
//                // Create a new Intent
//                Intent intent = new Intent(OreoMilkShake.this, My_Cart.class);
//
//                // Put the data as extras in the Intent
//                intent.putExtra("productName", productName);
//                intent.putExtra("restaurantName", restaurantName);
//                intent.putExtra("price", price);
//                intent.putExtra("quantity", quantity);
//
//                // Start the My_Cart activity with the Intent
//                startActivity(intent);
//
//            }
//        });
//
//        ImageView imageView = findViewById(R.id.leftarrow);
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//
//        });
//    }
//}
//
//
//
//
//
//
//
//
//
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
////
////import android.content.Intent;
////import android.os.Bundle;
////import android.text.SpannableString;
////import android.text.style.StrikethroughSpan;
////import android.util.Log;
////import android.view.View;
////import android.widget.Button;
////import android.widget.ImageView;
////import android.widget.TextView;
////import android.widget.Toast;
////
////import com.bumptech.glide.Glide;
////import com.ocem.foodieexpress.R;
////import com.ocem.foodieexpress.fragment.HomeFragment;
////import com.ocem.foodieexpress.model.BestFood.BestFood;
////
////public class OreoMilkShake extends AppCompatActivity {
////    private TextView tvOreo,tvMP,OreoOfferP;
////    ImageView minus,plus,mimosapizza,mimosalogo;
////    TextView tvquantity;
////
////    Button addToCart;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_oreo_milk_shake);
////
////        tvOreo = findViewById(R.id.tvOreo);
////        tvMP = findViewById(R.id.tvMP);
////        mimosapizza = findViewById(R.id.mimosapizza);
////        OreoOfferP = findViewById(R.id.OreoOfferP);
////        mimosalogo = findViewById(R.id.mimosalogo);
////
////
////        // Retrieve the "title" extra from the Intent
////        String title = getIntent().getStringExtra("title");
////        String restaurant = getIntent().getStringExtra("restaurant");
////        String imagePath = getIntent().getStringExtra("imagePath");
////        String price = getIntent().getStringExtra("price");
////        String logoPath = getIntent().getStringExtra("logoPath");
////
////        // Set the "title" to the tvOreo TextView
////        tvOreo.setText(title);
////        tvMP.setText(restaurant);
////        OreoOfferP.setText(price);
////
////
////        Glide.with(this)
////                .load("http://192.168.0.104:8000/images/" + imagePath)
////                .placeholder(R.drawable.ic_launcher_foreground)
////                .error(R.drawable.ic_launcher_foreground)
////                .into(mimosapizza);
////
////        Glide.with(this)
////                .load("http://192.168.0.104:8000/images/" + logoPath)
////                .placeholder(R.drawable.ic_launcher_foreground)
////                .error(R.drawable.ic_launcher_foreground)
////                .into(mimosalogo);
////
////        minus = findViewById(R.id.minus);
////        plus = findViewById(R.id.plus);
////        tvquantity = findViewById(R.id.tvQuantity);
////        addToCart = findViewById(R.id.btAddtocart);
////
////        plus.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                String currentValue = tvquantity.getText().toString();
////                int value = Integer.parseInt(currentValue);
////                value++;
////                tvquantity.setText(String.valueOf(value));
////            }
////        });
////
////        minus.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                String currentValue = tvquantity.getText().toString();
////                int value = Integer.parseInt(currentValue);
////                value--;
////                tvquantity.setText(String.valueOf(value));
////            }
////        });
////
////        addToCart.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
//////                Toast.makeText(OreoMilkShake.this, "Added to CartResponse", Toast.LENGTH_SHORT).show();
//////                Intent intent = new Intent(OreoMilkShake.this, My_Cart.class);
//////                startActivity(intent);
////
////                String productName = tvOreo.getText().toString();
////                String restaurantName = tvMP.getText().toString();
////                String price = OreoOfferP.getText().toString();
////                String quantity = tvquantity.getText().toString();
////
////
////                // Create a new Intent
////                Intent intent = new Intent(OreoMilkShake.this, My_Cart.class);
////
////                // Put the data as extras in the Intent
////                intent.putExtra("productName", productName);
////                intent.putExtra("restaurantName", restaurantName);
////                intent.putExtra("price", price);
////                intent.putExtra("quantity", quantity);
////
////                // Start the My_Cart activity with the Intent
////                startActivity(intent);
////
////            }
////        });
////
////        ImageView imageView = findViewById(R.id.leftarrow);
////
////        imageView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                onBackPressed();
////        }
////
////    });
////    }
////}