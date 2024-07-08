package az.atlacademy.module03.lesson62;

public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student findById(Long id) {
        return studentDao.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found wit id " + id));
    }

    public void save(Student student) {
        studentDao.save(student);
    }

    public void updateStudent(Long id, Student student) {
        studentDao.updateStudent(id, student);
    }

}
