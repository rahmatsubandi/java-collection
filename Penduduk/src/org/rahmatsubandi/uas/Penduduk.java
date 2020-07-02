/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rahmatsubandi.uas;

/**
 *
 * @author Rahmat Subandi
 */
public class Penduduk {
    private Integer id;
    private String nama;
    private String email;
    private Integer nohp;
    private String alamat;

    public Penduduk(Integer id, String nama, String email, Integer nohp, String alamat) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.nohp = nohp;
        this.alamat = alamat;
    }

    public Integer getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public Integer getNohp() {
        return nohp;
    }

    public String getAlamat() {
        return alamat;
    }
    
}
