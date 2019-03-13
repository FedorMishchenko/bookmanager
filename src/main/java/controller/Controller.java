package controller;

public interface Controller<T> {
    T post(T entity);
    T get(T entity);
    T put(T oldEntity, T newEntity);
    void delete(T entity);
}
