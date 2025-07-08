package gr.aueb.cf.schoolapp;


import gr.aueb.cf.schoolapp.model.Course;
import gr.aueb.cf.schoolapp.model.Region;
import gr.aueb.cf.schoolapp.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import javax.xml.transform.stream.StreamResult;
import java.util.List;

public class App {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("school8PU");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        // Select active teachers - JPQL
//        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t WHERE active = true", Teacher.class);
//        List<Teacher> teachers = query.getResultList();
//        teachers.forEach(System.out::println);

        // Criteria API - Select active teachers
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Teacher> query1 = cb.createQuery(Teacher.class);
//        Root<Teacher> teacher = query1.from(Teacher.class);
//        query1.select(teacher)
//                .where(
//                    cb.isTrue(teacher.get("active"))
//                );
//        List<Teacher> teachers = em.createQuery(query1).getResultList();
//        teachers.forEach(System.out::println);

        // Select active teachers from "Αθήνα" - JPQL
//        String sql = "SELECT t FROM Teacher t WHERE active = true AND t.region.title = :regionTitle";
//        TypedQuery<Teacher> query = em.createQuery(sql, Teacher.class);
//        query.setParameter("regionTitle", "Αθήνα");
//        List<Teacher> activeTeachersInRegion = query.getResultList();
//        activeTeachersInRegion.forEach(System.out::println);


        // Select active teachers from "Αθήνα" - Criteria API
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//
//        CriteriaQuery<Teacher> query = criteriaBuilder.createQuery(Teacher.class);
//        Root<Teacher> teacher = query.from(Teacher.class);
//        Join<Teacher, Region> region =  teacher.join("region");
//        ParameterExpression<String> regionTitle = criteriaBuilder.parameter((String.class));
//
//        query.select(teacher)
//                .where(
//                        criteriaBuilder.and(
//                                criteriaBuilder.isTrue(teacher.get("active")),
//                                criteriaBuilder.equal(region.get("title"), regionTitle)
//                        )
//                );
//        List<Teacher> activeTeachersInRegion = em.createQuery(query)
//                .setParameter(regionTitle, "Αθήνα")
//                .getResultList();
//        activeTeachersInRegion.forEach(System.out::println);

        // Select courses with comments containing with 'Coding' - JPQL
//        String sql = "SELECT c FROM Course c WHERE c.comments LIKE :searchTerm";
//        TypedQuery<Course> query = em.createQuery(sql, Course.class);
//        query.setParameter("searchTerm", "%Coding%");
//        List<Course> courses = query.getResultList();
//        courses.forEach(System.out::println);

        // Select courses with comments containing with 'Coding' - Criteria API
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//
//        CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);
//        Root<Course> course = query.from(Course.class);
//        ParameterExpression<String> comments = criteriaBuilder.parameter((String.class));
//
//        query.select(course)
//                .where(
//                  criteriaBuilder.like(course.get("comments"), comments)
//                );
//
//        List<Course> courses = em.createQuery(query).setParameter(comments, "%Coding%").getResultList();
//        courses.forEach(System.out::println);

        // Select male/female teachers born after a specific date
        String sql = "";


    }
}
