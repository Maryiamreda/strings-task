package org.example.task1;

import org.example.task1.ScannerClient.ScannerClientFunnyString;
import org.example.task1.SocketClient.SocketClientFunnyString;
import org.example.task1.factory.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DependencyInjector {

    private static final Map<Class, Supplier<Factory>> classFactoryMap = new HashMap<>();

    static {
        classFactoryMap.put(StringFunifier.class, FunfierFactory::new);
        classFactoryMap.put(DBController.class, DBFactory::new);
        classFactoryMap.put(SocketClientFunnyString.class, FunnyStringSocketFactory::new);
        classFactoryMap.put(ScannerClientFunnyString.class, ScannerFunnyStringFactory::new);
    }
    public DependencyInjector() {}

    public static <T> T getDependency(Class<?> myClass) throws SQLException {
        Factory factory = classFactoryMap.get(myClass).get();
        return (T) factory.createInstance();
    }
}