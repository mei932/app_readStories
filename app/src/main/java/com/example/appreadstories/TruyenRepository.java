package com.example.appreadstories;

import android.content.Context;

import java.util.ArrayList;

public class TruyenRepository {

    private DatabaseHelper dbHelper;

    public TruyenRepository(Context context) {
        dbHelper = new DatabaseHelper(context); // Truyền context vào DatabaseHelper
    }

    public ArrayList<Truyen> getAllTruyen() {
        ArrayList<Truyen> truyenList = new ArrayList<>();

        // Sử dụng phương thức getAllTruyens từ DatabaseHelper để lấy danh sách truyện
        truyenList = (ArrayList<Truyen>) dbHelper.getAllTruyens();

        return truyenList;
    }
}
