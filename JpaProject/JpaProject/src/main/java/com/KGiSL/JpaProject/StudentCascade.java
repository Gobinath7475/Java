package com.KGiSL.JpaProject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StudentCascade {

  public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaProject");

    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();

    StudentEntity1 s1 = new StudentEntity1();
    s1.setS_id(101);
    s1.setS_name("Vipul");
    s1.setS_age(20);

    StudentEntity1 s2 = new StudentEntity1();
    s2.setS_id(102);
    s2.setS_name("Aman");
    s2.setS_age(22);

    Subject sb1 = new Subject();
    sb1.setName("ENGLISH");
    sb1.setMarks(80);
    sb1.setS_id(s1.getS_id());

    Subject sb2 = new Subject();
    sb2.setName("Maths");
    sb2.setMarks(75);
    sb2.setS_id(s2.getS_id());

    s1.setSub(sb1);
    s2.setSub(sb2);

    em.persist(s1);
    em.persist(s2);

    StudentEntity1 s = em.find(StudentEntity1.class, 101);
    em.remove(s);

    em.getTransaction().commit();

    em.close();
    emf.close();

  }
}
