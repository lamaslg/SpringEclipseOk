/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luis.servicios;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pojos.Puesto;


/**
 *
 * @author luis
 */
@Transactional
public class ManagerPuestos 
            extends HibernateDaoSupport{
    
    
    
    public Puesto getPuesto(Integer id){
    
        Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
             
        
        Puesto em=(Puesto) ses.get(Puesto.class, id);
      
    
        return em;
    }
    
    public void addPuesto(Puesto em){
        
     Session ses= getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        ses.beginTransaction();
        ses.save(em);
        ses.getTransaction().commit();
        
    }
    public void deletePuesto(Puesto em){
         Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        ses.beginTransaction();
        ses.delete(em);
        ses.getTransaction().commit();
    
    }
    public void updatePuesto(Puesto em){
     Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        ses.beginTransaction();
        ses.update(em);
        ses.getTransaction().commit();
    }
     
    public Collection<Puesto> getAllPuesto(){
        
         Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        
        Query q=ses.createQuery("from Puesto");
        
        List<Puesto> emple=q.list();
        
        
        
        return emple;
    }
    
   
    
    public Collection<Puesto> consultarDatos(String consulta,
            Map<String,Object> params){
        
        Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        Query q=ses.getNamedQuery(consulta);
        
        for (String object : params.keySet()) {
            q.setParameter(object, params.get(object));
        }
        
        Collection<Puesto> l=q.list();
        
        return l;
        
    
    }
           
    
}









































