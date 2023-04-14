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

public class ListFPAdapter extends RecyclerView.Adapter<ListFPAdapter.ListViewHolder> {

    private ArrayList<FP> listfp;

    public ListFPAdapter(FP fp, ArrayList<FP> list) {
        this.listfp = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_fp, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        FP fp = listfp.get(position);
        Glide.with(holder.itemView.getContext())
                .load(fp.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(fp.getName());
        holder.tvDetail.setText(fp.getDetail());
    }

    @Override
    public int getItemCount() {

        return listfp.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_fp);
            tvName = itemview.findViewById(R.id.tv_item_namefp);
            tvDetail = itemview.findViewById(R.id.tv_detailfp);
        }
    }
}
