/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.Empleado;
import com.cet001.icaro.modelo.Vehiculo;
import com.cet001.icaro.vista.NuevoChoferView;
import com.cet001.icaro.vista.ConsultarChoferesView;
import com.cet001.icaro.vista.ModificarChoferView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ponsa
 */
public class ChoferController implements ActionListener {

    DaoImpl dao;

    ConsultarChoferesView consulChof;

    public ChoferController(ConsultarChoferesView consulChof, DaoImpl dao) {
        this.dao = dao;
        this.consulChof = consulChof;
        this.consulChof.botonAgregar.addActionListener(this);
        this.consulChof.buscarChofBoton.addActionListener(this);
        this.consulChof.borraChofBoton.addActionListener(this);
        this.consulChof.limpiaCamposBoton.addActionListener(this);
        this.consulChof.moficaChoBoton.addActionListener(this);

        llenarListaChof();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        switch (opcion) {//en función del comando devuelto por el método gAC, se entrará en 1 de las sig. alternativas
            case "agregarChofer": {//ver más abajo
                guardarChofer();
                llenarListaChof();
                limpiarTextosN();
                break;
            }

            case "botonModificar": {//BOTON  GUARDA DATOS DESDE VENTANA MODIFICAR MODIFICAR CHOFER
                
                actualizarChofer();
                limpiarTextosM();
                break;
            }

            case "botonLimpiar": {
                limpiarTextosM();

                break;
            }
            case "botonBuscar": { //abre ventana modificar chofer chofer
                cargaDatosChofer2();
                
                consulChof.mChoLegajo.setEditable(false);
                break;
                
            }
        }

    }

    protected void cargarDatosChofer() {
        int legajoB = parseInt(consulChof.mChoLegajo.getText());
        Chofer chofBusqueda = new Chofer();

        try {
            chofBusqueda = dao.getChofer(legajoB);
            consulChof.mChoLegajo.setText(String.valueOf(chofBusqueda.getNroLegajo()));
            consulChof.mChoApellido.setText(chofBusqueda.getApellido());
            consulChof.mChoNombre.setText(chofBusqueda.getNombre());
            consulChof.mChoDni.setText(chofBusqueda.getDni());
            consulChof.mChoComision.setText(String.valueOf(chofBusqueda.getComision()));
            consulChof.mChoSueldo.setText(String.valueOf(chofBusqueda.getSueldo()));
        } catch (Exception ex) {
            Logger.getLogger(ChoferController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        private void cargaDatosChofer2() {

        String legajo = this.consulChof.mChoLegajo.getText();
        Chofer chofBusqueda = new Chofer();
        List<Chofer> choferes = new ArrayList<>();
        try {
            int indice = 0;
            choferes = dao.getChoferes();
            for (int i = 0; i < choferes.size(); i++) {
                if (String.valueOf(choferes.get(i).getNroLegajo()).equals(legajo)) {
                    indice = i;
                }

            }
            chofBusqueda = choferes.get(indice);
            consulChof.mChoLegajo.setText(String.valueOf(chofBusqueda.getNroLegajo()));
            consulChof.mChoApellido.setText(chofBusqueda.getApellido());
            consulChof.mChoNombre.setText(chofBusqueda.getNombre());
            consulChof.mChoDni.setText(chofBusqueda.getDni());
            consulChof.mChoComision.setText(String.valueOf(chofBusqueda.getComision()));
            consulChof.mChoSueldo.setText(String.valueOf(chofBusqueda.getSueldo()));
        } catch (Exception e) {

        }

    }
    public void limpiarTextosM() {
        consulChof.mChoLegajo.setEditable(true);
        consulChof.mChoApellido.setText("");
        consulChof.mChoNombre.setText("");
        consulChof.mChoDni.setText("");
        consulChof.mChoLegajo.setText("");
        consulChof.mChoComision.setText("");
        consulChof.mChoSueldo.setText("");

    }

    public void limpiarTextosN() {
        
        consulChof.nChoApellido.setText("");
        consulChof.nChoNombre.setText("");
        consulChof.nChoDni.setText("");
        consulChof.nChoLegajo.setText("");
        consulChof.nChoComision.setText("");
        consulChof.nChoSueldo.setText("");

    }

    protected void llenarListaChof() {

        DefaultListModel dlm = new DefaultListModel();
        try {

            List<Chofer> choferes = new ArrayList<>();
            choferes = dao.getChoferes();
            for (Chofer c : choferes) {
                dlm.addElement("Legajo: " + c.getNroLegajo() + " Nombre: " + c.getNombre() + " Apellido: " + c.getApellido());
            }
            this.consulChof.jListChof.setModel(dlm);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }

    }

    protected void guardarChofer() {

        int legajo = parseInt(this.consulChof.nChoLegajo.getText());
        String nombre = this.consulChof.nChoNombre.getText();
        String apellido = this.consulChof.nChoApellido.getText();
        String dni = this.consulChof.nChoDni.getText();
        Double comision = parseDouble(this.consulChof.nChoComision.getText());
        Double sueldo = parseDouble(this.consulChof.nChoSueldo.getText());

        Chofer chofi = new Chofer(sueldo, comision, dni, nombre, apellido, legajo, "CH");
        try {
            dao.guardarChofer(chofi);
            JOptionPane.showMessageDialog(null, "Chofer Registrado");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }
    }

    protected void actualizarChofer() {
        int legajo = parseInt(this.consulChof.mChoLegajo.getText());//ojo
        String nombre = consulChof.mChoNombre.getText();
        String apellido = consulChof.mChoApellido.getText();
        String dni = consulChof.mChoDni.getText();
        Double sueldo = parseDouble(consulChof.mChoSueldo.getText());
        Double comision = parseDouble(consulChof.mChoComision.getText());
        Chofer chofAct = new Chofer(sueldo, comision, dni, nombre, apellido, legajo, "CH");

        try {
            dao.modificarEmpleado(legajo, dni, nombre, apellido, "CH", sueldo, comision, false);
            JOptionPane.showMessageDialog(null, "Chofer Actualizado");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }
    }

}
