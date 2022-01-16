package com.example.tanamanhias.model;

import java.io.Serializable;

public class Tanaman implements Serializable {
    private String jenis;
    private String varian;
    private String asal;
    private String deskripsi;
    private int drawableRes;

    public Tanaman(String jenis, String varian, String asal, String deskripsi, int drawableRes) {
        this.jenis = jenis;
        this.varian = varian;
        this.asal = asal;
        this.deskripsi = deskripsi;
        this.drawableRes = drawableRes;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getVarian() {
        return varian;
    }

    public void setVarian(String varian) {
        this.varian = varian;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }


}
