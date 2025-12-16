package org.example.task1;

import java.net.*;
import java.io.*;
import java.util.List;

import static org.example.task1.DependencyInjector.getDependency;
import static org.example.task1.Transform.stringsToEnum;
import static org.example.task1.Transform.transferStringToList;

public class Server {
    private ServerSocket serverSocket;
    private static StringFunifier sf;
    private static DBController db;

    static {
        try {
            sf = getDependency(StringFunifier.class);
            db = getDependency(DBController.class);
        } catch (Exception e) {
        }
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        //Starts server and Wait for a client connection
        while (true) {
            Socket s = serverSocket.accept();
            Thread client = new ClientHandler(s);
            client.start();
        }
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;

        ClientHandler(Socket socket) {
            this.clientSocket = socket;
            System.out.println("contsructor ");
        }
        public void run() {
            try (DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                 DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {
                while (true) {
                    String boringString = in.readUTF();
                    List<Integer> startRanges = transferStringToList(in.readUTF());
                    List<Integer> endRanges = transferStringToList(in.readUTF());
                    List<Operations> operationsList = stringsToEnum(in.readUTF());
                    String funnyString = sf.getFunnyString(boringString, startRanges, endRanges, operationsList);
                    db.addNewFunfierOp(boringString, funnyString, startRanges, endRanges, operationsList);
                    out.writeUTF(funnyString);
                    out.flush();
                }
            } catch (Exception e) {
                //this catch any exceptions happens during socket communication loop
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(5000);
    }

}
