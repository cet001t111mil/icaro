package com.cet001.icaro.dao;

import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.*;
import java.util.ArrayList;
import java.util.Calendar;
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

    public void GuardarMovimientoDeSaldo(MovimientoDeSaldo mov) throws Exception {
        manager.getTransaction().begin();

        manager.persist(mov);
        manager.getTransaction().commit();

    }

    public List<MovimientoDeSaldo> getMovimientoDeSaldo() throws Exception {
        manager.getTransaction().begin();
        List<MovimientoDeSaldo> results = null;

        results = new ArrayList<>();
        results = manager.createQuery("Select m "
                + "from MovimientoDeSaldo m").getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public void GuardarTelfonoCliente(TelefonoCliente tel) throws Exception {
        manager.getTransaction().begin();

        manager.persist(tel);
        manager.getTransaction().commit();

    }

    public List<TelefonoCliente> getTelefonoCliente() throws Exception {
        manager.getTransaction().begin();
        List<TelefonoCliente> results = null;

        results = new ArrayList<>();
        results = manager.createQuery("Select t "
                + "from TelefonoCliente t").getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public void GuardarCliente(Cliente clien) throws Exception {
        manager.getTransaction().begin();

        manager.persist(clien);
        manager.getTransaction().commit();

    }

    public List<Cliente> getClientes() throws Exception {
        manager.getTransaction().begin();
        List<Cliente> results = null;

        results = new ArrayList<>();
        results = manager.createQuery("Select c "
                + "from Cliente c").getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public List<Cliente> getClientesActivos() throws Exception {
        manager.getTransaction().begin();
        List<Cliente> results = null;

        results = new ArrayList<>();
        results = manager.createQuery("Select c "
                + "from Cliente c "
                + "where borrado_logico = ?1").setParameter(1, false).getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public void guardarViaje(Viaje viaje) throws Exception {
        manager.getTransaction().begin();

        manager.persist(viaje);
        manager.getTransaction().commit();

    }

    public List<Viaje> getViajes() throws Exception {
        manager.getTransaction().begin();
        List<Viaje> results = null;

        results = new ArrayList<>();
        results = manager.createQuery("Select v "
                + "from Viaje v").getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public List<Viaje> getViajesRealizados() throws Exception {
        manager.getTransaction().begin();
        List<Viaje> results = null;

        results = new ArrayList<>();
        results = manager.createQuery("Select v "
                + "from Viaje v "
                + "where borrado_logico = ?1").setParameter(1, false).getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public void guardarVehiculo(Vehiculo vehiculo) throws Exception {
        manager.getTransaction().begin();

        manager.persist(vehiculo);
        manager.getTransaction().commit();

    }

    public List<Vehiculo> getVehiculos() throws Exception {
        manager.getTransaction().begin();
        List<Vehiculo> results = null;

        results = new ArrayList<>();
        results = manager.createQuery("Select ve "
                + "from Vehiculo ve").getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public List<Vehiculo> getVehiculosActivos() throws Exception {
        manager.getTransaction().begin();
        List<Vehiculo> results = null;

        results = new ArrayList<>();
        results = manager.createQuery("Select ve "
                + "from Vehiculo ve "
                + "where borrado_logico = ?1").setParameter(1, false).getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public void guardarChofer(Empleado chof) throws Exception {
        manager.getTransaction().begin();

        manager.persist(chof);
        manager.getTransaction().commit();

    }

    public List<Chofer> getChoferes() throws Exception {
        manager.getTransaction().begin();
        List<Chofer> results = null;

        results = new ArrayList<>();
        results = manager.createQuery("Select e "
                + "from Empleado e "
                + "where tipo_empleado = ?1").setParameter(1, "CH").getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public List<Chofer> getChoferesActivos() throws Exception {

        manager.getTransaction().begin();
        List<Chofer> results = null;

        results = new ArrayList<>();
        Query query = manager.createQuery("Select e "
                + "from Empleado e "
                + "where tipo_empleado = ?1 AND borrado_logico = ?2");
        query.setParameter(1, "CH");
        query.setParameter(2, false);
        results = query.getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public void guardarOperador(Empleado operador) throws Exception {
        manager.getTransaction().begin();

        manager.persist(operador);
        manager.getTransaction().commit();

    }

    public List<Operador> getOperadores() throws Exception {
        manager.getTransaction().begin();
        List<Operador> results = null;

        results = new ArrayList<>();
        results = manager.createQuery("Select e "
                + "from Empleado e "
                + "where tipo_empleado = ?1").setParameter(1, "OP").getResultList();
        manager.getTransaction().commit();
        return results;
    }
// #################  Chicos, a ver qué opinan: éste me parece que no tiene mucho sentido no????

    public List<Operador> getOperadoresActivos() throws Exception {
        manager.getTransaction().begin();
        List<Operador> results = null;

        results = new ArrayList<>();

        Query query = manager.createQuery("Select e "
                + "from Empleado e "
                + "where tipo_empleado = ?1 AND borrado_logico = ?2");
        query.setParameter(1, "OP");
        query.setParameter(2, false);
        results = query.getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public List<Empleado> getEmpleados() throws Exception {
        manager.getTransaction().begin();
        List<Empleado> results = null;

        results = new ArrayList<>();
        results = manager.createQuery("Select e "
                + "from Empleado e").getResultList();
        manager.getTransaction().commit();
        return results;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /* En la ventana para modif op. los agregados con respecto a la de agregar chofer serían: un sector para elegir tipo
    de empleado por si un chofer cambia de rol y pasa a ser operador o viceversa y un sector para el borrado lógico que,
    para mí, allá en la ventana sería mejor ponerle otro nombre en lug de borrado logico.
     */
    public void modificarEmpleado(int nroLegajo, String dni, String nombre, String apellido, String tipoEmpleado, double sueldo, double comision, boolean borradoLogico) throws Exception {
        manager.getTransaction().begin();

        Empleado empl = manager.find(Empleado.class, nroLegajo);
        empl.setDni(dni);
        empl.setNombre(nombre);
        empl.setApellido(apellido);
        empl.setTipoEmpleado(tipoEmpleado);
        empl.setSueldo(sueldo);
        ((Chofer) empl).setComision(comision);
        empl.setBorradoLogico(borradoLogico);
        manager.persist(empl);
        manager.getTransaction().commit();

    }

    //no le vamos a permitir modif. la lista de viajes en esta vista.
    // (los viajes acá solo se verán. Para eliminar o modific. viaje habrá que ir a las correspondientes ventanas)
    public void modificarVehiculo(String patente, String marca, String modelo, int anio, boolean enViaje, boolean borradoLogico) throws Exception {
        manager.getTransaction().begin();

        Vehiculo vehic = manager.find(Vehiculo.class, patente);//patente es pk en la BD. No se permitirá modificar, pero se neces. recibir x parám. p/esta búsqueda
        vehic.setMarca(marca);
        vehic.setModelo(modelo);
        vehic.setAnio(anio);
        vehic.setEnViaje(enViaje);
        vehic.setBorradoLogico(borradoLogico);
        manager.persist(vehic);
        manager.getTransaction().commit();

    }
    //idem que p/caso anterior: se permitirá ver pero no modificar las listas: "telefonos","movSal","viajes"(p/estas mod. ir a las ventanas corresp.)

    //Supongo que permitimos ver acá las listas porque no haremos ventanas específicas para ver datos de cliente, de vehiculo,etc)
    //Si hicieramos esas vent. podriamos sacar las listas de las ventanas como ésta. Pero no creo que hagamos tantas ventanas,no?
    //lo que sí podemos hacer para eliminar las listas de estas ventanas es: titular las ventanas de modificaciones como "ver/modificar Cliente","ver/modificarViaje",etc.,
    //entonces ahí ya quedaría mejor sacar las listas de las ventanas en las que habían quedado sólo para vista.
    public void modificarCliente(int idCliente, String nombre, String apellido, String direccion, boolean borradoLogico, double saldo, double limiteDeCredito) throws Exception {
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

    }

    public void modificarViaje(int idViaje, String origen, String destino, double importe, int formaDePago, boolean borradoLogico, boolean enCurso, Vehiculo movil, Cliente cliente, Chofer chofer) throws Exception {
        manager.getTransaction().begin();

        Viaje vi = manager.find(Viaje.class, idViaje);
        vi.setOrigen(origen);
        vi.setDestino(destino);
        vi.setImporte(importe);
        vi.setFormaDePago(formaDePago);
        vi.setBorradoLogico(borradoLogico);
        vi.setEnCurso(enCurso);
        vi.setMovil(movil);
        vi.setCliente(cliente);
        vi.setChofer(chofer);
        manager.persist(vi);
        manager.getTransaction().commit();

    }

    public double obtenerFacturacionChofer(int nroLegajo, Calendar i, Calendar f) {
        manager.getTransaction().begin();
        double result = 0;

        Query query = manager.createQuery("Select sum(importe) "
                + "from Viaje "
                + "where nro_legajo_chofer= ?1 and fecha between ?2 and ?3 ");
        query.setParameter(1, nroLegajo);
        query.setParameter(2, i);
        query.setParameter(3, f);
        result = (double) query.getSingleResult();
        manager.getTransaction().commit();

        return result;

    }

    //CHICOS: èste es el mètodo que trae el saldo actualizado del cliente para luego aplicar el mètodo
    //que vamos a crear en package servicios para sumarle o descontarle un importe
    //creo que va bien pero revisar
    public double obtenerSaldoCliente(int idCliente) {
        manager.getTransaction().begin();
        Cliente c = null;
        double saldo = 0;

        Query query = manager.createQuery("Select c "
                + "from Clliente c "
                + "where id_cliente = ?1 ");
        query.setParameter(1, idCliente);
        c = (Cliente) query.getSingleResult();
        saldo = c.getSaldo();
        manager.getTransaction().commit();

        return saldo;

    }
}
