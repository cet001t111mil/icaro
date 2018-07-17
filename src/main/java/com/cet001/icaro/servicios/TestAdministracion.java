package com.cet001.icaro.servicios;

import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.Cliente;
import com.cet001.icaro.modelo.MovimientoDeSaldo;
import java.util.Calendar;

public class TestAdministracion {

//Este main es un espacio para probar todo tipo de cosas que necesitemos 
    public static void main(String[] args) throws Exception {
//        String b = "ad";
//        String c = "as";
//        String a = "ad";
//        System.out.println(b.equals(c));
//        System.out.println(b.equals(a));

//       //dde  acá
//        Chofer ch1 = new Chofer();
//        ch1.setComision(0.5);
//        Calendar c = Calendar.getInstance();
//
//        c.set(Calendar.YEAR, 2018);
//        c.set(Calendar.MONTH, 07);
//        c.set(Calendar.DAY_OF_MONTH, 07);
//        c.set(Calendar.HOUR_OF_DAY,22);// ojo!!!! usar HOUR_OF_DAY
//        c.set(Calendar.MINUTE, 33);
//        c.set(Calendar.SECOND, 15);
//        System.out.println(c);
//
////        System.out.println(c.toString());
////
//        Administracion a = new Administracion();
//        a.setComisionCalculadaFinal(ch1, '2018/08/02 10:10:10', `2018/08/12 10:10:10`);
////        double sueldoCh1 = a.calcularSueldo(ch1);
////        System.out.println(sueldoCh1);


////hasta acá es todo para borrar más adelante
////

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