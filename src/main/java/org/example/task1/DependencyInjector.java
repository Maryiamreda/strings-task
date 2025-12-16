package org.example.task1;
import org.example.task1.factory.DBFactory;
import org.example.task1.factory.FunfierFactory;
import java.sql.SQLException;

public class DependencyInjector {
    //static initialise block
    public static <T> T getDependency(Class<?> myClass) throws SQLException {
        if (myClass.equals(StringFunifier.class)) {
            StringFunifier funifier = FunfierFactory.createFunifier();
            return (T) funifier;
        }
        if (myClass.equals(DBController.class)) {
            DBController dbController = DBFactory.createDBController();
            return (T) dbController;
        }
        return null;
    }

}