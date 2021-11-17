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
import model.DB;
import model.KonfirmasiBeli;
import model.KonfirmasiStok;
import view.Pembelian;

public class Control3 extends MouseAdapter implements ActionListener{
    private Pembelian v3;
    private KonfirmasiBeli a1;
    private KonfirmasiStok a2;
    
    public void Control3() throws SQLException{
        v3 = new Pembelian();
        a1 = new KonfirmasiBeli();
        a2 = new KonfirmasiStok();
        ActionListener a = null;
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
