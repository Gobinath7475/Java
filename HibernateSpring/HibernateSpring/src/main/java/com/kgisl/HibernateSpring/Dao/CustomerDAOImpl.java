package com.kgisl.HibernateSpring.Dao;

import com.kgisl.HibernateSpring.entity.Customer;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> root = cq.from(Customer.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.merge(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Customer.class, theId);
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customerToDelete = currentSession.get(Customer.class, theId);
        currentSession.remove(customerToDelete);
    }


    // @Override
    // @Transactional
    // public void updateCustomer(Customer updatedCustomer) {
    // Session currentSession = sessionFactory.getCurrentSession();
    // currentSession.merge(updatedCustomer);
    // }

    // @Override
    // @Transactional
    // public void updateCustomer(Customer updatedCustomer) {
    //     Session currentSession = sessionFactory.getCurrentSession();
    //     Customer existingCustomer = currentSession.get(Customer.class, updatedCustomer.getId());
    //     // Update the properties of existingCustomer with the values from
    //     // updatedCustomer
    //     currentSession.merge(existingCustomer);
    // }
}
