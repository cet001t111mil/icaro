package com.cet001.icaro.servicios;

import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.Cliente;
import com.cet001.icaro.modelo.Empleado;
import com.cet001.icaro.modelo.MovimientoDeSaldo;
import com.cet001.icaro.modelo.Operador;
import java.util.Calendar;

/**
 *
 * falta probar el método calc. sueldo con un chofer y también con un operador
 */
public class Administracion {

    private double comisionCalculadaFinal;

//ponemos throws Exception en todos estos? Al getSaldoActualizadoCliente me obligó a agregarla
    private double calcularComisionChofer(Chofer chof, Calendar i, Calendar f) throws Exception {
        DaoImpl dao = new DaoImpl("remiseria?zeroDateTimeBehavior=convertToNullPU");
        double comisionCalculada = 0;
        comisionCalculada = dao.obtenerFacturacionChofer(chof, i, f) * chof.getComision();
        return comisionCalculada;
    }

    public void setComisionCalculadaFinal(Chofer chof, Calendar i, Calendar f) throws Exception {
        this.comisionCalculadaFinal = this.calcularComisionChofer(chof, i, f);
    }

    public double getComisionCalculadaFinal() {
        return comisionCalculadaFinal;
    }

    public double calcularSueldo(Empleado emp) throws Exception {
        double sueldoCalculado = 0;
        if (emp instanceof Operador) {
            Operador op = (Operador) emp;
            sueldoCalculado = op.getSueldo();//El operador no tiene permitido recibir ninguna comisión.(nota para dejar)
        } else if (emp instanceof Chofer) {
            Chofer chof = (Chofer) emp;
            sueldoCalculado = chof.getSueldo() + this.getComisionCalculadaFinal();
        }
        return sueldoCalculado;
    }

//ya está validado en Clase DaoImpl q no se recibirán tipos de comprobantes que no sean RE,NC,FA o ND
    public double getSaldoActualizadoCliente(Cliente c, double importe, MovimientoDeSaldo mov) throws Exception {
        DaoImpl dao = new DaoImpl("remiseria?zeroDateTimeBehavior=convertToNullPU");
        double saldoActualizado = 0;
        double saldoInicial = dao.getSaldoCliente(c);
        if (mov.getTipoComprobante().equals("RE") || mov.getTipoComprobante().equals("NC")) {
            saldoActualizado = saldoInicial - importe;
        }
        if (mov.getTipoComprobante().equals("FA") || mov.getTipoComprobante().equals("ND")) {
            saldoActualizado = saldoInicial + importe;
        }
        return saldoActualizado;
    }

}
