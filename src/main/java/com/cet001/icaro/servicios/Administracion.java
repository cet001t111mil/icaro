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

  

//ponemos throws Exception en todos estos? Al getSaldoActualizadoCliente me obligó a agregarla
    private double calcularComisionChofer(int nroLegajo, Calendar i, Calendar f) throws Exception {
        DaoImpl dao = new DaoImpl("remiseria?zeroDateTimeBehavior=convertToNullPU");
        double comisionCalculada = 0;
        double facturacion  = dao.obtenerFacturacionChofer(nroLegajo, i, f);
        double comision = dao.getChofer(nroLegajo).getComision();
        comisionCalculada = facturacion * comision;
        return comisionCalculada;
    }

    public double calcularSueldo(Empleado emp,int nroLegajo,Calendar i,Calendar f) throws Exception {
        double sueldoCalculado = 0;
        if (emp instanceof Operador) {
            Operador op = (Operador) emp;
            sueldoCalculado = op.getSueldo();//El operador no tiene permitido recibir ninguna comisión.(nota para dejar)
        } else if (emp instanceof Chofer) {
            Chofer chof = (Chofer) emp;
            sueldoCalculado = chof.getSueldo() + this.calcularComisionChofer(nroLegajo, i, f);
        }
        return sueldoCalculado;
    }

//ya está validado en Clase DaoImpl q no se recibirán tipos de comprobantes que no sean RE,NC,FA o ND
    public void calcularNuevoSaldoCliente(int idCliente, MovimientoDeSaldo mov) throws Exception {
        DaoImpl dao = new DaoImpl("remiseria?zeroDateTimeBehavior=convertToNullPU");
        double saldoNuevo = 0;
        double saldoActual = dao.getSaldoCliente(idCliente);
        if (mov.getTipoComprobante().equals("RE") || mov.getTipoComprobante().equals("NC")) {
            saldoNuevo = saldoActual - mov.getImporte();
            saldoActual = saldoNuevo;
            dao.guardarNuevoSaldoCliente(saldoActual, idCliente);
        }
        if (mov.getTipoComprobante().equals("FA") || mov.getTipoComprobante().equals("ND")) {
            saldoNuevo = saldoActual + mov.getImporte();
            saldoActual = saldoNuevo;
            dao.guardarNuevoSaldoCliente(saldoActual, idCliente);
        }
    }

     

}
