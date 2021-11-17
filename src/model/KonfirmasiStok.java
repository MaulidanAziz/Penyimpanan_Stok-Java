/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Untuk Pembelian
public class KonfirmasiStok extends Connection_Data{
    private final String[][] stokpembelian = new String[100][3];
    private int j = 0;
    
    public KonfirmasiStok() throws SQLException{
        connect();
        try{
        Connection_Data con = new Connection_Data();
        con.getConnection();
        Statement stat = con.getConnection().createStatement();
        ResultSet rs = stat.executeQuery("SELECT * from tubes_pbo.pengadaan "
                    + "INNER JOIN tubes_pbo.detailpengadaan "
                    + "ON pengadaan.idPengadaan = detailpengadaan.idPengadaan");
        while (rs.next()){
            stokpembelian[j][0] = rs.getString("idPengadaan");
            stokpembelian[j][1] = rs.getString("KodeBarang");
            stokpembelian[j][2] = rs.getString("Jumlah");
            j++;   
        }
        } catch (SQLException e){
            e.printStackTrace();
        }       
    }
    
    public void Purchase(String idPengadaan) throws SQLException{
        Connection_Data con = new Connection_Data();
        con.getConnection();
        String sql = "SELECT * FROM `tubes_pbo`.`detailpengadaan` WHERE `idPengadaan` = `"+idPengadaan+"` ";
        PreparedStatement stat = con.getConnection().prepareStatement(sql);
        stat.executeUpdate();
    }
    
    public String tampilStok(int prod, int atr){
        return stokpembelian[prod][atr];
    }
    
    public void tambahStok(int idProduk)throws SQLException{
        String po = stokpembelian[idProduk][0];
        String id = stokpembelian[idProduk][1];
        String jumlah = stokpembelian[idProduk][2];
        int total = Integer.parseInt(jumlah);
        DB db = new DB();
        int totalStok = total + Integer.parseInt(db.outBar(idProduk, 4));
            
        Connection_Data koneksi = new Connection_Data();  
        koneksi.getConnection();
            
        Statement stmt1 = koneksi.getConnection().createStatement();
        int rs = stmt1.executeUpdate("UPDATE `tubes_pbo`.`barang` SET `Stok_Barang` = '"+totalStok+"' WHERE `barang`.`KodeBarang` = '"+id+"';");
        int rs1 = stmt1.executeUpdate("DELETE FROM `tubes_pbo`.`detailpengadaan` WHERE `KodeBarang` ='"+id+"' AND `idPengadaan` = '"+po+"';");
    }    
    
    public Integer jumlahStok(){
        return j;
    } 
    
}
