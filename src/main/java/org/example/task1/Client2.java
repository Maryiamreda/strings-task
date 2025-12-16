package org.example.task1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client2 {
    public Client2(String addr, int port) throws IOException {
        // Establish a connection
        // Initialize socket and input/output streams
        Socket socket = new Socket(addr, port); //Connected
        DataInputStream input = new DataInputStream(System.in);//it reads text typed by the user in the console
        DataInputStream in=new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream()); //Sending data(output) over the network (to the socket)

        while (true) {
            out.writeUTF(input.readLine()); //encodes a String into bytes in a special binary format and sends it through the socket.
            out.writeUTF(input.readLine());
            out.writeUTF(input.readLine());
            out.writeUTF(input.readLine());
            out.flush();
            System.out.println(in.readUTF());
        }

    }

    public static void main(String[] args) throws IOException {
        new Client2("127.0.0.1", 5000);
    }
}
