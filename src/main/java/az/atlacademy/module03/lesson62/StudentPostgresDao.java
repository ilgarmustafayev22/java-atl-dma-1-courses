package az.atlacademy.module03.lesson62;

import java.sql.*;
import java.util.Optional;

public class StudentPostgresDao implements StudentDao {

    private static final String FIND_BY_ID_SQL = "SELECT * FROM students WHERE id = ?;";

    private static final String INSERT_INTO = "INSERT INTO students(name, surname, age) VALUES(?, ?, ?);";

    public static final String UPDATE_STUDENT = "UPDATE students\n" +
            "SET name = ?,\n" +
            "    surname = ?,\n" +
            "    age = ?\n" +
            "WHERE id = ?;";

    @Override
    public Optional<Student> findById(Long id) {
        try {
            final Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "mysecretpassword");
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_BY_ID_SQL);

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long studentId = resultSet.getLong("id");
            String studentName = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            int age = resultSet.getInt("age");
            Student student = new Student(studentId, studentName, surname, age);
            conn.close();
            return Optional.of(student);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(Student student) {
        try{
            final Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStudent(Long id, Student student) {
        try{
            final Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "mysecretpassword");

            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setLong(4, id);

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
