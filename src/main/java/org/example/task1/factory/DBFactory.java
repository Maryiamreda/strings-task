package org.example.task1.factory;
import org.example.task1.DBController;

import java.sql.SQLException;

public class DBFactory implements Factory<DBController>{
    private static DBController dbController;
    public   DBController createInstance() throws SQLException {
        if (dbController == null) {
            dbController = new DBController();
        }
        return dbController;
    }
}
