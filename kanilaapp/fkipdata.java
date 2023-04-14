package com.example.kanilaapp;

import java.util.ArrayList;

public class fkipdata {
    private static String [] fkipName = {
            "Kantin 1",
            "Kantin 2",
            "Kantin 3"
    };

    private static String [] fkipdetail = {
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at"
    };

    private static int[] fkipImage = {
            R.drawable.kantinfkip1,
            R.drawable.kantinfkip2,
            R.drawable.kantinfkip3
    };

    static ArrayList<FKIP> getListData(){
        ArrayList<FKIP> list = new ArrayList<>();
        for (int position = 0; position < fkipName.length; position++) {
            FKIP fkip = new FKIP();
            fkip.setName(fkipName[position]);
            fkip.setDetail(fkipdetail[position]);
            fkip.setPhoto(fkipImage[position]);
            list.add(fkip);
        }
        return list;
    }
}
