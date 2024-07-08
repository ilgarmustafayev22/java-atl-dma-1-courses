package az.atlacademy.module03.lesson54;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MaleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ServletOutputStream outputStream = resp.getOutputStream();
            //PrintWriter pw = resp.getWriter();
            outputStream.write("Hello Java".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
