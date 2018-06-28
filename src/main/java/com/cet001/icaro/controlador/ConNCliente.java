/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import com.cet001.icaro.dao.ClienteImp;
import com.cet001.icaro.modelo.Cliente;
import com.cet001.icaro.vista.NuevoCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author ponsa
 */
public class ConNCliente implements ActionListener {

    private NuevoCliente nuevoCliente;

    public ConNCliente(NuevoCliente nuevoCliente) {
        this.nuevoCliente = nuevoCliente;
        this.nuevoCliente.jButton2.addActionListener(this);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent f) {
        String nombre = nuevoCliente.nombre.getText();
        String apellido = nuevoCliente.apellido.getText();
        String saldo = nuevoCliente.saldo.getText();
        String direccion = nuevoCliente.direccion.getText();
        String comision = nuevoCliente.telefono.getText();

        Cliente clien = new Cliente(nombre, apellido, Double.parseDouble(saldo), direccion);
        
        ClienteImp clienI = new ClienteImp(clien);
  
        
}
}