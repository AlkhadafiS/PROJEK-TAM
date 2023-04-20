package com.example.kanilaapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.SearchEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MENU extends AppCompatActivity {
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

    private RecyclerView rvMENU;
    private ArrayList<MENU> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        getSupportActionBar().hide();
        Typeface typeface = Typeface.createFromAsset(getAssets(), "kanila_font.otf");
        TextView textView = findViewById(R.id.logo_textview);
        textView.setTypeface(typeface);
        rvMENU = findViewById(R.id.rv_menu);
        rvMENU.setHasFixedSize(true);

        list.addAll(menudata.getListData());
        showRecyclerList();
    }

    private void filter(String text){
        ArrayList<MENU> filteredList = new ArrayList<>();
        for (MENU menu : list) {
            if (menu.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(menu);
            }
        }
        ListMenuAdapter adapter = (ListMenuAdapter) rvMENU.getAdapter();
        adapter.filteredList(filteredList);
    }


    private void showRecyclerList(){
        rvMENU.setLayoutManager(new LinearLayoutManager(this));
        ListMenuAdapter listMenuAdapter = new ListMenuAdapter(this, list);
        rvMENU.setAdapter(listMenuAdapter);

    }
}
