package 网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost",8888);
            System.out.println("开启客户端");
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        DataInputStream dis = new DataInputStream(is);
                        while (true){
                            String msg = dis.readUTF();
                            System.out.println("接收服务端消息： " + msg);
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
                        OutputStream os = socket.getOutputStream();
                        DataOutputStream dos = new DataOutputStream(os);
                        Scanner scanner = new Scanner(System.in);
                        while (true) {
                            String str = scanner.next();
                            dos.writeUTF(str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            };
            thread1.start();
            thread2.start();
            thread1.join();
            System.out.println("客户端关闭");
            socket.close();
        } catch (Exception e) {
            System.out.println("断开连接");
        }
    }
}
