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

public class ListFISIPAdapter extends RecyclerView.Adapter<ListFISIPAdapter.ListViewHolder> {

    private ArrayList<FISIP> listfisip;

    public ListFISIPAdapter(FISIP fisip, ArrayList<FISIP> list) {
        this.listfisip = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_fisip, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        FISIP fisip = listfisip.get(position);
        Glide.with(holder.itemView.getContext())
                .load(fisip.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(fisip.getName());
        holder.tvDetail.setText(fisip.getDetail());
    }

    @Override
    public int getItemCount() {

        return listfisip.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_fisip);
            tvName = itemview.findViewById(R.id.tv_item_namefisip);
            tvDetail = itemview.findViewById(R.id.tv_detailfisip);
        }
    }
}
