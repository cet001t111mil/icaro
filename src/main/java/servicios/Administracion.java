/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import com.cet001.icaro.dao.DaoImpl;
import com.cet001.icaro.modelo.Chofer;
import com.cet001.icaro.modelo.Empleado;
import com.cet001.icaro.modelo.Operador;
import java.util.Calendar;

/**
 *
 falta probar el método calc. sueldo con un chofer y también con un operador
 */
public class Administracion {

    private double comisionCalculadaFinal;

    //falta lo de abrir y cerrar transaccion en todos. No olvidarme de hacerlo!!!!!
    private double calcularComisionChofer(Chofer chof, Calendar i, Calendar f) {
        DaoImpl dao = new DaoImpl("remiseria?zeroDateTimeBehavior=convertToNullPU");
        double comisionCalculada = 0;
        try {
                comisionCalculada = dao.obtenerFacturacionChofer(chof, i, f) * chof.getComision();
         
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comisionCalculada;
    }

    public void setComisionCalculadaFinal(Chofer chof, Calendar i, Calendar f) {
        this.comisionCalculadaFinal = this.calcularComisionChofer(chof, i, f);
    }

    public double getComisionCalculadaFinal() {
        return comisionCalculadaFinal;
    }

    public double calcularSueldo(Empleado emp) {
        double sueldoCalculado = 0;
        try {
        
            if (emp instanceof Operador) {
                Operador op = (Operador) emp;
                sueldoCalculado = op.getSueldo();//El operador no tiene permitido recibir ninguna comisión.(nota para dejar)
            } else if (emp instanceof Chofer) {
                Chofer chof = (Chofer) emp;
                sueldoCalculado = chof.getSueldo() + this.getComisionCalculadaFinal();
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sueldoCalculado;
    }

}
