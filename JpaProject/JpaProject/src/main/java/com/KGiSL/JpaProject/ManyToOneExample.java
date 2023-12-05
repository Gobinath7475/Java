package com.KGiSL.JpaProject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManyToOneExample {  
  
    public static void main(String[] args) {  
          
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JpaProject");  
          
        EntityManager em=emf.createEntityManager();  
          
        em.getTransaction().begin();  
          
        em.getTransaction().commit();  
        em.close();  
        emf.close();     
    }  
}
      
