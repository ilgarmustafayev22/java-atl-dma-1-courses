package az.atlacademy.springjdbctemplateexample.dao;

import az.atlacademy.springjdbctemplateexample.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentJdbcTemplateDao implements StudentDao<Student> {

    public static final String FIND_ALL_STUDENTS = "SELECT * FROM students;";
    private static final String FIND_STUDENT_BY_ID = "SELECT * FROM students WHERE id = ?;";

    public static final String UPDATE_STUDENT = "UPDATE students\n" +
            "SET name = ?,\n" +
            "    surname = ?,\n" +
            "    age = ?\n" +
            "WHERE id = ?;";

    private static final String INSERT_INTO = "INSERT INTO students(name, surname, age) VALUES(?, ?, ?);";

    public static final String DELETE_STUDENT = "DELETE FROM students WHERE id = ?;";
    private JdbcTemplate jdbcTemplate;

    //@Autowired
    public StudentJdbcTemplateDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query(FIND_ALL_STUDENTS, BeanPropertyRowMapper.newInstance(Student.class));
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.of(jdbcTemplate.queryForObject(FIND_STUDENT_BY_ID, new Object[]{id}, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setSurname(rs.getString("surname"));
            student.setAge(rs.getInt("age"));
            return student;
        }));
    }

    @Override
    public void save(Student student) {
        jdbcTemplate.update(INSERT_INTO, student.getName(), student.getSurname(), student.getAge());
    }

    @Override
    public void updateStudent(Long id, Student student) {
        jdbcTemplate.update(UPDATE_STUDENT, student.getName(), student.getName(), student.getAge(), id);
    }

    @Override
    public void deleteStudent(Long id) {
        jdbcTemplate.update(DELETE_STUDENT, id);
    }

}
