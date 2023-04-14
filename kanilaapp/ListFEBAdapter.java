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

public class ListFEBAdapter extends RecyclerView.Adapter<ListFEBAdapter.ListViewHolder> {

    private ArrayList<FEB> listfeb;

    public ListFEBAdapter(FEB feb, ArrayList<FEB> list) {
        this.listfeb = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_feb, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        FEB feb = listfeb.get(position);
        Glide.with(holder.itemView.getContext())
                .load(feb.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(feb.getName());
        holder.tvDetail.setText(feb.getDetail());
    }

    @Override
    public int getItemCount() {

        return listfeb.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_feb);
            tvName = itemview.findViewById(R.id.tv_item_namefeb);
            tvDetail = itemview.findViewById(R.id.tv_detailfeb);
        }
    }
}
