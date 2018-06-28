package com.cet001.icaro.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
@Embeddable
class TelefonoCliente implements Serializable {
//@Id
private int id_cliente;

    private static final long serialVersionUID = 6217477364203581943L;

@Entity
    static class Numero implements Serializable {
        private static final long serialVersionUID = -5309486314614506660L;
        @Id
        @Column(name="CODAREA")
        private String codArea ;
        @Id
        @Column(name="NROTEL")
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
    private Numero numero;
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
