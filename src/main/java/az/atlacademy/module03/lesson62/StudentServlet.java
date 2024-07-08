package az.atlacademy.module03.lesson62;

import az.atlacademy.module03.lesson55.StudentNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.OutputStream;

public class StudentServlet extends HttpServlet {

    private final StudentService studentService;
    private final ObjectMapper objectMapper;

    public StudentServlet(StudentService studentService, ObjectMapper objectMapper) {
        this.studentService = studentService;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        if (id.isEmpty() || id == null) {
            resp.setStatus(HttpStatus.BAD_REQUEST_400);
            try (OutputStream os = resp.getOutputStream()) {
                String messsage = "id: [" + id + "] is invalid!";
                os.write(messsage.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Student student = null;
        try {
            student = studentService.findById(Long.valueOf(id));
        } catch (StudentNotFoundException se) {
            resp.setStatus(HttpStatus.NOT_FOUND_404);
            try (OutputStream os = resp.getOutputStream()) {
                os.write(se.getMessage().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            se.printStackTrace();
        }

        try {
            byte[] bytes = objectMapper.writeValueAsBytes(student);
            try (OutputStream os = resp.getOutputStream()) {
                resp.setContentType(MediaType.APPLICATION_JSON);
                os.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JsonProcessingException e) {
            resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR_500);
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");

        if (name == null || name.isEmpty() || surname == null || surname.isEmpty() || age == null || age.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required parameters");
        }

        int parsedAge = 0;
        try {
            assert age != null;
            parsedAge = Integer.parseInt(age);
            if (parsedAge <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid age format");
        }
        studentService.save(new Student(name, surname, parsedAge));
        resp.setStatus(HttpStatus.CREATED_201);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");
        String id = req.getParameter("id");

        if (name == null || name.isEmpty() || surname == null || surname.isEmpty() || age == null || age.isEmpty() || id == null || id.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required parameters");
        }

        int parsedAge = 0;
        try {
            assert age != null;
            parsedAge = Integer.parseInt(age);
            if (parsedAge <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid age format");
        }

        long parsedId = 0;
        try {
            assert id != null;
            parsedId = Long.parseLong(id);
            if (parsedId <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid age format");
        }
        studentService.updateStudent(parsedId, new Student(name, surname, parsedAge));
        resp.setStatus(HttpStatus.OK_200);
    }

}
