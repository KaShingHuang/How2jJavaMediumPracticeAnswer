package 集合框架;

import java.util.*;

public class PracticeHashSet {
    public static void main(String[] args) {
        List list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random()*10));
        }
        double sum=0;
        for (int i = 0; i < 1000000; i++) {
            Collections.shuffle(list);
            System.out.println("运行");
            System.out.println(list.indexOf(0)+" "+list.indexOf(1)+" "+list.indexOf(2));
            if(list.indexOf(0)==3&&list.indexOf(1)==1&&list.indexOf(2)==4) sum++;
        }
        System.out.println(sum/100000);


    }
}
