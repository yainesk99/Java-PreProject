package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends Util implements UserService {
    UserDaoJDBCImpl daoJDBC = new UserDaoJDBCImpl();

    public void createUsersTable()  {
        daoJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        daoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        daoJDBC.saveUser(name,lastName,age);
    }
    public void removeUserById(long id) {

        daoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return daoJDBC.getAllUsers();

    }

    public void cleanUsersTable() {
        daoJDBC.cleanUsersTable();

    }
}
