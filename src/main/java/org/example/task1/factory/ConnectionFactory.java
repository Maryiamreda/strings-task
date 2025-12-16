package org.example.task1.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;
    private static final String url = "jdbc:mariadb://localhost:3306/funfunier?user=root&password=root";
    private ConnectionFactory(){
    }
    static public Connection createConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url);
        }
        return connection;
    }
}
