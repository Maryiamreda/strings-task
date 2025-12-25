package org.example.task1.SocketClient;

import org.example.task1.enums.Function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public interface SocketClientInputToFunctionalityMapper {
    void handleSocketOperation(BufferedReader in, PrintWriter out) throws IOException;
    void boolean isFunctionalitySupported(Function operationMethod);
}
