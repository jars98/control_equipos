package modelo.entidad;
// Generated 06-oct-2018 13:52:48 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Depto generated by hbm2java
 */
public class Depto  implements java.io.Serializable {


     private Integer iddepto;
     private String nombre;
     private Set<Empleado> empleados = new HashSet<Empleado>(0);

    public Depto() {
    }

    public Depto(String nombre, Set<Empleado> empleados) {
       this.nombre = nombre;
       this.empleados = empleados;
    }
   
    public Integer getIddepto() {
        return this.iddepto;
    }
    
    public void setIddepto(Integer iddepto) {
        this.iddepto = iddepto;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set<Empleado> getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }




}


