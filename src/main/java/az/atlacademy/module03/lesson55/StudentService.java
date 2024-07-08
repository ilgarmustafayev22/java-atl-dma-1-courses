package az.atlacademy.module03.lesson55;

import java.util.List;

public class StudentService {

    private final StudentDao<Student> studentDao;

    public StudentService(StudentDao<Student> studentDao) {
        this.studentDao = studentDao;
    }

    public Student findByName(String name){
      return studentDao.findByName(name)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with name " + name));
    }

    public void save(Student student){
        studentDao.save(student);
    }

    public void updateStudent(Long id, Student student){
        studentDao.updateStudent(id, student);
    }

    public void deleteStudent(Long id){
        studentDao.deleteStudent(id);
    }

    public List<Student> findAllStudents(){
        return studentDao.findAllStudents();
    }

}
