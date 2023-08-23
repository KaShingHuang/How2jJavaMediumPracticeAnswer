package 网络编程;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatBotClient {
    public static void main(String[] args) {
        try {
            Socket s=new Socket("127.0.0.1",8888);
            InputStream is=s.getInputStream();
            DataInputStream dis=new DataInputStream(is);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            Scanner scanner = new Scanner(System.in);
            while(true){
                String Input=scanner.next();
                dos.writeUTF(Input);
                System.out.println(dis.readUTF());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
