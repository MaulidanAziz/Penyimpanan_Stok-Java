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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DB;
import view.ModulGudang;
import model.Gudang;
import view.NewProduct;


//Untuk Modul Gudang
public class Control2 extends MouseAdapter implements ActionListener {
    private ModulGudang v2;
    private DB db;
    
    public void Control2() throws SQLException{
        v2 = new ModulGudang();
        db = new DB();
        ActionListener a = null;
        v2.addActionListener(this);
        v2.tampilTabel();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(v2.getUpdate())) {
            btnUpdateActionPerformed();
            try {
                v2.tampilTabel();
            } catch (SQLException ex) {
                Logger.getLogger(Control2.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source.equals(v2.getStok())){
            btnStokActionPerformed();
            try {
                v2.tampilTabel();
            } catch (SQLException ex) {
                Logger.getLogger(Control2.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source.equals(v2.getUpdate())) {
            btnUpdateActionPerformed();
        }
    }
    
    
    public void btnStokActionPerformed() {                                        
        try{
          v2.tampilTabel();
        } catch (SQLException ex) {
          Logger.getLogger(ModulGudang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void btnUpdateActionPerformed() {                                          
        NewProduct a = new NewProduct();
        a.setVisible(true);
    } 
    
}
