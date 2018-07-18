/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.vista.ComisionesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ponsa
 */
public class ComisionesController implements ActionListener {
    
    ComisionesView comV;
    DaoImpl dao;
    
   public ComisionesController (ComisionesView comV,DaoImpl dao){
       this.comV = comV;
       this.dao = dao;
       llenarListaChof();
       
        
   } 
   
   
   
   protected void llenarListaChof() {

        DefaultListModel dlm = new DefaultListModel();
        try {

            List<Chofer> choferes = new ArrayList<>();
            choferes = dao.getChoferes();
            for (Chofer c : choferes) {
                dlm.addElement("Legajo: " + c.getNroLegajo() + " Nombre: " + c.getNombre() + " " + c.getApellido()+" Comision : % "+c.getComision());
            }
            this.comV.jChofList.setModel(dlm);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
   
   
   
   
   
}
