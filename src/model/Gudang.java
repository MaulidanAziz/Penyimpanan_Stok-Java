/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Gudang {
    private int kode;
    private String nama;
    private int berat;
    private int harga;
    private int stok;
    private int rak;

    public Gudang(int kode, String nama, int berat, int harga, int stok, int rak) {
        this.kode = kode;
        this.nama = nama;
        this.berat = berat;
        this.harga = harga;
        this.stok = stok;
        this.rak = rak;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setRak(int rak) {
        this.rak = rak;
    }

    public int getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getBerat() {
        return berat;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public int getRak() {
        return rak;
    }
    
    
}
