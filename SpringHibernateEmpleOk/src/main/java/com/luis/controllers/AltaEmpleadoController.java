/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luis.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.luis.model.viewforms.EmpleadosViewForm;
import com.luis.servicios.ManagerConocimientos;
import com.luis.servicios.ManagerEmpleados;
import com.luis.servicios.ManagerPuestos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pojos.Conocimientos;
import pojos.Empleado;
import pojos.Puesto;

/**
 *
 * @author luis
 */
@Controller
@RequestMapping(value = "/AltaEmpleado.htm")
public class AltaEmpleadoController {
    static String path;
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
            BindingResult result,HttpServletRequest req){
    
    	Date d=new Date();
    String ruta=d.getTime()+".png";
    
   
    	File dir=new File("/uploads");
    	if(!dir.exists())
    		dir.mkdir();
    	
    System.out.println(dir.getAbsolutePath());
    	
    	File f=new File(dir,ruta);
    	
    	try {
			FileOutputStream fos=new FileOutputStream(f);
			byte[] datos=new byte[(int) empleado.getFoto().getSize()];
			empleado.getFoto().getInputStream().read(datos);
			fos.write(datos);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
    	
    	
    	
          if(result.hasErrors())
              return "AltaEmpleado";
    
          Puesto p=new Puesto();
          p.setIdPuesto(empleado.getPuesto());
          Empleado em=new Empleado();
          em.setNombre(empleado.getNombre());
          em.setSalario(empleado.getSalario());
          em.setPuesto(p);
          em.setFechaAlta(empleado.getFechaAlta());
          em.setFoto("/uploads/"+ruta);
          Set<Conocimientos> sc=new HashSet<Conocimientos>();
          for (Integer idCon : empleado.getConocimientos()) {
			Conocimientos con=new Conocimientos();
			con.setIdConocimiento(idCon);
        	  sc.add(con);
        	  
          }
         em.setConocimientos(sc);
          
          managerEmpleados.addEmpleado(em);
          
          return "redirect:/empleados.htm";
    
    }
    
    @RequestMapping(method = RequestMethod.GET)
    protected EmpleadosViewForm formBackingObject
                    (HttpServletRequest req)throws Exception{
               path=req.getSession().getServletContext().getRealPath("/");
              
        EmpleadosViewForm empleado=new EmpleadosViewForm();
        empleado.setSalario(new Double(35000));
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

















