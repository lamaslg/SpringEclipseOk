/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luis.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.*;




/**
 *
 * @author luis
 */


public class HolaMundoController implements Controller{
    
    
    
   
    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException
    {
    
        request.setAttribute("algo", "Vale, te digo algo");
    
    
        return new ModelAndView("hola");
    
    }

    
    
}
