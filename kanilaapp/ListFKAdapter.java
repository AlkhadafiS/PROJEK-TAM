package com.example.kanilaapp;

import android.content.Context;
import android.content.Intent;
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

public class ListFKAdapter extends RecyclerView.Adapter<ListFKAdapter.ListViewHolder> {

    private ArrayList<FK> listfk;
    private Context context;

    public ListFKAdapter(Context context, ArrayList<FK> list) {
        this.context = context;
        this.listfk = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_fk, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        FK fk = listfk.get(position);
        Glide.with(holder.itemView.getContext())
                .load(fk.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(fk.getName());
        holder.tvDetail.setText(fk.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int index = holder.getAdapterPosition();
                Intent intent;

                switch (index) {
                    case 0:
                    case 1:
                    case 2:
                        intent = new Intent(context, MENU.class);
                        break;

                    default:
                        intent = new Intent(context, MainActivity.class);
                        break;
                }
                intent.putExtra("fakultas_name", listfk.get(holder.getAdapterPosition()).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return listfk.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        public View parentLayout;
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_fk);
            tvName = itemview.findViewById(R.id.tv_item_namefk);
            tvDetail = itemview.findViewById(R.id.tv_detailfk);
            parentLayout = itemview.findViewById(R.id.parentLayout);
        }
    }
}
