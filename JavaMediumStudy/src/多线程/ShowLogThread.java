package 多线程;

import java.util.Iterator;
import java.util.LinkedList;

public class ShowLogThread extends Thread{
    LinkedList<String> Content=new LinkedList<String>();
    DecodingThread St1;

    public ShowLogThread(DecodingThread t1){
        this.St1=t1;
    }

    @Override
    public void run() {
        while(true){
            Content=St1.getContent();

            if(Content==null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            else{
                for (int i = 0; i < Content.size(); i++) {
                    System.out.println(Content.get(i));
                }

                }
            }
        }
    }


