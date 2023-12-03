//package com.ocem.foodieexpress.Activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.ocem.foodieexpress.R;
//import com.ocem.foodieexpress.adapter.BestFoodAdaptor;
//import com.ocem.foodieexpress.adapter.CategoryAdaptor;
//import com.ocem.foodieexpress.domain.BestFoodDomain;
//import com.ocem.foodieexpress.domain.CategoryDomain;
//
//import java.util.ArrayList;
//
//public class HomeActivity extends AppCompatActivity {
//
//    private BottomNavigationView bottomNavigationView;
//    TextView tvSee;
//    private RecyclerView.Adapter adapter,adapter2;
//    private RecyclerView recyclerViewCategoryList,recyclerViewBestFoodList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.Home);
//
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            int itemId = item.getItemId();
//            if(itemId == R.id.Home) {
//                return true;
//            }
//            if(itemId == R.id.Category) {
//                startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
//                overridePendingTransition(0,0);
//                finish();
//                return true;
//            }
//            if(itemId == R.id.Offer) {
//                startActivity(new Intent(getApplicationContext(), OfferActivity.class));
//                overridePendingTransition(0,0);
//                finish();
//                return true;
//            }
//            if(itemId == R.id.More) {
//                startActivity(new Intent(getApplicationContext(), MoreActivity.class));
//                overridePendingTransition(0,0);
//                finish();
//                return true;
//            }
//            return false;
//        });
//
//        tvSee = findViewById(R.id.tvSee);
//        tvSee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        recyclerViewCategory();
//        recyclerViewBestFood();
//    }
//
//    private void recyclerViewCategory(){
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        recyclerViewCategoryList = findViewById(R.id.recyclerView);
//        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
//
//        ArrayList<CategoryDomain> category = new ArrayList<>();
//        category.add(new CategoryDomain("Veg ", "vegetable"));
//        category.add(new CategoryDomain("Non-Veg", "non_veg"));
//        category.add(new CategoryDomain("Bakeries", "bakery"));
//        category.add(new CategoryDomain("Liquors", "liquor"));
//        category.add(new CategoryDomain("Ice Cream", "ice_cream"));
//
//        adapter = new CategoryAdaptor(category,getApplicationContext());
//        recyclerViewCategoryList.setAdapter(adapter);
//    }
//
//    private void recyclerViewBestFood(){
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        recyclerViewBestFoodList = findViewById(R.id.recyclerView2);
//        recyclerViewBestFoodList.setLayoutManager(linearLayoutManager);
//
//        ArrayList<BestFoodDomain> bestfoodList = new ArrayList<>();
//        bestfoodList.add(new BestFoodDomain("Chilli Momo", "chilimomo", "Breeze Hotel"));
//        bestfoodList.add(new BestFoodDomain("Milkshake", "oreomilkshake","Black Forest"));
//        bestfoodList.add(new BestFoodDomain("Veg Burger", "burger","Baishnab"));
//        bestfoodList.add(new BestFoodDomain("Black Forest", "cake","Delight Cake"));
//        bestfoodList.add(new BestFoodDomain("Chowmein","chowmein","Metro Pizza"));
//
//        adapter2 = new BestFoodAdaptor(bestfoodList,getApplicationContext());
//        recyclerViewBestFoodList.setAdapter(adapter2);
//    }
//}
