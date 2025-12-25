package org.example.task1.ScannerClient;
import static org.example.task1.Utilities.InputHandler.mapInputToFunnyStringRequest;

import org.example.task1.FunnyStringService;
import org.example.task1.mapper.FunnyStringRequest;

import java.util.Scanner;

public class ScannerClientFunnyString  {
    private final FunnyStringService service;
    public ScannerClientFunnyString(FunnyStringService service) {
        this.service = service;
    }
    public void handleFunnyStringOperation(Scanner scanner) {
        FunnyStringRequest funnyStringRequest=mapInputToFunnyStringRequest(scanner);
        String funnyString =service.execute(funnyStringRequest);
        System.out.println(funnyString);
    }
}
