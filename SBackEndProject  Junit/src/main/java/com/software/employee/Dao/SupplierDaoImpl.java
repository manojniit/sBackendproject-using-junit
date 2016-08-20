package com.software.employee.Dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.software.employee.modal.Supplier;
@EnableTransactionManagement
@Repository(value = "supplierDao")

public class SupplierDaoImpl implements SupplierDao{
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean save(Supplier supplier)
	{
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		return false;
		}
		
		
	}
	public boolean update(Supplier supplier)
	{ 
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
	}
	public boolean delete(Supplier supplier)
	{
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	public Supplier get(String id)
	{
		String hql = "from Supplier where id = " + " ' " +  id + " ' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list = query.list();
		if(list == null)
	    {
	    	return null;
	    }
		else
	    {
	    	return list.get(0);
	    }
		
	
	
	}

	public List<Supplier> list() {
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	

}
