package com.cet001.icaro.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovimientoDeSaldo implements Serializable {

    private static final long serialVersionUID = 4592438298290387661L;
    @Id
    @Column(name = "id_movimiento")
    private int idMovimiento;
    private double importe;
    @Column(name = "tipo_comprobante")
    private String tipoComprobante;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public MovimientoDeSaldo() {
    }

    public MovimientoDeSaldo(int id_movimiento, double importe, String tipoComprobante, Cliente cliente) {
        this.idMovimiento = id_movimiento;
        this.importe = importe;
        this.tipoComprobante = tipoComprobante;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "MovimientoDeSaldo{" + "id=" + idMovimiento + ", importe=" + importe + ", tipoComprobante=" + tipoComprobante + ", cliente=" + cliente + '}';
    }

    public int getId() {
        return idMovimiento;
    }

    public void setId(int id_movimiento) {
        this.idMovimiento = id_movimiento;
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
