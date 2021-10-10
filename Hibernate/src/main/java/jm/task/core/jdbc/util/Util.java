package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


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

    static final String connectionString = "jdbc:mysql://localhost:3306/sys";
    static final String login = "root";
    static final String password = "root";

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(connectionString, login, password);
        return conn;
    }

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();


                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, connectionString);
                settings.put(Environment.USER, login);
                settings.put(Environment.PASS, password);
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (SessionFactory) sessionFactory;
    }

}
