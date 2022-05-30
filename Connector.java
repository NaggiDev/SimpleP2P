package UDP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Connector {

    ServerSocket server;
    Socket socket;
    int Port = 6000;
    DataOutputStream out;
    BufferedReader in;

    public void start (){
        try {
            server = new ServerSocket(Port);
            socket = new Socket();

            socket = server.accept();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = in.readLine();

            System.out.println(message);

            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Bye");
            socket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
