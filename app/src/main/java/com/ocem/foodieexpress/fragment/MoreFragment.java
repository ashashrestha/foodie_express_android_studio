package com.ocem.foodieexpress.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

//import com.ocem.foodieexpress.domain.More;
//import com.ocem.foodieexpress.adapter.MoreAdapter;
import com.ocem.foodieexpress.Activity.LoginActivity;
import com.ocem.foodieexpress.R;

import java.util.ArrayList;

public class MoreFragment extends Fragment {

   View view;

   CardView cardView1;
   TextView tvlogout;

    public MoreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view = inflater.inflate(R.layout.fragment_more, container, false);

        cardView1 = view.findViewById(R.id.cardView1);
        tvlogout = view.findViewById(R.id.tvlogout);

        tvlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("LOGIN",
                        Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("LOGIN",false).apply();

                Toast.makeText(requireContext(), "You have been logged out", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(requireActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                requireActivity().finish();
            }
        });
       return view;
    }
}