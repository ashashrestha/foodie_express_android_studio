package com.ocem.foodieexpress.fragment;

import static androidx.recyclerview.widget.LinearLayoutManager.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.ocem.foodieexpress.Activity.my_cart_empty;
import com.ocem.foodieexpress.model.BestFood.BestFood;
import com.ocem.foodieexpress.model.BestFood.BestFoodResponse;
import com.ocem.foodieexpress.model.HomeBestOffer;
import com.ocem.foodieexpress.model.HomeBestOfferResponse;
import com.ocem.foodieexpress.model.HomeRestaurant;
import com.ocem.foodieexpress.model.HomeRestaurantResponse;
import com.ocem.foodieexpress.model.HomeSlider;
import com.ocem.foodieexpress.model.HomeSliderResponse;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.adapter.BestFoodAdaptor;
import com.ocem.foodieexpress.adapter.CategoryAdaptor;
import com.ocem.foodieexpress.domain.BestFoodDomain;
import com.ocem.foodieexpress.remote.APIUtil;
import com.ocem.foodieexpress.remote.FoodieService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    ImageSlider imageSlider;

    View view;
    private RecyclerView.Adapter adapter,adapter2;
    List<HomeSlider> homeSliderList = new ArrayList<HomeSlider>();

    List<HomeBestOffer> homeBestOfferList;
    private List<HomeRestaurant> homeRestaurantList;

    private List<BestFood> bestFoodList;

    private RecyclerView recyclerViewCategoryList,recyclerViewBestFoodList;

    public HomeFragment() {
        // Required empty public constructor
    }



    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //bestfood
//        bestfoodList = new ArrayList<>();
//        bestfoodList.add(new BestFoodDomain("Chilli Momo", "chilimomo", "Breeze Hotel"));
//        bestfoodList.add(new BestFoodDomain("Milkshake", "oreomilkshake","Black Forest"));
//        bestfoodList.add(new BestFoodDomain("Veg Burger", "burger","Baishnab"));
//        bestfoodList.add(new BestFoodDomain("Black Forest", "cake","Delight Cake"));
//        bestfoodList.add(new BestFoodDomain("Chowmein","chowmein","Metro Pizza"));

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //retrofit for category
        recyclerViewCategoryList = view.findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(new LinearLayoutManager(requireContext(),HORIZONTAL,false));
        homeRestaurantList = new ArrayList<>();

        //BestFood
        recyclerViewBestFoodList = view.findViewById(R.id.recyclerView2);
        recyclerViewBestFoodList.setLayoutManager(new LinearLayoutManager(requireContext(),HORIZONTAL ,false));
        bestFoodList = new ArrayList<>();

        //Image Slider Api
        imageSlider = view.findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
