package 集合框架;

import java.util.HashSet;
import java.util.Iterator;

public class CreateUniqueRandom {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(set.size()<50){
            set.add((int)(Math.random()*10000));
        }
        Iterator iterator =  set.iterator();
        while(iterator.hasNext()){
            Integer i = (Integer) iterator.next();
            System.out.println(i);
        }
    }
}
