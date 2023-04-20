package com.example.kanilaapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ListFakultasAdapter extends RecyclerView.Adapter<ListFakultasAdapter.ListViewHolder> {

    private ArrayList<fakultas> listFakultas;
    private OnItemClickCallBack onItemClickCallBack;
    private Context context;

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

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
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        holder.tvName.setText(fakultas.getName());
        holder.tvDetail.setText(fakultas.getDetail());

        int[] colors = holder.itemView.getResources().getIntArray(R.array.list_background_colors);
        int color = colors[position % colors.length];
        holder.parentLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.rounded_background));
        holder.parentLayout.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);

        // menambahkan padding pada setiap item
        int padding = holder.itemView.getResources().getDimensionPixelSize(R.dimen.list_item_padding);
        holder.parentLayout.setPadding(padding, padding, padding, padding);

        // mengatur margin item agar tidak menempel pada sisi kanan
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) holder.parentLayout.getLayoutParams();
        params.rightMargin = holder.itemView.getResources().getDimensionPixelSize(R.dimen.list_item_margin_right);
        holder.parentLayout.setLayoutParams(params);

        holder.itemView.setOnClickListener(v -> onItemClickCallBack.onItemClicked(fakultas));
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

    public interface OnItemClickCallBack {
        void onItemClicked(fakultas data);
    }
}
