import java.net.*;
import java.io.*;

public class Server extends Thread{
    private ServerSocket ServerSocket;

    public Server(int port) throws IOException{
        ServerSocket = new ServerSocket(port);
    }

    public void run() {
        while(true){
            try{
                System.out.println("Waiting...");
                Socket Server = ServerSocket.accept();
                System.out.println("Connected!");

                DataInputStream in = new DataInputStream(Server.getInputStream());
                System.out.println(in.readUTF());

                DataOutputStream out = new DataOutputStream(Server.getOutputStream());
                out.writeUTF("Thanks!");

                Server.close();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }


    public static void main(String[] args){
        int port = Integer.parseInt(args[0]);
        try{
            Thread t = new Server(port);
            t.start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}