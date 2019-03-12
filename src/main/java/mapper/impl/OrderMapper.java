package mapper.impl;

import dto.impl.OrderDto;
import entity.Order;
import mapper.Mapper;

public class OrderMapper implements Mapper<OrderDto, Order> {
    @Override
    public Order mapToObject(OrderDto origin) {
        return new Order();
    }

    @Override
    public OrderDto mapToDto(Order object) {
        return new OrderDto();
    }
}
