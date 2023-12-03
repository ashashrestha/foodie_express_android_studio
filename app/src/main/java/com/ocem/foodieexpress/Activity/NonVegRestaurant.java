//package com.ocem.foodieexpress.Activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.SearchView;
//
//import com.ocem.foodieexpress.R;
//import com.ocem.foodieexpress.adapter.NonVegRestaurantAdapter;
//import com.ocem.foodieexpress.domain.NVRDemo;
//import com.ocem.foodieexpress.fragment.CategoryFragment;
//
//import java.util.ArrayList;
//
//public class NonVegRestaurant extends AppCompatActivity {
//
//    View view  ;
//    private RecyclerView recyclerview;
//    private ArrayList<NVRDemo> NVRArrayList;
//    private Button button;
//
//    private com.ocem.foodieexpress.adapter.NonVegRestaurantAdapter nonVegRestaurantAdapter;
//    private SearchView searchView;
//
//    ImageView imageView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_non_veg_restaurant);
//
//        imageView = findViewById(R.id.leftarrow);
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(NonVegRestaurant.this, CategoryFragment.class);
//                startActivity(intent);
//            }
//        });
//
//        NVRArrayList = new ArrayList<>();
//
//        searchView = findViewById(R.id.searchView);
//        searchView.clearFocus();
//        recyclerview = findViewById(R.id.NVR_recyclerView);
//
//        setCategoryinfo();
//        setAdapter();
//    }
//    private void setAdapter() {
//        nonVegRestaurantAdapter  = new NonVegRestaurantAdapter(NVRArrayList,getApplicationContext());
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerview.setLayoutManager(layoutManager);
//        recyclerview.setAdapter(nonVegRestaurantAdapter);
//    }
//    private void setCategoryinfo() {
//
//        NVRArrayList.add(new NVRDemo("syanko", "Syanko Katti Roll", "Shahidchowk-3, Bharatpur, Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//        NVRArrayList.add(new NVRDemo("tandoori", "Purano Tandoori Restaurant & Bar", "Mills Area-1, Bharatpur, Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//        NVRArrayList.add(new NVRDemo("mimosapizza", "Mimosa Pizza", "Shahidchowk-1, Bharatpur,Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//        NVRArrayList.add(new NVRDemo("grinders", "Grinders Coffee", "NGO Rd, Bharatpur,Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//        NVRArrayList.add(new NVRDemo("bhetghat", "Bhetghat Restaurant", "Shahidchowk-1, Bharatpur,Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//        NVRArrayList.add(new NVRDemo("kfc", "KFC", "Chaubiskoti-10, Bharatpur,Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//        NVRArrayList.add(new NVRDemo("metro", "Metro Pizza", "Chaubiskoti-10, Bharatpur,Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//    }
//}

