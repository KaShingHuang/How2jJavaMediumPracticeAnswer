package 多线程;

public class HeroChargeThread extends Thread {
    public void run(){
        while(true){
            for (int i = 1; i < 4; i++) {
                System.out.println("波动拳第"+i+"发");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                System.out.println("开始为时5秒的充能");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        HeroChargeThread t1=new HeroChargeThread();
        t1.start();
    }
}
