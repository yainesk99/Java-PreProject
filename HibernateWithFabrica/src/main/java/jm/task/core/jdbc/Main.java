package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import org.hibernate.HibernateException;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws HibernateException, SQLException {

        User user1 = new User("Ivan", "Ivanov", (byte) 5);
        User user2 = new User("Kseniya", "Chechulova", (byte) 22);
        User user3 = new User("Oksana", "Markitan", (byte) 33);
        User user4 = new User("Artsiom", "Makartsou", (byte) 23);

        UserService service = new UserServiceImpl();
        service.createUsersTable();
        service.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        service.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        service.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        service.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        service.removeUserById(1);
        service.getAllUsers();
        service.cleanUsersTable();
        service.dropUsersTable();
    }
}








