package com.example.kanilaapp;

import java.util.ArrayList;

public class fkdata {
    private static String [] fkName = {
            "Kantin 1",
            "Kantin 2",
            "Kantin 3"
    };

    private static String [] fkdetail = {
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at"
    };

    private static int[] fkImage = {
            R.drawable.kantinfk1,
            R.drawable.kantinfk2,
            R.drawable.kantinfk3
    };

    static ArrayList<FK> getListData(){
        ArrayList<FK> list = new ArrayList<>();
        for (int position = 0; position < fkName.length; position++) {
            FK fk = new FK();
            fk.setName(fkName[position]);
            fk.setDetail(fkdetail[position]);
            fk.setPhoto(fkImage[position]);
            list.add(fk);
        }
        return list;
    }
}
