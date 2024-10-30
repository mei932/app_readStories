package com.example.appreadstories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;

import java.util.ArrayList;

public class ChapterRepository {

    private DatabaseHelper dbHelper;

    public ChapterRepository(Context context) {
        dbHelper = new DatabaseHelper(context); // Truyền context vào DatabaseHelper
    }

    public ArrayList<Chapter> getChaptersByTruyenId(int truyenId) {
        ArrayList<Chapter> chapterList = new ArrayList<>();

        // Sử dụng SQLiteDatabase để truy vấn
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + DatabaseHelper.TABLE_CHAPTER + " WHERE " + DatabaseHelper.COLUMN_CHAPTER_TRUYEN_ID + " = ?";

        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(truyenId)});

        if (cursor.moveToFirst()) {
            do {
                try {
                    // Sử dụng getColumnIndexOrThrow để kiểm tra sự tồn tại của cột
                    int idTruyen = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_CHAPTER_TRUYEN_ID));
                    String tenChapter = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TEN_CHAPTER));
                    String linkChapter = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_LINK_CHAPTER));

                    Chapter chapter = new Chapter(idTruyen, tenChapter, linkChapter);
                    chapterList.add(chapter);
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Xử lý ngoại lệ nếu cột không tồn tại
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return chapterList;
    }
}
