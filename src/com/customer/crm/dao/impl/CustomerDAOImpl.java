package com.customer.crm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.crm.dao.CustomerDAO;
import com.customer.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Customer> getCustomers() {
		Query<Customer> query = sessionFactory.getCurrentSession().createQuery("from Customer");
		List<Customer> customers =  query.getResultList();
		return customers;
	}

	@Override
	public Customer getCustomerById(int id) {
		return sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public void saveOrUpdateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public void deleteCustomerById(int id) {
		Query<Customer> query = sessionFactory.getCurrentSession().createQuery("delete from Customer where id=:theId");
		query.setParameter("theId", id);
		query.executeUpdate();
	}

}
