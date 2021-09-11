package com.customer.crm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.crm.dao.CustomerDAO;
import com.customer.crm.entity.Customer;
import com.customer.crm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		return customerDAO.getCustomerById(id);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveOrUpdateCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomerById(int id) {
		customerDAO.deleteCustomerById(id);
	}

}
