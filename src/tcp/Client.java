package tcp;

import java.net.*;
import java.io.*;
/*
 * @author Rakibul Islam
 */
public class Client{
    public static void main(String[] args) throws Exception{
        InetAddress a = InetAddress.getLocalHost();
        Socket clientSocket = new Socket(a, 4321);
        
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        
        while(true){
            System.out.print("Enter text: ");
            String input = inFromUser.readLine();
            if(input.matches("exit")) break;
            System.out.println("Client output: "+input);
            outToServer.writeBytes(input+"\n");

            String ans = inFromServer.readLine();
            System.out.println("Client input: "+ans);
        }
        
        clientSocket.close();
    }
}
