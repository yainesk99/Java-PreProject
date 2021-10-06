package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl  implements UserService {
    UserDaoHibernateImpl daoHibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {
        daoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
        daoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        daoHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        daoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return daoHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        daoHibernate.cleanUsersTable();

    }
}
