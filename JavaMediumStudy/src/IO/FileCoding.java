package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCoding {
    //step3 文件加密
    /*public static void encodeFile(File encodingFile, File encodedFile){
        try (FileInputStream fis=new FileInputStream(encodingFile); FileOutputStream fos=new FileOutputStream(encodedFile)){
            byte content[]=fis.readAllBytes();
            for (int i = 0; i < content.length; i++) {
                if(Character.isDigit((char)(content[i]))){
                    if((char)(content[i])=='9') content[i]-=9;  //9变0
                    else content[i]+=1;//原基础加一
                }
                else if(Character.isLetter((char)(content[i]))){
                    if((char)(content[i])=='z' || (char)(content[i])=='Z') content[i]-=25;
                    else content[i]+=1;
                }
            }
            fos.write(content);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }*/


    /*// step 5文件解密
    public static void decodeFile(File decodingFile, File decodedFile){
        try (FileInputStream fis=new FileInputStream(decodingFile); FileOutputStream fos=new FileOutputStream(decodedFile)){
            byte content[]=fis.readAllBytes();
            for (int i = 0; i < content.length; i++) {
                if(Character.isDigit((char)(content[i]))){
                    if((char)(content[i])=='0') content[i]+=9;  //0变9
                    else content[i]-=1;//原基础减一
                }
                else if(Character.isLetter((char)(content[i]))){
                    if((char)(content[i])=='a' || (char)(content[i])=='A') content[i]+=25;
                    else content[i]-=1;
                }
            }
            fos.write(content);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }*/





    public static void main(String[] args) {
        File oldfile=new File("E:/JavaStudyItem/JavaMediumStudy/src/IO/lol.txt");
        File newfile=new File("E:/JavaStudyItem/JavaMediumStudy/src/IO/new.txt");
//        encodeFile(oldfile,newfile);
//        decodeFile(newfile,oldfile);

    }
}
