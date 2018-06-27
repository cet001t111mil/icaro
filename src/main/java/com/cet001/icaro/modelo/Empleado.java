package com.cet001.icaro.modelo;

import java.io.Serializable;
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
    protected int nro_legajo;
    protected String dni;
    protected String nombre;
    protected String apellido;
    protected String tipo_empleado;

    public Empleado() {
    }

    public Empleado(String dni, String nombre, String apellido, int nro_legajo,String tipo_empleado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nro_legajo = nro_legajo;
        this.tipo_empleado = tipo_empleado;
    }

    public abstract double calcularSueldo(double importe);

    @Override
    public String toString() {
        return "Empleado{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", nroLegajo=" + nro_legajo + ", tipoEmpleado=" + tipo_empleado + '}';
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

    public int getNro_legajo() {
        return nro_legajo;
    }

    public void setNro_legajo(int nro_legajo) {
        this.nro_legajo = nro_legajo;
    }

    public String getTipo_empleado() {
        return tipo_empleado;
    }

    public void setTipo_empleado(String tipo_empleado) {
        this.tipo_empleado = tipo_empleado;
    }


 
}
