//package com.ocem.foodieexpress.adapter;
//
//import android.content.Context;
//        import android.content.Intent;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.Button;
//        import android.widget.ImageView;
//        import android.widget.TextView;
//
//        import androidx.annotation.NonNull;
//        import androidx.recyclerview.widget.RecyclerView;
//
//        import com.bumptech.glide.Glide;
//        import com.ocem.foodieexpress.domain.NVRDemo;
//        import com.ocem.foodieexpress.R;
//        import com.ocem.foodieexpress.Activity.RestaurantActivity;
//
//        import java.util.ArrayList;
//
//public class NonVegRestaurantAdapter extends RecyclerView.Adapter<NonVegRestaurantAdapter.NVRViewHolder> {
//    private ArrayList<NVRDemo> NVRArrayList;
//    Context context;
//    public NonVegRestaurantAdapter(ArrayList<NVRDemo> NVRArrayList, Context context) {
//        this.NVRArrayList = NVRArrayList;
//        this.context = context;
//    }
//
//
//    @NonNull
//    @Override
//    public NonVegRestaurantAdapter.NVRViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_non_veg_restaurant_list_item,parent,false);
//        return new NonVegRestaurantAdapter.NVRViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull NonVegRestaurantAdapter.NVRViewHolder holder, int position) {
//
//        holder.RestroName.setText(NVRArrayList.get(position).getRestroNAme());
//        holder.RestroAdd.setText(NVRArrayList.get(position).getRestroAdd());
//        holder.DeliveryHrs.setText(NVRArrayList.get(position).getDeliveryHrs());
//
//        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier
//                (NVRArrayList.get(position).getRestroLogo(),"drawable",
//                        holder.itemView.getContext().getPackageName());
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.RestroLogo);
//
//        drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(NVRArrayList.get(position).getAddLogo(), "drawable", holder.itemView.getContext().getPackageName());
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.AddLogo);
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//
//                if (position == 2) {
//                    Intent intent = new Intent(context, RestaurantActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                }
//            }
//        });
//
//        holder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//
//                if (position == 2) {
//                    Intent intent = new Intent(context, RestaurantActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                }
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return NVRArrayList.size();
//    }
//
//    public class NVRViewHolder extends RecyclerView.ViewHolder {
//        private Button button;
//        private ImageView RestroLogo;
//        private   TextView RestroName;
//        private ImageView AddLogo;
//        private   TextView RestroAdd;
//        private   TextView DeliveryHrs;
//        public NVRViewHolder(@NonNull View itemView) {
//
//            super(itemView);
//            RestroLogo = itemView.findViewById(R.id.RestroLogo);
//            RestroName = itemView.findViewById(R.id.tvRestroName);
//            AddLogo = itemView.findViewById(R.id.Addlogo);
//            RestroAdd = itemView.findViewById(R.id.tvRestroAdd);
//            DeliveryHrs = itemView.findViewById(R.id.tvDeliveryHrs);
//            button = itemView.findViewById(R.id.btOrdernow);
//        }
//  }
//}

