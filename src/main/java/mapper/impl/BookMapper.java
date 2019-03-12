package mapper.impl;

import dto.impl.BookDto;
import entity.Book;
import mapper.Mapper;

public class BookMapper implements Mapper<BookDto, Book> {
    @Override
    public Book mapToObject(BookDto origin) {
        return new Book();
    }

    @Override
    public BookDto mapToDto(Book object) {
        return new BookDto();
    }
}
