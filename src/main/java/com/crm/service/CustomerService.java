package com.crm.service;

import java.util.List;

import com.crm.entity.Customer;

public interface CustomerService {
	
	public void saveCustomer(Customer customer);
	
	public List<Customer> getCustomers();
	
	public Customer getCustomer(Integer customerId);
	
	public void deleteCustomer(Integer customerId);
	
}
