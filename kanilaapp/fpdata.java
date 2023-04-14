package com.example.kanilaapp;

import java.util.ArrayList;

public class fpdata {
    private static String [] fpName = {
            "Kantin 1",
            "Kantin 2",
            "Kantin 3"
    };

    private static String [] fpdetail = {
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at",
            "Buka dari Senin-Jum'at"
    };

    private static int[] fpImage = {
            R.drawable.kantinfp1,
            R.drawable.kantinfp2,
            R.drawable.kantinfp3
    };

    static ArrayList<FP> getListData(){
        ArrayList<FP> list = new ArrayList<>();
        for (int position = 0; position < fpName.length; position++) {
            FP fp = new FP();
            fp.setName(fpName[position]);
            fp.setDetail(fpdetail[position]);
            fp.setPhoto(fpImage[position]);
            list.add(fp);
        }
        return list;
    }
}
