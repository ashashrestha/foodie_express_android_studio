//package com.ocem.foodieexpress.Activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.SearchView;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.ocem.foodieexpress.adapter.OfferAdapter;
//import com.ocem.foodieexpress.domain.OfferDomain;
//import com.ocem.foodieexpress.R;
//
//import java.util.ArrayList;
//
//public class OfferActivity extends AppCompatActivity {
//
//    private BottomNavigationView bottomNavigationView;
//    View view  ;
//    private RecyclerView recyclerview;
//    private ArrayList<OfferDomain> offerArrayList;
//
//    private OfferAdapter offerAdapter;
//    private SearchView searchView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_offer);
//
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.Offer);
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
//                startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
////                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
//                overridePendingTransition(0,0);
//                finish();
//                return true;
//            }
//            if(itemId == R.id.Offer) {
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
//
//
//        offerArrayList = new ArrayList<>();
//
//        searchView = findViewById(R.id.searchView1);
//        searchView.clearFocus();
//        recyclerview = findViewById(R.id.Offer_recyclerView);
//
//
//        setCategoryinfo();
//        setAdapter();
//    }
//    private void setAdapter() {
//        OfferAdapter OfferAdapter = new OfferAdapter(offerArrayList);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
//        recyclerview.setLayoutManager(layoutManager);
//        recyclerview.setAdapter(OfferAdapter);
//    }
//    private void setCategoryinfo() {
//
//        offerArrayList.add(new OfferDomain("chicken_biryani1", "2 Plates Chicken", "Biryani Offers","kg","NRS 450","NRS 500","Offer"));
//        offerArrayList.add(new OfferDomain("mutton_biryani1", "2 Plates Mutton", "Biryani Offers","kg","NRS 725","NRS 800","Offer"));
//        offerArrayList.add(new OfferDomain("black_forest", "2 Pound Black", "Forest Cake","Combo","NRS 999","NRS 1200","Offer"));
//        offerArrayList.add(new OfferDomain("pastry", "Black Forest Pastry", "","Pc","NRS 90","NRS 100","Offer"));
//        offerArrayList.add(new OfferDomain("samosa1", "Buy 5 Samosa", "Get 1 Free","Combo","NRS 100","NRS 120","Offer"));
//        offerArrayList.add(new OfferDomain("momo2", "Buy 3 momo ", "Get 1 Free","Combo","NRS 300","NRS 400","Offer"));
//    }
//}