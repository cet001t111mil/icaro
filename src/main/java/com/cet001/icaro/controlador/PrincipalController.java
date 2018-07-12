/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cet001.icaro.controlador;

import com.cet001.icaro.dao.DaoImpl;
import java.awt.event.ActionListener;
import com.cet001.icaro.vista.PrincipalView;
import com.cet001.icaro.vista.NuevoChoferView;
import com.cet001.icaro.vista.NuevoClienteView;
import com.cet001.icaro.vista.NuevoOperadorView;
import com.cet001.icaro.vista.NuevoViajeView;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JMenuItem;

/**
 *
 * @author ponsa
 */
public class PrincipalController implements ActionListener {//esta es la clase del objeto que "controlará" al objeto de tipo "Principal"

    private PrincipalView wPrincipal;//esta variable alojará un objeto cuya parte visible para el usuario será la ventana principal del programa.

    public PrincipalController(PrincipalView wPrincipal,DaoImpl dao) {//el constructor recibe por parámetro al objeto mencionado
        
        this.wPrincipal = wPrincipal;//asignación del obj.a la variable declarada inicialmente
        this.wPrincipal.menuAgregarChofer.addActionListener(this);//esto conecta al controlador con el menú del chofer en la opción "nuevo chofer" para detectar el click en dicha opción.
        this.wPrincipal.jMenuItem1.addActionListener(this);//esto conecta al controlador con el menu del viaje en la opción "nuevo viaje" para detectar el click en dicha opción.
        this.wPrincipal.agreCliente.addActionListener(this);//esto conecta al controlador con el menu del cliente en la opción "agregar cliente" para detectar el click en dicha opción.
        this.wPrincipal.menuAgregarOperador.addActionListener(this);
        
    }

    public void iniciar() {
        this.wPrincipal.setTitle("Icaro Gestion Remis");//asignación de título a la variable wPrincipal.
        

    }

    /*Al dar click sobre un botón o sobre una alternativa de un menú de la ventana se creará 1 evento, es
    decir, un objeto de tipo ActionEvent que representa a la acción realizada.
    */
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
                NuevoOperadorController conNOpe = new NuevoOperadorController(nOpe);//se crea 1 obj. controlador que "controlará" a nChof
                break;
            }
            
            case "nChof": {//ver más abajo
                NuevoChoferView nChof = new NuevoChoferView();//se crea 1 obj. de tipo NuevoChofer
                nChof.setTitle("Nuevo Chofer");
                nChof.setVisible(true);//hace visible al usuario el formulario para registrar los datos de 1 nuevo chofer (son los datos que luego se asignarán a nChof)
                NuevoChoferController connchof = new NuevoChoferController(nChof);//se crea 1 obj. controlador que "controlará" a nChof
                break;
            }
            case "nviaje": {
                System.out.println("nuevo viaje");
                NuevoViajeView nVven = new NuevoViajeView();
                nVven.setTitle("Nuevo Viaje");
                nVven.setVisible(true);
                break;
            }
            case "agreCliente": {
                NuevoClienteView nVclien = new NuevoClienteView();
                nVclien.setTitle("Nuevo Cliente");
                nVclien.setVisible(true);
                NuevoClienteController conNclien = new NuevoClienteController(nVclien);

            }
        }

    }

}
/* Los nombres de los "case" se agregan desde "Principal" del paquete "vista". Entrando a design y luego
a properties. Allí buscar actionCommand.
Antes de buscar "properties" hay que seleccionar una opción tal como agregar cliente del menú de la seccion
establecida para los clientes en la ventana principal.
*/