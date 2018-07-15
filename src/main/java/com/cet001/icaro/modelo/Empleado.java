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
    protected double sueldo;
    @Column(name = "borrado_logico")
    protected boolean borradoLogico;

    public Empleado() {
    }

    public Empleado(String dni, String nombre, String apellido, int nroLegajo,String tipoEmpleado,double sueldo) {
        
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroLegajo = nroLegajo;
        this.tipoEmpleado = tipoEmpleado;
        this.sueldo = sueldo;
        this.borradoLogico = false;
        System.out.println(this.tipoEmpleado+"desde el super");
    }

    public abstract double calcularSueldo(double importe);

    @Override
    public String toString() {
        return "Empleado{" + "nroLegajo=" + nroLegajo + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoEmpleado=" + tipoEmpleado + ", sueldo=" + sueldo + ", borrado lógico=" + borradoLogico + '}';
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

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isBorradoLogico() {
        return borradoLogico;
    }

    public void setBorradoLogico(boolean borraloLogico) {
        this.borradoLogico = borraloLogico;
    }

    

   


 
}
