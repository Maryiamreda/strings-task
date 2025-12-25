package org.example.task1.SocketClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public interface SocketClient {
    void handleSocketOperation(BufferedReader in, PrintWriter out) throws IOException;
}
