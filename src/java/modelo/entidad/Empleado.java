package modelo.entidad;
// Generated 06-oct-2018 13:52:48 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {


     private Integer idempleado;
     private Depto depto;
     private String nombre;
     private String apellido;
     private String dui;
     private Set<Movimiento> movimientos = new HashSet<Movimiento>(0);

    public Empleado() {
        // para el combo
        depto = new Depto();
    }

    public Empleado(Depto depto, String nombre, String apellido, String dui, Set<Movimiento> movimientos) {
       this.depto = depto;
       this.nombre = nombre;
       this.apellido = apellido;
       this.dui = dui;
       this.movimientos = movimientos;
    }
   
    public Integer getIdempleado() {
        return this.idempleado;
    }
    
    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }
    public Depto getDepto() {
        return this.depto;
    }
    
    public void setDepto(Depto depto) {
        this.depto = depto;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDui() {
        return this.dui;
    }
    
    public void setDui(String dui) {
        this.dui = dui;
    }
    public Set<Movimiento> getMovimientos() {
        return this.movimientos;
    }
    
    public void setMovimientos(Set<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }




}


