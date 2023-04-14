package com.example.kanilaapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListFakultasAdapter extends RecyclerView.Adapter<ListFakultasAdapter.ListViewHolder> {

    private ArrayList<fakultas> listFakultas;

    private Context context;

    LinearLayout parentLayout;

    public ListFakultasAdapter(Context context, ArrayList<fakultas> list) {
        this.context = context;
        this.listFakultas = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_fakultas, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        fakultas fakultas = listFakultas.get(position);
        Glide.with(holder.itemView.getContext())
                .load(fakultas.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(fakultas.getName());
        holder.tvDetail.setText(fakultas.getDetail());


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            int index = holder.getAdapterPosition();
            Intent intent;

            switch (index) {
                case 0:
                    intent = new Intent(context, FMIPA.class);
                    break;
                case 1:
                    intent = new Intent(context, FEB.class);
                    break;
                case 2:
                    intent = new Intent(context, FH.class);
                    break;
                case 3:
                    intent = new Intent(context, FP.class);
                    break;
                case 4:
                    intent = new Intent(context, FKIP.class);
                    break;
                case 5:
                    intent = new Intent(context, FT.class);
                    break;
                case 6:
                    intent = new Intent(context, FISIP.class);
                    break;
                case 7:
                    intent = new Intent(context, FK.class);
                    break;

                default:
                    intent = new Intent(context, MainActivity.class);
                    break;
            }
                intent.putExtra("fakultas_name", listFakultas.get(holder.getAdapterPosition()).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return listFakultas.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        public View parentLayout;
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_fakultas);
            tvName = itemview.findViewById(R.id.tv_item_name);
            tvDetail = itemview.findViewById(R.id.tv_detail);
            parentLayout = itemview.findViewById(R.id.parentLayout);
        }
    }
}
