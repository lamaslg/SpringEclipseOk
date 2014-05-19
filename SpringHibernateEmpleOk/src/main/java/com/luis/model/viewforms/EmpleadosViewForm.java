/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luis.model.viewforms;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author luis
 */
public class EmpleadosViewForm {
    
	private Integer idEmpleado;
	@NotNull(message="El nombre es obligatorio")
	@Size(min=4,max=30)
	private String nombre;
    @NotNull
    @Range(min=9000,max=60000)
	private Double salario;
    @Range(min=1,max=Integer.MAX_VALUE)
    private Integer puesto;
    private Date fechaAlta;
    private Integer[] conocimientos;
   private MultipartFile foto;
    public Integer[] getConocimientos() {
		return conocimientos;
	}

	public void setConocimientos(Integer[] conocimientos) {
		this.conocimientos = conocimientos;
	}
    
    public EmpleadosViewForm() {
    	
    		fechaAlta=new Date();
    
    }
    
    public Integer getPuesto() {
		return puesto;
	}

	public void setPuesto(Integer puesto) {
		this.puesto = puesto;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public MultipartFile getFoto() {
		return foto;
	}

	public void setFoto(MultipartFile foto) {
		this.foto = foto;
	}

	
    
    
}
