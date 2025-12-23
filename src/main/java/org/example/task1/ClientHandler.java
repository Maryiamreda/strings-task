package org.example.task1;


import org.example.task1.entity.FunRanges;
import org.example.task1.entity.Funifier;
import org.example.task1.entity.Operation;
import org.example.task1.entity.Ranges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

import static org.example.task1.DBHandler.InsertFunnyRange;
import static org.example.task1.DBHandler.InsertFunnyString;
import static org.example.task1.DependencyInjector.getDependency;
import static org.example.task1.Transform.stringsToEnum;
import static org.example.task1.Transform.transferStringToList;

public class ClientHandler extends Thread {
    private final Socket clientSocket;
    private static final StringFunifier sf;

    static {
        try {
            sf = getDependency(StringFunifier.class);
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
                if (fnName.equals("getFunnyString")) {
                    String boringString = in.readLine();
                    List<Integer> startRanges = transferStringToList(in.readLine());
                    List<Integer> endRanges = transferStringToList(in.readLine());
                    List<Operations> operationsList = stringsToEnum(in.readLine());
                    String funnyString = sf.getFunnyString(boringString, startRanges, endRanges, operationsList);
                    InsertFunnyString(boringString,funnyString, startRanges, endRanges, operationsList);
                    out.println(funnyString);
                } else if (fnName.equals("getFunRanges")) {
                    String boringString = in.readLine();
                    List<Integer> startRanges = transferStringToList(in.readLine());
                    List<Integer> endRanges = transferStringToList(in.readLine());
                    String funnyRange = sf.getFunRanges(boringString, startRanges, endRanges);
                    InsertFunnyRange(boringString,funnyRange, startRanges, endRanges);
                    out.println(funnyRange);
                }
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
