/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.istack.internal.logging.Logger;
import controller.Control2;
import java.sql.*;
import java.util.logging.Level;

public class Connection_Data {
    private Connection koneksi;
    private String driver = "com.mysql.jdbc.Driver";
    private String host = "localhost:";
    private String jdbc = "jdbc:mysql://";
    private String port = "3306/"; 
    private String database = "tubes_pbo";  
    private String url = jdbc + host + port + database;
    private String username = "root";
    private String password = "";
    
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public Connection getConnection(){
        if (koneksi == null){
            try {
                Class.forName(driver);
                try{
                    koneksi = DriverManager.getConnection(url, username, password);
                } catch (SQLException se) {
                }
            } catch (ClassNotFoundException cnfe) {
            }
        }
        return koneksi;    
    }
    
       public void connect() {
        try {
            String url = "jdbc:mysql://localhost/tubes_pbo";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Control2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect() {
        try {
            conn.close();
            stmt.close();
        }
        catch (SQLException ex){
            java.util.logging.Logger.getLogger(Control2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
