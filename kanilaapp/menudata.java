package com.example.kanilaapp;

import java.util.ArrayList;

public class menudata {
    private static String [] menuName = {
            "Nasi Telor",
            "Nasi Ayam",
            "Es Teh"
    };

    private static String [] menudetail = {
            "Seporsi nasi hangat dengan telor yang bisa request di dadar atau ceplok (10k)",
            "Seporsi nasi hangat dengan ayam goreng atau ayam semur (10k)",
            "Es teh refill sepuasnya (5k)"
    };

    private static int[] menuImage = {
            R.drawable.nasitelor,
            R.drawable.nasiayam,
            R.drawable.esteh
    };

    static ArrayList<MENU> getListData(){
        ArrayList<MENU> list = new ArrayList<>();
        for (int position = 0; position < menuName.length; position++) {
            MENU menu = new MENU();
            menu.setName(menuName[position]);
            menu.setDetail(menudetail[position]);
            menu.setPhoto(menuImage[position]);
            list.add(menu);
        }
        return list;
    }
}
