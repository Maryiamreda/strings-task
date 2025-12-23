package org.example.task1;

import java.lang.reflect.Field;

import java.sql.*;


public class DBController implements DBInterface {
    private final Connection connection;

    public DBController() throws SQLException {
        //jdbc builds communication between java and db
        //Establish a Connection
        String url = "jdbc:mariadb://localhost:3306/funfunier?user=root&password=root";
        connection = DriverManager.getConnection(url);
        // Prepared and Callable Statement interfaces enable sending sql commands and receive data from your database.
    }

    @Override
    public int insert(Object myobject) {
        //INSERT INTO stringfunifier (boring_string,funny_string) VALUES (?,?)
        StringBuilder myQuery = new StringBuilder();
        StringBuilder fieldNames = new StringBuilder();
        StringBuilder insertedValues = new StringBuilder();
        myQuery.append("INSERT INTO " + myobject.getClass().getSimpleName() + " (");
        int id = -1;
        try {
            Field[] fields = myobject.getClass().getDeclaredFields();
            //column names
            for (int i = 1; i < fields.length; ) {
                fieldNames.append(fields[i].getName());
                fields[i].setAccessible(true);
                insertedValues.append('"').append(fields[i].get(myobject)).append('"');
                if (i++ != fields.length - 1) {
                    fieldNames.append(",");
                    insertedValues.append(",");
                    continue;
                }
                fieldNames.append(") VALUES (");
                insertedValues.append(") ");
            }
            myQuery.append(fieldNames).append(insertedValues);
            System.out.println(myQuery);
            Statement statement = connection.createStatement();
            statement.executeQuery(String.valueOf(myQuery));
            ResultSet result = statement.executeQuery("SELECT LAST_INSERT_ID()");
            if (result.next()) { //return one row with one value
                System.out.println(result);
                id = result.getInt(1); //integer value from first column
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public Object get(Object myobject) throws SQLException {
        //SELECT * FROM table name;
        Object result;
        try {
            result = myobject.getClass().getDeclaredConstructor().newInstance();
            Field myId = myobject.getClass().getDeclaredField("id");
            myId.setAccessible(true);
            StringBuilder myQuery = new StringBuilder("SELECT * FROM " + myobject.getClass().getSimpleName() + " WHERE id =" + myId.get(myobject));
            Statement statement = connection.createStatement();
            System.out.println(myQuery);
            ResultSet resultSet = statement.executeQuery(String.valueOf(myQuery));
            Field[] fields = myobject.getClass().getDeclaredFields();
            while (resultSet.next()) {
                for (Field field : fields) {
                    field.setAccessible(true);
                    Object value = resultSet.getObject(field.getName());
                    field.set(result, value); // this is to set the value of the field represented by this Field object
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
