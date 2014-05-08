package com.luis.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pojos.Empleado;
import pojos.Puesto;

import com.luis.model.viewforms.EmpleadosViewForm;
import com.luis.servicios.ManagerEmpleados;


@Controller
@RequestMapping(value="/empleado")
public class EmpleadosRest {

	@Autowired
	private ManagerEmpleados managerEmpleados;
	
	
	
	public ManagerEmpleados getManagerEmpleados() {
		return managerEmpleados;
	}



	public void setManagerEmpleados(ManagerEmpleados managerEmpleados) {
		this.managerEmpleados = managerEmpleados;
	}



	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public @ResponseBody EmpleadosViewForm empleado(@PathVariable int id){
		
		Empleado emple=managerEmpleados.getEmpleado(id, true);
		
		EmpleadosViewForm evf=new EmpleadosViewForm();
		evf.setIdEmpleado(emple.getIdEmpleado());
		evf.setNombre(emple.getNombre());
		evf.setFechaAlta(emple.getFechaAlta());
		evf.setPuesto(emple.getPuesto().getIdPuesto());
		
		return evf;
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<EmpleadosViewForm> empleado(){
		
		Collection<Empleado> emple=managerEmpleados.getAllEmpleados();
		List<EmpleadosViewForm> l=new ArrayList<EmpleadosViewForm>();
		
		for (Empleado e : emple) {
			EmpleadosViewForm evf=new EmpleadosViewForm();
			evf.setIdEmpleado(e.getIdEmpleado());
			evf.setNombre(e.getNombre());
			evf.setFechaAlta(e.getFechaAlta());
			evf.setPuesto(e.getPuesto().getIdPuesto());
			l.add(evf);
		}
		
		
		return l;
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody EmpleadosViewForm 
						alta(@RequestBody EmpleadosViewForm emple){
		
		Puesto p=new Puesto();
		p.setIdPuesto(emple.getPuesto());
		
		Empleado e=new Empleado();
		e.setNombre(emple.getNombre());
		e.setPuesto(p);
		e.setSalario(emple.getSalario());
		e.setFechaAlta(new Date());
		managerEmpleados.addEmpleado(e);
		
		emple.setIdEmpleado(e.getIdEmpleado());
		emple.setFechaAlta(e.getFechaAlta());
		
		return emple;
		
		
		
		
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody EmpleadosViewForm 
						borrar(@RequestBody EmpleadosViewForm emple){
		
		
		
		Empleado e=new Empleado();
		e.setIdEmpleado(emple.getIdEmpleado());
		managerEmpleados.deleteEmpleado(e);
		
		
		return emple;
		
	}
	
}




