//package com.ocem.foodieexpress.adapter;
//
//import android.content.Context;
//        import android.content.Intent;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.Button;
//        import android.widget.ImageView;
//        import android.widget.TextView;
//
//        import androidx.annotation.NonNull;
//        import androidx.recyclerview.widget.RecyclerView;
//
//        import com.bumptech.glide.Glide;
//import com.ocem.foodieexpress.Restaurant;
//import com.ocem.foodieexpress.domain.NVRDemo;
//        import com.ocem.foodieexpress.R;
//        import com.ocem.foodieexpress.Activity.RestaurantActivity;
//import com.ocem.foodieexpress.model.HomeRestaurant;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class NonVegRestaurantAdapter extends RecyclerView.Adapter<NonVegRestaurantAdapter.NVRViewHolder> {
//
//    private List<Restaurant> NVRArrayList;
//    Context context;
//    public NonVegRestaurantAdapter( Context context) {
//        this.NVRArrayList = NVRArrayList;
//        this.context = context;
//    }
//
//
//    @NonNull
//    @Override
//    public NonVegRestaurantAdapter.NVRViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_non_veg_restaurant_list_item,parent,false);
//        return new NonVegRestaurantAdapter.NVRViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull NonVegRestaurantAdapter.NVRViewHolder holder, int position) {
//
//        holder.RestroName.setText(NVRArrayList.get(position).getRestroNAme());
//        holder.RestroAdd.setText(NVRArrayList.get(position).getRestroAdd());
//        holder.DeliveryHrs.setText(NVRArrayList.get(position).getDeliveryHrs());
//
//        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier
//                (NVRArrayList.get(position).getRestroLogo(),"drawable",
//                        holder.itemView.getContext().getPackageName());
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.RestroLogo);
//
//        drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(NVRArrayList.get(position).getAddLogo(), "drawable", holder.itemView.getContext().getPackageName());
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.AddLogo);
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//
//                if (position == 2) {
//                    Intent intent = new Intent(context, RestaurantActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                }
//            }
//        });
//
//        holder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//
//                if (position == 2) {
//                    Intent intent = new Intent(context, RestaurantActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                }
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return NVRArrayList.size();
//    }
//
//    public class NVRViewHolder extends RecyclerView.ViewHolder {
//        private Button button;
//        private ImageView RestroLogo;
//        private   TextView RestroName;
//        private ImageView AddLogo;
//        private   TextView RestroAdd;
//        private   TextView DeliveryHrs;
//        public NVRViewHolder(@NonNull View itemView) {
//
//            super(itemView);
//            RestroLogo = itemView.findViewById(R.id.RestroLogo);
//            RestroName = itemView.findViewById(R.id.tvRestroName);
//            AddLogo = itemView.findViewById(R.id.Addlogo);
//            RestroAdd = itemView.findViewById(R.id.tvRestroAdd);
//            DeliveryHrs = itemView.findViewById(R.id.tvDeliveryHrs);
//            button = itemView.findViewById(R.id.btOrdernow);
//        }
//    }
//}

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
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.Activity.RestaurantActivity;
import com.ocem.foodieexpress.domain.NVRDemo;
import com.ocem.foodieexpress.model.Restaurant.Restaurant;
import com.ocem.foodieexpress.model.Restaurant.RestaurantResponse;


import java.util.ArrayList;

public class NonVegRestaurantAdapter extends RecyclerView.Adapter<NonVegRestaurantAdapter.NVRViewHolder> {
    private ArrayList<NVRDemo> NVRArrayList;
    private Context context;

    public NonVegRestaurantAdapter(ArrayList<NVRDemo> NVRArrayList, Context context) {
        this.NVRArrayList = NVRArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public NVRViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_non_veg_restaurant_list_item, parent, false);
        return new NVRViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NVRViewHolder holder, int position) {

        NVRDemo nvrDemo = NVRArrayList.get(position);
        holder.RestroName.setText(nvrDemo.getRestroNAme());
        holder.RestroAdd.setText(nvrDemo.getRestroAdd());
        holder.DeliveryHrs.setText(nvrDemo.getDeliveryHrs());

//        Glide.with(holder.RestroLogo.getContext())
//                .load("http://192.168.21.224:8000/images/" + nvrDemo.getRestroLogo())
//                .error(R.drawable.ic_launcher_foreground)
//                .into(holder.RestroLogo);

        Glide.with(context)
                .load("http://192.168.137.1:8000/images/" + nvrDemo.getRestroLogo())
                .placeholder(R.drawable.veg_khajaset)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.RestroLogo);


