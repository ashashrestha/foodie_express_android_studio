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
import com.ocem.foodieexpress.domain.PastaDomain;

import java.util.ArrayList;

public class PastaAdapter extends RecyclerView.Adapter<PastaAdapter.PastaViewHolder>{
    ArrayList<PastaDomain> PastaArrayList;

    public PastaAdapter(ArrayList<PastaDomain> PastaArrayList) {

        this.PastaArrayList = PastaArrayList;
    }
    @NonNull
    @Override
    public PastaAdapter.PastaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item,parent,false);
        return new PastaAdapter.PastaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PastaAdapter.PastaViewHolder holder, int position) {
        holder.tvCLargeP.setText(PastaArrayList.get(position).getHeading());
        holder.tvCNrs.setText(PastaArrayList.get(position).getCNrs());
        holder.tvPlate.setText(PastaArrayList.get(position).getPlate());
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(PastaArrayList.get(position).getTitleImage(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.PastaImage);
    }

    @Override
    public int getItemCount() {

        return PastaArrayList.size();
    }

    public class PastaViewHolder extends RecyclerView.ViewHolder {
        ImageView PastaImage;
        TextView tvCLargeP;
        TextView tvPlate;
        TextView tvCNrs;
        public PastaViewHolder(@NonNull View itemView) {

            super(itemView);
            PastaImage = itemView.findViewById(R.id.CLPimage);
            tvCLargeP = itemView.findViewById(R.id.tvCLargeP);
            tvPlate = itemView.findViewById(R.id.tvPlate);
            tvCNrs = itemView.findViewById(R.id.tvCNrs);
        }
    }
}
