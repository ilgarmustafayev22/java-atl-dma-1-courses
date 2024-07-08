package az.atlacademy.module03.lesson55;

import java.util.List;
import java.util.Optional;

public interface StudentDao <E>{

    Optional<E> findByName(String name);

    void save(Student student);

    void updateStudent(Long id, Student student);

    void deleteStudent(Long id);

    List<Student> findAllStudents();

    private void foo(){
        System.out.println("aaa");
    }

}
