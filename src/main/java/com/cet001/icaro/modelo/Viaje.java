
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
    private int idViaje;
    private String origen;
    private String destino;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fecha;
    private double importe;
    @Column(name = "forma_de_pago")
    private int formaDePago;
    @Column(name = "borrado_logico")
    private boolean borradoLogico;
    @Column (name = "en_curso")
    private boolean enCurso ; 
    
    

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
        this.borradoLogico = false;
        this.enCurso = true;
    }

    @Override
    public String toString() {
        return "Viaje{" + "idViaje=" + idViaje + ", origen=" + origen + ", destino=" + destino + ", fecha=" + fecha + ", importe=" + importe + ", formaDePago=" + formaDePago + ", borradoLogico=" + borradoLogico + ", enCurso=" + enCurso + ", movil=" + movil + ", cliente=" + cliente + ", chofer=" + chofer + '}';
    }



    
    //Métodos settters & getters:

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
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

    public boolean isBorradoLogico() {
        return borradoLogico;
    }

    public void setBorradoLogico(boolean borradoLogico) {
        this.borradoLogico = borradoLogico;
    }

    
    public boolean isEnCurso() {
        return enCurso;
    }

    public void setEnCurso(boolean enCurso) {
        this.enCurso = enCurso;
    }

    

}
