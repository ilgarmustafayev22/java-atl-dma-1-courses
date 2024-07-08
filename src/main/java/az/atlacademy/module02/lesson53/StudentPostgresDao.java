package az.atlacademy.module02.lesson53;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentPostgresDao implements StudentDao<Student>{

    private static final String FIND_STUDENT_BY_NAME = "SELECT * FROM students WHERE name = ?;";

    @Override
    public Optional<Student> findByName(String name) {
        try (final Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "mysecretpassword")) {
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_STUDENT_BY_NAME);

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
                long id = resultSet.getLong("id");
                String studentName = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                Student student = new Student();
                student.setId(id);
                student.setName(studentName);
                student.setSurname(surname);
                student.setAge(age);
                return Optional.of(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
