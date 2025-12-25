package org.example.task1.Servers;

import org.example.task1.ScannerClient.ScannerClientFunnyString;
import org.example.task1.enums.Function;

import java.sql.SQLException;
import java.util.Scanner;

import static org.example.task1.DependencyInjector.getDependency;

public class ConsoleServer {
    private static final ScannerClientFunnyString scannerClient;
    private static final Scanner scanner;

    static {
        try {
            scannerClient = getDependency(ScannerClientFunnyString.class);
            scanner = new Scanner(System.in);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        while (true) {
            String operation = scanner.nextLine();
            Function function = Function.valueOf(operation);
            switch (function) {
                case FUNNY_STRING -> scannerClient.handleFunnyStringOperation(scanner);
            }
        }
    }

    public static void main(String[] args) {
        new ConsoleServer().start();
    }
}