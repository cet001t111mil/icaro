package com.cet001.icaro.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TelefonoCliente implements Serializable {

    private static final long serialVersionUID = 6217477364203581943L;

    
    @Embeddable
    public static class Numero implements Serializable {

        private static final long serialVersionUID = -5309486314614506660L;
        @Column(name = "cod_area")
        private String codArea;
        @Column(name = "nro_telefono")
        private String nroTel;

        public Numero() {
        }

        public Numero(String codArea, String nroTel) {
            this.codArea = codArea;
            this.nroTel = nroTel;
        }

        @Override
        public String toString() {
            return "Numero{" + "codArea=" + codArea + ", nroTel=" + nroTel + '}';
        }

        public String getCodArea() {
            return codArea;
        }

        public void setCodArea(String codArea) {
            this.codArea = codArea;
        }

        public String getNroTel() {
            return nroTel;
        }

        public void setNroTel(String nroTel) {
            this.nroTel = nroTel;
        }

    }
    @EmbeddedId
    private Numero numero;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public TelefonoCliente() {
    }

    public TelefonoCliente(Numero numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "TelefonoCliente{" + "numero=" + numero + ", cliente=" + cliente + '}';
    }

    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
