package service.impl;

import dao.OrderDao;
import entity.Order;
import service.Service;

public class OrderService implements Service<Order> {
    private OrderDao orderDao;
    public OrderService(){
        orderDao = new OrderDao();
    }

    @Override
    public Order create(Order object) {
        return null;
    }

    @Override
    public Order get(Order object) {
        return null;
    }

    @Override
    public Order update(Order oldObject, Order newObject) {
        return null;
    }

    @Override
    public void delete(Order object) {

    }
}
