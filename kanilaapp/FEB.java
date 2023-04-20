package com.example.kanilaapp;

import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FEB extends AppCompatActivity {
    private String name;
    private String detail;
    private int photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    private RecyclerView rvFEB;
    private ArrayList<FEB> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feb);

        getSupportActionBar().hide();
        Typeface typeface = Typeface.createFromAsset(getAssets(), "kanila_font.otf");
        TextView textView = findViewById(R.id.logo_textview);
        textView.setTypeface(typeface);
        rvFEB = findViewById(R.id.rv_feb);
        rvFEB.setHasFixedSize(true);

        list.addAll(febdata.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvFEB.setLayoutManager(new LinearLayoutManager(this));
        ListFEBAdapter listFEBAdapter = new ListFEBAdapter(this, list);
        rvFEB.setAdapter(listFEBAdapter);

//        RecyclerView.ItemDecoration itemDecoration = new RecyclerView.ItemDecoration() {
//            @Override
//            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//                super.getItemOffsets(outRect, view, parent, state);
//                int position = parent.getChildAdapterPosition(view);
//                if (position >= 0) {
//                    view.setBackgroundColor(getResources().getColor(R.color.feb)); // replace "yellow" with your desired color
//                }
//            }
//        };
//        rvFEB.addItemDecoration(itemDecoration);
    }
}
