package com.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.CustomerDao;
import com.crm.entity.Customer;
import com.crm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Transactional
	public List<Customer> getCustomers() {
		try {
			List<Customer> customers = customerDao.getCustomers();
			return customers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public void saveCustomer(Customer customer) {
		try {
			customerDao.saveCustomer(customer);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	public Customer getCustomer(Integer customerId) {
		try {
			return customerDao.getCustomer(customerId);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public void deleteCustomer(Integer customerId) {
		try {
			customerDao.deleteCustomer(customerId);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
