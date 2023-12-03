package com.ocem.foodieexpress.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.adapter.ColdBeverageAdapter;
import com.ocem.foodieexpress.domain.ColdBeverageDomain;

import java.util.ArrayList;

public class ColdBeverageFragment extends Fragment {
    View view;
    private RecyclerView recyclerview;
    private ArrayList<ColdBeverageDomain> coldBeverageDomainArrayList;
    private Button button;

    private RecyclerView.Adapter ColdBeverageAdapter;

    public ColdBeverageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        coldBeverageDomainArrayList = new ArrayList<>();
        coldBeverageDomainArrayList.add(new ColdBeverageDomain("Oreo Shake","oreomilkshake","Cup","NRS 300"));
        coldBeverageDomainArrayList.add(new ColdBeverageDomain("Ice Cream Shake","icecreamshake","Cup","NRS 300"));
        coldBeverageDomainArrayList.add(new ColdBeverageDomain( "Lemonade","lemonade","Cup","NRS 180"));

    }

    @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_cold_beverage2, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.coldbeverage_recyclerView);
        com.ocem.foodieexpress.adapter.ColdBeverageAdapter coldBeverageAdapter = new ColdBeverageAdapter(coldBeverageDomainArrayList);

        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(coldBeverageAdapter);
        return view;
    }
}