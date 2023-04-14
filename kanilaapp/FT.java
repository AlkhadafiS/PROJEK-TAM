package com.example.kanilaapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FT extends AppCompatActivity {
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

    private RecyclerView rvFT;
    private ArrayList<FT> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ft);

        rvFT = findViewById(R.id.rv_ft);
        rvFT.setHasFixedSize(true);

        list.addAll(ftdata.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvFT.setLayoutManager(new LinearLayoutManager(this));
        ListFTAdapter listFTAdapter = new ListFTAdapter(this, list);
        rvFT.setAdapter(listFTAdapter);

    }
}
