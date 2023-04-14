package com.example.kanilaapp;

import java.util.ArrayList;

public class febdata {
    private static String [] febName = {
            "Kantin 1",
            "Kantin 2",
            "Kantin 3"
    };

    private static String [] febdetail = {
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at"
    };

    private static int[] febImage = {
            R.drawable.kantinfeb1,
            R.drawable.kantinfeb2,
            R.drawable.kantinfeb3
    };

    static ArrayList<FEB> getListData(){
        ArrayList<FEB> list = new ArrayList<>();
        for (int position = 0; position < febName.length; position++) {
            FEB feb = new FEB();
            feb.setName(febName[position]);
            feb.setDetail(febdetail[position]);
            feb.setPhoto(febImage[position]);
            list.add(feb);
        }
        return list;
    }
}
