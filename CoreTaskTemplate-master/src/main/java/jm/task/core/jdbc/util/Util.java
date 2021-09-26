package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    // реализуйте настройку соеденения с БД
    private final String driverName = "com.mysql.cj.jdbc.Driver";
    private final String connectionString = "jdbc:mysql://localhost:3306/sys";
    private final String login = "root";
    private final String password = "root";


    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(connectionString, login, password);
        return conn;
    }
}
