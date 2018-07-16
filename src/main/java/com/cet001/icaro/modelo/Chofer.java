package com.cet001.icaro.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity

/*YA PROBADO !!! FUNCIONA OK
 Columna tipo_empleado (columna discriminatoria, persiste en forma automàtica
 x eso comento el mètodo setTipoEmpleado en Clase Empleado porque no es necesario y ademàs evitamos asì tener 
que validar la entrada del usuario que no sea "CH" de Chofer u "OP" de Empleado*/


@DiscriminatorValue(value = "CH")
public class Chofer extends Empleado implements Serializable{

    private static final long serialVersionUID = -6744894858606796067L;
    private double comision;
    @OneToMany (mappedBy = "chofer")
    private List<Viaje> viajes = new ArrayList<>();

    public Chofer() {
    }

    public Chofer(double comision) {
        this.comision = comision;
    }

    public Chofer(double sueldo, double comision, String dni, String nombre, String apellido, int nroLegajo, String tipoEmpleado) {
        
        super(dni, nombre, apellido, nroLegajo, tipoEmpleado,sueldo);
     System.out.println(tipoEmpleado);
        this.comision = comision;
    }
    
 
    @Override
    public String toString(){
     return super.toString()+", comision="+this.comision;
    }
    //métodos setters & getters
    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }
    
    
}
