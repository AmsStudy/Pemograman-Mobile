package com.example.myapplication.model;

public class Mahasiwa {
    private String stb;
    private String nama;

    public Mahasiwa(String stb, String nama) {
        this.stb = stb;
        this.nama = nama;
    }

    public Mahasiwa() {

    }

    public String getStb() {
        return stb;
    }

    public void setStb(String stb) {
        this.stb = stb;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
