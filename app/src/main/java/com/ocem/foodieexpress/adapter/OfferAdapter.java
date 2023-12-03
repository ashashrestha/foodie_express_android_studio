package com.ocem.foodieexpress.adapter;

import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ocem.foodieexpress.domain.OfferDomain;
import com.ocem.foodieexpress.R;

import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder>{

    private ArrayList<OfferDomain> offerArrayList;

    public OfferAdapter(ArrayList<OfferDomain> offerArrayList) {
        this.offerArrayList = offerArrayList;
    }

    @NonNull
    @Override
    public OfferAdapter.OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_list_item,parent,false);
        return new OfferAdapter.OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {
        holder.title.setText(offerArrayList.get(position).getTitle());
        holder.food.setText(offerArrayList.get(position).getFood());
        holder.amount.setText(offerArrayList.get(position).getAmount());
        holder.offerP.setText(offerArrayList.get(position).getOfferP());
        holder.offer.setText(offerArrayList.get(position).getOffer());

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier
                (offerArrayList.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        String price = String.valueOf(offerArrayList.get(position).getPrice());
        SpannableString spannableString = new SpannableString(price);
        spannableString.setSpan(new StrikethroughSpan(),0,price.length(),0);
        holder.price.setText(spannableString);
    }

    @Override
    public int getItemCount() {

        return offerArrayList.size();
    }

    public class OfferViewHolder extends RecyclerView.ViewHolder {

        private ImageView pic;
        private TextView title;
        private TextView food;
        private   TextView amount;
        private   TextView offerP;
        private   TextView price;
        private   TextView offer;
        public OfferViewHolder(@NonNull View itemView) {

            super(itemView);
            pic = itemView.findViewById(R.id.pic);
            title = itemView.findViewById(R.id.title);
            food = itemView.findViewById(R.id.food);
            amount = itemView.findViewById(R.id.amount);
            offerP = itemView.findViewById(R.id.offerP);
            price = itemView.findViewById(R.id.price);
            offer = itemView.findViewById(R.id.offer);
        }
    }
}
