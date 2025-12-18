package org.example.task1;

import java.sql.SQLException;
import java.util.List;

public interface DBInterface<T> {
    void insert(T o) throws SQLException;
    T get(Long id);

//    List<T> get(T o);
}
