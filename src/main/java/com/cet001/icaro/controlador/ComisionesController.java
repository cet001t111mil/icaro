/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.Empleado;
import com.cet001.icaro.vista.ComisionesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import com.cet001.icaro.servicios.Administracion;
import static java.lang.Integer.parseInt;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ponsa
 */
public class ComisionesController implements ActionListener {
    
    ComisionesView comV;
    DaoImpl dao;
    Administracion adm;
    
   public ComisionesController (ComisionesView comV,DaoImpl dao){
       this.comV = comV;
       this.dao = dao;
       llenarListaChoferes();
       this.comV.clacComBoton.addActionListener(this);
        
   } 
   
   
   
   protected void llenarListaChoferes() {

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
        
        Empleado emp=null;
        try {
            emp = dao.getEmpleado(parseInt(comV.chofLegajo.getText()));
        } catch (Exception ex) {
            Logger.getLogger(ComisionesController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        Calendar i = Calendar.getInstance();
        
        i.set(Calendar.YEAR, parseInt(comV.anioI.getSelectedItem().toString()));
        i.set(Calendar.MONTH, parseInt(comV.mesI.getSelectedItem().toString()));
        i.set(Calendar.DAY_OF_MONTH, parseInt(comV.diaI.getSelectedItem().toString()));
        i.set(Calendar.HOUR_OF_DAY, 00);// ojo!!!! usar HOUR_OF_DAY
        i.set(Calendar.MINUTE, 00);
        i.set(Calendar.SECOND, 00);
        
           Calendar f = Calendar.getInstance();
        
        f.set(Calendar.YEAR, parseInt(comV.anioF.getSelectedItem().toString()));
        f.set(Calendar.MONTH, parseInt(comV.mesF.getSelectedItem().toString()));
        f.set(Calendar.DAY_OF_MONTH, parseInt(comV.diaF.getSelectedItem().toString()));
        f.set(Calendar.HOUR_OF_DAY, 00);// ojo!!!! usar HOUR_OF_DAY
        f.set(Calendar.MINUTE, 00);
        f.set(Calendar.SECOND, 00);
        
        try {
            i.toString();
            f.toString()
            //System.out.println(adm.calcularSueldo(emp, i, f));
            //comV.resulComision.setText(String.valueOf(adm.calcularSueldo(emp, i, f)));
        } catch (Exception ex) {
            Logger.getLogger(ComisionesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void calcularComision() {
        
    
    }
   
   
   
   
   
}
