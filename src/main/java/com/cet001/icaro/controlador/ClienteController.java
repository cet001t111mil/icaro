/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Cliente;
import com.cet001.icaro.vista.ClienteView;
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
public class ClienteController implements ActionListener {

    private DaoImpl dao;
    private ClienteView cView;

    public ClienteController(ClienteView nuevoCliente, DaoImpl dao) {
        this.dao = dao;
        this.cView = nuevoCliente;
        this.cView.guardarBoton.addActionListener(this);
        this.cView.limpiarBusq.addActionListener(this);
        this.cView.mBorrra.addActionListener(this);
        this.cView.buscaBoton.addActionListener(this);
        this.cView.mModificar.addActionListener(this);

        llenarListaClientes();
    }

    @Override
    public void actionPerformed(ActionEvent f) {
        String opcion = f.getActionCommand();
        switch (opcion) {
            case "guardarCliente":
                guardarCliente();
                limpiarCamposN();
                llenarListaClientes();
                break;
            case "cliBuscar":
                llenarCamposBusqueda();
                cView.mIdCliente.setEditable(false);
                cView.mCliSaldo.setEditable(false);
                break;
            case "mCliLimpiar":
                cView.mCliSaldo.setEditable(true);
                cView.mIdCliente.setEditable(true);

                limpiarCamposM();

                break;
            case "mCliModificar":
                modificarCliente();
                limpiarCamposM();
                cView.mIdCliente.setEditable(true);
                cView.mCliSaldo.setEditable(true);
                llenarListaClientes();
        }
    }

    private void modificarCliente() {
        int idClie = parseInt(cView.mIdCliente.getText());
        Cliente clie = new Cliente();
        try {
            clie = dao.getCliente(idClie);
            String nombre = cView.mCliNombre.getText();
            String apellido = cView.mCliApellido.getText();
            String direccion = cView.mCliDireccion.getText();
            Double limiteDeCredito = parseDouble(cView.mCliLimite.getText());
            dao.modificarCliente(idClie, nombre, apellido, direccion, true, idClie, idClie);
            JOptionPane.showMessageDialog(null, "Cliente Actualizado");
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }
    }

    public void llenarCamposBusqueda() {
        Cliente cli = new Cliente();
        int id = parseInt(cView.mIdCliente.getText());
        try {
            cli = dao.getCliente(id);
            cView.mCliNombre.setText(cli.getNombre());
            cView.mCliApellido.setText(cli.getApellido());
            cView.mCliDireccion.setText(cli.getDireccion());
            cView.mCliLimite.setText(String.valueOf(cli.getLimiteDeCredito()));
            cView.mCliSaldo.setText(String.valueOf(cli.getSaldo()));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }
    }

    protected void llenarListaClientes() {

        DefaultListModel dlm = new DefaultListModel();
        try {

            List<Cliente> clientes = new ArrayList<>();
            clientes = dao.getClientes();
            for (Cliente c : clientes) {
                dlm.addElement("N°: " + c.getIdCliente() + " Nombre: " + c.getNombre() + " " + c.getApellido());
            }
            this.cView.listaClientes.setModel(dlm);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }

    }

    public void limpiarCamposN() {
        cView.nNombre.setText("");
        cView.nApellido.setText("");
        cView.nSaldo.setText("");
        cView.nDireccion.setText("");
    }

    public void limpiarCamposM() {

        cView.mCliNombre.setText("");
        cView.mCliApellido.setText("");
        cView.mCliSaldo.setText("");
        cView.mCliDireccion.setText("");
        cView.mCliLimite.setText("");
        cView.mIdCliente.setText("");

    }

    public void guardarCliente() {
        String nombre = cView.nNombre.getText();
        String apellido = cView.nApellido.getText();
        String saldo = cView.nSaldo.getText();
        String direccion = cView.nDireccion.getText();
        Cliente clien = new Cliente(nombre, apellido, Double.parseDouble(saldo), direccion);
        try {
            dao.guardarCliente(clien);
            JOptionPane.showMessageDialog(null, "Cliente Registrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }
    }

}
