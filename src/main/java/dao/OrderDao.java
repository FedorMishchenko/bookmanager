package dao;

import common.SqlQueries;
import entity.Order;
import exceptions.MyDaoException;
import repository.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDao implements EntityDao<Order> {
    @Override
    public Order create(Order object) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.CREATE_ORDER);

            return null;
        }catch (SQLException e) {
            throw new MyDaoException("SQLException in OrderDao create", e);
        }
    }

    @Override
    public Order get(Order object) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.GET_ORDER);

            return null;
        }catch (SQLException e) {
            throw new MyDaoException("SQLException in OrderDao get", e);
        }
    }

    @Override
    public Order update(Order oldObject, Order newObject) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.UPDATE_ORDER);
            
            return null;
        }catch (SQLException e) {
            throw new MyDaoException("SQLException in OrderDao update", e);
        }
    }

    @Override
    public void delete(Order object) {
        try (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    SqlQueries.DELETE_ORDER);

        }catch (SQLException e) {
            throw new MyDaoException("SQLException in OrderDao delete", e);
        }
    }
}
