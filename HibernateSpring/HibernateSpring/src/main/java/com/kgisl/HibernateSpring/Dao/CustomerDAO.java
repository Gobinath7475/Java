package com.kgisl.HibernateSpring.Dao;

import java.util.List;

import com.kgisl.HibernateSpring.entity.Customer;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

   // public void updateCustomer(Customer theCustomer);
}