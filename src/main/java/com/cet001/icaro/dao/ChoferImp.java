/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.dao;

import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author ponsa
 */
public class ChoferImp {

    public ChoferImp() { //dejamos el constructor vacio por si necesitamos usar spring

    }

    public void guardarChofer(Empleado chof) {
        try {
            System.out.println("persistido chofer");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("remiseria?zeroDateTimeBehavior=convertToNullPU");
            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();
            manager.persist(chof);
            manager.getTransaction().commit();
            manager.close();
            emf.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Chofer> getChoferes() {
//còdigo modificado ver si es correcto (x tema herencia de Clase Empleado)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("remiseria?zeroDateTimeBehavior=convertToNullPU");
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Chofer> results = new ArrayList<>();
        results = manager.createQuery("Select e"
                + "from Empleado e"
                + "where tipo_empleado = ?1").setParameter(1, "CH").getResultList();
        for (Chofer e : results) {
            e.toString();
        }

        return results;
    }

}
