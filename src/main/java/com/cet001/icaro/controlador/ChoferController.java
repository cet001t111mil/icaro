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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ponsa
 */
public class ChoferController implements ActionListener {//esta es la clase del objeto que "controlará" a los objetos de tipo NuevoChofer

    DaoImpl dao;
    private NuevoChoferView nuevoChofer;
    private ConsultarChoferesView consulChof;

    public ChoferController(NuevoChoferView nuevoChofer, DaoImpl dao) {
        this.dao = dao;
        this.nuevoChofer = nuevoChofer;
        this.nuevoChofer.jButton1.addActionListener(this);
    }
    //Constructor consulta choferes
    
    
    public ChoferController(ConsultarChoferesView consultaChofer, DaoImpl dao) {
        this.dao = dao;
        this.consulChof = consultaChofer;
        llenaListaChof();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        switch (opcion) {//en función del comando devuelto por el método gAC, se entrará en 1 de las sig. alternativas
            case "nChof": {//ver más abajo
                guardarChofer();
                break;
            }

            case "modChof": {//ver más abajo
                modificarChofer();

                break;
            }

        }

    }

    protected void llenaListaChof() {
        DefaultListModel Dlm = new DefaultListModel();
        try {
            String listaChof = "";
            List<Chofer> choferes = dao.getChoferes();

            for (Chofer c : choferes) {
                Dlm.addElement("Legajo: " + c.getNroLegajo() + " Nombre: " + c.getNombre() + " Apellido: " + c.getApellido());
            }
            consulChof.jListChof.setModel(Dlm);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }

    }

    protected void guardarChofer() {

        String legajo = nuevoChofer.legajo.getText();
        String nombre = nuevoChofer.nombre.getText();
        String apellido = nuevoChofer.apellido.getText();
        String dni = nuevoChofer.dni.getText();
        String comision = nuevoChofer.comision.getText();
        String sueldo = nuevoChofer.sueldo.getText();
        Chofer chofi = new Chofer(Double.parseDouble(sueldo), Double.parseDouble(comision), dni, nombre, apellido, Integer.parseInt(legajo),"CH");
        try {

            dao.guardarChofer(chofi);
            JOptionPane.showMessageDialog(null, "Chofer Guardado");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }
    }

    protected void modificarChofer() {
        //String legajo = 
    }

}
