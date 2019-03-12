package dto.impl;

import dto.EntityDto;
import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class OrderDto implements EntityDto {
    private Integer bookId;
    private Integer userId;
    private Integer id;

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
        sb.append("bookId=").append(bookId);
        sb.append(", userId=").append(userId);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
