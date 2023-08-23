package 异常处理;

public class PraticeTryCatch {
    public static int run1(){
        System.out.println(1);
        return 1;
    }
    public static int run2(){
        System.out.println(2);
        return 2;
    }
    public static int run3(){
        System.out.println(3);
        return 3;
    }

    public static void main (String[] args) {
        try{
            run1();
        }
        catch (Exception e){
            run2();
        }
        finally {
            run3();
        }

    }
}
