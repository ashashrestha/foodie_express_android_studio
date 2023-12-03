package com.ocem.foodieexpress.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ocem.foodieexpress.Activity.NonVegRestaurant;
import com.ocem.foodieexpress.model.Datum;
import com.ocem.foodieexpress.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Datum> dataArrayList;
    private Context context;

    public CategoryAdapter(  Context context,List<Datum> dataArrayList) {
        this.context = context;
        this.dataArrayList = dataArrayList;

    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_category_list, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Datum datum = dataArrayList.get(position);

        holder.tvCLargeP.setText(datum.getType());

        Glide.with(context)
                .load("http://192.168.137.1:8000/images/" + datum.getPhotoPath())
                .placeholder(R.drawable.veg_khajaset)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.CategoryImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();

                    Intent intent = new Intent(context, NonVegRestaurant.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount()
    {
        return dataArrayList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView CategoryImage;
        TextView tvCLargeP;
        Button button;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            CategoryImage = itemView.findViewById(R.id.CLPimage);
            tvCLargeP = itemView.findViewById(R.id.tvCLargeP);
            button = itemView.findViewById(R.id.btOrdernow);

            // You can handle button clicks here and open activities based on category or item clicked
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle button click here
                }
            });
        }
    }
}





//package com.ocem.foodieexpress.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import com.bumptech.glide.Glide;
//import com.ocem.foodieexpress.R;
//import com.ocem.foodieexpress.model.domain.Category;
//import com.ocem.foodieexpress.model.domain.OfferDomain;
//
//import java.util.ArrayList;
//
//public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
////    private List<Data> categoryArrayList;
//
//    private ArrayList<Category> categoryArrayList;
//    private Context context;
//
//    public CategoryAdapter(ArrayList<Category> categoryArrayList,Context context) {
//        this.categoryArrayList = categoryArrayList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_category_list, parent, false);
//        return new CategoryViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
//
//        holder.tvCLargeP.setText(categoryArrayList.get(position).getHeading1());
//
//        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier
//                (categoryArrayList.get(position).getTitleImage(),"drawable",holder.itemView.getContext().getPackageName());
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.CategoryImage);
//
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.CategoryImage);
//    }
//
//    @Override
//    public int getItemCount() {
//        return categoryArrayList.size();
//    }
//
//    public class CategoryViewHolder extends RecyclerView.ViewHolder {
//        ImageView CategoryImage;
//        TextView tvCLargeP;
//        Button button;
//
//        public CategoryViewHolder(@NonNull View itemView) {
//            super(itemView);
//            CategoryImage = itemView.findViewById(R.id.CLPimage);
//            tvCLargeP = itemView.findViewById(R.id.tvCLargeP);
//            button = itemView.findViewById(R.id.btOrdernow);
//
//            // You can handle button clicks here and open activities based on category or item clicked
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // Handle button click here
//                }
//            });
//        }
//    }
//}
























//package com.ocem.foodieexpress.adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.ocem.foodieexpress.Activity.NonVegRestaurant;
//import com.ocem.foodieexpress.R;
//import com.ocem.foodieexpress.model.model.RestaurantType;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
//   private List<RestaurantType> categoryArrayList;
//   Button button;
//   Context context;
//   public CategoryAdapter( Context context,List<RestaurantType> categoryArrayList) {
//        this.categoryArrayList = categoryArrayList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_category_list,parent,false);
//        return new CategoryAdapter.CategoryViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
//        final RestaurantType temp = categoryArrayList.get(position);
//
////        holder.tvCLargeP.setText(categoryArrayList.get(position).getType());
////        holder.tvCNrs.setText(categoryArrayList.get(position).getType());
////
////        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(categoryArrayList.get(position).getType(),"drawable",holder.itemView.getContext().getPackageName());
////
////        Glide.with(holder.itemView.getContext())
////                .load(drawableResourceId)
////                .into(holder.CategoryImage);
////
////        holder.itemView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                int position = holder.getAdapterPosition();
////
////                if (position == 1) {
////                    Intent intent = new Intent(context, NonVegRestaurant.class);
////                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                    context.startActivity(intent);
////                }
////            }
////        });
////
////        holder.button.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                int position = holder.getAdapterPosition();
////
////                if (position == 1) {
////                    Intent intent = new Intent(context, NonVegRestaurant.class);
////                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                    context.startActivity(intent);
////                }
////            }
////        });
//
//        holder.tvCLargeP.setText(categoryArrayList.get(position).getData().getType());
//        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(categoryArrayList.get(position)
//                        .getData().getPhotoPath(), "drawable",holder.itemView.getContext().getPackageName());
//
//        Glide.with(holder.itemView.getContext())
//               .load(drawableResourceId)
//               .into(holder.CategoryImage);
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//
//      return categoryArrayList.size();
//    }
//
//    public class CategoryViewHolder extends RecyclerView.ViewHolder {
//        private Button button;
//        ImageView CategoryImage;
//        TextView tvCLargeP;
//      private TextView tvCNrs;
//        public CategoryViewHolder(@NonNull View itemView) {
//            super(itemView);
//              CategoryImage = itemView.findViewById(R.id.CLPimage);
//              tvCLargeP = itemView.findViewById(R.id.tvCLargeP);
//              tvCNrs = itemView.findViewById(R.id.tvCNrs);
//              button = itemView.findViewById(R.id.btOrdernow);
//        }
//
//
//    }
//}
