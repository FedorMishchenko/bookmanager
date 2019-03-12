package dao;

import common.SqlQueries;
import entity.User;
import exceptions.MyDaoException;
import repository.DBFactory;

import java.sql.*;

public class UserDao implements EntityDao<User> {
    @Override
    public User create(User object) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.CREATE_USER);
            statement.setString(1, object.getLogin());
            statement.executeUpdate();
            return get(object);
        } catch (SQLException e) {
            throw new MyDaoException("SQLException in UserDao create", e);
        }
    }

    @Override
    public User get(User object) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.GET_USER);
            statement.setString(1, object.getLogin());
            ResultSet resultSet = statement.executeQuery();
            return new User().setId(resultSet.getInt(1))
                    .setLogin(resultSet.getString(2))
                    .setOrder(resultSet.getInt(3));
        } catch (SQLException e) {
            throw new MyDaoException("SQLException in UserDao get", e);
        }
    }

    @Override
    public User update(User oldObject, User newObject) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            User user = get(oldObject);
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.UPDATE_USER);
            statement.setInt(1, user.getId());
            statement.setString(2, newObject.getLogin());
            statement.setInt(3,newObject.getOrder());
            statement.setString(4,user.getLogin());
            statement.executeUpdate();
            return get(newObject);
        } catch (SQLException e) {
            throw new MyDaoException("SQLException in UserDao update", e);
        }
    }

    @Override
    public void delete(User object) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.DELETE_USER);
            statement.setString(1, object.getLogin());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new MyDaoException("SQLException in UserDao delete", e);
        }
    }
}
