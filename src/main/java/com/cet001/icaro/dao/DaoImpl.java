package com.cet001.icaro.dao;

import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.*;
import com.cet001.icaro.modelo.TelefonoCliente.Numero;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
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

    private EntityManagerFactory emf;
    private EntityManager manager;

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

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
    
    

//mètodos para Clase MovimientoDeSaldo
    /*dentro de este método se valida tipoComprobante ya que este atributo define en método calcularNuevoSaldo en Clase servicios.Administracion
    si se suma o se resta el importe pasado por parámetro. Ej: RE (recibo) acredita en cta cte del Cliente y FA(factura)debita en cta cte*/
    public void guardarMovimientoDeSaldo(MovimientoDeSaldo mov) throws Exception {
        manager.getTransaction().begin();
        if (mov.getTipoComprobante().equals("RE") || mov.getTipoComprobante().equals("FA") || mov.getTipoComprobante().equals("NC") || mov.getTipoComprobante().equals("ND")) {
            manager.persist(mov);
            manager.getTransaction().commit();
        } else {
            throw new Exception("Comprobante no existente");
        }
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

//mètodos para Clase TelefonoCliente    
    public void guardarTelfonoCliente(TelefonoCliente tel) throws Exception {
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

//mètodos para Clase Cliente    
    public void guardarCliente(Cliente clien) throws Exception {
        manager.getTransaction().begin();
        manager.persist(clien);
        manager.getTransaction().commit();
    }

    public Cliente getCliente(int id) throws Exception {
        manager.getTransaction().begin();
        Cliente result = null;
        Query query = manager.createQuery("Select c "
                + "from Cliente c "
                + "where c.idCliente = ?1");
        query.setParameter(1, id);
        result = (Cliente) query.getSingleResult();
        return result;
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
                + "where c.borradoLogico = ?1").setParameter(1, false).getResultList();
        manager.getTransaction().commit();
        return results;
    }

//mètodos para Clase Viaje    
    public void guardarViaje(Viaje viaje) throws Exception {
        manager.getTransaction().begin();
        manager.persist(viaje);
        manager.getTransaction().commit();
    }

    public Viaje getViaje(int idViaje) throws Exception {
        manager.getTransaction().begin();
        Viaje result = null;
        Query query = manager.createQuery("Select v "
                + "from Viaje v "
                + "where v.idViaje = ?1");
        query.setParameter(1, idViaje);
        result = (Viaje) query.getSingleResult();
        return result;
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
                + "where v.borradoLogico = ?1").setParameter(1, false).getResultList();
        manager.getTransaction().commit();
        return results;
    }

