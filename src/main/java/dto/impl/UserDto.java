package dto.impl;

import dto.EntityDto;
import entity.Order;
import org.jetbrains.annotations.Contract;

import java.util.List;
import java.util.Objects;

public class UserDto implements EntityDto {
    private String login;
    private Integer id;
    private List<Order> orders;

    public String getLogin() {
        return login;
    }

    public UserDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public UserDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public UserDto setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return getLogin().equals(userDto.getLogin()) &&
                Objects.equals(getId(), userDto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDto{");
        sb.append("login='").append(login).append('\'');
        sb.append(", id=").append(id);
        sb.append(", orders=").append(orders);
        sb.append('}');
        return sb.toString();
    }
}
