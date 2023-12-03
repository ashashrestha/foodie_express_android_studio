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
import com.ocem.foodieexpress.domain.ColdBeverageDomain;

import java.util.ArrayList;

public class ColdBeverageAdapter extends RecyclerView.Adapter<ColdBeverageAdapter.ColdBeverageViewHolder>{
    ArrayList<ColdBeverageDomain> coldBeverageDomainArrayList;
    public ColdBeverageAdapter(ArrayList<ColdBeverageDomain> coldBeverageDomainArrayList) {

        this.coldBeverageDomainArrayList = coldBeverageDomainArrayList;
    }

    @NonNull
    @Override
    public ColdBeverageAdapter.ColdBeverageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item,parent,false);
        return new ColdBeverageAdapter.ColdBeverageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ColdBeverageAdapter.ColdBeverageViewHolder holder, int position) {
        holder.tvCLargeP.setText(coldBeverageDomainArrayList.get(position).getHeading());
        holder.tvCNrs.setText(coldBeverageDomainArrayList.get(position).getCNrs());
        holder.tvPlate.setText(coldBeverageDomainArrayList.get(position).getPlate());
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(coldBeverageDomainArrayList.get(position).getTitleImage(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.ColdBeverageImage);
    }

    @Override
    public int getItemCount() {
        return coldBeverageDomainArrayList.size();
    }

    public class ColdBeverageViewHolder extends RecyclerView.ViewHolder {
        ImageView ColdBeverageImage;
        TextView tvCLargeP;
        TextView tvPlate;
        TextView tvCNrs;
        public ColdBeverageViewHolder(@NonNull View itemView) {
            super(itemView);
            ColdBeverageImage = itemView.findViewById(R.id.CLPimage);
            tvCLargeP = itemView.findViewById(R.id.tvCLargeP);
            tvPlate = itemView.findViewById(R.id.tvPlate);
            tvCNrs = itemView.findViewById(R.id.tvCNrs);
        }
    }
}
