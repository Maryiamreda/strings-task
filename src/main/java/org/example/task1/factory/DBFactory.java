package org.example.task1.factory;
import org.example.task1.DBController;

import java.sql.SQLException;

public class DBFactory {
    private static DBController dbController;
    private DBFactory(){}
    static public DBController createDBController() throws SQLException {
        if (dbController == null) {
            dbController = new DBController();
        }
        return dbController;
    }
}
