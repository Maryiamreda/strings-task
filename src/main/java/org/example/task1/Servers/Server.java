package org.example.task1.Servers;

import org.example.task1.ClientHandler;

import java.net.*;
import java.io.*;
public class Server {
    private ServerSocket serverSocket;
    public void start(int port) throws IOException {
        try {
            serverSocket = new ServerSocket(port);
            //Starts server and Wait for a client connection
            while (true) {
                Socket s = serverSocket.accept(); //this is blocking
                Thread client = new ClientHandler(s);
                client.start(); //begin a new ClientHandler thread of execution
            }
        } catch (IOException e) {
            serverSocket.close();
        }
    }
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(5000);
    }
}
