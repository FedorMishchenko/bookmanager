package dto.impl;

import dto.EntityDto;
import entity.Book;
import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class OrderDto implements EntityDto {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Book book;

    public Book getBook() {
        return book;
    }

    public OrderDto setBook(Book book) {
        this.book = book;
        return this;
    }

    public Integer getBookId() {
        return bookId;
    }

    public OrderDto setBookId(Integer bookId) {
        this.bookId = bookId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public OrderDto setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public OrderDto setId(Integer id) {
        this.id = id;
        return this;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDto)) return false;
        OrderDto orderDto = (OrderDto) o;
        return getBookId().equals(orderDto.getBookId()) &&
                getUserId().equals(orderDto.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getUserId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDto{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", bookId=").append(bookId);
        sb.append(book.toString());
        sb.append('}');
        return sb.toString();
    }
}
