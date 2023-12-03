package com.ocem.foodieexpress.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ocem.foodieexpress.model.Datum;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.model.RestaurantType;
import com.ocem.foodieexpress.adapter.CategoryAdapter;
import com.ocem.foodieexpress.remote.APIUtil;
import com.ocem.foodieexpress.remote.FoodieService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoryFragment extends Fragment {

    private RecyclerView recyclerView;

    private List<Datum> dataArrayList;
    private CategoryAdapter categoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        recyclerView = view.findViewById(R.id.category_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        dataArrayList = new ArrayList<>();
//        SharedPreferences shp = this.getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);

        // Retrofit
        FoodieService foodieService = APIUtil.getFoodieService();
//        Call<RestaurantType> restaurantTypeCall  = foodieService.getRestaurantType("Bearer"+shp);
        Call<RestaurantType> restaurantTypeCall  = foodieService.getRestaurantType();

        restaurantTypeCall.enqueue(new Callback<RestaurantType>() {
            @Override
            public void onResponse(Call<RestaurantType> call, Response<RestaurantType> response) {
                if (response.code() == 200 && response.body() != null) {
                    RestaurantType restaurantType = response.body();
                    List<Datum> dataArrayList = restaurantType.getData();
                    categoryAdapter = new CategoryAdapter(getContext(),dataArrayList);
                    recyclerView.setAdapter(categoryAdapter);
                } if(response.code() == 404){
                    Toast.makeText(getActivity(), "Data not found", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "API request failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RestaurantType> call, Throwable t) {
                Log.d("TAG", "Error: " + t.toString());
                Toast.makeText(getContext(), "Error fetching data", Toast.LENGTH_SHORT).show();
            }

        });
        return view;
    }

}



//package com.ocem.foodieexpress.fragment;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//
//import com.ocem.foodieexpress.Activity.My_Cart;
//import com.ocem.foodieexpress.Activity.my_cart_empty;
//import com.ocem.foodieexpress.R;
//import com.ocem.foodieexpress.adapter.CategoryAdapter;
//import com.ocem.foodieexpress.model.domain.Category;
//
//import java.util.ArrayList;
//
//public class CategoryFragment extends Fragment {
//
//    View view;
//    private RecyclerView recyclerview;
//    private ArrayList<Category> categoryArrayList;
//
//    private Button button;
//
//    private CategoryAdapter categoryAdapter;
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        categoryArrayList = new ArrayList<>();
//        categoryArrayList.add(new Category("veg_khajaset", "Veg", "Restaurant"));
//        categoryArrayList.add(new Category("non_veg_rest", "Non Veg", "Restaurant"));
//        categoryArrayList.add(new Category("cake", "Bakeries", ""));
//        categoryArrayList.add(new Category("liquors1", "Liquors", ""));
//        categoryArrayList.add(new Category("icecream1", "Ice Cream", ""));
//
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        view = inflater.inflate(R.layout.fragment_category, container, false);
//        recyclerview = (RecyclerView) view.findViewById(R.id.category_recyclerView);
//        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryArrayList, getApplicationContext());
//        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerview.setAdapter(categoryAdapter);
//        return view;
//
//    }
//
//
//    private Context getApplicationContext() {
//
//        return getContext();
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        ImageView cart = view.findViewById(R.id.cart);
//        cart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), My_Cart.class);
//                startActivity(intent);
//            }
//        });


////
////    @Override
////    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
////        super.onViewCreated(view, savedInstanceState);
////
////        recyclerview = view.findViewById(R.id.category_recyclerView);
//////        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
////
////      recyclerview.setLayoutManager(new LinearLayoutManager(requireContext()));
////
//////        recyclerview.setLayoutManager(layoutManager);
////        categoryAdapter = new CategoryAdapter((Context) getContext(),categoryArrayList);
////        recyclerview.setAdapter(categoryAdapter);
////
////        //retrofit
////        FoodieService foodieService = RetrofitClient.getClient().create(FoodieService.class);
////        Call<List<RestaurantType>> restaurantTypeCall = foodieService.getRestaurantType();
////        restaurantTypeCall.enqueue(new Callback<List<RestaurantType>>() {
////            @Override
////            public void onResponse(Call<List<RestaurantType>> call, Response<List<RestaurantType>> response) {
////                categoryArrayList = response.body();
////                Log.d("TAG","Response ="+ categoryArrayList);
//////                categoryAdapter = new CategoryAdapter(response.body().get().getId());
////            }
////
////            @Override
////            public void onFailure(Call<List<RestaurantType>> call, Throwable t) {
////                Log.d("TAG","Response ="+ t.toString());
////            }
////
////
//////            @Override
//////            public void onResponse(Call<RestaurantTypeResponse> call, Response<RestaurantTypeResponse> response) {
//////                List<Datum> datumList = response.body().getData();
//////                categoryAdapter = new CategoryAdapter(response.body().getData(),getActivity()
//////                );
//////            }
//////
//////            @Override
//////            public void onFailure(Call<RestaurantTypeResponse> call, Throwable t) {
//////               Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_SHORT).show();
//////            }
//////        });
////        });
////    }



