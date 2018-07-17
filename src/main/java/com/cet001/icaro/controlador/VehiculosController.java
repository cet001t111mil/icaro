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
import java.util.ArrayList;

/**
 *
 * @author ponsa
 */
public class VehiculosController implements ActionListener {

    DaoImpl dao;
    VehiculosView vehiView;

    public VehiculosController(VehiculosView vehiView, DaoImpl dao) {
        this.dao = dao;
        this.vehiView = vehiView;
        llenarListaVehiculos();
        this.vehiView.borrarVehi.addActionListener(this);
        this.vehiView.guardaVehiculo.addActionListener(this);
        this.vehiView.modVehiculo.addActionListener(this);
        this.vehiView.cargarVehiculo.addActionListener(this);
        this.vehiView.limpiarBusq.addActionListener(this);

    }

    public void llenarListaVehiculos() {

        DefaultListModel Dlm = new DefaultListModel();

        try {
            String listaV = "";
            List<Vehiculo> vehiculos = dao.getVehiculosActivos();

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
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        switch (opcion) {//en función del comando devuelto por el método gAC, se entrará en 1 de las sig. alternativas
            case "guardaVehiculo": {//ver más abajo
                guardaVehiculo();
                limpGuardar();
                break;
            }

            case "cargVehiculo": {
                cargaVehiculo();
                this.vehiView.selePatMod.setEditable(false);
                break;
            }
            case "modVehiculo": {
                modificaVehiculo();
                limpBuscar();
                break;
            }

            case "limpBuscar": {
                limpBuscar();
                break;
            }
            case "borraVehiculo": {
                cargaVehiculo();
                int eleccion = JOptionPane.showConfirmDialog(null, "Se borrará el Vehiculo " + this.vehiView.selePatMod.getText(), "Borrado de Vehiculo", JOptionPane.OK_CANCEL_OPTION);
                switch (eleccion) {
                    case 0:
                        borraVehiculo();
                        limpBuscar();
                        llenarListaVehiculos();
                        break;
                    case 2:
                        limpBuscar();
                        break;
                }
               
            }

        }

    }

    protected void limpGuardar() {
        this.vehiView.agregaVehiAnio.setText("");
        this.vehiView.agregaVehiMarca.setText("");
        this.vehiView.agregaVehiMod.setText("");
        this.vehiView.agregaVehiPatente.setText("");
        this.vehiView.modifVehiMode.setText("");

    }

    protected void limpBuscar() {
        this.vehiView.selePatMod.setText("");
        this.vehiView.selePatMod.setEditable(true);
        this.vehiView.modifVehiAnio.setText("");
        this.vehiView.modifVehiMarca.setText("");
        this.vehiView.modifVehiMode.setText("");

    }

    private void modificaVehiculo() {
        String patente = this.vehiView.selePatMod.getText();
        String marca = this.vehiView.modifVehiMarca.getText();
        String modelo = this.vehiView.modifVehiMode.getText();
        String anio = this.vehiView.modifVehiAnio.getText();

        try {

            dao.modificarVehiculo(patente, marca, modelo, Integer.parseInt(anio), false, "F");
            llenarListaVehiculos();
            JOptionPane.showMessageDialog(null, "Vehiculo Modificado");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }
    }

    private void guardaVehiculo() {
        String patente = this.vehiView.agregaVehiPatente.getText();
        String marca = this.vehiView.agregaVehiMarca.getText();
        String modelo = this.vehiView.agregaVehiMod.getText();
        String anio = this.vehiView.agregaVehiAnio.getText();
        try {
            Vehiculo vehi = new Vehiculo(patente, marca, modelo, Integer.parseInt(anio));
            dao.guardarVehiculo(vehi);
            llenarListaVehiculos();
            JOptionPane.showMessageDialog(null, "Vehiculo Guardado");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }
    }

    private void cargaVehiculo() {

        String patente = this.vehiView.selePatMod.getText();
        Vehiculo ve = new Vehiculo();
        List<Vehiculo> vehiculos = new ArrayList<>();
        try {
            int indice = 0;
            vehiculos = dao.getVehiculos();
            for (int i = 0; i < vehiculos.size(); i++) {
                if (vehiculos.get(i).getPatente().equals(patente)) {
                    indice = i;
                }

            }
            //System.out.println(vehiculos.get(indice));
            ve = vehiculos.get(indice);
            this.vehiView.modifVehiMarca.setText(ve.getMarca());
            this.vehiView.modifVehiMode.setText(ve.getModelo());
            this.vehiView.modifVehiAnio.setText(String.valueOf(ve.getAnio()));
        } catch (Exception e) {

        }

    }

    private void borraVehiculo() {

        String patente = this.vehiView.selePatMod.getText();
        String marca = this.vehiView.modifVehiMarca.getText();
        String modelo = this.vehiView.modifVehiMode.getText();
        String anio = this.vehiView.modifVehiAnio.getText();

        try {

            dao.modificarVehiculo(patente, marca, modelo, Integer.parseInt(anio), false, "T");
            llenarListaVehiculos();
            JOptionPane.showMessageDialog(null, "Vehiculo Borrado");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }
    }

}
