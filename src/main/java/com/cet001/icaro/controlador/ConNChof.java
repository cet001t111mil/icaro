/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import com.cet001.icaro.dao.ChoferImp;
import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.Empleado;
import com.cet001.icaro.vista.NuevoChofer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author ponsa
 */
public class ConNChof implements ActionListener {
    private NuevoChofer nuevoChofer;
    
    
    public ConNChof (NuevoChofer nuevoChofer){
        this.nuevoChofer=nuevoChofer;
        this.nuevoChofer.jButton1.addActionListener(this);
                
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        
        String legajo = nuevoChofer.legajo.getText();
        String nombre = nuevoChofer.nombre.getText();
        String apellido = nuevoChofer.apellido.getText();
        String dni = nuevoChofer.dni.getText();
        String comision = nuevoChofer.comision.getText();
        String sueldo = nuevoChofer.sueldo.getText();
        Empleado chof = new Chofer (Double.parseDouble(sueldo), Double.parseDouble(comision),dni,nombre,apellido,Integer.parseInt(legajo),"CH");
        
        ChoferImp chI = new ChoferImp ();
        chI.guardarChofer(chof);
        
        
    }



    
}
