package com.ocem.foodieexpress.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ocem.foodieexpress.domain.Pizza;
import com.ocem.foodieexpress.adapter.PizzaAdapter;
import com.ocem.foodieexpress.R;

import java.util.ArrayList;


public class PizzaFragment extends Fragment {

  View view;
  private RecyclerView recyclerview;
    private ArrayList<Pizza> pizzaArrayList;
    private Button button;

    private RecyclerView.Adapter PizzaAdapter;

    public PizzaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pizza, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.pizza_recyclerView);
        com.ocem.foodieexpress.adapter.PizzaAdapter pizzaAdapter = new PizzaAdapter( pizzaArrayList);

        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(pizzaAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pizzaArrayList = new ArrayList<>();
        pizzaArrayList.add(new Pizza("Veg Pizza Large","veg_pizza2","Plate","NRS 500"));
        pizzaArrayList.add(new Pizza("BBQ Pizza Small","bbq_pizza","Plate","NRS 400"));
        pizzaArrayList.add(new Pizza("Chicken Pizza Large","chicken_pizza","Plate","NRS 600"));

    }

}