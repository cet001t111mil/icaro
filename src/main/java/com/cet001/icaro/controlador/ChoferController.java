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
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ponsa
 */
public class ChoferController implements ActionListener {

    DaoImpl dao;
    private NuevoChoferView nuevoChofer;
    private ConsultarChoferesView consulChof;
    private ModificarChoferView modChof;

    public ChoferController(NuevoChoferView nuevoChofer, DaoImpl dao) { //controla la ventana nuevo chofer
        this.dao = dao;
        this.nuevoChofer = nuevoChofer;
        this.nuevoChofer.jButton1.addActionListener(this);
    }
    //Constructor consulta choferes

    public ChoferController(ConsultarChoferesView consultaChofer, DaoImpl dao) { //controla ventana consultas chofer
        this.dao = dao;
        this.consulChof = consultaChofer;
        this.consulChof.botonAgregar.addActionListener(this);
        this.consulChof.modificar.addActionListener(this);
        llenaListaChof();
    }

    public ChoferController(ModificarChoferView modChof, DaoImpl dao) { //controla modificar chofer
        this.dao = dao;
        this.modChof = modChof;
        this.modChof.actualizarChofButton.addActionListener(this);
        
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

            case "AgregarChof": {
                NuevoChoferView nChof = new NuevoChoferView();//se crea 1 obj. de tipo NuevoChofer
                nChof.setTitle("Nuevo Chofer");
                nChof.setVisible(true);//hace visible al usuario el formulario para registrar los datos de 1 nuevo chofer (son los datos que luego se asignarán a nChof)
                ChoferController connchof = new ChoferController(nChof, this.dao);//se crea 1 obj. controlador que "controlará" a nChof
                break;
            }
            case "modificarChofer": {
                ModificarChoferView modChof = new ModificarChoferView();
                modChof.setTitle("Modificar Chofer");
                modChof.setVisible(true);
                ChoferController connchof = new ChoferController(modChof, this.dao);
                guardarChofer();
                break;
            }
        }

    }

    protected void llenaListaChof() {
        DefaultListModel Dlm = new DefaultListModel();
        try {
            String listaChof = "";
            List<Chofer> choferes = this.dao.getChoferesActivos();

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

        String legajo = this.nuevoChofer.legajo.getText();
        String nombre = this.nuevoChofer.nombre.getText();
        String apellido = this.nuevoChofer.apellido.getText();
        String dni = this.nuevoChofer.dni.getText();
        String comision = this.nuevoChofer.comision.getText();
        String sueldo = this.nuevoChofer.sueldo.getText();
        Chofer chofi = new Chofer(Double.parseDouble(sueldo), Double.parseDouble(comision), dni, nombre, apellido, Integer.parseInt(legajo), "CH");
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
