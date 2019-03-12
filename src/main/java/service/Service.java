package service;

public interface Service<T> {
    T create(T object);
    T get(T object);
    T update(T oldObject, T newObject);
    void delete(T object);
}
