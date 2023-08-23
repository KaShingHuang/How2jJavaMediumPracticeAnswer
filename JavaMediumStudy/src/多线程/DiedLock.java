package 多线程;

public class DiedLock {
    public static void main(String[] args) {
        DiedLock l1=new DiedLock();
        DiedLock l2=new DiedLock();
        DiedLock l3=new DiedLock();
        Thread t1= new Thread(){
            @Override
            public void run() {
                synchronized (l1){
                    System.out.println("这是l1");
                    try{
                        Thread.sleep(1000);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("我想要获得l2,l1等待中");
                    synchronized (l2){
                        System.out.println("l2获得成功");
                    }
                }
            }
        };

        Thread t2= new Thread(){
            @Override
            public void run() {
                synchronized (l2){
                    System.out.println("这是l2");
                    try{
                        Thread.sleep(1000);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("我想要获得l3,l2等待中");
                    synchronized (l3){
                        System.out.println("l3获得成功");
                    }
                }
            }
        };

        Thread t3= new Thread(){
            @Override
            public void run() {
                synchronized (l3){
                    System.out.println("这是l3");
                    try{
                        Thread.sleep(1000);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("我想要获得l1,l3等待中");
                    synchronized (l1){
                        System.out.println("l1获得成功");
                    }
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();


    }


}
