package entity;

import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class User {
    private Integer id;
    private String login;
    private Integer order;


    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public Integer getOrder() {
        return order;
    }

    public User setOrder(Integer order) {
        this.order = order;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getLogin().equals(user.getLogin()) &&
                Objects.equals(getOrder(), user.getOrder()) &&
                getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", order=").append(order);

        sb.append('}');
        return sb.toString();
    }
}
