package 多线程;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class ThreadFind extends Thread{
    String FilePath;
    String ThreadPOOLNAME;
    public ThreadFind(String name){
        this.ThreadPOOLNAME=name;
    }
    public void Setfilepath(String str){
        this.FilePath=str;
    }

    public void run() {
        File file=new File(FilePath);
        System.out.println(FilePath+"的文件的内容是:");
        try(FileReader fr = new FileReader(file)){
            char all[]= new char[(int)file.length()];
            fr.read(all);
            for (char ch:all){
                System.out.print(ch);
            }
            System.out.println();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