//        // Load restaurant logo using Glide
//        int drawableResourceId = context.getResources().getIdentifier(
//                nvrDemo.getRestroLogo(), "drawable", context.getPackageName());
//        Glide.with(context)
//                .load(drawableResourceId)
//                .into(holder.RestroLogo);
//
//        // Load address logo using Glide
//        drawableResourceId = context.getResources().getIdentifier(
//                nvrDemo.getAddLogo(), "drawable", context.getPackageName());
//        Glide.with(context)
//                .load(drawableResourceId)
//                .into(holder.AddLogo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle item click here
                // For example, you can start a new activity for restaurant details
                Intent intent = new Intent(context, RestaurantActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return NVRArrayList.size();
    }

    public class NVRViewHolder extends RecyclerView.ViewHolder {
        private Button button;
        private ImageView RestroLogo;
        private TextView RestroName;
        private ImageView AddLogo;
        private TextView RestroAdd;
        private TextView DeliveryHrs;

        public NVRViewHolder(@NonNull View itemView) {
            super(itemView);
            RestroLogo = itemView.findViewById(R.id.RestroLogo);
            RestroName = itemView.findViewById(R.id.tvRestroName);
            AddLogo = itemView.findViewById(R.id.Addlogo);
            RestroAdd = itemView.findViewById(R.id.tvRestroAdd);
            DeliveryHrs = itemView.findViewById(R.id.tvDeliveryHrs);
            button = itemView.findViewById(R.id.btOrdernow);
        }
    }
}
























//package com.ocem.foodieexpress.adapter;
//
//        import android.content.Context;
//        import android.content.Intent;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.Button;
//        import android.widget.ImageView;
//        import android.widget.TextView;
//
//        import androidx.annotation.NonNull;
//        import androidx.recyclerview.widget.RecyclerView;
//
//        import com.bumptech.glide.Glide;
//        import com.ocem.foodieexpress.domain.NVRDemo;
//        import com.ocem.foodieexpress.R;
//        import com.ocem.foodieexpress.Activity.RestaurantActivity;
//        import com.ocem.foodieexpress.model.Restaurant.Restaurant;
//
//        import java.util.ArrayList;
//
//public class NonVegRestaurantAdapter extends RecyclerView.Adapter<NonVegRestaurantAdapter.NVRViewHolder> {
//    private ArrayList<NVRDemo> NVRArrayList;
//
////    private ArrayList<Restaurant> restaurantArrayList;
//    private Context context;
//    public NonVegRestaurantAdapter(ArrayList<NVRDemo> NVRArrayList, Context context) {
//        this.NVRArrayList = NVRArrayList;
//        this.context = context;
//    }
//
//
//    @NonNull
//    @Override
//    public NonVegRestaurantAdapter.NVRViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_non_veg_restaurant_list_item,parent,false);
//        return new NonVegRestaurantAdapter.NVRViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull NonVegRestaurantAdapter.NVRViewHolder holder, int position) {
//
//        holder.RestroName.setText(NVRArrayList.get(position).getRestroNAme());
//        holder.RestroAdd.setText(NVRArrayList.get(position).getRestroAdd());
//        holder.DeliveryHrs.setText(NVRArrayList.get(position).getDeliveryHrs());
//
//        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier
//                (NVRArrayList.get(position).getRestroLogo(),"drawable",
//                        holder.itemView.getContext().getPackageName());
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.RestroLogo);
//
//        drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(NVRArrayList.get(position).getAddLogo(), "drawable", holder.itemView.getContext().getPackageName());
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.AddLogo);
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//
//                if (position == 2) {
//                    Intent intent = new Intent(context, RestaurantActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                }
//            }
//        });
//
//        holder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//
//                if (position == 2) {
//                    Intent intent = new Intent(context, RestaurantActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                }
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return NVRArrayList.size();
//    }
//
//    public class NVRViewHolder extends RecyclerView.ViewHolder {
//        private Button button;
//        private ImageView RestroLogo;
//        private   TextView RestroName;
//        private ImageView AddLogo;
//        private   TextView RestroAdd;
//        private   TextView DeliveryHrs;
//        public NVRViewHolder(@NonNull View itemView) {
//
//            super(itemView);
//            RestroLogo = itemView.findViewById(R.id.RestroLogo);
//            RestroName = itemView.findViewById(R.id.tvRestroName);
//            AddLogo = itemView.findViewById(R.id.Addlogo);
//            RestroAdd = itemView.findViewById(R.id.tvRestroAdd);
//            DeliveryHrs = itemView.findViewById(R.id.tvDeliveryHrs);
//            button = itemView.findViewById(R.id.btOrdernow);
//        }
//    }
//}








