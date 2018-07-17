/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.vista.VehiculosView;

/**
 *
 * @author ponsa
 */
public class VehiculosController {
    DaoImpl dao;
    VehiculosView vehiView;
    
    public VehiculosController (VehiculosView vehiView, DaoImpl dao){
        this.dao = dao;
        this.vehiView = vehiView;
    }
           
}
