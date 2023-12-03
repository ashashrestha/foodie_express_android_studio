package com.ocem.foodieexpress.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.adapter.OfferAdapter;
import com.ocem.foodieexpress.domain.OfferDomain;

import java.util.ArrayList;

public class OfferFragment extends Fragment {

    View view;
    private RecyclerView recyclerview;
    private ArrayList<OfferDomain> offerArrayList;
    private Button button;

    private RecyclerView.Adapter OfferAdapter;
    public OfferFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       offerArrayList = new ArrayList<>();
        offerArrayList.add(new OfferDomain("chicken_biryani1", "2 Plates Chicken", "Biryani Offers","kg","NRS 450","NRS 500","Offer"));
        offerArrayList.add(new OfferDomain("mutton_biryani1", "2 Plates Mutton", "Biryani Offers","kg","NRS 725","NRS 800","Offer"));
        offerArrayList.add(new OfferDomain("black_forest", "2 Pound Black", "Forest Cake","Combo","NRS 999","NRS 1200","Offer"));
        offerArrayList.add(new OfferDomain("pastry", "Black Forest Pastry", "","Pc","NRS 90","NRS 100","Offer"));
        offerArrayList.add(new OfferDomain("samosa1", "Buy 5 Samosa", "Get 1 Free","Combo","NRS 100","NRS 120","Offer"));
        offerArrayList.add(new OfferDomain("momo2", "Buy 3 momo ", "Get 1 Free","Combo","NRS 300","NRS 400","Offer"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_offer, container, false);
        OfferAdapter OfferAdapter = new OfferAdapter(offerArrayList);
        recyclerview = (RecyclerView) view.findViewById(R.id.Offer_recyclerView);
        recyclerview.setLayoutManager( new GridLayoutManager(getActivity(),2));
        recyclerview.setAdapter(OfferAdapter);
        return view;
    }

}