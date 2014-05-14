package com.luis.servicios;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pojos.Puesto;
import pojos.Usuario;

@Transactional
public class ManagerAuth extends HibernateDaoSupport{

	
	public Usuario validar(String login,String pwd) {
		Usuario us=null;
		
		Session ses=  getHibernateTemplate().
                getSessionFactory().getCurrentSession();
	Query q=
		ses.createQuery("from Usuario where login=:login and password=:pwd");
	        q.setString("login", login);
	        try {
				q.setString("pwd", Utils.getHash(pwd));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        List<Usuario> usua=q.list();  
        if(usua.size()>0)
        	    us=usua.get(0);
      
    
        return us;
		
		
	}
	
	
}
