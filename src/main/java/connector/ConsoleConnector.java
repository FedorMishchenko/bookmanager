package connector;

import controller.Controller;
import controller.impl.BookController;
import controller.impl.OrderController;
import controller.impl.UserController;
import dto.EntityDto;
import dto.dtohandler.BookDtoHandler;
import dto.dtohandler.DtoHandler;
import dto.dtohandler.OrderDtoHandler;
import dto.dtohandler.UserDtoHandler;
import dto.impl.UserDto;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleConnector {
    private static final Logger log = Logger.getLogger(ConsoleConnector.class);
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Controller> commandMap;
    private static Map<String, DtoHandler> session;

    public static void init() {
        commandMap = new HashMap<>();
        commandMap.put("user", new UserController());
        commandMap.put("order", new OrderController());
        commandMap.put("item", new BookController());
        session = new HashMap<>();
        session.put("user", new UserDtoHandler());
        session.put("order", new OrderDtoHandler());
        session.put("item", new BookDtoHandler());

    }

    public static void start() {
        while (true) {
            log.info("Enter command: user, order, book");
            start(scanner.nextLine());
        }
    }

    private static void start(String command) {
        Controller controller = commandMap.get(command);
        DtoHandler handler = session.get(command);
        switch (command) {
            case "user":
                handler.transfer(controller);
                break;
            case "order":
                handler.transfer(controller);
                break;
            case "item":
                handler.transfer(controller);
                break;
        }
    }
}
