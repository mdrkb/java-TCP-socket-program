package tcp;

import java.net.*;
import java.io.*;
/*
 * @author Rakibul Islam
 */
public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(4321);
        while(true){
            Socket s = serverSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(s.getOutputStream());
                        
            String input = inFromClient.readLine();
            System.out.println("Server input: "+input);
           
            String output = "";
            char[] array = input.toCharArray();
            for(int i=0; i<array.length; i++){
                char ch = (char)((int)array[i]+1);
                output += ch;
            }
            
            System.out.println("Server output: "+output);
            outToClient.flush();
            outToClient.writeBytes(output+"\n");
        }
    }
}
