package org.example.task1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
        int id =-1;
        try {

            Field[] fields = myobject.getClass().getDeclaredFields();
            Method[] method=myobject.getClass().getDeclaredMethods();
            System.out.println("after");
            //column names
            for (int i = 0; i < fields.length; ) {
                fieldNames.append(fields[i].getName());
                System.out.println(fields[i].getName());
                insertedValues.append('"');
                insertedValues.append(method[i].invoke(myobject));
                System.out.println("method is " + method[i].getName());
                insertedValues.append('"');
                if (i++ == fields.length - 1) {
                    fieldNames.append(") VALUES (");
                    insertedValues.append(") ");
                } else {
                    fieldNames.append(",");
                    insertedValues.append(",");
                }
            }
            myQuery.append(fieldNames).append(insertedValues);
             System.out.println(myQuery);
            Statement statement= connection.createStatement();

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
        //SELECT * FROM FunRanges;
        Field[] fields = myobject.getClass().getDeclaredFields();
        StringBuilder myQuery=new StringBuilder("SELECT * FROM "+myobject.getClass().getSimpleName()+" WHERE id =");
         myQuery.append(fields[0]);
        Statement statement= connection.createStatement();
        return statement.executeQuery(String.valueOf(myQuery));
    }
}
