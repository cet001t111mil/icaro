package com.cet001.icaro.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;


@Entity
@Inheritance
@DiscriminatorColumn(name = "tipo_empleado")

public abstract class Empleado implements Serializable {

    private static final long serialVersionUID = -933026923467806480L;
    @Id
    @Column(name = "nro_legajo")
    protected int nroLegajo;
    protected String dni;
    protected String nombre;
    protected String apellido;
    @Column(name = "tipo_empleado")
    protected String tipoEmpleado;

    public Empleado() {
    }

    public Empleado(String dni, String nombre, String apellido, int nroLegajo,String tipoEmpleado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroLegajo = nroLegajo;
        this.tipoEmpleado = tipoEmpleado;
    }

    public abstract double calcularSueldo(double importe);

    @Override
    public String toString() {
        return "Empleado{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", nroLegajo=" + nroLegajo + ", tipoEmpleado=" + tipoEmpleado + '}';
    }

    //métodos setters & getters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(int nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

   


 
}
