package az.atlacademy.module03.lesson55;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StudentPostgresDao implements StudentDao<Student> {

    private static final String FIND_STUDENT_BY_NAME = "SELECT * FROM students WHERE name = ?;";

    private static final String INSERT_INTO = "INSERT INTO students(name, surname, age) VALUES(?, ?, ?);";

    public static final String UPDATE_STUDENT = "UPDATE students\n" +
            "SET name = ?,\n" +
            "    surname = ?,\n" +
            "    age = ?\n" +
            "WHERE id = ?;";

    public static final String DELETE_STUDENT = "DELETE  FROM students WHERE id = ?;";

    public static final String GET_ALL_STUDENTS = "SELECT * FROM students;";

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
            Student student = new Student(id, studentName, surname, age);
            return Optional.of(student);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(Student student) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "mysecretpassword");

            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setInt(3, student.getAge());

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateStudent(Long id, Student student) {
        try (final Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "mysecretpassword")) {

            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setLong(4, id);

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(Long id) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "mysecretpassword")) {
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_STUDENT);
            preparedStatement.setLong(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> findAllStudents() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "mysecretpassword")) {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_STUDENTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                students.add(new Student(id, name, surname, age));
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
