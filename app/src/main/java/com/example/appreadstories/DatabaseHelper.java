package com.example.appreadstories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "appReadStories.db";
    private static final int DATABASE_VERSION = 1;

    // Thay đổi độ truy cập thành public
    public static final String TABLE_TRUYEN = "truyen";
    public static final String TABLE_CHAPTER = "chapter";

    // Cột bảng Truyen
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TEN_TRUYEN = "tenTruyen";
    public static final String COLUMN_POSTER_URL = "posterURL";
    public static final String COLUMN_MO_TA = "moTa";

    // Cột bảng Chapter
    public static final String COLUMN_CHAPTER_ID = "id";
    public static final String COLUMN_CHAPTER_TRUYEN_ID = "idTruyen";
    public static final String COLUMN_TEN_CHAPTER = "tenChapter";
    public static final String COLUMN_LINK_CHAPTER = "linkChapter";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTruyenTable = "CREATE TABLE " + TABLE_TRUYEN + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TEN_TRUYEN + " TEXT, " +
                COLUMN_POSTER_URL + " TEXT, " +
                COLUMN_MO_TA + " TEXT)";
        db.execSQL(createTruyenTable);

        String createChapterTable = "CREATE TABLE " + TABLE_CHAPTER + " (" +
                COLUMN_CHAPTER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CHAPTER_TRUYEN_ID + " INTEGER, " +
                COLUMN_TEN_CHAPTER + " TEXT, " +
                COLUMN_LINK_CHAPTER + " TEXT)";
        db.execSQL(createChapterTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRUYEN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHAPTER);
        onCreate(db);
    }

    // Thêm truyện
    public void addTruyen(Truyen truyen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TEN_TRUYEN, truyen.getTenTruyen());
        values.put(COLUMN_POSTER_URL, truyen.getPosterURL());
        values.put(COLUMN_MO_TA, truyen.getMoTa());
        db.insert(TABLE_TRUYEN, null, values);
        db.close();
    }

    // Lấy danh sách truyện
    // Lấy danh sách truyện
    public List<Truyen> getAllTruyens() {
        List<Truyen> truyenList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_TRUYEN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)); // Sử dụng getColumnIndexOrThrow
                String tenTruyen = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEN_TRUYEN));
                String posterURL = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_POSTER_URL));
                String moTa = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MO_TA));
                truyenList.add(new Truyen(id, tenTruyen, posterURL, moTa));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return truyenList;
    }

    // Thêm chapter
    public void addChapter(Chapter chapter) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CHAPTER_TRUYEN_ID, chapter.getIdTruyen());
        values.put(COLUMN_TEN_CHAPTER, chapter.getTenChapter());
        values.put(COLUMN_LINK_CHAPTER, chapter.getLinkChapter());
        db.insert(TABLE_CHAPTER, null, values);
        db.close();
    }
}
