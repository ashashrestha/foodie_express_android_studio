package com.ocem.foodieexpress.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.fragment.CategoryFragment;
import com.ocem.foodieexpress.fragment.HomeFragment;
import com.ocem.foodieexpress.fragment.MoreFragment;
import com.ocem.foodieexpress.fragment.OfferFragment;

public class MainActivity extends AppCompatActivity {

   BottomNavigationView bottomNavigationView;

   HomeFragment homeFragment = new HomeFragment();
   CategoryFragment categoryFragment = new CategoryFragment();
   OfferFragment offerFragment = new OfferFragment();
   MoreFragment moreFragment = new MoreFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.constraint_layout,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.Home) {
                    selectedFragment = new HomeFragment();
                } else if (item.getItemId() == R.id.Category) {
                    selectedFragment = new CategoryFragment();
                } else if (item.getItemId() == R.id.Offer) {
                    selectedFragment = new OfferFragment();
                } else if (item.getItemId() == R.id.More) {
                    selectedFragment = new MoreFragment();
                }


                getSupportFragmentManager().beginTransaction().replace(R.id.constraint_layout, selectedFragment).commit();
                return true;
            }
        });

//        FoodieService foodieService = APIUtil.getFoodieService();
//        Call<FoodieResponse> foodieResponseCall = foodieService.getFoodieList();
//        foodieResponseCall.enqueue(new Callback<FoodieResponse>(){
//            @Override
//            public void onResponse(Call<FoodieResponse> call, Response<FoodieResponse> response) {
//                Log.v("OUTPUT",response.toString());
//                FoodieResponse foodieResponse = response.body();
//                List<Foodie> foodieList = foodieResponse.getFoodie();
//            }
//
//            @Override
//            public void onFailure(Call<FoodieResponse> call, Throwable t) {t.printStackTrace();
//            }
//
//        });
    }

}