package com.luis.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pojos.Conocimientos;
import pojos.Empleado;
import pojos.Puesto;

import com.luis.model.viewforms.EmpleadosViewForm;
import com.luis.servicios.ManagerConocimientos;
import com.luis.servicios.ManagerEmpleados;
import com.luis.servicios.ManagerPuestos;

@Controller
@RequestMapping(value="/ModificarEmpleado.htm")
public class ModificarEmpleadoController {
	@Autowired
    private ManagerEmpleados managerEmpleados;

    @Autowired
    private ManagerPuestos managerPuestos;
    
    @Autowired
    private ManagerConocimientos managerConocimientos;
    
    
    
    
    public ManagerConocimientos getManagerConocimientos() {
		return managerConocimientos;
	}

	public void setManagerConocimientos(ManagerConocimientos managerConocimientos) {
		this.managerConocimientos = managerConocimientos;
	}

	public ManagerPuestos getManagerPuestos() {
		return managerPuestos;
	}

	public void setManagerPuestos(ManagerPuestos managerPuestos) {
		this.managerPuestos = managerPuestos;
	}

	public ManagerEmpleados getManagerEmpleados() {
        return managerEmpleados;
    }

    public void setManagerEmpleados(ManagerEmpleados managerEmpleados) {
        this.managerEmpleados = managerEmpleados;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    protected String onSubmit(EmpleadosViewForm empleado,
            BindingResult result){
    
          if(result.hasErrors())
              return "ModificarEmpleado";
    
          Puesto p=new Puesto();
          p.setIdPuesto(empleado.getPuesto());
          Empleado em=new Empleado();
          em.setNombre(empleado.getNombre());
          em.setSalario(empleado.getSalario());
          em.setPuesto(p);
          em.setFechaAlta(empleado.getFechaAlta());
          
          Set<Conocimientos> sc=new HashSet<Conocimientos>();
          for (Integer idCon : empleado.getConocimientos()) {
			Conocimientos con=new Conocimientos();
			con.setIdConocimiento(idCon);
        	  sc.add(con);
        	  
          }
         em.setConocimientos(sc);
          em.setIdEmpleado(empleado.getIdEmpleado());
          managerEmpleados.updateEmpleado(em);
          
          return "redirect:/empleados.htm";
    
    }
    
    @RequestMapping(method = RequestMethod.GET)
    protected EmpleadosViewForm formBackingObject
                    (HttpServletRequest req)throws Exception{
             
    	
    	Integer id=Integer.parseInt(req.getParameter("id"));
    	Empleado emp=managerEmpleados.getEmpleado(id,false);
    	
        EmpleadosViewForm empleado=new EmpleadosViewForm();
        empleado.setSalario(emp.getSalario());
        empleado.setNombre(emp.getNombre());
        empleado.setFechaAlta(emp.getFechaAlta());
        empleado.setPuesto(emp.getPuesto().getIdPuesto());
        empleado.setIdEmpleado(emp.getIdEmpleado());
        Integer[] conom=new Integer[emp.getConocimientos().size()];
        
        int pos=0;
        for (Conocimientos con : emp.getConocimientos()) {
		conom[pos++]=con.getIdConocimiento();	
        	
		}
        
        empleado.setConocimientos(conom);
        
        req.setAttribute("empleado", empleado);
        
        Collection<Puesto> lp=managerPuestos.getAllPuesto();
        Map<Integer,String> m=new HashMap<Integer, String>();
        
        Collection<Conocimientos> lc=managerConocimientos.getAllConocimientos();
        Map<Integer,String> mc=new HashMap<Integer, String>();
        
        for (Puesto puesto : lp) {
			m.put(puesto.getIdPuesto(), puesto.getNombre());
		}
        
        for (Conocimientos conocimientos : lc) {
			mc.put(conocimientos.getIdConocimiento(), 
					conocimientos.getNombre());
		}
        
        
        req.setAttribute("puestos", m);
        req.setAttribute("conocimientos", mc);
        
        return empleado;
        
        }
}
