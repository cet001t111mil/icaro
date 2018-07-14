/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.Empleado;
import com.cet001.icaro.vista.NuevoChoferView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ponsa
 */
public class NuevoChoferController implements ActionListener {//esta es la clase del objeto que "controlará" a los objetos de tipo NuevoChofer

    private NuevoChoferView nuevoChofer;//declaración de la variable que alojará 1 objeto de tipo NuevoChofer cuya parte visible para el usuario será la ventana "Nuevo Chofer"
    DaoImpl dao;

    public NuevoChoferController(NuevoChoferView nuevoChofer, DaoImpl dao) {
        this.dao = dao;
        this.nuevoChofer = nuevoChofer;
        this.nuevoChofer.jButton1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String legajo = nuevoChofer.legajo.getText();
        String nombre = nuevoChofer.nombre.getText();
        String apellido = nuevoChofer.apellido.getText();
        String dni = nuevoChofer.dni.getText();
        String comision = nuevoChofer.comision.getText();
        String sueldo = nuevoChofer.sueldo.getText();
        Empleado chofi = new Chofer(Double.parseDouble(sueldo), Double.parseDouble(comision), dni, nombre, apellido, Integer.parseInt(legajo), "CH");
        try {
            
        
        dao.guardarChofer(chofi);
        }catch(SQLException ex){
          //  JOptionPane.showMessageDialog(nuevoChofer, ex.getMessage());
           ex.printStackTrace();
        }catch(Exception ex){
             ex.printStackTrace();
             //JOptionPane.showMessageDialog(nuevoChofer, ex.getMessage());
        }
    }

}
