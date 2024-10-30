package com.example.appreadstories;

public class Chapter {

    private int idTruyen;
    private String tenChapter;
    private String linkChapter;

    public Chapter( int idTruyen, String tenChapter, String linkChapter) {

        this.idTruyen = idTruyen;
        this.tenChapter = tenChapter;
        this.linkChapter = linkChapter;
    }



    public int getIdTruyen() {
        return idTruyen;
    }

    public String getTenChapter() {
        return tenChapter;
    }

    public String getLinkChapter() {
        return linkChapter;
    }
}
