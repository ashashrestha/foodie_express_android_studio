package com.ocem.foodieexpress.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ocem.foodieexpress.domain.Pizza;
import com.ocem.foodieexpress.R;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder> {

    ArrayList<Pizza> pizzaArrayList;
    public PizzaAdapter(ArrayList<Pizza> pizzaArrayList) {
        this.pizzaArrayList = pizzaArrayList;
    }

    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item,parent,false);
        return new PizzaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder holder, int position) {

        holder.tvCLargeP.setText(pizzaArrayList.get(position).getHeading());
        holder.tvCNrs.setText(pizzaArrayList.get(position).getCNrs());
        holder.tvPlate.setText(pizzaArrayList.get(position).getPlate());
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(pizzaArrayList.get(position).getTitleImage(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.PizzaImage);

    }

    @Override
    public int getItemCount() {

        return pizzaArrayList.size();
    }

    public static class PizzaViewHolder extends RecyclerView.ViewHolder{


        ImageView PizzaImage;
        TextView tvCLargeP;
        TextView tvPlate;
        TextView tvCNrs;


        public PizzaViewHolder(@NonNull View itemView) {
            super(itemView);
            PizzaImage = itemView.findViewById(R.id.CLPimage);
            tvCLargeP = itemView.findViewById(R.id.tvCLargeP);
            tvPlate = itemView.findViewById(R.id.tvPlate);
            tvCNrs = itemView.findViewById(R.id.tvCNrs);

        }
    }
}

