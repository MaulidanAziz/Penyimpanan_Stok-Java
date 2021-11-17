/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Connection_Data;

public class DB extends Connection_Data{
    private final String[][] bar = new String[100][8];
    private int a = 0;

    public DB(){
        connect();
        try{
            Statement stat = getConnection().createStatement();
            ResultSet rs = stat.executeQuery("select * from tubes_pbo.barang");
            while (rs.next()){
                bar[a][0] = rs.getString("Kode_Barang");
                bar[a][1] = rs.getString("Nama_Barang");
                bar[a][2] = rs.getString("Berat");
                bar[a][3] = rs.getString("Harga");
                bar[a][4] = rs.getString("Stok_Barang");
                bar[a][5] = rs.getString("No_Rak");
                a++;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void createNewBar(String id, String nama, int berat, int harga, int stok, int rak) throws SQLException{
            Connection_Data koneksi = new Connection_Data();  
            koneksi.getConnection();
            String sql = "INSERT INTO `tubes_pbo`.`barang` "
                    + "(`Kode_Barang`, `Nama_Barang`, `Berat`, `Harga`, `Stok_Barang`, `No_Rak`) "
                    + "VALUES ('"+id+"', '"+nama+"', '"+berat+"', '"+harga+"', '"+stok+"', '"+rak+"')";
            PreparedStatement stat = koneksi.getConnection().prepareStatement(sql);
            stat.executeUpdate();
    }
    
    public void deleteBarang(String urutan) throws SQLException{
            Connection_Data koneksi = new Connection_Data();  
            koneksi.getConnection();
            Statement stmt1 = koneksi.getConnection().createStatement();
            int rs = stmt1.executeUpdate("DELETE FROM `tubes_pbo`.`barang` WHERE `KodeBarang` ='"+urutan+"';");
    }
    
    public void editBarang(String idProduk, String namaProduk, int berat, int hargaProduk, int stok) throws SQLException{
        String update = JOptionPane.showInputDialog(null, "Pilihan edit :\n"
            + "1. Edit berdasarkan ID Barang\n"
            + "2. Edit berdasarkan nama Barang");
        
        Connection_Data con = new Connection_Data();
        con.getConnection();
        Statement stat = con.getConnection().createStatement();
        
        int pil = Integer.parseInt(update);
        switch(pil){
            case 1:
                try{
                    int rs = stat.executeUpdate("UPDATE `tubes_pbo`.`barang` SET `Nama_Barang` = '"+namaProduk+"' "
                            + "WHERE `barang`.`Kode_Barang` = '"+idProduk+"';");
                    int rs1 = stat.executeUpdate("UPDATE `tubes_pbo`.`barang` SET `Berat` = '"+berat+"' "
                            + "WHERE `barang`.`Kode_Barang` = '"+idProduk+"';");
                    int rs2 = stat.executeUpdate("UPDATE `tubes_pbo`.`barang` SET `Harga` = '"+hargaProduk+"' "
                            + "WHERE `barang`.`Kode_Barang` = '"+idProduk+"';");
                    int rs3 = stat.executeUpdate("UPDATE `tubes_pbo`.`barang` SET `Stok_Barang` = '"+stok+"' "
                            + "WHERE `barang`.`Kode_Barang` = '"+idProduk+"';");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Pastikan ID Produk sama dengan data sebelumnya");
                }
                break;
            case 2:
                try{
                    int rs4 = stat.executeUpdate("UPDATE `tubes_pbo`.`barang` SET `Kode_Barang` = '"+idProduk+"' "
                            + "WHERE `barang`.`Nama_Barang` = '"+namaProduk+"';");
                    int rs5 = stat.executeUpdate("UPDATE `tubes_pbo`.`barang` SET `Berat` = '"+berat+"' "
                            + "WHERE `barang`.`Nama_Barang` = '"+namaProduk+"';");
                    int rs6 = stat.executeUpdate("UPDATE `tubes_pbo`.`barang` SET `Harga` = '"+hargaProduk+"' "
                            + "WHERE `barang`.`Nama_Barang` = '"+namaProduk+"';");
                    int rs7 = stat.executeUpdate("UPDATE `tubes_pbo`.`barang` SET `Stok_Barang` = '"+stok+"' "
                            + "WHERE `barang`.`Nama_Barang` = '"+namaProduk+"';");
                } catch (SQLException ex){
                  JOptionPane.showMessageDialog(null, "Pastikan ID Produk sama dengan data sebelumnya");  
                }
                break;
        }
    }
    
    public String outBar(int x, int y){
        return bar[x][y];
    }
    
    public Integer jumBar(){
        return a;
    }
    
    public void signin(String user, String pass) throws SQLException{
        Connection_Data con = new Connection_Data();
        con.getConnection();
        
        String query = "SELECT COUNT(*) AS TOTAL FROM `akun` WHERE `username` = '"+user.trim()+"' AND password = '"+pass.trim()+"'";
        
        try (Statement stmt = con.getConnection().createStatement()){
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String total = rs.getString("TOTAL");
                int i_total = Integer.parseInt(total);
                
                if(i_total==1){
                    System.out.println("sign in berhasil");
                }else{
                    System.out.println("sign in gagal");
                }
            }
        } catch (SQLException e){
            System.out.println(""+e.getMessage().toString());
        }  
    }
    
    
}


