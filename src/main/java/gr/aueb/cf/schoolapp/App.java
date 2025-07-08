package gr.aueb.cf.schoolapp;


import gr.aueb.cf.schoolapp.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class App {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("school8PU");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        // Select active teachers - JPQL
        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t WHERE active = true", Teacher.class);
        List<Teacher> teachers = query.getResultList();
        teachers.forEach(System.out::println);

        // C

    }
}
