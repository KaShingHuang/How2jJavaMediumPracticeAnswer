package 集合框架;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CompareDifFind {


    public static void main(String[] args) {
        ArrayList<cHero> list = new ArrayList<cHero>();
        HashMap<Integer,ArrayList<cHero>> map = new HashMap<Integer, ArrayList<cHero>>();
        for (int i = 0; i < 20000000; i++) {
            int num = (int) (((int) (Math.random()) * 10000));
            if(num==5555) System.out.println(1);
            String name = "hero-" + num;
            cHero ho = new cHero(name);
            list.add(ho);
            if (!map.containsKey(num))
                map.put(num, new ArrayList<>());
            map.get(num).add(ho);
        }
            long startTime =  System.currentTimeMillis();
            // 不使用HashMap，直接使用for循环找出来，并统计花费的时间,把名字叫做 hero-5555的所有对象找出来
            int sum=0;
            for (cHero ele:list) {
                if(ele.name==" hero-5555"){
                    System.out.println(ele.name);
                    sum++;
                }
            }
            long endTime =  System.currentTimeMillis();
            long usedTime = (endTime-startTime);
            System.out.println("找到了"+sum+"个，一共用时"+usedTime+"s");

            startTime =  System.currentTimeMillis();
            //借助HashMap，找出结果，并统计花费的时间
            sum=0;
            if (map.containsKey(5555)) {
                cHero clist[] = (cHero[]) map.get(5555).toArray(new cHero[]{});
                for (int i = 0; i < clist.length; i++) {
                    System.out.println(clist[i].name);
                    sum++;
                }
            }
            endTime =  System.currentTimeMillis();
            usedTime = (endTime-startTime);
            System.out.println("找到了"+sum+"个，一共用时"+usedTime+"s");


        }
    }


class cHero{
    String name;
    public cHero(String name){ this.name=name;}
}
