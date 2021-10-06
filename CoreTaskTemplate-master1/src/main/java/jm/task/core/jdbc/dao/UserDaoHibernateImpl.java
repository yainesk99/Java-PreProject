package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.*;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        try (Session session = (Session) getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS sys.Users (Id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), lastName VARCHAR(20),age SMALLINT);";
            session.createSQLQuery(sql).addEntity(User.class);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try (Session session = (Session) getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String sql = "DROP TABLE IF NOT EXISTS sys.Users;";
            session.createSQLQuery(sql).addEntity(User.class);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = (Session) getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = (Session) getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(session.find(User.class, id));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {

        Transaction transaction = null;
        List<User> list = new ArrayList<>();

        try (Session session = (Session) getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
//            Query query = session.createSQLQuery("select u from User u");
//            list = query.list();

            list = session.createQuery("FROM User", User.class).list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try (Session session = (Session) getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.createSQLQuery("TRUNCATE TABLE  sys.users").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
