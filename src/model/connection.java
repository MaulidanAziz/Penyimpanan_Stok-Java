package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class connection {
    
    private Connection koneksi;
    private String driver = "com.mysql.jdbc.Driver";
    private String host = "localhost:";
    private String jdbc = "jdbc:mysql://";
    private String port = "3306/"; 
    private String database = "tubes_pbo";  
    private String url = jdbc + host + port + database;
    private String username = "root";
    private String password = "";
    
    public Connection getConnection() throws SQLException{
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

}

