
package com.cet001.icaro;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

//@Entity
//@DiscriminatorColumn(name = "OP")
public class Operador extends Empleado implements Serializable{

    private static final long serialVersionUID = -2539942624498235346L;
    private double sueldo;

    public Operador() {
    }

    public Operador(double sueldo) {
        this.sueldo = sueldo;
    }

    public Operador(double sueldo, String dni, String nombre, String apellido, int nroLegajo, String tipoEmpleado) {
        super(dni, nombre, apellido, nroLegajo, tipoEmpleado);
        this.sueldo = sueldo;
    }
    
    
    @Override
    public double calcularSueldo(double importe) {
     return importe;        
    }
    
    @Override
    public String toString(){
       return super.toString()+",sueldo="+this.sueldo;
    }
    //métodos setters & getters
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    
    
}
