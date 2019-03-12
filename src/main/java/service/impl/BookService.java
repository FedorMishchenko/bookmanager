package service.impl;

import dao.BookDao;
import entity.Book;
import service.Service;

public class BookService implements Service<Book> {
    private BookDao bookDao;
    public BookService(){
        bookDao = new BookDao();
    }

    @Override
    public Book create(Book object) {
        return null;
    }

    @Override
    public Book get(Book object) {
        return null;
    }

    @Override
    public Book update(Book oldObject, Book newObject) {
        return null;
    }

    @Override
    public void delete(Book object) {

    }
}
