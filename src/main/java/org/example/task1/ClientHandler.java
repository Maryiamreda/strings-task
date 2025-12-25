package org.example.task1;

import org.example.task1.SocketClient.SocketClientFunnyString;
import org.example.task1.SocketClient.SocketClientInputToFunctionalityMapper;
import org.example.task1.enums.Function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

import static org.example.task1.DependencyInjector.getDependency;


public class ClientHandler extends Thread {
    private final Socket clientSocket;
    public static List<SocketClientInputToFunctionalityMapper> socketClientInputToFunctionalityMappers;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }
    static {
        try {
            socketClientInputToFunctionalityMappers = getDependency(SocketClientInputToFunctionalityMapper.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            while (true) {
                String fnName = in.readLine();
                socketClientInputToFunctionalityMappers.forEach(mapper -> {
                  if (mapper.isFunctionalitySupported(fnName)) {
                      mapper.handleSocketOperation(in, out);
                  }
                })

//                else if (fnName.equals("getFunRanges")) {
//                    String boringString = in.readLine();
//                    List<Integer> startRanges = transferStringToList(in.readLine());
//                    List<Integer> endRanges = transferStringToList(in.readLine());
//                    FunRangesService fr=new FunRangesService();
//                    String funnyRange =fr.execute(boringString, startRanges, endRanges);
//                    out.println(funnyRange);
//                }
                out.flush();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            //this catch any exceptions happens during socket communication loop
            try {
                clientSocket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
