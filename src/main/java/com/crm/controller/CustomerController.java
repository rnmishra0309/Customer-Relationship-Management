package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.entity.Customer;
import com.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customerList = customerService.getCustomers();
		model.addAttribute("customers", customerList);
		return "list-customers";
	}
	
	@GetMapping("/add-customer")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("save-or-update-customer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/customer-update-form")
	public String updateCustomerForm(@RequestParam("customerId") Integer customerId, Model model) {
		Customer currentCustomer = customerService.getCustomer(customerId);
		model.addAttribute("customer", currentCustomer);
		return "customer-form";
	}
	
	@GetMapping("/customer-delete-form")
	public String deleteCustomerForm(@RequestParam("customerId") Integer customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}
	
}
