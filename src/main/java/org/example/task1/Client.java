package org.example.task1;

import java.io.*;
import java.net.*;

public class Client {
    Socket socket;
    public Client(String addr, int port) throws IOException {
        // Establish a connection
        // Initialize socket and input/output streams
        //Sending data(output) over the network (to the socket)
        Socket socket = new Socket(addr, port); //Connected
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));//it reads text typed by the user in the console
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);//Sending data(output) over the network (to the socket)
        while (true) {
            System.out.println("enter function name");
            String fnName=input.readLine();
            out.println(fnName); // Sends bytes through the socket output stream
            out.println(input.readLine());
            out.println(input.readLine());
            out.println(input.readLine());
            if (fnName.equals("getFunnyString")) {
                out.println(input.readLine());
            }
            System.out.println(in.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        new Client("127.0.0.1", 5000);
    }
}
