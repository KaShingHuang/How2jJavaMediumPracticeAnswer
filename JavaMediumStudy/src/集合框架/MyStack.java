package 集合框架;

import java.util.LinkedList;

public class MyStack implements Stack{
    LinkedList hero=new LinkedList<>();


    @Override
    public void push(Hero h) {
        hero.add(h);

    }

    @Override
    public Hero pull() {
        Hero result=(Hero)hero.pollLast();
        return result;
    }

    @Override
    public Hero peek() {
        return  (Hero)hero.peekLast();
    }

    public static void main(String[] args) {
        MyStack ms=new MyStack();
        for(int i=0;i<5;i++){
            ms.push(new Hero("hero"+i));
        }
        for(int i=0;i<5;i++){
            Hero h2=ms.pull();
            System.out.println("弹出"+h2);
        }
    }
}
