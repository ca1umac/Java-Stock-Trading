import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args){
        String ServerName = args[0];
        int port = Integer.parseInt(args[1]);

        try{
            System.out.println("Connecting...");
            Socket Client = new Socket(ServerName, port);
            System.out.println("Connected!");

            OutputStream outToServer = Client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("Hello from Client!");

            InputStream inFromServer = Client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            System.out.println(in.readUTF());
            Client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
