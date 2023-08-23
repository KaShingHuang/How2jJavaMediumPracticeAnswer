package 多线程;

import 集合框架.Hero;
import 集合框架.Stack;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyStack_lock implements Stack {
    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    LinkedList<Hero> stack=new LinkedList<Hero>();
    @Override
    public void push(集合框架.Hero h) {
        try {
            lock.lock();
            System.out.println("push占用了锁");
            stack.add(h);
            System.out.println("增加了英雄"+h);
            condition.signal();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
            System.out.println("push释放了锁");

        }
    }

    @Override
    public 集合框架.Hero pull() {
        Hero hero = null;
        try {
            lock.lock();

            System.out.println("pull占用了锁");
            if(stack.size()==0) {
                System.out.println("没有东西可以取出了，临时释放lock并等待");
                condition.await();
            }
            else
                    hero = stack.poll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("pull释放了锁");
            System.out.println("取出了英雄"+hero);
            lock.unlock();
            return hero;
        }
    }

    @Override
    public 集合框架.Hero peek() {
        return null;
    }

    public static void main(String[] args) {
        MyStack_lock stackLock = new MyStack_lock();
        Thread t1=new Thread(){
            @Override
            public void run() {
                while(true){
                    Hero hero = gethero();
                    stackLock.push(hero);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread t2=new Thread(){
            @Override
            public void run() {
                while(true){
                    stackLock.pull();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        t1.start();
        t2.start();


    }

    public static Hero gethero(){
        char RandomCode[]=new char[2];
        for (int i = 0; i < 2; i++) {
            RandomCode[i]=(char)(((int)(Math.random()*27))+'a');
        }
        String name=new String(RandomCode);
        Hero h=new Hero(name);
        return h;
    }
}
