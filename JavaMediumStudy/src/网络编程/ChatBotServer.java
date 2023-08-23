package 网络编程;

import JDBC.GetDataBase;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;

public class ChatBotServer {
    public static void main(String[] args) throws IOException, SQLException {
        ServerSocket ss=new ServerSocket(8888);
        System.out.println("8888端口正在监听");
        Socket ac = ss.accept();
        System.out.println("有链接过来"+ac);
        InputStream is=ac.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        OutputStream os = ac.getOutputStream();
        DataOutputStream dos=new DataOutputStream(os);
        while(true) {
            String Message = dis.readUTF();
            String Answer = GetDataBase.GetAnswer(Message);
            dos.writeUTF(Answer);
        }

    }
}
