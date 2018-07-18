/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Operador;
import com.cet001.icaro.vista.NuevoOperadorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ponsa
 */
class OperadorController implements ActionListener {
    private NuevoOperadorView nuevoOp;
    private DaoImpl dao;
    public OperadorController (NuevoOperadorView nuevoOperador, DaoImpl dao){
        this.dao=dao;
        this.nuevoOp=nuevoOperador;
        this.nuevoOp.guardarOp.addActionListener(this);
    };
    
@Override
    public void actionPerformed(ActionEvent e){
       Operador op = new Operador();
       op.setNombre(nuevoOp.nombre.getText());
       op.setApellido(nuevoOp.apellido.getText());
       op.setDni(nuevoOp.dni.getText());
       op.setNroLegajo(parseInt(nuevoOp.legajo.getText()));
       op.setSueldo(parseDouble(nuevoOp.sueldo.getText()));
       try{
         
       dao.guardarOperador(op);
      JOptionPane.showMessageDialog(null, "Operador Guardado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage().toString());
        }
    }
    
}
