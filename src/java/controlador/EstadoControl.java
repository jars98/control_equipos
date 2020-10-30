/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.EstadoDao;
import modelo.entidad.Estado;

/**
 *
 * @author Alejandro
 */
@ManagedBean
@ViewScoped
public class EstadoControl {

    private List<Estado> listaEstados;
    private Estado estado;

    /**
     * Creates a new instance of EstadoControl
     */
    public EstadoControl() {
    }

    public List<Estado> getListaEstados() {
        EstadoDao ud = new EstadoDao();
        listaEstados = ud.listarEstados();
        return listaEstados;
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void limpiarEstado() {
        estado = new Estado();
    }

    public void agregarEstado() {
        EstadoDao ud = new EstadoDao();
        ud.agregar(estado);
    }

    public void modificarEstado() {
        EstadoDao ud = new EstadoDao();
        ud.modificar(estado);
        limpiarEstado();
    }

    public void eliminarEstado() {
        EstadoDao ud = new EstadoDao();
        ud.eliminar(estado);
        limpiarEstado();
    }
}