package com.ocem.foodieexpress.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.adapter.NonVegRestaurantAdapter;
import com.ocem.foodieexpress.domain.NVRDemo;
import com.ocem.foodieexpress.fragment.CategoryFragment;
import com.ocem.foodieexpress.model.Restaurant.Restaurant;
import com.ocem.foodieexpress.model.Restaurant.RestaurantResponse;
import com.ocem.foodieexpress.remote.FoodieService;
import com.ocem.foodieexpress.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NonVegRestaurant extends AppCompatActivity {

    private RecyclerView recyclerview;
    private ArrayList<NVRDemo> NVRArrayList;
    private NonVegRestaurantAdapter nonVegRestaurantAdapter;
    private SearchView searchView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_veg_restaurant);

        imageView = findViewById(R.id.leftarrow);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NonVegRestaurant.this, CategoryFragment.class);
                startActivity(intent);
            }
        });

        NVRArrayList = new ArrayList<>();

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        recyclerview = findViewById(R.id.NVR_recyclerView);

        // Initialize Retrofit
        FoodieService foodieService = RetrofitClient.getClient().create(FoodieService.class);

        // Make an API call to fetch restaurant data
        Call<RestaurantResponse> call = foodieService.getRestaurant();
        call.enqueue(new Callback<RestaurantResponse>() {
            @Override
            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Restaurant> restaurantList = response.body().getData();
                    setCategoryinfo(restaurantList); // Populate the restaurant data
                    setAdapter();
                }
            }

            @Override
            public void onFailure(Call<RestaurantResponse> call, Throwable t) {
                // Handle API call failure
            }
        });
    }

    private void setAdapter() {
        nonVegRestaurantAdapter = new NonVegRestaurantAdapter(NVRArrayList, getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(nonVegRestaurantAdapter);
    }

    private void setCategoryinfo(List<Restaurant> restaurantList) {
        for (Restaurant restaurant : restaurantList) {
            NVRArrayList.add(new NVRDemo(
                    restaurant.getName(),
                    restaurant.getName(),
                    restaurant.getAddress(),
                    restaurant.getPhotoPath(),
                    restaurant.getDeliveryTime()
            ));
        }
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
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.SearchView;
//
//import com.ocem.foodieexpress.R;
//import com.ocem.foodieexpress.RestaurantType;
//import com.ocem.foodieexpress.adapter.NonVegRestaurantAdapter;
//import com.ocem.foodieexpress.domain.NVRDemo;
//import com.ocem.foodieexpress.fragment.CategoryFragment;
//import com.ocem.foodieexpress.model.Restaurant.Restaurant;
//import com.ocem.foodieexpress.model.Restaurant.RestaurantResponse;
//import com.ocem.foodieexpress.remote.APIUtil;
//import com.ocem.foodieexpress.remote.FoodieService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class NonVegRestaurant extends AppCompatActivity {
//
//    View view  ;
//    private RecyclerView recyclerview;
//    private ArrayList<NVRDemo> NVRArrayList;
//    private Button button;
//
//    private NonVegRestaurantAdapter nonVegRestaurantAdapter;
//    private SearchView searchView;
//
//
//
//    ImageView imageView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_non_veg_restaurant);
//
//
//
//        imageView = findViewById(R.id.leftarrow);
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(NonVegRestaurant.this, CategoryFragment.class);
//                startActivity(intent);
//
//            }
//        });
//
//        NVRArrayList = new ArrayList<>();
//
//        searchView = findViewById(R.id.searchView);
//        searchView.clearFocus();
//        recyclerview = findViewById(R.id.NVR_recyclerView);
//
//        setCategoryinfo();
//        setAdapter();
//    }
//    private void setAdapter() {
//        nonVegRestaurantAdapter  = new NonVegRestaurantAdapter(NVRArrayList,getApplicationContext());
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerview.setLayoutManager(layoutManager);
//        recyclerview.setAdapter(nonVegRestaurantAdapter);
//    }
//    private void setCategoryinfo() {
//
//        NVRArrayList.add(new NVRDemo("syanko", "Syanko Katti Roll", "Shahidchowk-3, Bharatpur, Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//        NVRArrayList.add(new NVRDemo("tandoori", "Purano Tandoori Restaurant & Bar", "Mills Area-1, Bharatpur, Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//        NVRArrayList.add(new NVRDemo("mimosapizza", "Mimosa Pizza", "Shahidchowk-1, Bharatpur,Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//        NVRArrayList.add(new NVRDemo("grinders", "Grinders Coffee", "NGO Rd, Bharatpur,Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//        NVRArrayList.add(new NVRDemo("bhetghat", "Bhetghat Restaurant", "Shahidchowk-1, Bharatpur,Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//        NVRArrayList.add(new NVRDemo("kfc", "KFC", "Chaubiskoti-10, Bharatpur,Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//        NVRArrayList.add(new NVRDemo("metro", "Metro Pizza", "Chaubiskoti-10, Bharatpur,Chitwan","address","Delivery Hours: 10:00 AM to 9:00 PM"));
//    }
//}