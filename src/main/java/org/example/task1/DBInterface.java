package org.example.task1;

public interface DBInterface<T> {
    void insert(T o);
    T get(Long id);
//    List<T> get(T o);
}
