/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro;

import com.cet001.icaro.controlador.PrincipalController;
import com.cet001.icaro.modelo.Viaje;
import com.cet001.icaro.vista.PrincipalView;
import java.awt.Window;

/**
 *
 * @author ponsa
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        PrincipalView pri = new PrincipalView();
        
        PrincipalController con = new PrincipalController (pri);
        con.iniciar();
        pri.setVisible(true);
        
    }
    
}
