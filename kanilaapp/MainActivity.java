package com.example.kanilaapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFakultas;
    private ArrayList<fakultas> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFakultas = findViewById(R.id.rv_fakultas);
        rvFakultas.setHasFixedSize(true);

        list.addAll(fakultasdata.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvFakultas.setLayoutManager(new LinearLayoutManager(this));
        ListFakultasAdapter listFakultasAdapter = new ListFakultasAdapter(list);
        rvFakultas.setAdapter(listFakultasAdapter);
    }

}