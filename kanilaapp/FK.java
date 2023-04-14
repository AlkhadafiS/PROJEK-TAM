package com.example.kanilaapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FK extends AppCompatActivity {
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

    private RecyclerView rvFK;
    private ArrayList<FK> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fk);

        rvFK = findViewById(R.id.rv_fk);
        rvFK.setHasFixedSize(true);

        list.addAll(fkdata.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvFK.setLayoutManager(new LinearLayoutManager(this));
        ListFKAdapter listFKAdapter = new ListFKAdapter(this, list);
        rvFK.setAdapter(listFKAdapter);

    }
}
