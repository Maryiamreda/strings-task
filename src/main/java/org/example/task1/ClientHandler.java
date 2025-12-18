package org.example.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

import static org.example.task1.DependencyInjector.getDependency;
import static org.example.task1.Transform.stringsToEnum;
import static org.example.task1.Transform.transferStringToList;

public class ClientHandler extends Thread {
    private final Socket clientSocket;
    private static final StringFunifier sf;
    private static final DBController db;

    static {
        try {
            sf = getDependency(StringFunifier.class);
            db = getDependency(DBController.class);
        } catch (SQLException e) {
            throw new Error(e.getSQLState());
        }
    }

    ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            while (true) {
                String fnName = in.readLine();
                String boringString = in.readLine();
                List<Integer> startRanges = transferStringToList(in.readLine());
                List<Integer> endRanges = transferStringToList(in.readLine());
                String funnyString;
                List<Operations> operationsList = null;
                if (fnName.equals("getFunnyString")) {
                    operationsList = stringsToEnum(in.readLine());
                    funnyString = sf.getFunnyString(boringString, startRanges, endRanges, operationsList);
                } else {
                    funnyString = sf.getFunRanges(boringString, startRanges, endRanges);
                }
//                db.addNewFunfierOp(boringString, funnyString, startRanges, endRanges, operationsList);
                StringFunfierEntity rd=new StringFunfierEntity();
                rd.setFName(fnName);
                rd.setBoringString(boringString);
                rd.setFunnyString(funnyString);
                rd.setStartRange(startRanges);
                rd.setEndRange(endRanges);
                rd.setOperations(operationsList);
                db.insert(rd);
                out.println(funnyString);
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
