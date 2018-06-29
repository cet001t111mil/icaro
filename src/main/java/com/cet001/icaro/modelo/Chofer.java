package com.cet001.icaro.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorColumn(name = "CH") 
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
        this.comision = comision;
    }
    
    public double obtenerFacturacionTotal (List<Viaje> viajes, Calendar i,Calendar f){
//////        sum
//////        recorrer lista 
//////                si esta etre las fechas entra
//////                        sum importe+importe
//////        
        return 33;
    }
    
    @Override
    public double calcularSueldo(double totalDeViajes)  { //viene como parametro el resultado de obtener facturaciontotal
       
        return totalDeViajes * comision;
    }

##############///////TERMINAR
    @Override
    public double getSueldo(){
    return super.getSueldo()+this.calcularSueldo(sueldo)
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
