package az.atlacademy.springrelationsexample.manytomany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    private Long id;

    @ManyToMany(mappedBy = "likedCourses")
    private Set<Student> likes;

}
