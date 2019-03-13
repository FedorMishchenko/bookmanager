package dao;

import common.SqlQueries;
import entity.Book;
import entity.Order;
import exceptions.MyDaoException;
import repository.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDao implements EntityDao<Order> {
    @Override
    public Order create(Order object) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.CREATE_ORDER);
                statement.setInt(1, object.getUserId());
                statement.setInt(2, object.getBookId());
                statement.executeUpdate();
                return get(object);
        }catch (SQLException e) {
            throw new MyDaoException("SQLException in OrderDao create", e);
        }
    }

    @Override
    public Order get(Order object) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.GET_ORDER);
            statement.setInt(1, object.getUserId());
            ResultSet resultSet = statement.executeQuery();
            PreparedStatement statement2 = connection.prepareStatement(
                    SqlQueries.GET_BOOK);
            statement2.setInt(1, object.getBook().getId());
            ResultSet result = statement2.executeQuery();
            Book book = new Book()
                    .setId(result.getInt(1))
                    .setName(result.getString(2))
                    .setAuthor(result.getString(3))
                    .setPrice(result.getDouble(4));
            return new Order()
                    .setId(resultSet.getInt(1))
                    .setUserId(resultSet.getInt(2))
                    .setBookId(resultSet.getInt(3))
                    .setBook(book);
        }catch (SQLException e) {
            throw new MyDaoException("SQLException in OrderDao get", e);
        }
    }

    @Override
    public Order update(Order oldObject, Order newObject) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.UPDATE_ORDER);
            Order order = get(oldObject);
            statement.setInt(1, order.getId());
            statement.setInt(2, newObject.getUserId());
            statement.setInt(3, newObject.getBookId());
            statement.setInt(4, order.getUserId());
            statement.executeUpdate();
            return get(newObject);
        }catch (SQLException e) {
            throw new MyDaoException("SQLException in OrderDao update", e);
        }
    }

    @Override
    public void delete(Order object) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.DELETE_ORDER);
            statement.setInt(1, object.getId());
            statement.executeUpdate();
        }catch (SQLException e) {
            throw new MyDaoException("SQLException in OrderDao delete", e);
        }
    }
}
