package com.example.kanilaapp;

import java.util.ArrayList;

public class fmipadata {
    private static String [] fmipaName = {
            "Kantin 1",
            "Kantin 2",
            "Kantin 3"
    };

    private static String [] fmipadetail = {
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at"
    };

    private static int[] fmipaImage = {
            R.drawable.kantinfmipa1,
            R.drawable.kantinfmipa2,
            R.drawable.kantinfmipa3
    };

    static ArrayList<FMIPA> getListData(){
        ArrayList<FMIPA> list = new ArrayList<>();
        for (int position = 0; position < fmipaName.length; position++) {
            FMIPA fmipa = new FMIPA();
            fmipa.setName(fmipaName[position]);
            fmipa.setDetail(fmipadetail[position]);
            fmipa.setPhoto(fmipaImage[position]);
            list.add(fmipa);
        }
        return list;
    }
}
