package com.cet001.icaro.dao;

import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * //Santi:le puse los 2 cierres de conex. al "finalize" xq quise respetar lo
 * que habíamos acordado ayer, pero me parece bien así como indicaste vos.
 * Pregunta: en el "finalize" le dejamos ambos cierres así como están o quitamos
 * el manager.close() que ya lo tenemos en el "finally" todos los métodos??? .
 *
 *///######### manager close despues de c/consulta // emf en constructor del dao
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

    public void GuardarCliente(Cliente clien) throws Exception {
        try {
            System.out.println("persistido cliente");
            manager.getTransaction().begin();
            manager.persist(clien);
            manager.getTransaction().commit();

        } finally {
            manager.close();
        }

    }

    public List<Cliente> getClientes() throws Exception {
        manager.getTransaction().begin();
        List<Cliente> results = null;
        try {
            results = new ArrayList<>();
            results = manager.createQuery("Select c"
                    + "from Cliente c").getResultList();
            manager.getTransaction().commit();

        } finally {
            manager.close();
            return results;
        }
    }

    public List<Cliente> getClientesActivos() throws Exception {
        manager.getTransaction().begin();
        List<Cliente> results = null;
        try {
            results = new ArrayList<>();
            results = manager.createQuery("Select c"
                    + "from Cliente c"
                    + "where borrado_logico = ?1").setParameter(1, false).getResultList();
            for (Cliente e : results) {
                e.toString();
            }
            manager.getTransaction().commit();

        } finally {
            manager.close();
            return results;
        }
    }

    public void guardarViaje(Viaje viaje) throws Exception {
        try {
            System.out.println("persistido viaje");
            manager.getTransaction().begin();
            manager.persist(viaje);
            manager.getTransaction().commit();

        } finally {
            manager.close();
        }
    }

    public List<Viaje> getViajes() throws Exception {
        manager.getTransaction().begin();
        List<Viaje> results = null;
        try {
            results = new ArrayList<>();
            results = manager.createQuery("Select v"
                    + "from Viaje v").getResultList();
            for (Viaje e : results) {
                e.toString();
            }
            manager.getTransaction().commit();

        } finally {
            manager.close();
            return results;

        }
    }

    public List<Viaje> getViajesRealizados() throws Exception {
        manager.getTransaction().begin();
        List<Viaje> results = null;
        try {
            results = new ArrayList<>();
            results = manager.createQuery("Select v"
                    + "from Viaje v"
                    + "where borrado_logico = ?1").setParameter(1, false).getResultList();
            for (Viaje e : results) {
                e.toString();
            }
            manager.getTransaction().commit();

        } finally {
            manager.close();
            return results;
        }
    }

    public void guardarVehiculo(Vehiculo vehiculo) throws Exception {
        try {
            System.out.println("persistido vehículo");
            manager.getTransaction().begin();
            manager.persist(vehiculo);
            manager.getTransaction().commit();

        } finally {
            manager.close();
        }
    }

    public List<Vehiculo> getVehiculos() throws Exception {
        manager.getTransaction().begin();
        List<Vehiculo> results = null;
        try {
            results = new ArrayList<>();
            results = manager.createQuery("Select ve"
                    + "from Vehiculo ve").getResultList();
            for (Vehiculo e : results) {
                e.toString();
            }
            manager.getTransaction().commit();

        } finally {
            manager.close();
            return results;
        }
    }

    public List<Vehiculo> getVehiculosActivos() throws Exception {
        manager.getTransaction().begin();
        List<Vehiculo> results = null;
        try {
            results = new ArrayList<>();
            results = manager.createQuery("Select ve"
                    + "from Vehiculo ve"
                    + "where borrado_logico = ?1").setParameter(1, false).getResultList();
            for (Vehiculo e : results) {
                e.toString();
            }
            manager.getTransaction().commit();

        } finally {
            manager.close();
            return results;
        }

    }

    public void guardarChofer(Empleado chof) throws Exception {
        try {
            System.out.println("persistido chofer");
            manager.getTransaction().begin();
            manager.persist(chof);
            manager.getTransaction().commit();

        } finally {
            manager.close();
        }
    }

    public List<Chofer> getChoferes() throws Exception {
        manager.getTransaction().begin();
        List<Chofer> results = null;
        try {
            results = new ArrayList<>();
            results = manager.createQuery("Select e"
                    + "from Empleado e"
                    + "where tipo_empleado = ?1").setParameter(1, "CH").getResultList();
            for (Chofer e : results) {
                e.toString();
            }
            manager.getTransaction().commit();

        } finally {
            manager.close();
            return results;
        }
    }

    public List<Chofer> getChoferesActivos() throws Exception {

        manager.getTransaction().begin();
        List<Chofer> results = null;
        try {
            results = new ArrayList<>();
            Query query = manager.createQuery("Select e"
                    + "from Empleado e"
                    + "where tipo_empleado = ?1 AND borrado_logico = ?2");
            query.setParameter(1, "CH");
            query.setParameter(2, false);
            results = query.getResultList();
            for (Chofer e : results) {
                e.toString();
            }
            manager.getTransaction().commit();

        } finally {
            manager.close();
            return results;
        }

    }

    public void guardarOperador(Empleado operador) throws Exception {
        try {
            System.out.println("persistido operador");
            manager.getTransaction().begin();
            manager.persist(operador);
            manager.getTransaction().commit();

        } finally {
            manager.close();
        }
    }

    public List<Operador> getOperadores() throws Exception {
        manager.getTransaction().begin();
        List<Operador> results = null;
        try {
            results = new ArrayList<>();
            results = manager.createQuery("Select e"
                    + "from Empleado e"
                    + "where tipo_empleado = ?1").setParameter(1, "OP").getResultList();
            for (Operador e : results) {
                e.toString();
            }
            manager.getTransaction().commit();

        } finally {
            manager.close();
            return results;
        }
    }
