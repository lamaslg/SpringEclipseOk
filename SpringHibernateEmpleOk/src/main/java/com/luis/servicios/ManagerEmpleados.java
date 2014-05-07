/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luis.servicios;

import pojos.Conocimientos;
import pojos.Empleado;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author luis
 */
@Transactional
public class ManagerEmpleados 
            extends HibernateDaoSupport{
    
    
    
    public Empleado getEmpleado(Integer id,boolean lazy){
    
        Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
             
        
        Empleado em=(Empleado) ses.get(Empleado.class, id);
        if(!lazy)
        		Hibernate.initialize(em.getConocimientos());
	
    
        return em;
    }
    
    public void addEmpleado(Empleado em){
        
     Session ses= getHibernateTemplate().
                getSessionFactory().getCurrentSession();
       // ses.beginTransaction();
        ses.save(em);
       // ses.getTransaction().commit();
        
    }
    public void deleteEmpleado(Empleado em){
         Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
       // ses.beginTransaction();
        ses.delete(em);
       // ses.getTransaction().commit();
    
    }
    public void updateEmpleado(Empleado em){
     Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        //ses.beginTransaction();
        ses.update(em);
       // ses.getTransaction().commit();
    }
     
    public Collection<Empleado> getAllEmpleados(){
        
         Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        
        Query q=ses.createQuery("from Empleado");
        
        List<Empleado> emple=q.list();
        
        
        
        return emple;
    }
    
    public Collection<Empleado> findEmpleadoByPuesto(int idPuesto){
        
        Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        
        Query q= 
            ses.createQuery("from Empleado where idPuesto= :puesto");
        
        q.setInteger("puesto", idPuesto);
    
        
        List<Empleado> l=q.list();
        
        return l;
    
    }
    
    public Collection<Empleado> consultarDatos(String consulta,
            Map<String,Object> params){
        
        Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        Query q=ses.getNamedQuery(consulta);
        
        for (String object : params.keySet()) {
            q.setParameter(object, params.get(object));
        }
        
        Collection<Empleado> l=q.list();
        
        return l;
        
    
    }
           
    
}









































