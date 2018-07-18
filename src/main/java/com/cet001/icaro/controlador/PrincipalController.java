/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import static com.cet001.icaro.Test.perUnit;
import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Cliente;
import com.cet001.icaro.modelo.Empleado;
import com.cet001.icaro.modelo.Vehiculo;
import com.cet001.icaro.modelo.Viaje;
import com.cet001.icaro.vista.ConsultarChoferesView;
import java.awt.event.ActionListener;
import com.cet001.icaro.vista.PrincipalView;
import com.cet001.icaro.vista.ClienteView;
import com.cet001.icaro.vista.NuevoOperadorView;
import com.cet001.icaro.vista.NuevoViajeView;
import com.cet001.icaro.vista.VehiculosView;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;

/**
 *
 * @author ponsa
 */
public class PrincipalController implements ActionListener {//esta es la clase del objeto que "controlará" al objeto de tipo "Principal"

    DaoImpl dao;
    private PrincipalView wPrincipal;

    public PrincipalController(PrincipalView wPrincipal, DaoImpl dao) {
        this.dao = dao;
        this.wPrincipal = wPrincipal;

    }

    public void iniciar() {
        this.wPrincipal.setTitle("Icaro Gestion Remis");
        
        this.wPrincipal.jMenuItem1.addActionListener(this);
        this.wPrincipal.agreCliente.addActionListener(this);
        this.wPrincipal.menuAgregarOperador.addActionListener(this);
        this.wPrincipal.menuV.addActionListener(this);
        this.wPrincipal.consultarChoferes.addActionListener(this);
        llenarListaViajesCurso();
        llenarListaVehiculos();
        System.out.println("no llena vehiculos");
    }

    public void llenarListaVehiculos() {

        DefaultListModel Dlm = new DefaultListModel();

        try {
            List<Vehiculo> vehiculos = dao.getVehiculosDisponiblesParaViaje();

            for (Vehiculo v : vehiculos) {
                Dlm.addElement("Patente: " + v.getPatente() + " - " + v.getMarca() + " " + v.getModelo());
            }
            wPrincipal.jList1.setModel(Dlm);

        } catch (SQLException ex) {
            wPrincipal.pNotificaciones.setText(ex.toString());
        } catch (Exception ex) {
            wPrincipal.pNotificaciones.setText(ex.toString());
        }
    }

    public void llenarListaViajesCurso() {

        DefaultListModel Dlm = new DefaultListModel();
        try {
            String listaVia = "";
            List<Viaje> viajes = dao.getViajes();

            for (Viaje vI : viajes) {
                Dlm.addElement("Origen: " + vI.getOrigen() + " - Destino " + vI.getDestino());

            }
            wPrincipal.jList2.setModel(Dlm);

        } catch (SQLException ex) {
            wPrincipal.pNotificaciones.setText(ex.toString());
        } catch (Exception ex) {
            wPrincipal.pNotificaciones.setText(ex.toString());
        }
    }

//        public void llenarListaClientes() {
//        String listaVia = "";
//        List<Cliente> viajes = dao.getClientes();
//        for (Cliente vI : viajes) {
//            listaVia = listaVia + vI.getNombre()+"\n ";
//        }
//        wPrincipal.viajesEnCursoPanel.setText(listaVia);//         
//    }
    @Override
    public void actionPerformed(ActionEvent e) {//se recibe por parám. un evento
/*
el obj. recibido invoca al método gAC que devuelve el comando asociado a la acción que provocó la creación
de este objeto "e". El resultado es asignado a la variable "opción" de tipo String.
         */
        String opcion = e.getActionCommand();

        switch (opcion) {//en función del comando devuelto por el método gAC, se entrará en 1 de las sig. alternativas
            case "nOpe": {//ver más abajo
                NuevoOperadorView nOpe = new NuevoOperadorView();//se crea 1 obj. de tipo NuevoChofer
                nOpe.setTitle("Nuevo Operador");
                nOpe.setVisible(true);//hace visible al usuario el formulario para registrar los datos de 1 nuevo chofer (son los datos que luego se asignarán a nChof)
                OperadorController conNOpe = new OperadorController(nOpe);//se crea 1 obj. controlador que "controlará" a nChof
                break;
            }

            case "admChoferes": {//ver más abajo
                ConsultarChoferesView cChof = new ConsultarChoferesView();
                cChof.setTitle("Administracion Choferes");
                cChof.setVisible(true);//hace visible al usuario el formulario para registrar los datos de 1 nuevo chofer (son los datos que luego se asignarán a nChof)
                ChoferController connchof = new ChoferController(cChof, this.dao);//se crea 1 obj. controlador que "controlará" a nChof
                break;
            }
            case "nviaje": {
                System.out.println("nuevo viaje");
                NuevoViajeView nVven = new NuevoViajeView();
                nVven.setTitle("Nuevo Viaje");
                nVven.setVisible(true);
                ViajeController vCon = new ViajeController(nVven,dao);
                        
                break;
            }
            case "agreCliente": {
                ClienteView nVclien = new ClienteView();
                nVclien.setTitle("Nuevo Cliente");
                nVclien.setVisible(true);
                ClienteController conNclien = new ClienteController(nVclien, dao);
                break;
            }
            case "conChof": {
                ConsultarChoferesView conChofV = new ConsultarChoferesView();
                conChofV.setTitle("Consultar Choferes");
                conChofV.setVisible(true);
                ChoferController modChof = new ChoferController(conChofV,dao);
                break;
            }
                case "menuVeh": {
                VehiculosView vehiView = new VehiculosView();
                vehiView.setTitle("Vehiculos");
                vehiView.setVisible(true);
                VehiculosController vehiCon = new VehiculosController(vehiView, this.dao);
                break;
            }

        }

    }

}
