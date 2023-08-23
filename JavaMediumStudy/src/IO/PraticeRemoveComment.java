package IO;

import java.io.*;

public class PraticeRemoveComment {
    public static void removeComments(File javaFile,File OutPutFile){
       try(FileReader fr=new FileReader(javaFile); BufferedReader br=new BufferedReader(fr); FileWriter fri=new FileWriter(OutPutFile);
       BufferedWriter bw=new BufferedWriter(fri)){
           while(true){
               String line= br.readLine();
               if(line==null) break;
               if(line.trim().charAt(0)=='/'){
                   String writeline=line.substring(2,line.length());
                   bw.write(writeline);
                   bw.newLine();
               }
           }
       }
       catch (Exception e){
           e.printStackTrace();
       }
    }

    public static void main(String[] args) {
        File InPutFile= new File("E:/JavaStudyItem/JavaMediumStudy/OriginalComment.txt");
        File OutPutFile= new File("E:/JavaStudyItem/JavaMediumStudy/DealedComment.txt");
        removeComments(InPutFile,OutPutFile);
    }
}
