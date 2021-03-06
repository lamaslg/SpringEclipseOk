package pojos;
// Generated 22-abr-2014 18:45:34 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {


     private Integer idEmpleado;
     private String nombre;
     private double salario;
     private Date fechaAlta;
     private Puesto puesto;
     private String foto;
     private Set<Conocimientos> conocimientos;

    public Set<Conocimientos> getConocimientos() {
        return conocimientos;
    }

    public void setConocimientos(Set conocimientos) {
        this.conocimientos = conocimientos;
    }
    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    public Empleado() {
    }

	
    public Empleado(String nombre, double salario, Puesto puesto) {
        this.nombre = nombre;
        this.salario = salario;
        this.puesto = puesto;
    }
    public Empleado(String nombre, double salario, Date fechaAlta, Puesto puesto) {
       this.nombre = nombre;
       this.salario = salario;
       this.fechaAlta = fechaAlta;
       this.puesto = puesto;
    }
   
    public Integer getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getSalario() {
        return this.salario;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
   




}


