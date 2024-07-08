package az.atlacademy.module03.lesson62;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgres {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "mysecretpassword");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
