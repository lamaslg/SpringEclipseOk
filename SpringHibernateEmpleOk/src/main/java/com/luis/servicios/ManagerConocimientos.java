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
import org.springframework.transaction.annotation.Transactional;
import pojos.Conocimientos;


/**
 *
 * @author luis
 */
@Transactional
public class ManagerConocimientos 
            extends HibernateDaoSupport{
    
    
    
    public Conocimientos getConocimientos(Integer id){
    
        Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
             
        
        Conocimientos em=(Conocimientos) ses.get(Conocimientos.class, id);
      
    
        return em;
    }
    
    public void addConocimientos(Conocimientos em){
        
     Session ses= getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        ses.beginTransaction();
        ses.save(em);
        ses.getTransaction().commit();
        
    }
    public void deleteConocimientos(Conocimientos em){
         Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        ses.beginTransaction();
        ses.delete(em);
        ses.getTransaction().commit();
    
    }
    public void updateConocimientos(Conocimientos em){
     Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        ses.beginTransaction();
        ses.update(em);
        ses.getTransaction().commit();
    }
     
    public Collection<Conocimientos> getAllConocimientos(){
        
         Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        
        Query q=ses.createQuery("from Conocimientos");
        
        List<Conocimientos> emple=q.list();
        
        
        
        return emple;
    }
    
   
    
    public Collection<Conocimientos> consultarDatos(String consulta,
            Map<String,Object> params){
        
        Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
        Query q=ses.getNamedQuery(consulta);
        
        for (String object : params.keySet()) {
            q.setParameter(object, params.get(object));
        }
        
        Collection<Conocimientos> l=q.list();
        
        return l;
        
    
    }
           
    
}









































