package IO;

import javax.swing.plaf.metal.MetalIconFactory;
import java.io.File;

public class Ergodic {
    public static void main(String[] args) {

        File f1 = new File("C:/Users/23285/Desktop/初一数学课件/初二上");
        String FileList[] = f1.list();
        /*//step 5 遍历文件夹练习
        for (String FileName:FileList) {
            System.out.println(FileName);
        }*/

     /*   //step 6 遍历子文件夹
        for (String FileName : FileList) {
            String FilePath = "C:/Users/23285/Desktop/初一数学课件/初二上/" + FileName;
            File f2 = new File(FilePath);
            if (f2.isDirectory()) {
                String ChildFileList[] = f2.list();
                for (String ChildFileName : ChildFileList) {
                    System.out.println(ChildFileName);
                }
            } else System.out.println(FileName);

        }*/

    }
}

