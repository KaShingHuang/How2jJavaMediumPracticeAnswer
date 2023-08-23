package 多线程;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

class ThreadPoolFind{
    String Threadname;
    String FilePath;
    public ThreadPoolFind(String s) {
        this.Threadname=s;
    }

    public void SetFilePath(String path){
        this.FilePath=path;
    }

    public void run() {
        File file=new File(FilePath);
        System.out.println(Threadname+"正在读取"+FilePath+"的文件的内容是:");
        try(FileReader fr = new FileReader(file)){
            char all[]= new char[(int)file.length()];
            fr.read(all);
            for (char ch:all){
                System.out.print(ch);
            }
            System.out.println();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
public class ThreadPool {

    // 线程池大小
    String FilePath;
    int threadPoolSize;

    // 任务容器
    LinkedList<ThreadPoolFind> tasks = new LinkedList<ThreadPoolFind>();

    // 试图消费任务的线程

    public ThreadPool() {
        threadPoolSize = 10;

        // 启动10个任务消费者线程
        synchronized (tasks) {
            for (int i = 0; i < threadPoolSize; i++) {
                tasks.add(new ThreadPoolFind("查找线程"+i));
            }
        }
    }

    public void add(ThreadPoolFind r) {
        synchronized (tasks) {
            tasks.add(r);
            tasks.notifyAll();
        }
    }

    public ThreadPoolFind getRunnable() {
        synchronized (tasks) {
            if(tasks.size()>0) return tasks.pollFirst();
            else {
                try {
                    tasks.wait();
                } catch (InterruptedException e) {
                    System.out.println("打印的线程不够了");
                }
            }
            return null;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        File filestart=new File("E:/JavaStudyItem/JavaMediumStudy");
        ThreadPool pool =  new ThreadPool();
        Search(filestart,pool);
    }

    public static void Search(File file,ThreadPool pool) throws InterruptedException {
        File ContainFile[]=file.listFiles();
        if(ContainFile==null){
            System.out.println("空文件");
            return;
        }
        else{
            //遍历每一个文件
            for (File file1:ContainFile) {
                //如果当前的文件是一个目录
                if(file1.isDirectory()){
                    Search(file1,pool);
                }

                //如果当前文件不是目录
                else{
                    if(file1.getAbsolutePath().endsWith(".txt")){
                        ThreadPoolFind t11=pool.getRunnable();
                        t11.SetFilePath(file1.getAbsolutePath());
                        t11.run();
                        pool.add(t11);
                        System.out.println(t11.Threadname+"回收了");
                        //可以加上观察多线程
//                        Thread.sleep(1000);
                    }
                }
            }
        }

    }


}
