package service.impl;

import dao.UserDao;
import entity.User;
import service.Service;

public class UserService implements Service<User> {
    private UserDao userDao;
    public UserService(){
        userDao = new UserDao();
    }

    @Override
    public User create(User object) {
        return null;
    }

    @Override
    public User get(User object) {
        return null;
    }

    @Override
    public User update(User oldObject, User newObject) {
        return null;
    }

    @Override
    public void delete(User object) {

    }
}
