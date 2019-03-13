package dto.impl;

import dto.EntityDto;
import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class BookDto implements EntityDto {
    private Integer id;
    private String name;
    private String author;
    private Double price;

    public String getName() {
        return name;
    }

    public BookDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookDto setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public BookDto setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public BookDto setId(Integer id) {
        this.id = id;
        return this;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDto)) return false;
        BookDto bookDto = (BookDto) o;
        return getName().equals(bookDto.getName()) &&
                getAuthor().equals(bookDto.getAuthor()) &&
                getPrice().equals(bookDto.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAuthor(), getPrice());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookDto{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
