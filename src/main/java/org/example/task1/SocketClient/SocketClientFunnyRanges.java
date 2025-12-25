package org.example.task1.SocketClient;

import org.example.task1.enums.Function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SocketClientFunnyRanges implements SocketClientInputToFunctionalityMapper {
    @Override
    public void handleSocketOperation(BufferedReader in, PrintWriter out) throws IOException {

    }

    @Override
    public boolean isFunctionalitySupported(Function operationMethod) {
        return false;
    }
}
