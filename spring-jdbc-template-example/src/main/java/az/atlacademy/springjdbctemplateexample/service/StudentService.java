package az.atlacademy.springjdbctemplateexample.service;

import az.atlacademy.springjdbctemplateexample.dao.StudentDao;
import az.atlacademy.springjdbctemplateexample.exception.StudentNotFoundException;
import az.atlacademy.springjdbctemplateexample.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentDao<Student> studentDao;

    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public Student findById(Long id) {
        return studentDao.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
    }

    public void save(Student student) {
        studentDao.save(student);
    }

    public void updateStudent(Long id, Student student) {
        studentDao.updateStudent(id, student);
    }

    public void deleteStudent(Long id) {
        studentDao.deleteStudent(id);
    }

}
