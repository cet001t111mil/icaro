/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.dao;

import com.cet001.icaro.modelo.Chofer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ponsa
 */
public class ChoferImp {
        
    public ChoferImp(Chofer chof){
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
}
