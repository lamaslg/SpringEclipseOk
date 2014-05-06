/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luis.controllers;

import com.luis.servicios.ManagerPuestos;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojos.Puesto;

/**
 *
 * @author luis
 */

@Controller
public class PuestosController implements BeanFactoryAware{
    
    ManagerPuestos mp;
    
    @RequestMapping(value="/puestos.htm")
    public ModelAndView handleRequest(HttpServletRequest hsr,
            HttpServletResponse hsr1) throws Exception {
        Collection<Puesto>  l=mp.getAllPuesto();
        
        return new ModelAndView("puestos","puestos",l);
        
        
     }

 
    public void setBeanFactory(BeanFactory bf) throws BeansException {
        
        mp=(ManagerPuestos)bf.getBean(ManagerPuestos.class);
        
    }
}
