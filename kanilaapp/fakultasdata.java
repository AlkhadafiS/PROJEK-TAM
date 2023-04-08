package com.example.kanilaapp;

import java.util.ArrayList;

public class fakultasdata {
    private static String [] fakultasName = {
            "FMIPA",
            "FEB",
            "FH",
            "FP",
            "FKIP",
            "FT",
            "FISIP",
            "FK"
    };

    private static String [] fakultasdetail = {
            "Fakultas Matematika dan Ilmu Pengetahuan Alam",
            "Fakultas Ekonomi dan Bisnis",
            "Fakultas Hukum",
            "Fakultas Pertanian",
            "Fakultas Keguruan dan Ilmu Pendidikan",
            "Fakultas Teknik",
            "Fakultas Ilmu Sosial dan Ilmu Politik",
            "Fakultas Kedokteran"
    };

    private static int[] fakultasImage = {
            R.drawable.fmipa,
            R.drawable.feb,
            R.drawable.fh,
            R.drawable.fp,
            R.drawable.fkip,
            R.drawable.ft,
            R.drawable.fisip,
            R.drawable.fk
    };

    static ArrayList<fakultas> getListData(){
        ArrayList<fakultas> list = new ArrayList<>();
        for (int position = 0; position < fakultasName.length; position++) {
            fakultas fakultas = new fakultas();
            fakultas.setName(fakultasName[position]);
            fakultas.setDetail(fakultasdetail[position]);
            fakultas.setPhoto(fakultasImage[position]);
            list.add(fakultas);
            }
            return list;
        }
    }
