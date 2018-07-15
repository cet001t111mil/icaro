/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro;

import com.cet001.icaro.controlador.PrincipalController;
import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.Empleado;
import com.cet001.icaro.modelo.Viaje;
import com.cet001.icaro.vista.PrincipalView;
import java.awt.Window;

/**
 *
 * @author ponsa
 */
public class Test {
public static String perUnit ="remiseria?zeroDateTimeBehavior=convertToNullPU";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       
        DaoImpl dao =new DaoImpl (perUnit);
        PrincipalView pri = new PrincipalView();
        PrincipalController con = new PrincipalController (pri, dao);
        
        pri.setVisible(true);
        con.iniciar();
   
    
    }
    
}
