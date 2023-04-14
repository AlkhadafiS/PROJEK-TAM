package com.example.kanilaapp;

import java.util.ArrayList;

public class ftdata {
    private static String [] ftName = {
            "Kantin 1",
            "Kantin 2",
            "Kantin 3"
    };

    private static String [] ftdetail = {
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at"
    };

    private static int[] ftImage = {
            R.drawable.kantinft1,
            R.drawable.kantinft2,
            R.drawable.kantinft3
    };

    static ArrayList<FT> getListData(){
        ArrayList<FT> list = new ArrayList<>();
        for (int position = 0; position < ftName.length; position++) {
            FT ft = new FT();
            ft.setName(ftName[position]);
            ft.setDetail(ftdetail[position]);
            ft.setPhoto(ftImage[position]);
            list.add(ft);
        }
        return list;
    }
}
