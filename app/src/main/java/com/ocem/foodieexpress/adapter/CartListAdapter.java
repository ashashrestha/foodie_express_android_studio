package com.ocem.foodieexpress.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.model.Cart.CartItem;
import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.CartViewHolder> {
    private ArrayList<CartItem> cartItemList;
    private Context context;

    public CartListAdapter(ArrayList<CartItem> cartItemList, Context context) {
        this.cartItemList = cartItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public CartListAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list_item,parent,false);
        return new CartListAdapter.CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem cartItem = cartItemList.get(position);

        Glide.with(context)
                .load(cartItem.getPhotoPath())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.ivProduct);


        holder.tvProductName.setText(cartItem.getMenuName());
        holder.tvRestroName.setText(cartItem.getRestaurantName());
        holder.tvPrice.setText(cartItem.getPrice());
        holder.etQuantity.setText(String.valueOf(cartItem.getQuantity()));
        holder.tvminus.setText(cartItem.getMinus());
        holder.tvplus.setText(cartItem.getPlus());
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivProduct;
        private TextView tvProductName, tvRestroName, tvPrice, etQuantity , tvminus, tvplus;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProduct = itemView.findViewById(R.id.ivproduct);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvRestroName = itemView.findViewById(R.id.tvRestroName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            etQuantity = itemView.findViewById(R.id.etQuantity);
            tvminus = itemView.findViewById(R.id.tvminus);
            tvplus = itemView.findViewById(R.id.tvplus);

            tvplus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String currentValue = etQuantity.getText().toString();
                    int value = Integer.parseInt(currentValue);
                    value++;
                    etQuantity.setText(String.valueOf(value));
                }
            });

            tvminus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String currentValue = etQuantity.getText().toString();
                    int value = Integer.parseInt(currentValue);
                    value--;
                    etQuantity.setText(String.valueOf(value));
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
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.ocem.foodieexpress.R;
////import com.ocem.foodieexpress.domain.CartItem;
//import com.ocem.foodieexpress.model.Cart.CartItem;
//
//import java.util.ArrayList;
//
//
//public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.CartViewHolder> {
//    private ArrayList<CartItem> cartItemList;
//
//    Context context;
//
//    public CartListAdapter(ArrayList<CartItem> cartItemList, Context context) {
//        this.cartItemList = cartItemList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public CartListAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list_item,parent,false);
//        return new CartListAdapter.CartViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CartListAdapter.CartViewHolder holder, int position) {
//        CartItem cartItem = cartItemList.get(position);
//
//        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier
//                (cartItem.getProductImage(),"drawable",
//                        holder.itemView.getContext().getPackageName());
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.ivproduct);
//
//        holder.tvProductName.setText(cartItem.getProductName());
//        holder.tvRestroName.setText(cartItem.getRestaurantName());
//        holder.tvPrice.setText(cartItem.getPrice()+"");
//        holder.etQuantity.setText(cartItem.getQuantity());
//        holder.tvminus.setText(cartItem.getMinus());
//        holder.tvplus.setText(cartItem.getPlus());
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return cartItemList.size();
//    }
//
//    public class CartViewHolder extends RecyclerView.ViewHolder {
//
//        private ImageView ivproduct;
//        private TextView tvProductName;
//        private   TextView tvRestroName;
//        private   TextView tvPrice;
//        private   TextView etQuantity;
//        private TextView tvminus;
//        private   TextView tvplus;
//        public CartViewHolder(@NonNull View itemView) {
//
//            super(itemView);
//            ivproduct = itemView.findViewById(R.id.ivproduct);
//            tvProductName = itemView.findViewById(R.id.tvProductName);
//            tvRestroName = itemView.findViewById(R.id.tvRestroName);
//            tvPrice = itemView.findViewById(R.id.tvPrice);
//            etQuantity = itemView.findViewById(R.id.etQuantity);
//            tvminus = itemView.findViewById(R.id.tvminus);
//            tvplus = itemView.findViewById(R.id.tvplus);
//
//            tvplus.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String currentValue = etQuantity.getText().toString();
//                    int value = Integer.parseInt(currentValue);
//                    value++;
//                    etQuantity.setText(String.valueOf(value));
//                }
//            });
//
//            tvminus.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String currentValue = etQuantity.getText().toString();
//                    int value = Integer.parseInt(currentValue);
//                    value--;
//                    etQuantity.setText(String.valueOf(value));
//                }
//            });
//
//
//        }
//
//    }
//}





//package com.ocem.foodieexpress.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.ocem.foodieexpress.R;
//import com.ocem.foodieexpress.model.Cart.CartItem;
//
//import java.util.ArrayList;
//
//
//public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.CartViewHolder> {
//    private ArrayList<CartItem> cartItemList;
//    Context context;
//
//    public CartListAdapter(ArrayList<CartItem> cartItemList, Context context) {
//        this.cartItemList = cartItemList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public CartListAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list_item,parent,false);
//        return new CartListAdapter.CartViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CartListAdapter.CartViewHolder holder, int position) {
//        CartItem cartItem = cartItemList.get(position);
//
//        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier
//                (cartItem.getPhotoPath(), "drawable",
//                        holder.itemView.getContext().getPackageName());
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.ivproduct);
//
//        holder.tvProductName.setText(cartItem.getMenuName());
//        holder.tvRestroName.setText(cartItem.getRestaurantName());
//        holder.tvPrice.setText(cartItem.getPrice());
//        holder.tvminus.setText(cartItem.getMinus());
//        holder.etQuantity.setText(cartItem.getQuantity());
//        holder.tvplus.setText(cartItem.getPlus());
//
//        double itemPrice = Double.parseDouble(cartItem.getPrice());
//        int itemQuantity = cartItem.getQuantity();
//        double itemSubtotal = itemPrice * itemQuantity;
//        cartItem.setTotal(String.valueOf(itemSubtotal));
//
//        // Set the subtotal for this item
//        holder.tvSubtotal.setText(String.format("%.2f", itemSubtotal));
//    }
//
//
//    @Override
//    public int getItemCount() {
//
//        return cartItemList.size();
//    }
//
//    public class CartViewHolder extends RecyclerView.ViewHolder {
//
//        private ImageView ivproduct;
//        private TextView tvProductName;
//        private   TextView tvRestroName;
//        private   TextView tvPrice;
//        private TextView tvminus;
//        private   TextView etQuantity;
//        private   TextView tvplus;
//        private TextView tvSubtotal;
//
//        public CartViewHolder(@NonNull View itemView) {
//
//            super(itemView);
//            ivproduct = itemView.findViewById(R.id.ivproduct);
//            tvProductName = itemView.findViewById(R.id.tvProductName);
//            tvRestroName = itemView.findViewById(R.id.tvRestroName);
//            tvPrice = itemView.findViewById(R.id.tvPrice);
//            tvminus = itemView.findViewById(R.id.tvminus);
//            etQuantity = itemView.findViewById(R.id.etQuantity);
//            tvplus = itemView.findViewById(R.id.tvplus);
//
//            tvSubtotal = itemView.findViewById(R.id.tvsubtotal);
//
//            tvplus.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String currentValue = etQuantity.getText().toString();
//                    int value = Integer.parseInt(currentValue);
//                    value++;
//                    etQuantity.setText(String.valueOf(value));
//                }
//            });
//
//            tvminus.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String currentValue = etQuantity.getText().toString();
//                    int value = Integer.parseInt(currentValue);
//                    value--;
//                    etQuantity.setText(String.valueOf(value));
//                }
//            });
//        }
//
//    }
//}
