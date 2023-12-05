package com.kgisl.HibernateSpring.service;

import java.util.List;

import com.kgisl.HibernateSpring.entity.Customer;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

   // public void updateCustomer(Customer theCustomer);

}
