package com.KGiSL.JpaProject;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ListMapping {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaProject");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Address a1 = new Address();
        a1.setE_pincode(201301);
        a1.setE_city("Noida");
        a1.setE_state("Uttar Pradesh");

        Address a2 = new Address();
        a2.setE_pincode(302001);
        a2.setE_city("Jaipur");
        a2.setE_state("Rajasthan");

        Employee e1 = new Employee();
        e1.setE_id(1);
        e1.setE_name("Vijay");
        e1.getAddress().add(a1);

        Employee e2 = new Employee();
        e2.setE_id(2);
        e2.setE_name("John");
        e2.getAddress().add(a2);

        em.persist(e1);
        em.persist(e2);

        List<Employee> allEmployee = em.createQuery("SELECT E FROM Employee E", Employee.class).getResultList();
        System.out.println("all Employee:");
        for (Employee E : allEmployee) {
            System.out.println(E.getE_id() + ": " + E.getE_name() + " by " + E.getAddress().toString());
        }

        transaction.commit();
        em.close();
        emf.close();
    }
}
