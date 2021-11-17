/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class KonfirmasiBeli {
    private final String[][] pembelian = new String[100][3];
    private int j = 0;
    
    public KonfirmasiBeli() throws SQLException{
        Connection_Data koneksi = new Connection_Data();  
        koneksi.getConnection();
        Statement stat = koneksi.getConnection().createStatement();
        ResultSet rs = stat.executeQuery("select * from tubes_pbo.pengadaan where statusPengadaan = 'Waiting'");
        while (rs.next()){
            pembelian[j][0] = rs.getString("idPengadaan");
            pembelian[j][1] = rs.getString("tanggalPengadaan");
            j++;
        }
    }
    
    public void rubahstatus(String idPengadaan) throws SQLException{
        Connection_Data con = new Connection_Data();
        Statement stat = con.getConnection().createStatement();
        int rs = stat.executeUpdate("UPDATE `tubes_pbo`.`pengadaan` SET `statusPengadaan` = 'Confirmed' "
                            + "WHERE `pengadaan`.`idPengadaan` = '"+idPengadaan+"';");
    }
    
    public String outPembelian(int prod, int atr){
        return pembelian[prod][atr];
    }
    
    public Integer jumlahPembelian(){
        return j;
    }
}
