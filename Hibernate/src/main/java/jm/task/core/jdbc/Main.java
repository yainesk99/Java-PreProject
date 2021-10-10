package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static jm.task.core.jdbc.util.Util.*;

public class Main {

    public static void main(String[] args) throws HibernateException, SQLException {

        User user1 = new User("Ivan", "Ivanov", (byte) 5);
        User user2 = new User("Kseniya", "Chechulova", (byte) 22);
        User user3 = new User("Oksana", "Markitan", (byte) 33);
        User user4 = new User("Artsiom", "Makartsou", (byte) 23);

        UserService service = new UserServiceImpl();
        service.createUsersTable();

        UserService service1 = new UserServiceImpl();
        service1.saveUser(user1.getName(), user1.getLastName(), user1.getAge());

        UserService service2 = new UserServiceImpl();
        service2.saveUser(user2.getName(), user2.getLastName(), user2.getAge());

        UserService service3 = new UserServiceImpl();
        service3.saveUser(user3.getName(), user3.getLastName(), user3.getAge());

        UserService service4 = new UserServiceImpl();
        service4.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        UserService service5 = new UserServiceImpl();
        service5.removeUserById(1);

        UserService service8 = new UserServiceImpl();
        service8.getAllUsers();

        UserService service7 = new UserServiceImpl();
        service7.cleanUsersTable();

        UserService service6 = new UserServiceImpl();
        service6.dropUsersTable();
    }
}








