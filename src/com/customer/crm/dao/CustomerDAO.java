package com.customer.crm.dao;

import java.util.List;

import com.customer.crm.entity.Customer;


public interface CustomerDAO {

	public List<Customer> getCustomers();

	public Customer getCustomerById(int id);

	public void saveOrUpdateCustomer(Customer customer);

	public void deleteCustomerById(int id);
}
