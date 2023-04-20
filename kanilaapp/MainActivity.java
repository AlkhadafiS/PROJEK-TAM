package com.example.kanilaapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

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

        getSupportActionBar().hide();
        Typeface typeface = Typeface.createFromAsset(getAssets(), "kanila_font.otf");
        TextView textView = findViewById(R.id.logo_textview);
        textView.setTypeface(typeface);
        rvFakultas = findViewById(R.id.rv_fakultas);
        rvFakultas.setHasFixedSize(true);

        list.addAll(fakultasdata.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvFakultas.setLayoutManager(new LinearLayoutManager(this));
        ListFakultasAdapter listFakultasAdapter = new ListFakultasAdapter(this, list);
        rvFakultas.setAdapter(listFakultasAdapter);
        listFakultasAdapter.setOnItemClickCallBack(this::toActivity);
    }

    private void toActivity(fakultas data) {
        Intent intent;

        switch (data.getName()) {
            case "FMIPA":
                intent = new Intent(this, FMIPA.class);
                break;
            case "FH":
                intent = new Intent(this, FH.class);
                break;
            case "FEB":
                intent = new Intent(this, FEB.class);
                break;
            case "FP":
                intent = new Intent(this, FP.class);
                break;
            case "FKIP":
                intent = new Intent(this, FKIP.class);
                break;
            case "FT":
                intent = new Intent(this, FT.class);
                break;
            case "FISIP":
                intent = new Intent(this, FISIP.class);
                break;
            case "FK":
                intent = new Intent(this, FK.class);
                break;
            default:
                intent = new Intent(this, MainActivity.class);
                break;
        }
        intent.putExtra("fakultas_name", data.getName());
        startActivity(intent);
    }


}