// #################  Chicos, a ver qué opinan: éste me parece que no tiene mucho sentido no????

    public List<Operador> getOperadoresActivos() throws Exception {
        manager.getTransaction().begin();
        List<Operador> results = null;
        try {
            results = new ArrayList<>();

            Query query = manager.createQuery("Select e"
                    + "from Empleado e"
                    + "where tipo_empleado = ?1 AND borrado_logico = ?2");
            query.setParameter(1, "OP");
            query.setParameter(2, false);
            results = query.getResultList();

            for (Operador e : results) {
                e.toString();
            }
            manager.getTransaction().commit();

        } finally {
            manager.close();
            return results;
        }
    }

    public List<Empleado> getEmpleados() throws Exception {
        manager.getTransaction().begin();
        List<Empleado> results = null;
        try {
            results = new ArrayList<>();

            results = manager.createQuery("Select e"
                    + "from Empleado e").getResultList();
            for (Empleado e : results) {
                e.toString();
            }
            manager.getTransaction().commit();

        } finally {
            manager.close();
            return results;
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /* En la ventana para modif chofer los agregados con respecto a la de agregar chofer serían: un sector para elegir tipo
    de empleado por si un chofer cambia de rol y pasa a ser operador o viceversa y un sector para el borrado lógico que,
    para mí, allá en la ventana sería mejor ponerle otro nombre en lug de borrado logico.
     */
    public void modificarChofer(int nroLegajo, String dni, String nombre, String apellido, String tipoEmpleado, double sueldo, double comision, boolean borradoLogico) throws Exception {
        Try
        {
            manager.getTransaction().begin();
            Empleado chof = manager.find(Chofer.class, nroLegajo);
            chof.setDni(dni);
            chof.setNombre(nombre);
            chof.setApellido(apellido);
            chof.setTipoEmpleado(tipoEmpleado);
            chof.setSueldo(sueldo);
            ((Chofer) chof).setComision(comision);
            chof.setBorradoLogico(borradoLogico);
            manager.persist(chof);
            manager.getTransaction().commit();
        }finally{
            manager.close();
                }
    }

    /*
    Me parece que no tiene sentido hacer un metodo "modificarEmpleado" a parte de modChofer y modOperador, pero tal vez sería mejor 
    unificarlos en un "modificarEmpleado y que se vincule ese mismo método tanto a la ventana de "modificarEmpleado" como a la de
    "modificarOperador(). La unica dif. es que chof tiene comisión. En la ventana de modif. operador, tal vez se podría omitir 
    esa opción para que el operador no pueda setearse una comisión, ya que es él mismo el que va a modif. los datos ahí.
    Si prefieren así, avisen que los unifico.
     */
    public void modificarOperador(int nroLegajo, String dni, String nombre, String apellido, String tipoEmpleado, double sueldo, boolean borradoLogico) throws Exception {
        Try
        {
            manager.getTransaction().begin();
            Empleado operador = manager.find(Operador.class, nroLegajo);
            operador.setDni(dni);
            operador.setNombre(nombre);
            operador.setApellido(apellido);
            operador.setTipoEmpleado(tipoEmpleado);
            operador.setSueldo(sueldo);
            operador.setBorradoLogico(borradoLogico);
            manager.persist(operador);
            manager.getTransaction().commit();
        }finally{
        manager.close();
            }
    }

    //no le vamos a permitir modif. la lista de viajes en esta vista.
    // (los viajes acá solo se verán. Para eliminar o modific. viaje habrá que ir a las correspondientes ventanas)
    public void modificarVehiculo(String patente, String marca, String modelo, int anio, boolean enViaje, boolean borradoLogico) throws Exception {
        try {
            manager.getTransaction().begin();
            Vehiculo vehic = manager.find(Vehiculo.class, patente);//patente es pk en la BD. No se permitirá modificar, pero se neces. recibir x parám. p/esta búsqueda
            vehic.setMarca(marca);
            vehic.setModelo(modelo);
            vehic.setAnio(anio);
            vehic.setEnViaje(enViaje);
            vehic.setBorradoLogico(borradoLogico);
            manager.persist(vehic);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }

    }
    //idem que p/caso anterior: se permitirá ver pero no modificar las listas: "telefonos","movSal","viajes"(p/estas mod. ir a las ventanas corresp.)

    //Supongo que permitimos ver acá las listas porque no haremos ventanas específicas para ver datos de cliente, de vehiculo,etc)
    //Si hicieramos esas vent. podriamos sacar las listas de las ventanas como ésta. Pero no creo que hagamos tantas ventanas,no?
    //lo que sí podemos hacer para eliminar las listas de estas ventanas es: titular las ventanas de modificaciones como "ver/modificar Cliente","ver/modificarViaje",etc.,
    //entonces ahí ya quedaría mejor sacar las listas de las ventanas en las que habían quedado sólo para vista.
    public void modificarCliente(int idCliente, String nombre, String apellido, String direccion, boolean borradoLogico, double saldo, double limiteDeCredito) throws Exception {
        Try
        {
            manager.getTransaction().begin();
            Cliente cli = manager.find(Cliente.class, idCliente);
            cli.setNombre(nombre);
            cli.setApellido(apellido);
            cli.setDireccion(direccion);
            cli.setBorradoLogico(borradoLogico);
            cli.setSaldo(saldo);
            cli.setLimiteDeCredito(limiteDeCredito);
            manager.persist(cli);
            manager.getTransaction().commit();
        }finally{
        manager.close();
            }

    }

}
