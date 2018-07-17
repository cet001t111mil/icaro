/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.Cliente;
import com.cet001.icaro.modelo.Empleado;
import com.cet001.icaro.modelo.Vehiculo;
import com.cet001.icaro.vista.NuevoViajeView;
import com.cet001.icaro.modelo.Viaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ponsa
 */
public class ViajeController implements ActionListener {

    private NuevoViajeView nuevoViaje;
    DaoImpl dao;

    public ViajeController(NuevoViajeView nuevoViaje, DaoImpl dao) {
        this.nuevoViaje = nuevoViaje;
        this.dao = dao;
        this.nuevoViaje.guardarViaje.addActionListener(this);
        llenaComboChofer();
        llenaComboVehiculo();
        llenaComboCliente();

    }

    protected void llenaComboVehiculo() {
        List<Vehiculo> veActivos = new ArrayList<>();
        try {
            veActivos = dao.getVehiculosDisponiblesParaViaje();
            for (Vehiculo v : veActivos) {
                this.nuevoViaje.comboMovilViaje.addItem(v.getPatente());
            }

        } catch (Exception e) {

        }

    }

        protected void llenaComboChofer() {
        List<Chofer> choferes = new ArrayList<>();
        try {
            choferes = dao.getChoferes();
            for (Chofer em : choferes) {
                this.nuevoViaje.jComboChoferNV.addItem("Legajo: "+String.valueOf(em.getNroLegajo())+" "+em.getNombre()+" "+em.getApellido());
            }

        } catch (Exception e) {

        }

    }
    
            protected void llenaComboCliente() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes = dao.getClientes();
            for (Cliente cl: clientes) {
                this.nuevoViaje.jComboCliente.addItem("Codigo : "+String.valueOf(cl.getIdCliente())+" "+cl.getNombre()+" "+ cl.getApellido());
            }

        } catch (Exception e) {

        }

    }
        
        
    @Override
    public void actionPerformed(ActionEvent e) {
        String op = e.getActionCommand();
        switch (op) {
            case "guardar":

                Object seleccionAuto = this.nuevoViaje.comboMovilViaje.getSelectedItem();
                String patente = seleccionAuto.toString();
                Object seleccionChofer = this.nuevoViaje.jComboChoferNV.getSelectedItem();
                String legajoChofer = seleccionChofer.toString();
                try {
                    Vehiculo auto = dao.getVehiculo(patente);
                    Chofer chofer = dao.getChofer(Integer.parseInt(legajoChofer));
                    
                } catch (Exception exce) {

                }
                System.out.println(patente);

//        String origen = nuevoViaje.origen.getText();
//        String destino = nuevoViaje.destino.getText();
//        String fecha = nuevoViaje.fecha.getText();
//        String movil = nuevoViaje.comboMovilViaje.toString();
//        String cliente = nuevoViaje.cliente.getText();
//         //si yo recibo el id del chofer, lo puedo buscar , instanciar y agregar al constructor de viaje 
//        System.out.println("sdfs"+nuevoViaje.jComboChoferNV.getName());
        }
    }

}
