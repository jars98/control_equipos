/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.EquipoDao;
import modelo.entidad.Equipo;

/**
 *
 * @author Alejandro
 */
@ManagedBean
@ViewScoped
public class EquipoControl {

    private List<Equipo> listaEquipos;
    private Equipo equipo;

    /**
     * Creates a new instance of EquipoControl
     */
    public EquipoControl() {
    }

    public List<Equipo> getListaEquipos() {
        EquipoDao ud = new EquipoDao();
        listaEquipos = ud.listarEquipos();
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void limpiarEquipo() {
        equipo = new Equipo();
    }

    public void agregarEquipo() {
        EquipoDao ud = new EquipoDao();
        ud.agregar(equipo);
    }

    public void modificarEquipo() {
        EquipoDao ud = new EquipoDao();
        ud.modificar(equipo);
        limpiarEquipo();
    }

    public void eliminarEquipo() {
        EquipoDao ud = new EquipoDao();
        ud.eliminar(equipo);
        limpiarEquipo();
    }
}
