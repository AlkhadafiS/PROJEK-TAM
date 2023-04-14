package com.example.kanilaapp;

import java.util.ArrayList;

public class fhdata {
    private static String [] fhName = {
            "Kantin 1",
            "Kantin 2",
            "Kantin 3"
    };

    private static String [] fhdetail = {
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at"
    };

    private static int[] fhImage = {
            R.drawable.kantinfh1,
            R.drawable.kantinfh2,
            R.drawable.kantinfh3
    };

    static ArrayList<FH> getListData(){
        ArrayList<FH> list = new ArrayList<>();
        for (int position = 0; position < fhName.length; position++) {
            FH fh = new FH();
            fh.setName(fhName[position]);
            fh.setDetail(fhdetail[position]);
            fh.setPhoto(fhImage[position]);
            list.add(fh);
        }
        return list;
    }
}
