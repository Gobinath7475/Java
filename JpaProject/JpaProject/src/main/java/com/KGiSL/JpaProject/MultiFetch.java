package com.KGiSL.JpaProject;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class MultiFetch  {

     public static void main(String args[]) {

          EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaProject");
          EntityManager em = emf.createEntityManager();

          EntityTransaction transaction = em.getTransaction();

          transaction.begin();

          StudentEntity s = new StudentEntity();
          s.setS_id(1);
          s.setS_name("gopi");
          s.setS_age(23);

          em.persist(s);

          CriteriaBuilder cb = em.getCriteriaBuilder();
          
          CriteriaQuery<StudentEntity> cq = cb.createQuery(StudentEntity.class);

          Root<StudentEntity> stud = cq.from(StudentEntity.class);

          cq.multiselect(stud.get("s_id"), stud.get("s_name"), stud.get("s_age"));

          CriteriaQuery<StudentEntity> select = cq.select(stud);
          TypedQuery<StudentEntity> q = em.createQuery(select);
          List<StudentEntity> list = q.getResultList();

          System.out.println("s_id | s_name | s_age");

          for (StudentEntity s1 : list) {
               System.out.println(s1.getS_id() + " "+  s1.getS_name() +" " + s1.getS_age());

          }

          transaction.commit();
          em.close();
          emf.close();
     }
}
