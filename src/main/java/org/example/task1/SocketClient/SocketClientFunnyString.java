package org.example.task1.SocketClient;
import org.example.task1.FunnyStringService;
import org.example.task1.mapper.FunnyStringRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import static org.example.task1.SocketClient.FunnyStringBufferReaderInputHandler.mapInputToFunnyStringRequest;

public class SocketClientFunnyString implements SocketClient  {
    private final FunnyStringService service;
    public SocketClientFunnyString(FunnyStringService service) {
        this.service = service;
    }
    @Override
    public void handleSocketOperation(BufferedReader in, PrintWriter out) throws IOException {
        FunnyStringRequest funnyStringRequest=mapInputToFunnyStringRequest(in);
        String funnyString =service.execute(funnyStringRequest);
        out.println(funnyString);
    }
}