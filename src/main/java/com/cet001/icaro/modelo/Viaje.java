
package com.cet001.icaro.modelo;

import java.io.Serializable;
import java.util.Calendar;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Viaje implements Serializable {

    private static final long serialVersionUID = -5103238759854604732L;
    @Id
    @Column(name = "id_viaje")
    private int idViaje; // Falta ponerlo en el DC) - Sil
    private String origen;
    private String destino;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fecha;
    private double importe;
    @Column(name = "forma_de_pago")
    private int formaDePago;
    
    @ManyToOne
    @JoinColumn(name="nro_legajo_operador")
    private Operador operador; 

    @ManyToOne
    @JoinColumn(name = "patente")
    private Vehiculo movil;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="nro_legajo_chofer")
    private Chofer chofer;

    public Viaje() {
    }
/* Constructor con todos los atributos menos: destino,importe,forma de pago, ya que podrían no estar 
   disponibles al instanciar un objeto Viaje
*/
    public Viaje(int id, String origen, Calendar fecha, Vehiculo movil, Cliente cliente, Chofer chofer) {
        this.idViaje = id;
        this.origen = origen;
        this.fecha = fecha;
        this.movil = movil;
        this.cliente = cliente;
        this.chofer = chofer;
    }

    @Override
    public String toString() {
        return "Viaje{" + "origen=" + origen + ", destino=" + destino + ", fecha=" + fecha + ", movil=" + movil + ", importe=" + importe + ", cliente=" + cliente + ", chofer=" + chofer + ", id=" + idViaje + '}';
    }
    //Métodos settters & getters:

    public int getId() {
        return idViaje;
    }

    public void setId(int id) {
        this.idViaje = id;
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
