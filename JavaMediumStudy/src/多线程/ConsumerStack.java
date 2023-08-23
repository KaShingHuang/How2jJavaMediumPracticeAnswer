package 多线程;




import java.util.LinkedList;

public class ConsumerStack {
    LinkedList<Character> stack=new LinkedList<Character>();


    public synchronized char pull(){
        System.out.println(stack.size());
        if(stack.size()==0) {
            try {
                System.out.println("栈空了");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
       return stack.pollLast();
    }

    public synchronized  void push(char ch){
        System.out.println(stack.size());
        if(stack.size()==200) {
            System.out.println("栈满了");
            this.notifyAll();
        }
        else {
            stack.add(ch);
            System.out.println("Produce1 压入: " + ch);
        }
    }

    public static void main(String[] args) {
        ConsumerStack stack1= new ConsumerStack();
        Thread Produce1=new Thread(){
            @Override
            public void run() {
                while (true) {
                    char ch = getRandomChar();
                    stack1.push(ch);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        };
        Thread Produce2=new Thread(){
            @Override
            public void run() {
                while (true) {
                    char ch = getRandomChar();
                    stack1.push(ch);
                    System.out.println("Produce2 压入: " + ch);
                }
            }
        };

        Thread Consumer1=new Thread(){
            @Override
            public void run() {
                while (true) {
                    char ch = stack1.pull();
                    System.out.println("Consumer1 弹出: " + ch);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread Consumer2=new Thread(){
            @Override
            public void run() {
                while (true) {
                    char ch = stack1.pull();
                    System.out.println("Consumer2 弹出: " + ch);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread Consumer3=new Thread(){
            @Override
            public void run() {
                while (true){
                char ch=stack1.pull();
                System.out.println("Consumer3 弹出: "+ch);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Produce1.start();
//        Produce2.start();
        Consumer1.start();
//        Consumer2.start();
//        Consumer3.start();
    }

    public static char getRandomChar(){
        return (char)((int)(Math.random()*25)+'A');
    }

}
