package com.crm.dao;

import java.util.List;

import com.crm.entity.Customer;

public interface CustomerDao {
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(Integer id);
	
	public List<Customer> getCustomers();
	
	public void deleteCustomer(Integer id);
	
}
