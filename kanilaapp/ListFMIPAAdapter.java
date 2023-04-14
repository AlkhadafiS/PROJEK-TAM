package com.example.kanilaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListFMIPAAdapter extends RecyclerView.Adapter<ListFMIPAAdapter.ListViewHolder> {

    private ArrayList<FMIPA> listfmipa;

    public ListFMIPAAdapter(FMIPA fmipa, ArrayList<FMIPA> list) {
        this.listfmipa = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_fmipa, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        FMIPA fmipa = listfmipa.get(position);
        Glide.with(holder.itemView.getContext())
                .load(fmipa.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(fmipa.getName());
        holder.tvDetail.setText(fmipa.getDetail());
    }

    @Override
    public int getItemCount() {

        return listfmipa.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_fmipa);
            tvName = itemview.findViewById(R.id.tv_item_namefmipa);
            tvDetail = itemview.findViewById(R.id.tv_detailfmipa);
        }
    }
}
