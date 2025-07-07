package gr.aueb.cf.schoolapp.model;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private Boolean active;

    @ManyToOne()
    @JoinColumn(name = "region_id")
    private Region region;

    @Getter(AccessLevel.PROTECTED)
    @ManyToMany(mappedBy = "teachers")
    private Set<Course> courses = new HashSet<>();

    public Set<Course> getAllCourses() {
        return Collections.unmodifiableSet(courses);
    }

    public void addCourse(Course course) {
        if (courses == null) courses = new HashSet<>();
        courses.add(course);
        course.getTeachers().add(this);
    }

    public void removeCourse(Course course) {
        if (courses == null) return;
        courses.remove(course);
        course.getTeachers().remove(this);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", active=" + active +
                '}';
    }
}
