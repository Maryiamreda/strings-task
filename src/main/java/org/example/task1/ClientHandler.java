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
                if (fnName.equals("getFunnyString")) {
                    String boringString = in.readLine();
                    List<Integer> startRanges = transferStringToList(in.readLine());
                    List<Integer> endRanges = transferStringToList(in.readLine());
                    List<Operations> operationsList = stringsToEnum(in.readLine());
                    String funnyString = sf.getFunnyString(boringString, startRanges, endRanges, operationsList);
                    Funifier funifier = new Funifier();
                    funifier.setBoring_string(boringString);
                    funifier.setFunny_string(funnyString);
                    int id = db.insert(funifier);
                    Operation op = new Operation();
                    for (int i = 0; i < startRanges.size(); i++) {
                        op.setStart_range(startRanges.get(i));
                        op.setEnd_range(endRanges.get(i));
                        op.setOperation_name(operationsList.get(i));
                        op.setBoring_string(id);
                        db.insert(op);
                    }
                    out.println(funnyString);
                } else if (fnName.equals("getFunRanges")) {
                    String boringString = in.readLine();
                    List<Integer> startRanges = transferStringToList(in.readLine());
                    List<Integer> endRanges = transferStringToList(in.readLine());
                    String funnyString = sf.getFunRanges(boringString, startRanges, endRanges);
                    FunRanges funRanges = new FunRanges();
                    funRanges.setBoring_string(boringString);
                    funRanges.setFunny_string(funnyString);
                    int id = db.insert(funRanges);
                    Ranges range = new Ranges();
                    for (int i = 0; i < startRanges.size(); i++) {
                        range.setStart_range(startRanges.get(i));
                        range.setEnd_range(endRanges.get(i));
                        range.setBoring_string(id);
                        db.insert(range);
                    }
                    out.println(funnyString);
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
