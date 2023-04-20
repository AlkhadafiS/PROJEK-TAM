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

public class ListFEBAdapter extends RecyclerView.Adapter<ListFEBAdapter.ListViewHolder> {

    private ArrayList<FEB> listfeb;
    private Context context;

    public ListFEBAdapter(Context context, ArrayList<FEB> list) {
        this.context = context;
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
                intent.putExtra("fakultas_name", listfeb.get(holder.getAdapterPosition()).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return listfeb.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        public View parentLayout;
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_feb);
            tvName = itemview.findViewById(R.id.tv_item_namefeb);
            tvDetail = itemview.findViewById(R.id.tv_detailfeb);
            parentLayout = itemview.findViewById(R.id.parentLayout);
        }
    }
}

