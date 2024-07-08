package az.atlacademy.module03.lesson62;

import java.util.Optional;

public interface StudentDao {

    Optional<Student> findById(Long id);

    void save(Student student);

    void updateStudent(Long id, Student student);

}
