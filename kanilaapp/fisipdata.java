package com.example.kanilaapp;

import java.util.ArrayList;

public class fisipdata {
    private static String [] fisipName = {
            "Kantin 1",
            "Kantin 2",
            "Kantin 3"
    };

    private static String [] fisipdetail = {
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at"
    };

    private static int[] fisipImage = {
            R.drawable.kantinfisip1,
            R.drawable.kantinfisip2,
            R.drawable.kantinfisip3
    };

    static ArrayList<FISIP> getListData(){
        ArrayList<FISIP> list = new ArrayList<>();
        for (int position = 0; position < fisipName.length; position++) {
            FISIP fisip = new FISIP();
            fisip.setName(fisipName[position]);
            fisip.setDetail(fisipdetail[position]);
            fisip.setPhoto(fisipImage[position]);
            list.add(fisip);
        }
        return list;
    }
}
