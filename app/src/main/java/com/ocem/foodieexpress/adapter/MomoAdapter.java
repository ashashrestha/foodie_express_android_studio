package com.ocem.foodieexpress.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ocem.foodieexpress.R;
import com.ocem.foodieexpress.domain.Momo;

import java.util.ArrayList;

public class MomoAdapter extends RecyclerView.Adapter<MomoAdapter.MomoViewHolder> {
    ArrayList<Momo> momoArrayList;
    public MomoAdapter(ArrayList<Momo> momoArrayList) {

        this.momoArrayList = momoArrayList;
    }

    @NonNull
    @Override
    public MomoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item,parent,false);
        return new MomoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MomoViewHolder holder, int position) {
        holder.tvCLargeP.setText(momoArrayList.get(position).getHeading());
        holder.tvCNrs.setText(momoArrayList.get(position).getCNrs());
        holder.tvPlate.setText(momoArrayList.get(position).getPlate());
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(momoArrayList.get(position).getTitleImage(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.MomoImage);

    }

    @Override
    public int getItemCount() {

        return momoArrayList.size();
    }

    public static class MomoViewHolder extends RecyclerView.ViewHolder{

        ImageView MomoImage;
        TextView tvCLargeP;
        TextView tvPlate;
        TextView tvCNrs;


        public MomoViewHolder(@NonNull View itemView) {
            super(itemView);
            MomoImage = itemView.findViewById(R.id.CLPimage);
            tvCLargeP = itemView.findViewById(R.id.tvCLargeP);
            tvPlate = itemView.findViewById(R.id.tvPlate);
            tvCNrs = itemView.findViewById(R.id.tvCNrs);

        }
    }
}
