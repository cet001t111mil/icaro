/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.cet001.icaro.controlador;
import com.cet001.icaro.vista.NuevoViajeView;
import com.cet001.icaro.modelo.Viaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author ponsa
 */
public class ViajeController implements ActionListener {
    private NuevoViajeView nuevoViaje;
    
    public ViajeController (NuevoViajeView nuevoViaje){
        this.nuevoViaje = nuevoViaje;
        this.nuevoViaje.jButton2.addActionListener(this);
        
        
    }
    
    
    
    @Override
    public void actionPerformed (ActionEvent e){
        String origen = nuevoViaje.origen.getText();
        String destino = nuevoViaje.destino.getText();
        String fecha = nuevoViaje.fecha.getText();
        String movil = nuevoViaje.movil.getText();
        String cliente = nuevoViaje.cliente.getText();
         //si yo recibo el id del chofer, lo puedo buscar , instanciar y agregar al constructor de viaje 
        System.out.println("sdfs"+nuevoViaje.jComboChoferNV.getName());
    }
    
}
