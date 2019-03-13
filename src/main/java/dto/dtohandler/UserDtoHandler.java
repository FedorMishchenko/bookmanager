package dto.dtohandler;

import connector.ConsoleConnector;
import controller.impl.UserController;
import dto.impl.UserDto;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class UserDtoHandler extends DtoHandler<UserDto, UserController>{
    private static final Logger log = Logger.getLogger(UserDtoHandler.class);
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public UserDto init(){
        log.info("Enter user login:");
        String login = scanner.nextLine();
        return new UserDto().setLogin(login);
    }

    @Override
    public UserDto transfer(UserController controller) {
        UserDto userDto = init();
        while (true){
            log.info("Enter: post, get, up, del, exit");
            switch (scanner.nextLine()){
                case "post":
                    userDto = controller.post(userDto);
                    log.info(userDto.toString());
                    break;
                case "get":
                    userDto = controller.get(userDto);
                    log.info(userDto.toString());
                case "up":
                    userDto = controller.put(userDto,init());
                    log.info(userDto.toString());
                case "del":
                    controller.delete(userDto);
                    log.info(userDto.getLogin() + " successful deleted");
                case "exit":
                    ConsoleConnector.start();
            }
        }
    }


}
