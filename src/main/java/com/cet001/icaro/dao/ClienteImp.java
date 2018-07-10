/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.dao;

import com.cet001.icaro.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ponsa
 */
public class ClienteImp {

    public ClienteImp(Cliente clien) {
        try {
            System.out.println("persistido");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("remiseria?zeroDateTimeBehavior=convertToNullPU");
            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();
            manager.persist(clien);
            manager.getTransaction().commit();
            manager.close();
            emf.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //método agregado   
    public List<Cliente> getClientes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("remiseria?zeroDateTimeBehavior=convertToNullPU");
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Cliente> results = new ArrayList<>();
        results = manager.createQuery("Select c"
                + "from Clliente c").getResultList();
        for (Cliente e : results) {
            e.toString();
        }
//???? ver las 3 líneas siguientes
        manager.getTransaction().commit();
        manager.close();
        emf.close();
        return results;
    }

}
