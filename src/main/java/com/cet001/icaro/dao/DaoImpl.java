/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.dao;

import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.Cliente;
import com.cet001.icaro.modelo.Empleado;
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
public class DaoImpl {

    public DaoImpl() { //dejamos el constructor vacio por si necesitamos usar spring

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
//???? ver las 3 líneas siguientes
        manager.getTransaction().commit();
        manager.close();
        emf.close();
        return results;
    }

    public List<Cliente> getClientes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("remiseria?zeroDateTimeBehavior=convertToNullPU");
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Cliente> results = new ArrayList<>();
        results = manager.createQuery("Select c"
                + "from Cliente c").getResultList();
        for (Cliente e : results) {
            e.toString();
        }
//???? ver las 3 líneas siguientes
        manager.getTransaction().commit();
        manager.close();
        emf.close();
        return results;
    }
    
    
        public void GuardarCliente(Cliente clien) {
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
