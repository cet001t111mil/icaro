
package com.cet001.icaro;

import java.io.Serializable;


public class MovimientoDeSaldo implements Serializable{

    private static final long serialVersionUID = 4592438298290387661L;
    private int id ;
    private double importe;
    private String tipoComprobante;
    private Cliente cliente;

    public MovimientoDeSaldo() {
    }

    public MovimientoDeSaldo(int id, double importe, String tipoComprobante, Cliente cliente) {
        this.id = id;
        this.importe = importe;
        this.tipoComprobante = tipoComprobante;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "MovimientoDeSaldo{" + "id=" + id + ", importe=" + importe + ", tipoComprobante=" + tipoComprobante + ", cliente=" + cliente + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    

    
}
