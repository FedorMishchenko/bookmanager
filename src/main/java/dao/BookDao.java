package dao;

import common.SqlQueries;
import entity.Book;
import exceptions.MyDaoException;
import repository.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao implements EntityDao<Book> {
    @Override
    public Book create(Book object) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.CREATE_BOOK);
            statement.setString(1, object.getName());
            statement.setString(2, object.getAuthor());
            statement.setDouble(3, object.getPrice());
            statement.executeUpdate();
            return get(object);
        }catch (SQLException e) {
            throw new MyDaoException("SQLException in BookDao create", e);
        }
    }

    @Override
    public Book get(Book object) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.GET_BOOK);
            statement.setInt(1, object.getId());
            ResultSet resultSet = statement.executeQuery();
            return new Book().setId(resultSet.getInt(1))
                    .setName(resultSet.getString(2))
                    .setAuthor(resultSet.getString(3))
                    .setPrice(resultSet.getDouble(4));
        }catch (SQLException e) {
            throw new MyDaoException("SQLException in BookDao get", e);
        }
    }

    @Override
    public Book update(Book oldObject, Book newObject) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.UPDATE_BOOK);
            Book book = get(oldObject);
            statement.setInt(1, book.getId());
            statement.setString(2, newObject.getName());
            statement.setString(3, newObject.getAuthor());
            statement.setDouble(4, newObject.getPrice());
            statement.setInt(5, book.getId());
            statement.executeUpdate();
            return get(newObject);
        }catch (SQLException e) {
            throw new MyDaoException("SQLException in BookDao update", e);
        }
    }

    @Override
    public void delete(Book object) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.DELETE_BOOK);
            statement.setInt(1, object.getId());
            statement.executeUpdate();
        }catch (SQLException e) {
            throw new MyDaoException("SQLException in BookDao delete", e);
        }
    }
}