//mètodos para Clase Vehiculo    
    public void guardarVehiculo(Vehiculo vehiculo) throws Exception {
        manager.getTransaction().begin();
        manager.persist(vehiculo);
        manager.getTransaction().commit();
    }

    public Vehiculo getVehiculo(String patente) throws Exception {
        manager.getTransaction().begin();
        Vehiculo result = null;
        Query query = manager.createQuery("Select ve "
                + "from Vehiculo ve "
                + "where ve.patente = ?1");
        query.setParameter(1, patente);
        result = (Vehiculo) query.getSingleResult();
        return result;
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
                + "where ve.borradoLogico = ?1").setParameter(1, false).getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public List<Vehiculo> getVehiculosDisponiblesParaViaje() throws Exception {
        manager.getTransaction().begin();
        List<Vehiculo> results = null;

        results = new ArrayList<>();
        Query query = manager.createQuery("Select ve "
                + "from Vehiculo ve "
                + "where ve.enViaje = ?1 AND ve.borradoLogico = ?2");
        query.setParameter(1, false);
        query.setParameter(2, false);
        results = query.getResultList();

        manager.getTransaction().commit();
        return results;
    }

    //mètodos para Clase Empleado
    public Empleado getEmpleado(int nroLegajo) throws Exception {
        manager.getTransaction().begin();
        Empleado result = null;
        Query query = manager.createQuery("Select e "
                + "from Empleado e "
                + "where e.nroLegajo = ?1");
        query.setParameter(1, nroLegajo);
        result = (Empleado) query.getSingleResult();
        return result;
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

//mètodos para Clase Chofer    
    public void guardarChofer(Empleado chof) throws Exception {
        manager.getTransaction().begin();
        //System.out.println(chof.getTipoEmpleado() + "antes de persist");
        manager.persist(chof);
        manager.getTransaction().commit();
    }

    public Chofer getChofer(int nroLegajo) throws Exception {
        manager.getTransaction().begin();
        Chofer result = null;
        Query query = manager.createQuery("Select e "
                + "from Empleado e "
                + "where e.nroLegajo = ?1 AND e.tipoEmpleado = ?2");
        query.setParameter(1, nroLegajo);
        query.setParameter(2, "CH");
        result = (Chofer) query.getSingleResult();
        return result;
    }

    public List<Chofer> getChoferes() throws Exception {
        manager.getTransaction().begin();
        List<Chofer> results = null;
        results = new ArrayList<>();
        results = manager.createQuery("Select e "
                + "from Empleado e "
                + "where e.tipoEmpleado = ?1").setParameter(1, "CH").getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public List<Chofer> getChoferesActivos() throws Exception {

        manager.getTransaction().begin();
        List<Chofer> results = null;
        results = new ArrayList<>();
        Query query = manager.createQuery("Select e "
                + "from Empleado e "
                + "where e.tipoEmpleado = ?1 AND e.borradoLogico = ?2");
        query.setParameter(1, "CH");
        query.setParameter(2, false);
        results = query.getResultList();
        manager.getTransaction().commit();
        return results;
    }

//mètodos para Clase Operador
    public void guardarOperador(Empleado operador) throws Exception {
        manager.getTransaction().begin();
        manager.persist(operador);
        manager.getTransaction().commit();
    }

    public Operador getOperador(int nroLegajo) throws Exception {
        manager.getTransaction().begin();
        Operador result = null;
        Query query = manager.createQuery("Select e "
                + "from Empleado e "
                + "where e.nroLegajo = ?1 AND e.tipoEmpleado = ?2");
        query.setParameter(1, nroLegajo);
        query.setParameter(2, "OP");
        result = (Operador) query.getSingleResult();
        return result;
    }

    public List<Operador> getOperadores() throws Exception {
        manager.getTransaction().begin();
        List<Operador> results = null;
        results = new ArrayList<>();
        results = manager.createQuery("Select e "
                + "from Empleado e "
                + "where e.tipoEmpleado = ?1").setParameter(1, "OP").getResultList();
        manager.getTransaction().commit();
        return results;
    }

    public List<Operador> getOperadoresActivos() throws Exception {
        manager.getTransaction().begin();
        List<Operador> results = null;
        results = new ArrayList<>();
        Query query = manager.createQuery("Select e "
                + "from Empleado e "
                + "where e.tipoEmpleado = ?1 AND e.borradoLogico = ?2");
        query.setParameter(1, "OP");
        query.setParameter(2, false);
        results = query.getResultList();
        manager.getTransaction().commit();
        return results;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//updates    
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

    public void modificarTelefonoCliente(Numero numActual, String codAreaNuevo, String nroTelNuevo) throws Exception {
        manager.getTransaction();

        TelefonoCliente t = manager.find(TelefonoCliente.class, numActual);//obtenemos el obj.TelefonoCliente actual de la BD
        Numero numeroActual = t.getNumero();
        numeroActual.setCodArea(codAreaNuevo);
        numeroActual.setNroTel(nroTelNuevo);
        t.setNumero(numeroActual);

//        Numero n = numActual;
//        n.setCodArea(codAreaNuevo);//seteamos al obj. tipo Numero actual los atrib. nuevos.
//        n.setNroTel(nroTelNuevo);
//
//        t.setNumero(n); //al obj. tipo TelefonoCliente actual que obtuvimos de la BD le seteamos n que es el obj. tipo Numero ya modificado.
        manager.persist(t);
        manager.getTransaction().begin();
    }

//mètodos para funcionalidad de Clase Administracion
    public double obtenerFacturacionChofer(int nroLegajo, Calendar i, Calendar f) throws Exception {
        manager.getTransaction().begin();
        double result = 0;
        Query query = manager.createQuery("Select sum(importe) "
                + "from Viaje v "
                + "where v.nroLegajo = ?1 and v.fecha between ?2 and ?3 ");
        query.setParameter(1, nroLegajo);
        query.setParameter(2, i);
        query.setParameter(3, f);
        result = (double) query.getSingleResult();
        manager.getTransaction().commit();
        return result;
    }

    //èste es el mètodo que trae el saldo actualizado del cliente para luego aplicar el mètodo
    //que vamos a crear en package servicios para sumarle o descontarle un importe
    public double getSaldoCliente(int idCliente) throws Exception {
        manager.getTransaction().begin();
        double saldo = 0;
        Cliente c = null;
        Query query = manager.createQuery("Select c "
                + "from Cliente c "
                + "where c.idCliente = ?1 ");
        query.setParameter(1, idCliente);
        c = (Cliente) query.getSingleResult();
        saldo = c.getSaldo();
        manager.getTransaction().commit();
        return saldo;
    }

    public void guardarNuevoSaldoCliente(double nuevoSaldo, int idCliente) throws Exception {
        manager.getTransaction().begin();
        Cliente cli = manager.find(Cliente.class, idCliente);
        cli.setSaldo(nuevoSaldo);
        manager.persist(cli);
        manager.getTransaction().commit();
    }

}
