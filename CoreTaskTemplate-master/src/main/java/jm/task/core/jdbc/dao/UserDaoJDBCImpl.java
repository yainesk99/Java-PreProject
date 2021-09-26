package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.hql.internal.ast.SqlASTFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection;

    {
        try {
            connection = new Util().getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sqlCommand = "CREATE TABLE IF NOT EXISTS sys.myTable (Id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), lastName VARCHAR(20),age SMALLINT);";
        try (Statement statement = new Util().getConnection().createStatement()) {
            statement.execute(sqlCommand);
            System.out.println("База данных создана");
        } catch (SQLException throwables) {
            System.out.println("Соединение не установлено");
            System.out.println(throwables);
        }
    }

    public void dropUsersTable() {
        String sqlCommand = "DROP TABLE IF  EXISTS sys.myTable;";
        try (Statement statement = new Util().getConnection().createStatement()) {
            statement.execute(sqlCommand);
            System.out.println("База данных удалена");
        } catch (SQLException throwables) {
            System.out.println("Соединение не установлено");
            System.out.println(throwables);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String Sqlinsert = "INSERT INTO sys.myTable (name, lastName, age) VALUES(?,?,?);";
        try (PreparedStatement prSt =  new Util().getConnection().prepareStatement(Sqlinsert)){
            prSt.setString(1,name);
            prSt.setString(2, lastName);
            prSt.setByte(3, age);

            prSt.executeUpdate();
            System.out.println("User с именем " + name + " добавлен в БД");
        } catch (SQLException throwables) {
            System.out.println(throwables);
        }

     }

    public void removeUserById(long id) {
        String SqlDel = "DELETE FROM sys.myTable where id = ?;";
        try (Statement statement = (Statement) new Util().getConnection().prepareStatement(SqlDel)){
            System.out.println("User с id " + id +  " удален из  БД");
        } catch (SQLException throwables) {
            System.out.println(throwables);
        }
    }

    public List<User> getAllUsers() {
        String SqlGetAll = "SELECT * FROM sys.myTable;";
       List<User> resilts = new ArrayList<>();
       ResultSet rs = null;
        try (PreparedStatement prSt =  new Util().getConnection().prepareStatement(SqlGetAll)){
             rs = prSt.executeQuery(SqlGetAll);

                while (rs.next()) {
                    String name = rs.getString(2);
                    String lastName = rs.getString(3);
                    byte age = rs.getByte(4);
                    resilts.add(new User(name,lastName,age));
                    System.out.println(resilts);
                }

                if (resilts.size() > 0) {
                    System.out.println(resilts);
                } else {
                    System.out.println("Not found");
                }
            } catch (SQLException e) {
            e.printStackTrace();
        }

        return resilts;
    }


        public void cleanUsersTable() {
        String sqlClean = "TRUNCATE TABLE  sys.myTable; ";
        try (Statement statement = new Util().getConnection().createStatement()) {
            statement.execute(sqlClean);
            System.out.println("База данных очищена");
        } catch (SQLException throwables) {
            //System.out.println("Соединение не установлено");
            System.out.println(throwables);
        }

    }
}
