package com.cet001.icaro.modelo;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "OP")
public class Operador extends Empleado implements Serializable {

    private static final long serialVersionUID = -2539942624498235346L;

    public Operador() {
    }

    public Operador(double sueldo, String dni, String nombre, String apellido, int nroLegajo, String tipoEmpleado) {
        super(dni, nombre, apellido, nroLegajo, tipoEmpleado, sueldo);

    }

    //queda abierto para desarrollar el método que calcula realmente sueldo  
    @Override
    public double calcularSueldo(double importe) {
        return importe;
    }

    @Override
    public double getSueldo() {
        return super.getSueldo();

    }

    @Override
    public String toString() {
        return super.toString() + ",sueldo=" + this.getSueldo();
    }

}
