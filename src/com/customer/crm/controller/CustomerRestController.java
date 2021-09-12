package com.customer.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.customer.crm.entity.Customer;
import com.customer.crm.service.CustomerService;

@Controller
@RequestMapping("/customer/rest")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	//@ResponseBody
	public ResponseEntity<List<Customer>> customerList(){
		List<Customer> customers = customerService.getCustomers();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add-customer", method=RequestMethod.POST)
	public ResponseEntity<Void> addCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
