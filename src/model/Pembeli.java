/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Pembeli {
    private int id;
    private String nama;
    private String alamat;
    private int kode;
    private int jumlah;

    public Pembeli(int id, String nama, String alamat, int kode, int jumlah) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.kode = kode;
        this.jumlah = jumlah;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getKode() {
        return kode;
    }

    public int getJumlah() {
        return jumlah;
    }
    
    
}
