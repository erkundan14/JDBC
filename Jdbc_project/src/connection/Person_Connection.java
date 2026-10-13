package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Person_Connection {

    private static final String url = "jdbc:mysql://localhost:3306/jdbc_project";
    private static final String username = "root";
    private static final String password = "73017";

    public Connection getConnection() {

        try {
            // 1. Load and register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Get database connection
            Connection connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                return connection;
            } else {
                System.out.println("Something is wrong, please check again");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}