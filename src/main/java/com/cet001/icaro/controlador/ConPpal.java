/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import java.awt.event.ActionListener;
import com.cet001.icaro.vista.Principal;
import com.cet001.icaro.modelo.Viaje;
import com.cet001.icaro.vista.NuevoViaje;
import java.awt.event.ActionEvent;

/**
 *
 * @author ponsa
 */
public class ConPpal implements ActionListener {

    private Principal wPrincipal;
    private Viaje viaje;

    public ConPpal(Principal wPrincipal, Viaje viaje) {
        this.viaje = viaje;
        this.wPrincipal = wPrincipal;
        this.wPrincipal.jMenuItem1.addActionListener(this);
    }

    public void iniciar() {
        this.wPrincipal.setTitle("Icaro Gestion Remis");


    }

    public void actionPerformed(ActionEvent e) {
        NuevoViaje nVven = new NuevoViaje();
        nVven.setVisible(true);
    }
}
