package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws SQLException {
       Util util = new Util();
        util.getConnection();
        UserService service = new UserServiceImpl();
        service.createUsersTable();


        User user1 = new User("Ivan", "Ivanov", (byte)5);
        User user2 = new User("Kseniya", "Chechulova", (byte) 22);
        User user3 = new User("Oksana", "Markitan", (byte)33);
        User user4 = new User("Artsiom", "Makartsou", (byte)23);
        user1.setName("Ivan");
        user1.setLastName("Ivanov");
        user1.setAge((byte)5);

        user2.setName("Kseniya");
        user2.setLastName("Chechulova");
        user2.setAge((byte)22);

        user3.setName("Oksana");
        user3.setLastName("Markitan");
        user3.setAge((byte)33);

        user4.setName("Artsiom");
        user4.setLastName("akartsou");
        user4.setAge((byte)23);

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

       UserService service6 = new UserServiceImpl();
       service6.dropUsersTable();

        UserService service7 = new UserServiceImpl();
        service7.cleanUsersTable();

        UserService service8 = new UserServiceImpl();
        service8.getAllUsers();

       }
    }








