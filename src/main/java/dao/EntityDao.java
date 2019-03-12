package dao;

public interface EntityDao<T> {
    T create(T object);
    T get(T object);
    T update(T oldObject, T newObject);
    void delete(T object);
}
