package entity;

import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class Order {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Book book;

    public Book getBook() {
        return book;
    }

    public Order setBook(Book book) {
        this.book = book;
        return this;
    }

    public Integer getBookId() {
        return bookId;
    }

    public Order setBookId(Integer bookId) {
        this.bookId = bookId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Order setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Order setId(Integer id) {
        this.id = id;
        return this;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getBookId(), order.getBookId()) &&
                Objects.equals(getUserId(), order.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getUserId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(bookId);
        sb.append(", bookId=").append(userId);
        sb.append(book.toString());
        sb.append('}');
        return sb.toString();
    }
}
