/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Vehiculo;
import com.cet001.icaro.vista.VehiculosView;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author ponsa
 */
public class VehiculosController implements ActionListener{
    DaoImpl dao;
    VehiculosView vehiView;
    
    public VehiculosController (VehiculosView vehiView, DaoImpl dao){
        this.dao = dao;
        this.vehiView = vehiView;
        llenarListaVehiculos();
        this.vehiView.borrarVehi.addActionListener(this);
        this.vehiView.guardaVehiculo.addActionListener(this);
        this.vehiView.modVehiculo.addActionListener(this);
        this.vehiView.cargarVehiculo.addActionListener(this);
        
        
    }
    
     public void llenarListaVehiculos() {

        DefaultListModel Dlm = new DefaultListModel();

        try {
            String listaV = "";
            List<Vehiculo> vehiculos = dao.getVehiculos();

            for (Vehiculo v : vehiculos) {
                Dlm.addElement("Patente: " + v.getPatente() + " - " + v.getMarca() + " " + v.getModelo() + " - En Viaje: " + v.isEnViaje());
            }
            this.vehiView.lsitaVehiculos.setModel(Dlm);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }
    }
     
     
           
    @Override
     public void actionPerformed ( ActionEvent e){
          String opcion = e.getActionCommand();
           switch (opcion) {//en función del comando devuelto por el método gAC, se entrará en 1 de las sig. alternativas
            case "guardaVehiculo": {//ver más abajo
                guardaVehiculo();
                break;
            }
     }
     
}

    private void guardaVehiculo() {
        String patente = this.vehiView.agregaVehiPatente.getText();
        String marca = this.vehiView.agregaVehiMarca.getText();
        String modelo = this.vehiView.agregaVehiMod.getText();
        String anio = this.vehiView.agregaVehiAnio.getText();
        try{
        Vehiculo vehi = new Vehiculo (patente,marca,modelo,Integer.parseInt(anio));
        dao.guardarVehiculo(vehi);
        llenarListaVehiculos();
        JOptionPane.showMessageDialog(null, "Vehiculo Guardado");
         } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }
    }
    }
