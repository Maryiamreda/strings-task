package org.example.task1;

import java.sql.*;


public class FunFierRepository  {
    private final Connection connection;
    public FunFierRepository() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/funfunier?user=root&password=root";
        connection = DriverManager.getConnection(url);
    }


//    public void addNew(StringFunfierEntity data) throws SQLException {
//        //pre-compiled SQL statemen
//        PreparedStatement prepare_statement = connection.prepareStatement("INSERT INTO stringfunifier (boring_string,funny_string) VALUES (?,?)");
//        prepare_statement.setString(1, data.boringString);
//        prepare_statement.setString(2, data.funnyString);
//        prepare_statement.executeUpdate();
//        Statement st = connection.createStatement();
//        ResultSet result = st.executeQuery("SELECT LAST_INSERT_ID()");
//        int id = 0;
//        if (result.next()) { //return one row with one value
//            id = result.getInt(1); //integer value from first column
//        }
////        int j = data.startRange.size();
////        for (int i = 0; i < j; i++) {
////            String op = (data.operations != null) ? String.valueOf(data.operations.get(i)) : "NONE";
////            addNewOperation(op, data.startRange.get(i), data.endRange.get(i), id);
////        }
//    }

    private void addNewOperation(String opName, int start_range, int end_range, int parent_log) throws SQLException {
        String q = "INSERT INTO operation (name, start_range, end_range, boring_string) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(q); // Dynamic sql -- better for SQL injection
        ps.setString(1, opName);
        ps.setInt(2, start_range);
        ps.setInt(3, end_range);
        ps.setInt(4, parent_log);
        ps.executeUpdate();
    }

//    public void addNewOp(Object data) throws SQLException {
//        StringFunfierEntity stringFunfier=(StringFunfierEntity)  data;
//        //pre-compiled SQL statemen
//        PreparedStatement prepare_statement = connection.prepareStatement("INSERT INTO stringfunifier (boring_string,funny_string) VALUES (?,?)");
//        prepare_statement.setString(1, stringFunfier.boringString);
//        prepare_statement.setString(2, stringFunfier.funnyString);
//        prepare_statement.executeUpdate();
//        Statement st = connection.createStatement();
//        ResultSet result = st.executeQuery("SELECT LAST_INSERT_ID()");
//        int id = 0;
//        if (result.next()) { //return one row with one value
//            id = result.getInt(1); //integer value from first column
//        }
//        int j=stringFunfier.startRange.size();
//        for (int i = 0; i < j; i++) {
//            String op = (stringFunfier.operations != null) ? String.valueOf(stringFunfier.operations .get(i)) : "NONE";
//            addNewOperation(op, stringFunfier.startRange.get(i), stringFunfier.endRange.get(i), id);
//        }
//    }

}
