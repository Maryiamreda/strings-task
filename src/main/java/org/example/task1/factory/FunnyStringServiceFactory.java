package org.example.task1.factory;

import org.example.task1.FunnyStringService;

import java.sql.SQLException;

public class FunnyStringServiceFactory {
    private  static FunnyStringService funnyStringService;

    public static FunnyStringService createInstance() throws SQLException {
        if (funnyStringService==null)
            funnyStringService=new FunnyStringService();

        return funnyStringService;
    }
}
