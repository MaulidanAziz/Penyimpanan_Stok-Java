/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import model.Connection_Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Buat Sign in//
public class Akun {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

