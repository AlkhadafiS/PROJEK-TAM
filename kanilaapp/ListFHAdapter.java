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

public class ListFHAdapter extends RecyclerView.Adapter<ListFHAdapter.ListViewHolder> {

    private ArrayList<FH> listfh;

    public ListFHAdapter(FH fh, ArrayList<FH> list) {
        this.listfh = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_fh, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        FH fh = listfh.get(position);
        Glide.with(holder.itemView.getContext())
                .load(fh.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(fh.getName());
        holder.tvDetail.setText(fh.getDetail());
    }

    @Override
    public int getItemCount() {

        return listfh.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_fh);
            tvName = itemview.findViewById(R.id.tv_item_namefh);
            tvDetail = itemview.findViewById(R.id.tv_detailfh);
        }
    }
}
