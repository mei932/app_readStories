package com.example.appreadstories;

public class Truyen {
    private int id;
    private String tenTruyen;
    private String posterURL;
    private String moTa;

    public Truyen(int id, String tenTruyen, String posterURL, String moTa) {
        this.id = id;
        this.tenTruyen = tenTruyen;
        this.posterURL = posterURL;
        this.moTa = moTa;
    }

    public int getId() {
        return id;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public String getMoTa() {
        return moTa;
    }
}
