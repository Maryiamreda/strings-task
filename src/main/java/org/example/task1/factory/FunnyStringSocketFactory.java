package org.example.task1.factory;

import org.example.task1.FunnyStringService;
import org.example.task1.SocketClient.SocketClientFunnyString;

import java.sql.SQLException;

public class FunnyStringSocketFactory implements Factory<SocketClientFunnyString> {
    private static SocketClientFunnyString socketClientFunnyString;
    @Override
    public SocketClientFunnyString createInstance() throws SQLException {
        if (socketClientFunnyString==null){
            FunnyStringService funnyStringService=FunnyStringServiceFactory.createInstance();
            socketClientFunnyString=new SocketClientFunnyString(funnyStringService);
        }
        return socketClientFunnyString;
    }
}
