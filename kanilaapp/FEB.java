package com.example.kanilaapp;

import android.os.Bundle;
import android.view.View;

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

        rvFEB = findViewById(R.id.rv_feb);
        rvFEB.setHasFixedSize(true);

        list.addAll(febdata.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvFEB.setLayoutManager(new LinearLayoutManager(this));
        ListFEBAdapter listFEBAdapter = new ListFEBAdapter(this, list);
        rvFEB.setAdapter(listFEBAdapter);

    }
}
