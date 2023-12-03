//package com.ocem.foodieexpress.Activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.ocem.foodieexpress.R;
//
//public class MoreActivity extends AppCompatActivity {
//    private BottomNavigationView bottomNavigationView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_more);
//
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.More);
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
//                startActivity(new Intent(getApplicationContext(), OfferActivity.class));
////                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
//                overridePendingTransition(0,0);
//                finish();
//                return true;
//            }
//            if(itemId == R.id.More) {
//
//                return true;
//            }
//            return false;
//        });
//    }
//}