package dto.dtohandler;

import dto.impl.UserDto;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class UserDtoHandler extends DtoHandler{
    private static final Logger log = Logger.getLogger(UserDtoHandler.class);
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public UserDto init(){
        log.info("Enter user login:");
        String login = scanner.nextLine();
        return new UserDto().setLogin(login);
    }

}
