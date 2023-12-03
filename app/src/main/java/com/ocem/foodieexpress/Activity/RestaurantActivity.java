package com.ocem.foodieexpress.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.adapter.ViewPager2RestaurantAdapter;
import com.ocem.foodieexpress.fragment.PizzaFragment;

public class RestaurantActivity extends AppCompatActivity {

    ImageView imageView;
    TabLayout tabMenu;
    ViewPager2 viewpager2;

    ViewPager2RestaurantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        imageView = findViewById(R.id.leftarrow);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantActivity.this,NonVegRestaurant.class);
                startActivity(intent);
            }
        });

        replaceFragment(new PizzaFragment());

        tabMenu = findViewById(R.id.tabMenu);
        viewpager2 = findViewById(R.id.viewpager2);

        tabMenu.addTab(tabMenu.newTab().setText("PIZZA"));
        tabMenu.addTab(tabMenu.newTab().setText("MOMO"));
        tabMenu.addTab(tabMenu.newTab().setText("COLD BEVERAGE"));
        tabMenu.addTab(tabMenu.newTab().setText("PASTA"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new ViewPager2RestaurantAdapter(fragmentManager , getLifecycle());
        viewpager2.setAdapter(adapter);

        tabMenu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
       viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
           @Override
           public void onPageSelected(int position) {
               tabMenu.selectTab(tabMenu.getTabAt(position));
           }
       });
    }

    private void replaceFragment(PizzaFragment pizzaFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.commit();
    }
}