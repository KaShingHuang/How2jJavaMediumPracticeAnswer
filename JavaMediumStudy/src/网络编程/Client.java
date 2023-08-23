package 网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            //在8888端口上监听，看是否有连接请求过来
            System.out.println("开启服务端");
            Socket accept = serverSocket.accept();
            System.out.println("有连接过来"+accept);
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    try {
                        InputStream is = accept.getInputStream();
                        DataInputStream dis = new DataInputStream(is);
                        while (true){
                            String msg = dis.readUTF();
                            System.out.println("监听客户端消息： "+msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread thread2 = new Thread(){
                @Override
                public void run() {
                    try {
                        OutputStream os = accept.getOutputStream();
                        DataOutputStream dos = new DataOutputStream(os);
                        Scanner scanner = new Scanner(System.in);
                        while (true){
                            String strServer = scanner.next();
                            dos.writeUTF(strServer);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread1.start();
            thread2.start();
            thread1.join();
            System.out.println("服务器关闭");
            accept.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("断开连接");
        }
    }
}
