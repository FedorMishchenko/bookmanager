package exceptions;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class MyApplicationException extends RuntimeException {
    private static final Logger log = Logger.getLogger(MyApplicationException.class);
    public MyApplicationException(String massage, @NotNull Exception e) {
        log.warn(massage);
        log.warn(e.getCause());
    }
}
