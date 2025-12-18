package org.example.task1.factory;

import java.sql.SQLException;

public interface Factory<T> {
    T createInstance() throws SQLException;
}
