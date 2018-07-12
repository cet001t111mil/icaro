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
/**
 *
 * @author ponsa
 */
public class NuevoChoferController implements ActionListener {//esta es la clase del objeto que "controlará" a los objetos de tipo NuevoChofer
    private NuevoChoferView nuevoChofer;//declaración de la variable que alojará 1 objeto de tipo NuevoChofer cuya parte visible para el usuario será la ventana "Nuevo Chofer"
    
    
    public NuevoChoferController (NuevoChoferView nuevoChofer){
        this.nuevoChofer=nuevoChofer;
        this.nuevoChofer.jButton1.addActionListener(this);//esto conecta al controlador con el botón "guardar" del formulario "Nuevo Chofer" que pertenece al obj. recibido por parám. para que detecte el click en este botón.
                
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        
        String legajo = nuevoChofer.legajo.getText();//se obtiene el dato ingresado en el campo "legajo" del formulario "Nuevo Chofer" y se lo asigna a 1 variable de tipo String. Se hace lo mismo con c/u de los campos del formulario.
        String nombre = nuevoChofer.nombre.getText();
        String apellido = nuevoChofer.apellido.getText();
        String dni = nuevoChofer.dni.getText();
        String comision = nuevoChofer.comision.getText();
        String sueldo = nuevoChofer.sueldo.getText();
        //se crea un obj. de tipo Chofer y se le pasa por parám. a su constructor los datos de las variables recién asignadas previa conversión al tipo de dato que corresponda.
        Empleado chof = new Chofer (Double.parseDouble(sueldo), Double.parseDouble(comision),dni,nombre,apellido,Integer.parseInt(legajo),"CH");
        /*
        Se crea 1 obj. de tipo ChoferImp para guardar (persistir) en la BD al obj. "chof" y todos sus datos
        (los valores ingresados a través del formulario)
        */
        DaoImpl chI = new DaoImpl ();
        chI.guardarChofer(chof);//con este mét. se persiste el obj. "chof"
        
        
    }



    
}
