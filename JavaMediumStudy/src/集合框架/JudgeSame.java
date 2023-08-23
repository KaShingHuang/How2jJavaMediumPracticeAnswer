package 集合框架;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class JudgeSame {
    public static void main(String[] args) {
        /*// step 11判断是否相同
        String name="hero1";
        ArrayList Heros=new ArrayList<>();
        Heros.add(new Hero("hero1"));
        if (((Hero)(Heros.get(0))).name==name) System.out.println(1);*/

        // practice 支持泛型的ArrayList
       /* ArrayList<Hero> list=new ArrayList<Hero>();
        Hero h1=new Hero();
        Item item = new Item();
        list.add(h1);
        list.add(item);
        list.add(new a());*/

      /*  // step 练习-删除ArrayList中的数据
        ArrayList Heros=new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            String name="hero"+i;
            Heros.add(new Hero(name));
        }
        Iterator iterator = Heros.iterator();
        while(iterator.hasNext()){
            Hero hero = (Hero)iterator.next();
            String name=hero.name;
            if((Character.getNumericValue(name.charAt(name.length()-1)))%8==0) {iterator.remove(); }
        }*/

        //练习-使用LinkedList实现Stack栈


    }
}

class Item extends Hero{
    String ItemName;

    }
    class a{

    }


