package com.cet001.icaro.modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1044152195801582698L;
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue
    private int idCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    @Column(name = "borrado_logico")
    private boolean borradoLogico;
    private double saldo;
    @Column(name = "limite_de_credito")
    private double limiteDeCredito;

    @OneToMany(mappedBy = "cliente")
    private List<TelefonoCliente> telefonos = new ArrayList<>();
    @OneToMany(mappedBy = "cliente")
    private List<MovimientoDeSaldo> movSal = new ArrayList<>();
    @OneToMany(mappedBy = "cliente")
    private List<Viaje> viajes = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, double saldo, String direccion) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
        this.direccion = direccion;
        this.borradoLogico = false;
        this.limiteDeCredito = 0;
        
        
    }
//hacerlo en BD si conviente
    public void sumSaldo(double importe) {
        saldo = this.saldo + importe;
    }

    public void subtractSaldo(double importe) {
        saldo = this.saldo - importe;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", borrado lógico=" + borradoLogico + ", saldo=" + saldo + ", limiteDeCredito=" + limiteDeCredito + ", telefonos=" + telefonos + '}';
    }

    

    //métodos setters & getters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isBorradoLogico() {
        return borradoLogico;
    }

    public void setBorradoLogico(boolean borradoLogico) {
        this.borradoLogico = borradoLogico;
    }


    

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    public List<TelefonoCliente> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TelefonoCliente> telefonos) {
        this.telefonos = telefonos;
    }

    public List<MovimientoDeSaldo> getMovSal() {
        return movSal;
    }

    public void setMovSal(List<MovimientoDeSaldo> movSal) {
        this.movSal = movSal;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

}
