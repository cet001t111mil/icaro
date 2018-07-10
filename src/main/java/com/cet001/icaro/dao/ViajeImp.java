/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.dao;

import com.cet001.icaro.modelo.Viaje;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ponsa
 */
//métodos guardarViaje y getViajes agregado
public class ViajeImp {

    public void guardarViaje(Viaje viaje) {
        try {
            System.out.println("persistido");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("remiseria?zeroDateTimeBehavior=convertToNullPU");
            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();
            manager.persist(viaje);
            manager.getTransaction().commit();
            manager.close();
            emf.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Viaje> getViajes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("remiseria?zeroDateTimeBehavior=convertToNullPU");
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Viaje> results = new ArrayList<>();
        results = manager.createQuery("Select v"
                + "from Viaje v").getResultList();
        for (Viaje e : results) {
            e.toString();
        }
//???? ver las 3 líneas siguientes
        manager.getTransaction().commit();
        manager.close();
        emf.close();
        
        return results;



    }

}
