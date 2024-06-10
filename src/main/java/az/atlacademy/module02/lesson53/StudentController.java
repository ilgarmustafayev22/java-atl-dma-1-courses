package az.atlacademy.module02.lesson53;

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student findByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return studentService.findByName(name);
    }

}
