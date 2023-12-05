package com.KGiSL.JpaProject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.*;

public class SingleFetch {

     public static void main(String args[]) {

          EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaProject");
          EntityManager em = emf.createEntityManager();
          em.getTransaction().begin();
          CriteriaBuilder cb = em.getCriteriaBuilder();
          CriteriaQuery<StudentEntity> cq = cb.createQuery(StudentEntity.class);

          Root<StudentEntity> stud = cq.from(StudentEntity.class);

          cq.select(stud);

          CriteriaQuery<StudentEntity> select = cq.select(stud);
          TypedQuery<StudentEntity> q = em.createQuery(select);
          List<StudentEntity> list = q.getResultList();

          System.out.println("s_name");

          for (StudentEntity s : list) {
               System.out.println(s.getS_name());

          }

          em.getTransaction().commit();
          em.close();
          emf.close();
     }
}