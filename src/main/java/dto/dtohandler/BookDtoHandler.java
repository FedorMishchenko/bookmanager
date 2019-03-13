package dto.dtohandler;

import controller.impl.BookController;
import dto.impl.BookDto;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class BookDtoHandler extends DtoHandler<BookDto, BookController>{
    private static final Logger log = Logger.getLogger(BookDtoHandler.class);
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public BookDto init() {
        String name = scanner.nextLine();
        String author = scanner.nextLine();
        Double price = scanner.nextDouble();
        return new BookDto().setName(name).setAuthor(author).setPrice(price);
    }

    @Override
    public BookDto transfer(BookController controller) {
        return null;
    }
}
