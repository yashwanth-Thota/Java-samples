package org.thota.yashwanth.Amazon.dataSource;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.thota.yashwanth.Amazon.models.product;
import org.thota.yashwanth.Amazon.models.user;
public class UserServer {
	
	public UserServer(){
		cfg=new Configuration();
		cfg.configure().addAnnotatedClass(user.class);
		sf=cfg.buildSessionFactory();
	}
	public user getUser(int id){
		openSession();
		Query q=session.createQuery("from users where id="+id);
		user u=(user)q.uniqueResult();
		closeSession();
		return u;
	}
	public user addUser(user u){
		openSession();
		session.save(u);
		closeSession();
		return u;
	}
	public product addProduct(product p){
		openSession();
		session.save(p);
		closeSession();
		return p;
	}
	public List<product> getProducts(){
		openSession();
		List<product> l=new ArrayList<product>();
		for(Object t: session.createQuery("from products").list())
		{
			l.add((product)t);
		}
		return l;
	}
	
	private void openSession(){
		session=sf.openSession();
		t=session.beginTransaction();
	}
	private void closeSession(){
		t.commit();
		session.close();
	}
	private Configuration cfg;
	private SessionFactory sf;
	private Transaction t;
	private Session session;
}

