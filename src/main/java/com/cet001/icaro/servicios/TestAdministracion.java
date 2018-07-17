package com.cet001.icaro.servicios;

import com.cet001.icaro.modelo.Chofer;
import java.util.Calendar;

public class TestAdministracion {

//Este main es un espacio para probar todo tipo de cosas que necesitemos 
    public static void main(String[] args) {
        String b = "ad";
        String c = "as";
        String a = "ad";
        System.out.println(b.equals(c));
        System.out.println(b.equals(a));

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