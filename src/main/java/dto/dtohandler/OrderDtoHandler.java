package dto.dtohandler;


import controller.Controller;
import controller.impl.OrderController;
import dto.impl.OrderDto;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class OrderDtoHandler extends DtoHandler<OrderDto, OrderController>{
    private static final Logger log = Logger.getLogger(OrderDtoHandler.class);
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public OrderDto init() {
        log.info("Enter book id:");
        Integer bookId = scanner.nextInt();
        log.info("Enter user id:");
        Integer userId = scanner.nextInt();
        return new OrderDto().setBookId(bookId).setUserId(userId);
    }

    @Override
    public OrderDto transfer(OrderController controller) {
        return null;
    }
}
