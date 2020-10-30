/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.MovimientoDao;
import modelo.entidad.Movimiento;

/**
 *
 * @author Alejandro
 */
@ManagedBean
@ViewScoped
public class MovimientoControl {

    private List<Movimiento> listaMovimientos;
    private Movimiento movimiento;

    /**
     * Creates a new instance of MovimientoControl
     */
    public MovimientoControl() {
    }

    public List<Movimiento> getListaMovimientos() {
        MovimientoDao ud = new MovimientoDao();
        listaMovimientos = ud.listarMovimientos();
        return listaMovimientos;
    }

    public void setListaMovimientos(List<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public void limpiarMovimiento() {
        movimiento = new Movimiento();
    }

    public void agregarMovimiento() {
        MovimientoDao ud = new MovimientoDao();
        ud.agregar(movimiento);
    }

    public void modificarMovimiento() {
        MovimientoDao ud = new MovimientoDao();
        ud.modificar(movimiento);
        limpiarMovimiento();
    }

    public void eliminarMovimiento() {
        MovimientoDao ud = new MovimientoDao();
        ud.eliminar(movimiento);
        limpiarMovimiento();
    }
}
