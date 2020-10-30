/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import modelo.dao.EquipoDao;
import modelo.dao.MantenimientoDao;
import modelo.entidad.Equipo;
import modelo.entidad.Mantenimiento;

/**
 *
 * @author Alejandro
 */
@ManagedBean
@ViewScoped
public class MantenimientoControl {

    private List<Mantenimiento> listaMantenimientos;
    private Mantenimiento mantenimiento;
    // agregar para el combo
    private List<SelectItem> listaEquipos;
    private List<SelectItem> listaTipos;
    // para tener acceso al controlador de login
    @ManagedProperty("#{loginControl}")
    private LoginControl loginControl;

    /**
     * Creates a new instance of MantenimientoControl
     */
    public MantenimientoControl() {
        // agregar para el combo
        mantenimiento = new Mantenimiento();
    }

    public List<Mantenimiento> getListaMantenimientos() {
        MantenimientoDao ud = new MantenimientoDao();
        listaMantenimientos = ud.listarMantenimientos();
        return listaMantenimientos;
    }

    public void setListaMantenimientos(List<Mantenimiento> listaMantenimientos) {
        this.listaMantenimientos = listaMantenimientos;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public void limpiarMantenimiento() {
        mantenimiento = new Mantenimiento();
    }

    public void agregarMantenimiento() {
        MantenimientoDao ud = new MantenimientoDao();
        mantenimiento.setUsuario(loginControl.getUsuario());
        ud.agregar(mantenimiento);
    }

    public void modificarMantenimiento() {
        MantenimientoDao ud = new MantenimientoDao();
        ud.modificar(mantenimiento);
        limpiarMantenimiento();
    }

    public void eliminarMantenimiento() {
        MantenimientoDao ud = new MantenimientoDao();
        ud.eliminar(mantenimiento);
        limpiarMantenimiento();
    }

    // agregar para el combo
    public List<SelectItem> getListaEquipos() {
        this.listaEquipos = new ArrayList<SelectItem>();
        EquipoDao md = new EquipoDao();
        List<Equipo> equipos = md.listarEquipos();
        listaEquipos.clear();
        for (Equipo equipo : equipos) {
            SelectItem equipoItem = new SelectItem(equipo.getIdequipo(), equipo.getSerie() + " " + equipo.getMarca().getMarca() + " " + equipo.getModelo());
            listaEquipos.add(equipoItem);
        }
        return listaEquipos;
    }

    // agregar para el combo
    public List<SelectItem> getListaTipos() {
        this.listaTipos = new ArrayList<SelectItem>();
        listaTipos.clear();
        SelectItem tipoItem = new SelectItem(1, "Preventivo");
        listaTipos.add(tipoItem);
        tipoItem = new SelectItem(2, "Correctivo");
        listaTipos.add(tipoItem);
        return listaTipos;
    }

    // para guardar usuario de la sesion
    public LoginControl getLoginControl() {
        return loginControl;
    }

    public void setLoginControl(LoginControl loginControl) {
        this.loginControl = loginControl;
    }
}
