package com.cet001.icaro.servicios;

import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.Cliente;
import com.cet001.icaro.modelo.MovimientoDeSaldo;
import com.cet001.icaro.modelo.TelefonoCliente;
import java.util.Calendar;

public class TestAdministracion {

//Este main es un espacio para probar todo tipo de cosas que necesitemos 
    public static void main(String[] args) throws Exception {
//        String b = "ad";
//        String c = "as";
//        String a = "ad";
//        System.out.println(b.equals(c));
//        System.out.println(b.equals(a));

 // **********  
  
  //desde acá para enviar:
  
//  DaoImpl daoX = new DaoImpl("remiseria?zeroDateTimeBehavior=convertToNullPU");
//        Administracion adminX = new Administracion();
//
//        Calendar i = Calendar.getInstance();
//
//        i.set(Calendar.YEAR, 2018);
//        i.set(Calendar.MONTH, 6);
//        i.set(Calendar.DAY_OF_MONTH, 6);
//        i.set(Calendar.HOUR_OF_DAY, 17);// ojo!!!! usar HOUR_OF_DAY
//        i.set(Calendar.MINUTE, 05);
//        i.set(Calendar.SECOND, 22);
//
//        String anioI = Integer.toString(i.get(Calendar.YEAR));
//        String mesI = Integer.toString(i.get(Calendar.MONTH));
//        String diaI = Integer.toString(i.get(Calendar.DAY_OF_MONTH));
//        String horaI = Integer.toString(i.get(Calendar.HOUR_OF_DAY));
//        String minutosI = Integer.toString(i.get(Calendar.MINUTE));
//        String segundosI = Integer.toString(i.get(Calendar.SECOND));
//
//        Calendar f = Calendar.getInstance();
//
//        f.set(Calendar.YEAR, 2018);
//        f.set(Calendar.MONTH, 7);
//        f.set(Calendar.DAY_OF_MONTH, 7);
//        f.set(Calendar.HOUR_OF_DAY, 22);// ojo!!!! usar HOUR_OF_DAY
//        f.set(Calendar.MINUTE, 33);
//        f.set(Calendar.SECOND, 15);
//
//        String anioF = Integer.toString(i.get(Calendar.YEAR));
//        String mesF = Integer.toString(i.get(Calendar.MONTH));
//        String diaF = Integer.toString(i.get(Calendar.DAY_OF_MONTH));
//        String horaF = Integer.toString(i.get(Calendar.HOUR_OF_DAY));
//        String minutosF = Integer.toString(i.get(Calendar.MINUTE));
//        String segundosF = Integer.toString(i.get(Calendar.SECOND));
//        
//        Calendar g = Calendar.getInstance();
//
//        g.set(Calendar.YEAR, 2018);
//        g.set(Calendar.MONTH, 8);
//        g.set(Calendar.DAY_OF_MONTH, 8);
//        g.set(Calendar.HOUR_OF_DAY, 22);// ojo!!!! usar HOUR_OF_DAY
//        g.set(Calendar.MINUTE, 33);
//        g.set(Calendar.SECOND, 15);
//
//        String anioG = Integer.toString(g.get(Calendar.YEAR));
//        String mesG = Integer.toString(g.get(Calendar.MONTH));
//        String diaG = Integer.toString(g.get(Calendar.DAY_OF_MONTH));
//        String horaG = Integer.toString(g.get(Calendar.HOUR_OF_DAY));
//        String minutosG = Integer.toString(g.get(Calendar.MINUTE));
//        String segundosG = Integer.toString(g.get(Calendar.SECOND));
//        
//        Chofer chof1 = new Chofer(0.5);
//        chof1.setNroLegajo(2320);
//        chof1.setBorradoLogico(false);
// 
//        Vehiculo ve1 = new Vehiculo();
//        Cliente cli1 = new Cliente();
//        Viaje v1 = new Viaje(1, "Alberdi 888", i, ve1, cli1, chof1);
//        v1.setImporte(125);
//        Viaje v2 = new Viaje(2, "Alberdi 888", f, ve1, cli1, chof1);
//        v1.setImporte(20);
//        Viaje v3 = new Viaje(3, "Alberdi 888", g, ve1, cli1, chof1);
//        v1.setImporte(200);
//        
//        double comisionCalculada=adminX.calcularComisionChofer(2320, i, g);
//        System.out.println("Comisión calculada = " + comisionCalculada);
  
  //****** hasta acá es para probar los metodos que llevan fechas en sus parám.
  

//prueba Patri
DaoImpl dao1 = new DaoImpl("remiseria?zeroDateTimeBehavior=convertToNullPU");
Administracion admin1 = new Administracion();

//persistiendo cliente y trayendo saldo
//Cliente c1 = new Cliente("Pat", "Per", 1000,"La paz 2");
//dao1.guardarCliente(c1);
//System.out.println(dao1.getSaldoCliente(1));
//Cliente c3 = new Cliente("Pedro", "Picapiedras", 3000,"Lavalle 2");
//dao1.guardarCliente(c3);
//System.out.println(dao1.getSaldoCliente(51));
//persistiendo MoviientoDeSaldo
//MovimientoDeSaldo mov1 = new MovimientoDeSaldo(1000, 500,"RE", (dao1.manager.find(Cliente.class, 51)));
//dao1.guardarMovimientoDeSaldo(mov1);

//System.out.println(admin1.getSaldoActualizadoCliente(51, 500, dao1.manager.find(MovimientoDeSaldo.class, 1000)));

//MovimientoDeSaldo mov2 = new MovimientoDeSaldo(1001, 800,"FA", (dao1.manager.find(Cliente.class, 51)));
//dao1.guardarMovimientoDeSaldo(mov2);
//MovimientoDeSaldo mov1 = new MovimientoDeSaldo(1000, 500,"RE", (dao1.manager.find(Cliente.class, 51)));
//dao1.guardarMovimientoDeSaldo(mov1);

//System.out.println(admin1.getSaldoActualizadoCliente(51, 500, dao1.manager.find(MovimientoDeSaldo.class, 1000)));

//MovimientoDeSaldo mov3 = new MovimientoDeSaldo(1002, 500,"FA", (dao1.manager.find(Cliente.class, 51)));
//dao1.guardarMovimientoDeSaldo(mov3);
//admin1.calcularNuevoSaldoCliente(51, dao1.manager.find(MovimientoDeSaldo.class, 1002));

//System.out.println(dao1.manager.find(Cliente.class,51).toString());



    }

}
/*Esto lo guardo acá por las dudas p/recordar cosas por si no anda como lo puse en el Dao:
    public void modificarTelefonoCliente(TelefonoCliente telActual, TelefonoCliente telNuevo) {
        manager.getTransaction();
//       telActual.crearObjetoNumero(); //Borrar esto luego !!!!!!

        //Se obtiene 1 obj tipo Numero a partir del obj. TelefonoCliente actual y se aloja en var. tipo Numero
        TelefonoCliente.Numero numeroActual = telActual.getNumero();
        //Se obtiene el codigo de area y el nro del obj. Numero actual y se aloja c/u en 1 var. de tipo String
//        String codArAct =numeroActual.getCodArea(); 
//        String telAct =numeroActual.getNroTel();
        TelefonoCliente.Numero numeroNuevo = telNuevo.getNumero();

        TelefonoCliente t = manager.find(TelefonoCliente.class, numeroActual);
        t.setNumero(numeroNuevo);
        manager.persist(t);
        manager.getTransaction().begin();;

    }

Este mét iría en TelefonoCliente, si fuera necesario:
    //Borrar este método si me sale lo de modificarTelefonoCliente sin tener que usarlo
//    public static Numero crearObjetoNumero(){
//        TelefonoCliente.Numero numero =new TelefonoCliente.Numero();
//        return numero;
//    } 

//////////Dejo esto acá hasta que funcione la versión que dejé en el Dao
//    public void modificarTelefonoCliente(Cliente c, TelefonoCliente telActual, TelefonoCliente telNuevo) throws Exception {
//        manager.getTransaction();
//        TelefonoCliente.Numero numeroActual = telActual.getNumero();
//        TelefonoCliente.Numero numeroNuevo = telNuevo.getNumero();
//        TelefonoCliente t = manager.find(TelefonoCliente.class, numeroActual);
//        t.setNumero(numeroNuevo);
//        t.setCliente(c);
//        manager.persist(t);
//        manager.getTransaction().begin();
//    }

*/