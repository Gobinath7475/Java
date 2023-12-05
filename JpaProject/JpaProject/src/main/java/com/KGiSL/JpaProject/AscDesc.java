package com.KGiSL.JpaProject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.*;

public class AscDesc {

     public static void main(String args[]) {

          EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaProject");
          EntityManager em = emf.createEntityManager();

          em.getTransaction().begin();

          CriteriaBuilder cb = em.getCriteriaBuilder();

          CriteriaQuery<StudentEntity> cq = cb.createQuery(StudentEntity.class);

          Root<StudentEntity> stud = cq.from(StudentEntity.class);

          // cq.orderBy(cb.desc(stud.get("s_id")));
          cq.orderBy(cb.asc(stud.get("s_id")));

          CriteriaQuery<StudentEntity> select = cq.select(stud);

          TypedQuery<StudentEntity> q = em.createQuery(select);

          List<StudentEntity> list = q.getResultList();

          System.out.print("s_id");
          System.out.print("\t s_name");
          System.out.println("\t s_age");

          for (StudentEntity s : list) {
               System.out.print(s.getS_id());
               System.out.print("\t" + s.getS_name());
               System.out.println("\t" + s.getS_age());
          }

          em.getTransaction().commit();
          em.close();
          emf.close();
     }
}
