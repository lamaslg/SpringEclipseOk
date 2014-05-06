/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luis.controllers;

import com.luis.servicios.ManagerEmpleados;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojos.Empleado;

/**
 *
 * @author luis
 */

@Controller
public class EmpleadosController implements BeanFactoryAware{

  ManagerEmpleados dao;

  
   // @Override
    @RequestMapping(value="/empleados.htm")
    public ModelAndView handleRequest(HttpServletRequest hsr,
            HttpServletResponse hsr1) throws Exception {
        
        Date d=new Date();
        
        Collection<Empleado> c=dao.getAllEmpleados();
      
        Map<String,Object> datos=new HashMap<String, Object>();
        datos.put("fecha", d);
        datos.put("empleados", c);
        
        return new ModelAndView("empleados",datos);
        
    }

    @Override
    public void setBeanFactory(BeanFactory bf) throws BeansException {
               dao=(ManagerEmpleados) bf.getBean("daoEmpleado");
        
    }
    
}












