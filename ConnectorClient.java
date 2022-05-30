package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectorClient {
    Socket client;
    int Port = 6000;
    String ip = "192.168.5.112";

    BufferedReader in, keyboard;
    PrintStream out;

    public void start (){
        try {
            client = new Socket(ip, Port);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            keyboard = new BufferedReader(new InputStreamReader(System.in));

            String tec = keyboard.readLine();

            out = new PrintStream(client.getOutputStream());
            out.println(tec);

            String message = in.readLine();
            System.out.println(message);

            in.close();
            out.close();
            keyboard.close();
            client.close();

        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
