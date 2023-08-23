package IO;

import java.io.*;
import java.util.Arrays;

public class ByteStremWriteAndRead {
    public static void main(String[] args) throws Exception {

   /*     //step 4练习写入数据到文件
        File f1 = new File("E:/JavaStudyItem/JavaMediumStudy/src/IO/lol.txt");
        try (FileOutputStream fos = new FileOutputStream(f1)) {
            byte content[] = {89, 91};
            fos.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

       /* // step 6练习 拆分文件
        File f2=new File("E:/Xmind思维导图/Java基础.xmind");
        try(FileInputStream fis=new FileInputStream(f2)){
            byte content[]=fis.readAllBytes();
            System.out.println(content.length);
            byte writeContent[]=new byte[102400];

            for (int i = 0; i < content.length; i++) {
                if(i!=0&& i%102400==0 || i==content.length-1 ) {
                    String NEWFileName;
                    if(i%102400==0){
                        NEWFileName="E:/Xmind思维导图/Java基础"+i/102400+".xmind";
                        File NewFile=new File(NEWFileName);
                        try(FileOutputStream fos= new FileOutputStream(NewFile)){
                            fos.write(writeContent);
                            System.out.println("输出子文件"+NEWFileName);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    else {
                        NEWFileName="E:/Xmind思维导图/Java基础"+(i/102400+1)+".xmind";
                        File NewFile=new File(NEWFileName);
                        byte contenta[]= Arrays.copyOf(writeContent,content.length%102400);
                        try(FileOutputStream fos= new FileOutputStream(NewFile)){
                            fos.write(contenta);
                            System.out.println("输出子文件"+NEWFileName+contenta.length);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }


                }
                writeContent[i%102400]=content[i];
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }*/

        /*//step8 合并文件
        File AddFile= new File("E:/Xmind思维导图/Java基础合并.xmind");
        FileOutputStream fos=new FileOutputStream(AddFile);
        for (int i=1;i<5;i++){
            String filename="E:/Xmind思维导图/Java基础"+i+".xmind";
            File f1=new File(filename);
            try(FileInputStream fis=new FileInputStream(f1)){
                byte in[]=fis.readAllBytes();
                fos.write(in);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }*/
    }
}
