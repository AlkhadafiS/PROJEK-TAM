package com.example.kanilaapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FMIPA extends AppCompatActivity {
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

    private RecyclerView rvFMIPA;
    private ArrayList<FMIPA> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fmipa);

        getSupportActionBar().hide();
        Typeface typeface = Typeface.createFromAsset(getAssets(), "kanila_font.otf");
        TextView textView = findViewById(R.id.logo_textview);
        textView.setTypeface(typeface);
        rvFMIPA = findViewById(R.id.rv_fmipa);
        rvFMIPA.setHasFixedSize(true);

        list.addAll(fmipadata.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvFMIPA.setLayoutManager(new LinearLayoutManager(this));
        ListFMIPAAdapter listFMIPAAdapter = new ListFMIPAAdapter(this, list);
        rvFMIPA.setAdapter(listFMIPAAdapter);

    }
}
