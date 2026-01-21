package gr.aueb.cf.schoolapp;


import gr.aueb.cf.schoolapp.enums.GenderType;
import gr.aueb.cf.schoolapp.model.Course;
import gr.aueb.cf.schoolapp.model.Region;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.model.TeacherMoreInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import javax.xml.transform.stream.StreamResult;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        // Select male/female teachers born after a specific date - JPQL
//        String sql = "SELECT t FROM Teacher t JOIN t.teacherMoreInfo tmi " +
//                "WHERE tmi.gender = :gender AND tmi.dateOfBirth > :dateOfBirth";
//        TypedQuery<Teacher> query = em.createQuery(sql, Teacher.class);
//        query.setParameter("gender", GenderType.MALE);
//        query.setParameter("dateOfBirth", LocalDateTime.of(1970, 1, 1, 0, 0, 0));
//        List<Teacher> teachers = query.getResultList();
//        teachers.forEach(System.out::println);


        // Select male/female teachers born after a specific date - Criteria API
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//
//        CriteriaQuery<Teacher> query = criteriaBuilder.createQuery(Teacher.class);
//        Root<Teacher> teacher = query.from(Teacher.class);
//        Join<Teacher, TeacherMoreInfo> teacherMoreInfo =  teacher.join("teacherMoreInfo");
//
//        ParameterExpression<GenderType> gender = criteriaBuilder.parameter(GenderType.class);
//        ParameterExpression<LocalDateTime> date = criteriaBuilder.parameter(LocalDateTime.class);
//
//        query.select(teacher)
//                .where(
//                        criteriaBuilder.and(
//                                criteriaBuilder.equal(teacherMoreInfo.get("gender"), gender),
//                                criteriaBuilder.greaterThan(teacherMoreInfo.get("dateOfBirth"), date)
//                        )
//                );
//        List<Teacher> teachers = em.createQuery(query)
//                .setParameter(gender, GenderType.MALE)
//                .setParameter(date, LocalDateTime.of(1970, 1, 1, 0, 0, 0))
//                .getResultList();
//        teachers.forEach(System.out::println);


        // Select for every region =>  region.title and count for  inactive teachers per region - JPQL
//        String sql = "SELECT r.title, count(t) FROM Region r LEFT JOIN r.teachers t " +
//                "WHERE t.active = false OR t.active IS NULL GROUP BY r.title";
//        TypedQuery<Object[]> query = em.createQuery(sql, Object[].class);
//        List<Object[]> inactiveTeachersCountPerRegion = query.getResultList();
//        for (Object[] row : inactiveTeachersCountPerRegion) {
//            for (Object item : row) {
//                System.out.print(item + " ");
//            }
//            System.out.println();
//        }

        // Select for every region =>  region.title and count for  inactive teachers per region - Criteria API
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
//        Root<Region> region = query.from(Region.class);
//        Join<Region, Teacher> teacher = region.join("teachers", JoinType.LEFT);
//
//        query.multiselect(
//                region.get("title"),
//                cb.count(teacher)
//        ).where(
//                cb.or(
//                        cb.isFalse(teacher.get("active")),
//                        cb.isNull(teacher.get("active"))
//                )
//
//        ).groupBy(region.get("title"));
//
//        List<Object[]> inactiveTeachersCountPerRegion = em.createQuery(query).getResultList();
//        for (Object[] row : inactiveTeachersCountPerRegion) {
//            for (Object item : row) {
//                System.out.print(item + " ");
//            }
//            System.out.println();
//        }

        List<Teacher> teachers = findByCriteria("Αθανάσιος", null, true);
        teachers.forEach(System.out::println);
    }


    // filtering teachers με Multiple Criteria
    public static List<Teacher> findByCriteria(String firstname, String lastname, Boolean active) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = cb.createQuery(Teacher.class);
        Root<Teacher> teacher = query.from(Teacher.class);

        List<Predicate> predicates = new ArrayList<>();

        if (firstname != null) {
            predicates.add(cb.like(teacher.get("firstname"), firstname + "%"));
        }

        if (lastname != null) {
            predicates.add(cb.like(teacher.get("lastname"), lastname + "%"));
        }

        if (active != null) {
            predicates.add(cb.equal(teacher.get("active"), active));
        }

        query.where(predicates.toArray(new Predicate[0])); // preserve type safetυ
        return em.createQuery(query).getResultList();
    }
}
