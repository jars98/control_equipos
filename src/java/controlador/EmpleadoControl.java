/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import modelo.dao.DeptoDao;
import modelo.dao.EmpleadoDao;
import modelo.entidad.Depto;
import modelo.entidad.Empleado;

/**
 *
 * @author Alejandro
 */
@ManagedBean
@ViewScoped
public class EmpleadoControl {

    private List<Empleado> listaEmpleados;
    private Empleado empleado;
     // agregar para el combo
    private List<SelectItem> listaDeptos;

    /**
     * Creates a new instance of EmpleadoControl
     */
    public EmpleadoControl() {
         // agregar para el combo
        empleado = new Empleado();
    }

    public List<Empleado> getListaEmpleados() {
        EmpleadoDao ud = new EmpleadoDao();
        listaEmpleados = ud.listarEmpleados();
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void limpiarEmpleado() {
        empleado = new Empleado();
    }

    public void agregarEmpleado() {
        EmpleadoDao ud = new EmpleadoDao();
        ud.agregar(empleado);
    }

    public void modificarEmpleado() {
        EmpleadoDao ud = new EmpleadoDao();
        ud.modificar(empleado);
        limpiarEmpleado();
    }

    public void eliminarEmpleado() {
        EmpleadoDao ud = new EmpleadoDao();
        ud.eliminar(empleado);
        limpiarEmpleado();
    }
    
     // agregar para el combo
    public List<SelectItem> getListaDeptos() {
        this.listaDeptos = new ArrayList<SelectItem>();
        DeptoDao md = new DeptoDao();
        List<Depto> deptos = md.listarDeptos();
        listaDeptos.clear();
        for (Depto depto : deptos) {
            SelectItem deptoItem = new SelectItem(depto.getIddepto(), depto.getNombre());
            listaDeptos.add(deptoItem);
        }
        return listaDeptos;
    }
}
