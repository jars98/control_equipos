/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.DeptoDao;
import modelo.entidad.Depto;

/**
 *
 * @author Alejandro
 */
@ManagedBean
@ViewScoped
public class DeptoControl {

    private List<Depto> listaDeptos;
    private Depto depto;

    /**
     * Creates a new instance of DeptoControl
     */
    public DeptoControl() {
    }

    public List<Depto> getListaDeptos() {
        DeptoDao ud = new DeptoDao();
        listaDeptos = ud.listarDeptos();
        return listaDeptos;
    }

    public void setListaDeptos(List<Depto> listaDeptos) {
        this.listaDeptos = listaDeptos;
    }

    public Depto getDepto() {
        return depto;
    }

    public void setDepto(Depto depto) {
        this.depto = depto;
    }

    public void limpiarDepto() {
        depto = new Depto();        
    }

    public void agregarDepto() {
        DeptoDao ud = new DeptoDao();
        ud.agregar(depto);
    }

    public void modificarDepto() {
        DeptoDao ud = new DeptoDao();
        ud.modificar(depto);
        limpiarDepto();
    }

    public void eliminarDepto() {
        DeptoDao ud = new DeptoDao();
        ud.eliminar(depto);
        limpiarDepto();
    }
}
