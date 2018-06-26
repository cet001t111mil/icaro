
package com.cet001.icaro.modelo;

import java.io.Serializable;
import java.util.Calendar;


public class Viaje implements Serializable{

    private static final long serialVersionUID = -5103238759854604732L;
    private int id;
    private String origen;
    private String destino;
    private Calendar fecha;
    private double importe;
    private int formaDePago;
    private Vehiculo movil;
    private Cliente cliente;
    private Chofer chofer;

    public Viaje() {
    }
// Constructor con todos los atributos menos: destino,importe,forma de pago, ya que podrían no estar disponibles al instanciar un objeto Viaje
    public Viaje(int id, String origen, Calendar fecha, Vehiculo movil, Cliente cliente, Chofer chofer) {
        this.id = id;
        this.origen = origen;
        this.fecha = fecha;
        this.movil = movil;
        this.cliente = cliente;
        this.chofer = chofer;
    }
    
   
    @Override
    public String toString() {
        return "Viaje{" + "origen=" + origen + ", destino=" + destino + ", fecha=" + fecha + ", movil=" + movil + ", importe=" + importe + ", cliente=" + cliente + ", chofer=" + chofer + ", id=" + id + '}';
    }
    //métodos settters & getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(int formaDePago) {
        this.formaDePago = formaDePago;
    }

    public Vehiculo getMovil() {
        return movil;
    }

    public void setMovil(Vehiculo movil) {
        this.movil = movil;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }
    
}
