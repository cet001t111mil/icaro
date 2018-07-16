package com.cet001.icaro.modelo;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

/*YA PROBADO !!! FUNCIONA OK
 Columna tipo_empleado (columna discriminatoria, persiste en forma automàtica
 x eso comento el mètodo setTipoEmpleado en Clase Empleado porque no es necesario y ademàs evitamos asì tener 
que validar la entrada de usuario que no sea "CH" de Chofer u "OP" de Empleado*/

@DiscriminatorValue(value = "OP")
public class Operador extends Empleado implements Serializable {

    private static final long serialVersionUID = -2539942624498235346L;

    public Operador() {
    }

    public Operador(double sueldo, String dni, String nombre, String apellido, int nroLegajo, String tipoEmpleado) {
        super(dni, nombre, apellido, nroLegajo, tipoEmpleado, sueldo);

    }


    @Override
    public String toString() {
        return super.toString() + ",sueldo=" + this.getSueldo();
    }

}
