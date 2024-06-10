package az.atlacademy.module02.lesson53;

public class StudentService {

    private final StudentDao<Student> studentDao;

    public StudentService(StudentDao<Student> studentDao) {
        this.studentDao = studentDao;
    }

    public Student findByName(String name){
      return studentDao.findByName(name)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with name " + name));
    }

}
