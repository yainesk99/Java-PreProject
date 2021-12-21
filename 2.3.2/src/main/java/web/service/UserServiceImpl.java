package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Repository
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao ud;

    @Override
    public void addUser(User user) {
        ud.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        ud.updateUser(user);
    }

    @Override
    public void removeUser(int id) {
        ud.removeUser(id);
    }

    @Override
    public User getUserById(int id) {
        return ud.getUserById(id);
    }

    @Override
    public List<User> listUser() {
        return ud.listUser();
    }
}
