/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugasbesar.Model;

/**
 *
 * @author Rahmat Subandi
 */
public class Getraw {
    private String id;
    private String makanan;
    private String pelanggan;
    private String metode;
    private int harga;

    public void setId(String id) {
        this.id = id;
    }

    public void setMakanan(String makanan) {
        this.makanan = makanan;
    }

    public void setPelanggan(String pelanggan) {
        this.pelanggan = pelanggan;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public String getMakanan() {
        return makanan;
    }

    public String getPelanggan() {
        return pelanggan;
    }

    public String getMetode() {
        return metode;
    }

    public int getHarga() {
        return harga;
    }
}
