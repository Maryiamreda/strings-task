package org.example.task1.factory;

import org.example.task1.FunnyStringService;
import org.example.task1.ScannerClient.ScannerClientFunnyString;

import java.sql.SQLException;

public class ScannerFunnyStringFactory implements Factory<ScannerClientFunnyString> {
    private static ScannerClientFunnyString scannerClientFunnyString;
    @Override
    public ScannerClientFunnyString createInstance() throws SQLException {
        if (scannerClientFunnyString==null)
        {
            FunnyStringService service = FunnyStringServiceFactory.createInstance();
            scannerClientFunnyString = new ScannerClientFunnyString(service);
        }
        return scannerClientFunnyString;
    }
}
