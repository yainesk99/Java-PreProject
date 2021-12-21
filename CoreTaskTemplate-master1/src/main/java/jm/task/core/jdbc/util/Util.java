package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    // реализуйте настройку соеденения с БД
    public static Util instance;

    private Util() {
    }

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    final String connectionString = "jdbc:mysql://localhost:3306/sys";
    final String login = "root";
    final String password = "root";

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(connectionString, login, password);
        return conn;
    }
}
