/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import java.awt.event.ActionListener;
import com.cet001.icaro.vista.Principal;
import com.cet001.icaro.vista.NuevoChofer;
import com.cet001.icaro.vista.NuevoViaje;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JMenuItem;


/**
 *
 * @author ponsa
 */
public class ConPpal implements ActionListener {

    
    private Principal wPrincipal;
    

    public ConPpal(Principal wPrincipal) {
        
        this.wPrincipal = wPrincipal;
        this.wPrincipal.menuAgregarChofer.addActionListener(this);
        this.wPrincipal.jMenuItem1.addActionListener(this);
        
        
    }

    public void iniciar() {
        this.wPrincipal.setTitle("Icaro Gestion Remis");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String opcion = e.getActionCommand();
                
        switch (opcion) {
            case "nChof": {
                NuevoChofer nChof = new NuevoChofer();
                nChof.setTitle("Nuevo Chofer");
                nChof.setVisible(true);
                break;
            }
            case "nviaje": {
                System.out.println("nuevo viaje");
                NuevoViaje nVven = new NuevoViaje();
                nVven.setTitle("Nuevo Viaje");
                nVven.setVisible(true);
               
                
            }
        }

    }

}
