package az.atlacademy.module02.lesson53;

import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        String name = sc.next();

        final StudentDao<Student> studentPostgresDao = new StudentPostgresDao();
        final StudentService studentService = new StudentService(studentPostgresDao);
        final StudentController studentController = new StudentController(studentService);

        Student byName = studentController.findByName(name);
        System.out.println(byName);

    }

}
