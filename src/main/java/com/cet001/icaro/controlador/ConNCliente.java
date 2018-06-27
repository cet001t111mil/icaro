/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import com.cet001.icaro.modelo.Cliente;
import com.cet001.icaro.vista.NuevoCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        System.out.println("laskjdf");
        String nombre = nuevoCliente.nombre.getText();
        String apellido = nuevoCliente.apellido.getText();
        String saldo = nuevoCliente.saldo.getText();
        String direccion = nuevoCliente.direccion.getText();
        String comision = nuevoCliente.telefono.getText();

        Cliente clien = new Cliente(nombre, apellido, Double.parseDouble(saldo), direccion);

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("remiseria?zeroDateTimeBehavior=convertToNullPU");
            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();
            manager.persist(clien);

            manager.getTransaction().commit();
            manager.close();
            emf.close();
            System.out.println("persistido");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
