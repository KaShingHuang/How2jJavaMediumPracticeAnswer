package IO;

import java.io.*;

public class UseBufferWriteNumber {
    public static void UseBufferWrite(File f1 ){
        try(FileWriter fwe= new FileWriter(f1); BufferedWriter bw=new BufferedWriter(fwe)){
            String WriteContent="31@15";
            bw.write(WriteContent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void UseBufferRead(File f1){
        try(FileReader fr=new FileReader(f1);BufferedReader br=new BufferedReader(fr)){
            String content=br.readLine();
            String Number[]=content.split("@");
            for (String num:Number) System.out.println(num);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void UseDataStreamWrite(File f1){
        try(FileOutputStream fos=new FileOutputStream(f1);DataOutputStream dis=new DataOutputStream(fos)){
            dis.writeInt(25);
            dis.writeInt(31);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void UseDataStreamRead(File f1){
        try(FileInputStream fis=new FileInputStream(f1);DataInputStream dis=new DataInputStream(fis)){
            System.out.printf("%d %d",dis.readInt(),dis.readInt());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File f1=new File("E:/JavaStudyItem/JavaMediumStudy/Number.txt");
        UseDataStreamWrite(f1);
        UseDataStreamRead(f1);
    }
}
