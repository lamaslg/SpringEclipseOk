package com.luis.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.ejb.criteria.expression.BinaryArithmeticOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.luis.servicios.ManagerAuth;

import pojos.Usuario;


@Controller
@RequestMapping(value="/login.htm")
public class LoginController {

	@Autowired
	ManagerAuth manager;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView login(HttpServletRequest req,
			HttpServletResponse res){
		
		Usuario us=new Usuario();
		
		return new ModelAndView("login","usuario",us);
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public String onSubmit(Usuario usuario,BindingResult result,
			HttpServletRequest req){
		
		Usuario resultado=manager.validar(usuario.getLogin(), 
				usuario.getPassword());
		
		if(resultado!=null){
			List<GrantedAuthority> perm=new ArrayList<GrantedAuthority>();
			perm.add(new SimpleGrantedAuthority(resultado.getRol().getRol()));
			
			Authentication auth=
					new UsernamePasswordAuthenticationToken(
							resultado.getLogin(), resultado.getPassword(),
							perm
							);
			SecurityContextHolder.getContext().setAuthentication(auth);
			
			return "redirect:/AdminAltaEmpleado.htm";
			
		}
		else{
		
			return "login";
		}
		
	}
	
	
	
}
