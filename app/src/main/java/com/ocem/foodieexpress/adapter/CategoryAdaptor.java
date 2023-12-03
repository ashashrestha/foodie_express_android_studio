//package com.ocem.foodieexpress.adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.ocem.foodieexpress.Activity.NonVegRestaurant;
//import com.ocem.foodieexpress.R;
//import com.ocem.foodieexpress.domain.CategoryDomain;
//
//import java.util.ArrayList;
//
//public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {
//    Context context;
//
//    ArrayList<CategoryDomain> categoryDomains;
//
//    public CategoryAdaptor(ArrayList<CategoryDomain> categoryDomains, Context context){
//        this.categoryDomains = categoryDomains;
//        this.context = context;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
//        return new ViewHolder(inflate);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//       holder.categoryName.setText(categoryDomains.get(position).getTitle());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//
//                if (position == 1) {
//                    Intent intent = new Intent(context, NonVegRestaurant.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                }
//            }
//        });
//
//
//        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier
//                (categoryDomains.get(position).getPic(),"drawable",
//                        holder.itemView.getContext().getPackageName());
//
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.categoryPic);
//    }
//
//    @Override
//    public int getItemCount() {
//
//      return categoryDomains.size();
//
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        TextView categoryName;
//        ImageView categoryPic;
//        ConstraintLayout mainLayout;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            categoryName = itemView.findViewById(R.id.categoryName);
//            categoryPic = itemView.findViewById(R.id.categoryPic);
//            mainLayout = itemView.findViewById(R.id.mainLayout);
//        }
//    }
//}

package com.ocem.foodieexpress.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ocem.foodieexpress.Activity.NonVegRestaurant;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.domain.CategoryDomain;
import com.ocem.foodieexpress.model.Datum;
import com.ocem.foodieexpress.model.HomeRestaurant;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {
    Context context;
    private List<HomeRestaurant> homeRestaurantList;

    public CategoryAdaptor(Context context,List<HomeRestaurant> homeRestaurantList){
        this.context = context;
        this.homeRestaurantList = homeRestaurantList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeRestaurant homedata = homeRestaurantList.get(position);

        holder.categoryName.setText(homedata.getType());

        Glide.with(context)
                .load("http://192.168.137.1:8000/images/" + homedata.getPhotoPath())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.categoryPic);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//
//                if (position == 1) {
//                    Intent intent = new Intent(context, NonVegRestaurant.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {

        return homeRestaurantList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
