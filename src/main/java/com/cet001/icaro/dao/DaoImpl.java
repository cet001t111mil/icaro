/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.dao;

import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.Cliente;
import com.cet001.icaro.modelo.Empleado;
import com.cet001.icaro.modelo.Operador;
import com.cet001.icaro.modelo.Viaje;
import com.cet001.icaro.modelo.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ponsa
 */
public class DaoImpl {

    EntityManagerFactory emf;
    EntityManager manager;

    //nombre de la unid. de persist: "remiseria?zeroDateTimeBehavior=convertToNullPU"
    //Santi: dejé acá el nombre de la unid de persist. xq no sé si lo necesitás tener a mano. 
    public DaoImpl(String nomUnidPersistencia) {
        this.emf = Persistence.createEntityManagerFactory(nomUnidPersistencia);
        this.manager = emf.createEntityManager();
    }

    @Override
    protected void finalize() throws Throwable {//chicos: a este mét. lo dejé "protected" porque sobreescribe el mét. finalize de Object.
        manager.close();
        emf.close();

    }

    public void GuardarCliente(Cliente clien) {
        try {

            System.out.println("persistido cliente");
            manager.getTransaction().begin();
            manager.persist(clien);
            manager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //en los métodos que devuelven listas no hice try/catch todavía xq me da conflicto con "return"
    // ?????????????????
    public List<Cliente> getClientes() {

        manager.getTransaction().begin();

        List<Cliente> results = new ArrayList<>();
        results = manager.createQuery("Select c"
                + "from Cliente c").getResultList();
        for (Cliente e : results) {
            e.toString();
        }

        manager.getTransaction().commit();

        return results;
    }

    public List<Cliente> getClientesActivos() {

        manager.getTransaction().begin();
        List<Cliente> results = new ArrayList<>();
        results = manager.createQuery("Select c"
                + "from Cliente c"
                + "where activo = ?1").setParameter(1, true).getResultList();
        for (Cliente e : results) {
            e.toString();
        }
        manager.getTransaction().commit();

        return results;
    }

    public void guardarViaje(Viaje viaje) {
        try {
            System.out.println("persistido viaje");

            manager.getTransaction().begin();
            manager.persist(viaje);
            manager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Viaje> getViajes() {

        manager.getTransaction().begin();
        List<Viaje> results = new ArrayList<>();
        results = manager.createQuery("Select v"
                + "from Viaje v").getResultList();
        for (Viaje e : results) {
            e.toString();
        }
        manager.getTransaction().commit();

        return results;

    }

    public List<Viaje> getViajesActivos() {

        manager.getTransaction().begin();
        List<Viaje> results = new ArrayList<>();
        results = manager.createQuery("Select v"
                + "from Viaje v"
                + "where activo = ?1").setParameter(1, true).getResultList();
        for (Viaje e : results) {
            e.toString();
        }
        manager.getTransaction().commit();

        return results;

    }

    public void guardarVehiculo(Vehiculo vehiculo) {
        try {
            System.out.println("persistido vehículo");

            manager.getTransaction().begin();
            manager.persist(vehiculo);
            manager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Vehiculo> getVehiculos() {

        manager.getTransaction().begin();
        List<Vehiculo> results = new ArrayList<>();
        results = manager.createQuery("Select ve"
                + "from Vehiculo ve").getResultList();
        for (Vehiculo e : results) {
            e.toString();
        }
        manager.getTransaction().commit();

        return results;

    }

    public List<Vehiculo> getVehiculosActivos() {

        manager.getTransaction().begin();
        List<Vehiculo> results = new ArrayList<>();
        results = manager.createQuery("Select ve"
                + "from Vehiculo ve"
                + "where activo = ?1").setParameter(1, true).getResultList();
        for (Vehiculo e : results) {
            e.toString();
        }
        manager.getTransaction().commit();

        return results;

    }

    public void guardarChofer(Empleado chof) {
        try {
            System.out.println("persistido chofer");
          
            manager.getTransaction().begin();
            manager.persist(chof);
            manager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Chofer> getChoferes() {

        manager.getTransaction().begin();
        List<Chofer> results = new ArrayList<>();
        results = manager.createQuery("Select e"
                + "from Empleado e"
                + "where tipo_empleado = ?1").setParameter(1, "CH").getResultList();
        for (Chofer e : results) {
            e.toString();
        }
        manager.getTransaction().commit();

        return results;
    }

    public List<Chofer> getChoferesActivos() {

        manager.getTransaction().begin();
        List<Chofer> results = new ArrayList<>();
        Query query = manager.createQuery("Select e"
                + "from Empleado e"
                + "where tipo_empleado = ?1 AND activo = ?2");
        query.setParameter(1, "CH");
        query.setParameter(2, true);
        results = query.getResultList();
        for (Chofer e : results) {
            e.toString();
        }
        manager.getTransaction().commit();

        return results;
    }

    public void guardarOperador(Empleado operador) {
        try {
            System.out.println("persistido operador");

            manager.getTransaction().begin();
            manager.persist(operador);
            manager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Operador> getOperadores() {

        manager.getTransaction().begin();
        List<Operador> results = new ArrayList<>();
        results = manager.createQuery("Select e"
                + "from Empleado e"
                + "where tipo_empleado = ?1").setParameter(1, "OP").getResultList();
        for (Operador e : results) {
            e.toString();
        }
        manager.getTransaction().commit();

        return results;
    }
//éste me parece que no tiene mucho sentido no????

    public List<Operador> getOperadoresActivos() {

        manager.getTransaction().begin();
        List<Operador> results = new ArrayList<>();
        Query query = manager.createQuery("Select e"
                + "from Empleado e"
                + "where tipo_empleado = ?1 AND activo = ?2");
        query.setParameter(1, "OP");
        query.setParameter(2, true);
        results = query.getResultList();

        for (Operador e : results) {
            e.toString();
        }
        manager.getTransaction().commit();

        return results;
    }

    public List<Empleado> getEmpleados() {

        manager.getTransaction().begin();
        List<Empleado> results = new ArrayList<>();
        results = manager.createQuery("Select e"
                + "from Empleado e").getResultList();
        for (Empleado e : results) {
            e.toString();
        }
        manager.getTransaction().commit();

        return results;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void modificarNroLegajo(int nroLegajo,String dni,String nombre,String apellido,String tipoEmpleado,double sueldo,double comision,boolean borradoLogico) {

        manager.getTransaction().begin();
        Empleado chof = manager.find(Chofer.class, nroLegajo);
        chof.setNroLegajo(nroLegajo);
        chof.setDni(dni);
        chof.setNombre(nombre);
        chof.setApellido(apellido);
        chof.setTipoEmpleado(tipoEmpleado);
        chof.setSueldo(sueldo);
       ((Chofer)chof).setComision(comision);
       chof.setActivo(borradoLogico);
        manager.persist(chof);
        manager.getTransaction().commit();

    }

}
