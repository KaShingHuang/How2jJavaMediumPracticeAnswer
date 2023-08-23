package 集合框架;

import java.util.*;

public class ReverseKeyAndValue {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        HashMap<String,String> map2 = new HashMap<>();
        map.put("adc","物理英雄");
        map.put("apc","魔法英雄");
        map.put("t","坦克");
        Set Kset = map.keySet();
        Collection Vset=map.values();
        ArrayList Klist=new ArrayList<>(Kset);
        ArrayList Vlist=new ArrayList<>(Vset);
        for (int i = 0; i < Klist.size(); i++) {
            map2.put(Vlist.get(i).toString(),Klist.get(i).toString());
        }
        System.out.println(map2.values());
        System.out.println(map2.keySet());

    }
}