//        SharedPreferences shp = this.getActivity().getSharedPreferences("LOGIN",Context.MODE_PRIVATE);

        FoodieService foodieService = APIUtil.getFoodieService();

        Call<HomeSliderResponse> homeSliderResponseCall =
                foodieService.getslider();

        homeSliderResponseCall.enqueue(new Callback<HomeSliderResponse>() {
            @Override
            public void onResponse(Call<HomeSliderResponse> call, Response<HomeSliderResponse> response) {
                if(response.isSuccessful()){
                    homeSliderList = response.body().getData();
                    if (homeSliderList.size()>0){
                        for (int i =  0; i < homeSliderList.size(); i++){
                            String imageBaseUrl = "http://192.168.137.1:8000/images/" + homeSliderList.get(i).getPhoto();
                            slideModels.add(new SlideModel(imageBaseUrl, ScaleTypes.FIT));
                        }
                        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
                    }
                }
            }

            @Override
            public void onFailure(Call<HomeSliderResponse> call, Throwable t) {

            }
        });

            Call<HomeRestaurantResponse> homeRestaurantResponseCall  = foodieService.getHomeRestaurantType();
        homeRestaurantResponseCall.enqueue(new Callback<HomeRestaurantResponse>(){

                @Override
                public void onResponse(Call<HomeRestaurantResponse> call, Response<HomeRestaurantResponse> response) {
                    if (response.code() == 200 && response.body() != null) {
                        HomeRestaurantResponse homeRestaurantResponse = response.body();
                        List<HomeRestaurant> homeRestaurantList = homeRestaurantResponse.getData();
                        adapter = new CategoryAdaptor(getContext(),homeRestaurantList);
                        recyclerViewCategoryList.setAdapter(adapter);
                    } if(response.code() == 404){
                        Toast.makeText(getActivity(), "Data not found", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getActivity(), "API request failed", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<HomeRestaurantResponse> call, Throwable t) {
                    Log.d("TAG", "Error: " + t.toString());
                    Toast.makeText(getContext(), "Error fetching data", Toast.LENGTH_SHORT).show();
                }
            });

        Call<BestFoodResponse> bestFoodResponseCall  = foodieService.getBestFood();
        bestFoodResponseCall.enqueue(new Callback<BestFoodResponse>() {
            @Override
            public void onResponse(Call<BestFoodResponse> call, Response<BestFoodResponse> response) {
                if (response.code() == 200 && response.body() != null) {
                    BestFoodResponse bestFoodResponse = response.body();
                    List<BestFood> bestFoodList = bestFoodResponse.getData();
                    adapter2 = new BestFoodAdaptor(getContext(),bestFoodList);
                    recyclerViewBestFoodList.setAdapter(adapter2);
                } if(response.code() == 404){
                    Toast.makeText(getActivity(), "Data not found", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "API request failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BestFoodResponse> call, Throwable t) {
                Log.d("TAG", "Error: " + t.toString());
                Toast.makeText(getContext(), "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        });
//        Call<BestFoodResponse> call = foodieService.getBestFood();
//        call.enqueue(new Callback<BestFoodResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<BestFoodResponse> call,
//                                   @NonNull Response<BestFoodResponse> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    bestFoodList.addAll(response.body().getData());
//                    bestFoodAdapter.notifyDataSetChanged();
//                } else {
//                    Toast.makeText(getContext(), "Failed to fetch BestFood data", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<BestFoodResponse> call, @NonNull Throwable t) {
//                Toast.makeText(getContext(), "Network error. Please try again later.", Toast.LENGTH_SHORT).show();
//            }
//        });


//        SharedPreferences shp =getActivity().getSharedPreferences("LOGIN",Context.MODE_PRIVATE);
//        imgCakeFood = view.findViewById(R.id.imgCakeFood);
//        String imageUrl = "http://192.168.100.5:8000/images/";
//        Call<HomeBestOfferResponse> homeBestOfferResponseCall = foodieService.getHomeBestOffer();
//        homeBestOfferResponseCall.enqueue(new Callback<HomeBestOfferResponse>() {
//            @Override
//            public void onResponse(Call<HomeBestOfferResponse> call, Response<HomeBestOfferResponse> response) {
//                HomeBestOfferResponse homeBestOfferResponse = response.body();
//                List<HomeBestOffer> homeBestOfferList = homeBestOfferResponse.getData();
//
//                if (homeBestOfferList != null && !homeBestOfferList.isEmpty() ){
//
//                    tvhead.setText(homeBestOfferList.get(1).getmName());
//                    tvSubHead.setText(homeBestOfferList.get(1).getName());
//                    tvPrice.setText(homeBestOfferList.get(1).getPrice());
//                }
//                else {
//                    tvhead.setText("No data available");
//                    tvSubHead.setText("No data available");
//                    tvPrice.setText("No data available");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<HomeBestOfferResponse> call, Throwable t) {
//             t.printStackTrace();
//            }
//        });

        return view;
    }

    private Context getApplicationContext() {

        return getContext();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        ImageView cart = view.findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), my_cart_empty.class);
                startActivity(intent);
            }
        });

//        TextView tvSee = view.findViewById(R.id.tvSee);
//        tvSee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),CategoryFragment.class);
//                startActivity(intent);
//            }
//        });

    }
}