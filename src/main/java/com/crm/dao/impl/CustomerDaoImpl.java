package com.crm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.dao.CustomerDao;
import com.crm.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void saveCustomer(Customer customer) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Customer getCustomer(Integer id) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			return currentSession.get(Customer.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Customer> getCustomers() {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<Customer> queryString = currentSession.createQuery("from Customer", Customer.class);
			List<Customer> customerList = queryString.getResultList();
			return customerList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteCustomer(Integer id) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			Customer customer = currentSession.get(Customer.class, id);
			currentSession.delete(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
