/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.dao;

import com.cet001.icaro.modelo.Chofer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author ponsa
 */
public class ChoferImp {

    public ChoferImp() { //dejamos el constructor vacio por si necesitamos usar spring
        

    }

    public void guardarChofer (Chofer chof) { 
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

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("remiseria?zeroDateTimeBehavior=convertToNullPU");
        EntityManager manager = emf.createEntityManager();
        CriteriaBuilder cb = manager.getCriteriaBuilder();
         CriteriaQuery<Chofer> q = cb.createQuery(Chofer.class);
         TypedQuery<Chofer> query = manager.createQuery(q);
         List<Chofer> results = query.getResultList();
        return results;

//return  (List<Chofer>) manager.("SELECT e FROM e");

    }
}
