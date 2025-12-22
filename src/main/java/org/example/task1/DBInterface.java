package org.example.task1;

import java.sql.SQLException;

public interface DBInterface<T> {
    int insert(T o) throws SQLException;
    T get(T o) throws SQLException;
}
