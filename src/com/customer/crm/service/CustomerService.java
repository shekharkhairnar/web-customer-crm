package com.customer.crm.service;

import java.util.List;

import com.customer.crm.entity.Customer;


public interface CustomerService {

	public List<Customer> getCustomers();

	public Customer getCustomerById(int id);

	public void saveCustomer(Customer customer);

	public void deleteCustomerById(int id);
}
