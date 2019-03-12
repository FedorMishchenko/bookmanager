package exceptions;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class MyDaoException extends RuntimeException{
    private static final Logger log = Logger.getLogger(MyDaoException.class);
    public MyDaoException(String massage, @NotNull SQLException e) {
        log.warn(massage);
        log.warn(e.getCause());
    }
}
