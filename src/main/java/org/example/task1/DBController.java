package org.example.task1;

import java.sql.*;
import java.util.List;

public class DBController {
    private final Connection connection;
    private final String url = "jdbc:mariadb://localhost:3306/funfunier?user=root&password=root";
    public DBController() throws SQLException {
        //jdbc builds communication between java and db
        //Establish a Connection
        connection = DriverManager.getConnection(url);
        // Prepared and Callable Statement interfaces enable sending sql commands and receive data from your database.
    }
    void addNewFunfierOp(String boringString , String funnyString , List<Integer> startRanges, List<Integer> endRanges, List<Operations> operationsList ) throws SQLException {
        //pre-compiled SQL statemen
        PreparedStatement prepare_statement = connection.prepareStatement("INSERT INTO stringfunifier (boring_string,funny_string) VALUES (?,?)");
        prepare_statement.setString(1, boringString);
        prepare_statement.setString(2, funnyString);
        prepare_statement.executeUpdate();
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery("SELECT LAST_INSERT_ID()");
        int id = 0;
        if (result.next()) { //return one row with one value
            id = result.getInt(1); //integer value from first column
        }
        for (int i = 0; i < startRanges.size(); i++) {
            addNewOperation(operationsList.get(i),startRanges.get(i), endRanges.get(i) ,id );
        }
    }
  private void addNewOperation(Operations opName, int start_range,int end_range, int parent_log) throws SQLException {
        String q = "INSERT INTO operation (name, start_range, end_range, boring_string) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(q); // Dynamic sql -- better for SQL injection
        ps.setString(1, String.valueOf(opName));
        ps.setInt(2, start_range);
        ps.setInt(3, end_range);
        ps.setInt(4, parent_log);
        ps.executeUpdate();
    }
//            dbController.addNewOperation(
//                    String.valueOf(operationsList.get(rangeIndex)),
//                    operationSubString,
//                    editedSubstring,
//                    startRanges.get(rangeIndex),
//                    endRanges.get(rangeIndex),
//                    id);
}
