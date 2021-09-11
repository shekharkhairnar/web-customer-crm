package com.customer.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.crm.entity.Customer;
import com.customer.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String customerList(Model model){
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers",customers);
		return "list-customers";
	}
	
	@GetMapping("/add-customer")
	public String customerAddForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@GetMapping("/update")
	public String customerUpdateForm(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomerById(id);
		return "redirect:list";
	}
	
	
}
