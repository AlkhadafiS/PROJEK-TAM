package com.example.kanilaapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FP extends AppCompatActivity {
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

    private RecyclerView rvFP;
    private ArrayList<FP> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp);

        getSupportActionBar().hide();
        Typeface typeface = Typeface.createFromAsset(getAssets(), "kanila_font.otf");
        TextView textView = findViewById(R.id.logo_textview);
        textView.setTypeface(typeface);
        rvFP = findViewById(R.id.rv_fp);
        rvFP.setHasFixedSize(true);

        list.addAll(fpdata.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvFP.setLayoutManager(new LinearLayoutManager(this));
        ListFPAdapter listFPAdapter = new ListFPAdapter(this, list);
        rvFP.setAdapter(listFPAdapter);

    }
}
