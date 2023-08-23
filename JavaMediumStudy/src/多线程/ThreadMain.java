//package 多线程;
//
//import java.io.File;
//
//public class ThreadMain {
//    public static void main(String[] args) throws InterruptedException {
//        File filestart=new File("E:/JavaStudyItem/JavaMediumStudy");
//        ThreadPool pool =  new ThreadPool();
//        Search(filestart,pool);
//    }
//    //当前文件的判断
//    public static void Search(File file,ThreadPool pool) throws InterruptedException {
//        File ContainFile[]=file.listFiles();
//        if(ContainFile==null){
//            System.out.println("空文件");
//            return;
//        }
//        else{
//            //遍历每一个文件
//            for (File file1:ContainFile) {
//                //如果当前的文件是一个目录
//                if(file1.isDirectory()){
//                    Search(file1,pool);
//                }
//
//                //如果当前文件不是目录
//                else{
//                    if(file1.getAbsolutePath().endsWith(".txt")){
//                        ThreadFind t11=ThreadFindpool.getRunnable();
//                        t11.Setfilepath(file.getAbsolutePath());
//                        t11.run();
//                        //Thread.sleep(1000);可以加上观察多线程
//                    }
//                }
//            }
//        }
//
//    }
//}
