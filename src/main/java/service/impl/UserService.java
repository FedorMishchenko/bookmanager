package service.impl;

import dao.UserDao;
import entity.User;
import exceptions.MyApplicationException;
import service.Service;

public class UserService implements Service<User> {
    private UserDao userDao;
    public UserService(){
        userDao = new UserDao();
    }

    @Override
    public User create(User object) {
        try {
            return userDao.create(object);
        }catch (Exception e){
            throw new MyApplicationException("Exception in UserService create", e);
        }
    }

    @Override
    public User get(User object) {

        try {
            return userDao.get(object);
        }catch (Exception e){
            throw new MyApplicationException("Exception in UserService get", e);
        }
    }

    @Override
    public User update(User oldObject, User newObject) {

        try {
            return userDao.update(oldObject, newObject);
        }catch (Exception e){
            throw new MyApplicationException("Exception in UserService update", e);
        }
    }

    @Override
    public void delete(User object) {
        try {
            userDao.delete(object);
        }catch (Exception e){
            throw new MyApplicationException("Exception in UserService delete", e);
        }
    }
}
