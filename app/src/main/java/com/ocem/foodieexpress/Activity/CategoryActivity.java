//package com.ocem.foodieexpress.Activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.SearchView;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.ocem.foodieexpress.R;
//import com.ocem.foodieexpress.adapter.CategoryAdapter;
//import com.ocem.foodieexpress.domain.Category;
//
//import java.util.ArrayList;
//
//public class CategoryActivity extends AppCompatActivity{
//    private BottomNavigationView bottomNavigationView;
//    private RecyclerView recyclerview;
//    private ArrayList<Category> categoryArrayList;
//    private Button button;
//
//    private com.ocem.foodieexpress.adapter.CategoryAdapter CategoryAdapter;
//    private SearchView searchView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_category);
//
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.Category);
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            int itemId = item.getItemId();
//            if(itemId == R.id.Home) {
//                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
////                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
//                overridePendingTransition(0,0);
//                finish();
//                return true;
//            }
//            if(itemId == R.id.Category) {
//                return true;
//            }
//            if(itemId == R.id.Offer) {
//                startActivity(new Intent(getApplicationContext(), OfferActivity.class));
////                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
//                overridePendingTransition(0,0);
//                finish();
//                return true;
//            }
//            if(itemId == R.id.More) {
//                startActivity(new Intent(getApplicationContext(), MoreActivity.class));
////                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
//                overridePendingTransition(0,0);
//                finish();
//                return true;
//            }
//            return false;
//        });
//
//        categoryArrayList = new ArrayList<>();
//
//        searchView = findViewById(R.id.searchView);
//        searchView.clearFocus();
//        recyclerview = findViewById(R.id.category_recyclerView);
//
//
//        setCategoryinfo();
//        setAdapter();
//    }
//    private void setAdapter() {
//        CategoryAdapter  = new CategoryAdapter( categoryArrayList,getApplicationContext());
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerview.setLayoutManager(layoutManager);
//        recyclerview.setAdapter(CategoryAdapter);
//    }
//    private void setCategoryinfo() {
//
//        categoryArrayList.add(new Category("veg_khajaset", "Veg", "Restaurant"));
//        categoryArrayList.add(new Category("non_veg_rest", "Non Veg", "Restaurant"));
//        categoryArrayList.add(new Category("cake", "Bakeries", ""));
//        categoryArrayList.add(new Category("liquors1", "Liquors", ""));
//        categoryArrayList.add(new Category("icecream1", "Ice Cream", ""));
//    }
//
//}