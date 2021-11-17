/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Akun;
import model.DB;
import view.ModulGudang;
import view.signin;
//Untuk Sign in
public class Control1 extends MouseAdapter implements ActionListener{
    private signin v1;
    private DB db;
    
    public Control1() throws SQLException{
        v1 = new signin();
        db = new DB();
        v1.addActionListener(this);
        v1.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
   
}
