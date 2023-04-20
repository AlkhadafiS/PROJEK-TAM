package com.example.kanilaapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMenuAdapter extends RecyclerView.Adapter<ListMenuAdapter.ListViewHolder> {

    private static ArrayList<MENU> listmenu;
    private Context context;

    public ListMenuAdapter(Context context, ArrayList<MENU> list) {
        this.context = context;
        this.listmenu = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_menu, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        MENU menu = listmenu.get(position);
        Glide.with(holder.itemView.getContext())
                .load(menu.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(menu.getName());
        holder.tvDetail.setText(menu.getDetail());
        holder.btnCall.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                String phoneNumberWithCountryCode = "+6289510118224";
                String message = "Halo, saya ingin memesan ";
                String url = "https://api.whatsapp.com/send?phone=" + phoneNumberWithCountryCode + "&text=" + message + menu.getName() ;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
            }
        }));
    }

    @Override
    public int getItemCount() {

        return listmenu.size();
    }

    public void filteredList(ArrayList<MENU> filteredList){
        listmenu = filteredList;
        notifyDataSetChanged();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        Button btnCall;
        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_menu);
            tvName = itemview.findViewById(R.id.tv_item_namemenu);
            tvDetail = itemview.findViewById(R.id.tv_detailmenu);
            btnCall = (Button)itemView.findViewById(R.id.btn_call);
        }
    }
}
