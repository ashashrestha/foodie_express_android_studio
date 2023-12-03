package com.ocem.foodieexpress.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ocem.foodieexpress.domain.Momo;
import com.ocem.foodieexpress.adapter.MomoAdapter;
import com.ocem.foodieexpress.R;

import java.util.ArrayList;

public class MomoFragment extends Fragment {

    View view;
    private RecyclerView recyclerview;
    private ArrayList<Momo> momoArrayList;
    private Button button;

    private RecyclerView.Adapter MomoAdapter;

    public MomoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        momoArrayList = new ArrayList<>();
        momoArrayList.add(new Momo("Chicken chilly Momo","chilly_momo","Plate","NRS 220"));
        momoArrayList.add(new Momo("Chicken Momo Platter","platter","Plate","NRS 200"));
        momoArrayList.add(new Momo( "Chicken jhol Momo","jholm","Plate","NRS 500"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_momo, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.momo_recyclerView);
        com.ocem.foodieexpress.adapter.MomoAdapter momoAdapter = new MomoAdapter(momoArrayList);

        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(momoAdapter);
        return view;
    }

}