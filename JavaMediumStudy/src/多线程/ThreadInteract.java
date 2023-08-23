package 多线程;

public class ThreadInteract {
    public static void main(String[] args) {
        Hero garen=new Hero("盖伦",616);

        /*Thread t1=new Thread(){
            @Override
            public void run() {
                while (true) {
                    garen.Hurt();
                    try {
                        System.out.println("休息100");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread t3=new Thread(){
            @Override
            public void run() {
                while (true) {
                    garen.Hurt();
                    try {
                        System.out.println("休息100");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread t4=new Thread(){
            @Override
            public void run() {
                while (true) {
                    garen.Hurt();
                    try {
                        System.out.println("休息100");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread t6=new Thread(){
            @Override
            public void run() {
                while (true) {
                    garen.Hurt();
                    try {
                        System.out.println("休息100");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread t7=new Thread(){
            @Override
            public void run() {
                while (true) {
                    garen.Hurt();
                    try {
                        System.out.println("休息100");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread t2= new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        garen.Recover();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread t5= new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        garen.Recover();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();*/

    }

}
