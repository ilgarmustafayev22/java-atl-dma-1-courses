package az.atlacademy.springjdbctemplateexample.dao;

import az.atlacademy.springjdbctemplateexample.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao<E>{

    List<Student> findAll();

    Optional<E> findById(Long id);

    void save(Student student);

    void updateStudent(Long id, Student student);

    void deleteStudent(Long id);

}
