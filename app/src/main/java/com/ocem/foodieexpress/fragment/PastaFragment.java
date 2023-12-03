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
import com.ocem.foodieexpress.domain.PastaDomain;

import java.util.ArrayList;


public class PastaFragment extends Fragment {

    View view;
    private RecyclerView recyclerview;
    private ArrayList<PastaDomain> PastaArrayList;
    private Button button;

    private RecyclerView.Adapter PastaAdapter;
    public PastaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PastaArrayList = new ArrayList<>();
        PastaArrayList.add(new PastaDomain("Chicken Red Sauce Pasta","chickenredsauce","Plate","NRS 280"));
        PastaArrayList.add(new PastaDomain("Chicken White Sauce Pasta","whitesauce","Plate","NRS 350"));
        PastaArrayList.add(new PastaDomain("Chicken Red Sauce Pasta Sphagetti","redsaucesphagettii","Plate","NRS 280"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pasta2, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.pasta_recyclerView);
        com.ocem.foodieexpress.adapter.PastaAdapter PastaAdapter = new com.ocem.foodieexpress.adapter.PastaAdapter(PastaArrayList);

        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(PastaAdapter);
        return view;
    }
}