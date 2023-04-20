package com.example.kanilaapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FKIP extends AppCompatActivity {
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

    private RecyclerView rvFKIP;
    private ArrayList<FKIP> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fkip);

        getSupportActionBar().hide();
        Typeface typeface = Typeface.createFromAsset(getAssets(), "kanila_font.otf");
        TextView textView = findViewById(R.id.logo_textview);
        textView.setTypeface(typeface);
        rvFKIP = findViewById(R.id.rv_fkip);
        rvFKIP.setHasFixedSize(true);

        list.addAll(fkipdata.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvFKIP.setLayoutManager(new LinearLayoutManager(this));
        ListFKIPAdapter listFKIPAdapter = new ListFKIPAdapter(this, list);
        rvFKIP.setAdapter(listFKIPAdapter);

    }
}
