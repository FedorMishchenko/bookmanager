package dto.dtohandler;


import dto.impl.OrderDto;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class OrderDtoHandler extends DtoHandler{
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
}
