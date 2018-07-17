package com.cet001.icaro.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 4172404774480436129L;
    @Id
    private String patente;
    private String marca;
    private String modelo;
    private int anio;
    @Column(name="en_viaje")
    private boolean enViaje;
    @Column(name = "borrado_logico")
    private boolean borradoLogico;
    @OneToMany(mappedBy="movil")
    private List<Viaje> viajes = new ArrayList<>();

    public Vehiculo() {
    }

    /*No incluímos en el constructor atributo "enViaje" xq no en todos los casos se tiene o necesita esa información al
    instanciar un objeto de la Clase Vehiculo*/
    public Vehiculo(String patente, String marca, String modelo, int anio) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.borradoLogico = false;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "patente=" + patente + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", enViaje=" + enViaje + ", borrado lógico=" + borradoLogico + '}';
    }

    
    //setters & getters
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isEnViaje() {
        return enViaje;
    }

    public void setEnViaje(boolean enViaje) {
        this.enViaje = enViaje;
    }

    public boolean isBorradoLogico() {
        return borradoLogico;
    }

    public void setBorradoLogico(boolean borradoLogico) {
        this.borradoLogico = borradoLogico;
    }

   
    public List<Viaje> getViajes() {
        return viajes;
    }
    

}
