package com.software.employee.Dao;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.software.employee.modal.Product;
@EnableTransactionManagement
@Repository(value = "productDao")
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean save(Product product)
	{
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		return false;
		}
		
		
	}
	@Transactional
	public boolean update(Product product)
	{ 
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
	}
	@Transactional
	public boolean delete(Product product)
	{
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	@Transactional
	public Product get(String id)
	{
		String hql = "from product where id = " + " ' " +  id + " ' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();
		if(list == null)
	    {
	    	return null;
	    }
		else
	    {
	    	return list.get(0);
	    }
		
	
	
	}
	@Transactional
	public List<Product> list() {
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	

	

}
