package 多线程;

import java.util.LinkedList;

public class DecodingThread extends  Thread{
    String Truecode;
    LinkedList<String> CodeList=new LinkedList<String>();
    public DecodingThread(String code){
        this.Truecode=code;
    }
    @Override
    public void run() {
            //穷举密码 ascii对应0-127,并把穷举的密码加入Codelist
            int Find=0;
            char code[]=new char[3];
            for (int i = 0; i < 128&&Find!=1; i++) {
                for (int j = 0; j < 128&&Find!=1; j++) {
                    for (int k = 0; k <128&&Find!=1; k++) {
                        code[0]=(char)(i);
                        code[1]=(char)(j);
                        code[2]=(char)(k);
                        String string = new String(code);
                        CodeList.add(string);
                        if(string.equals(Truecode)) {
                            Find=1;
                            System.out.println("已经破解了密码，密码是------------------："+string);
                        }
                    }
                }
            }
        }
        public  LinkedList<String> getContent(){
            return CodeList;
        }



    public static void main(String[] args) {
        //生成长度是3的随机密码
        char RandomCode[]=new char[3];
        for (int i = 0; i < 3; i++) {
            RandomCode[i]=(char)(((int)(Math.random()*200)%128));
        }
        String CreateCode=new String(RandomCode);
        System.out.println("生成的随机密码是"+CreateCode);
        DecodingThread t1=new DecodingThread(CreateCode);
        ShowLogThread t2= new ShowLogThread(t1);
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }

}
