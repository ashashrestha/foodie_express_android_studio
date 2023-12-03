package com.ocem.foodieexpress.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ocem.foodieexpress.domain.BestFoodDomain;
import com.ocem.foodieexpress.Activity.OreoMilkShake;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.model.BestFood.BestFood;
import com.ocem.foodieexpress.model.HomeRestaurant;

import java.util.ArrayList;
import java.util.List;

public class BestFoodAdaptor extends RecyclerView.Adapter<BestFoodAdaptor.ViewHolder> {

    private List<BestFood> bestFoodList;
    Context context;
    public BestFoodAdaptor(Context context,List<BestFood> bestFoodList){

        this.bestFoodList = bestFoodList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_bestfood,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BestFood bestFood = bestFoodList.get(position);

        holder.title.setText(bestFood.getMenu().getmName());
        holder.restaurant.setText(bestFood.getName());

        Glide.with(context)
                .load("http://192.168.137.1:8000/images/" + bestFood.getPhotoPath())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    BestFood clickedItem = bestFoodList.get(position);

                    // Create an Intent to start the OreoMilkShake activity
                    Intent intent = new Intent(context, OreoMilkShake.class);

                    // Pass the necessary data to the OreoMilkShake activity using Intent extras
                    intent.putExtra("title", clickedItem.getMenu().getmName());
                    intent.putExtra("restaurant", clickedItem.getName());
                    intent.putExtra("imagePath", clickedItem.getPhotoPath());
                    intent.putExtra("price", clickedItem.getMenu().getPrice());
                    intent.putExtra("logoPath", clickedItem.getRestaurant().getPhotoPath());
                    intent.putExtra("menuId", clickedItem.getMenu().getId());

                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return bestFoodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,restaurant,price;
        ImageView pic;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            restaurant = itemView.findViewById(R.id.restaurant);
            pic = itemView.findViewById(R.id.pic);
            price = itemView.findViewById(R.id.price);
        }
    }
}