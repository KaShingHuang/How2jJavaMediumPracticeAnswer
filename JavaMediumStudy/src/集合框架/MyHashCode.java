package 集合框架;

public class MyHashCode {
    //练习-自定义字符串的hashcode
    public static int hashcode(String str){
        if(str.length()==0) return 0;
        else {
            int code=0;
            char ch[]=str.toCharArray();
            for (char cha:ch) {
                code+=Character.charCount(cha);
            }
            code*=23;
            if(code>1999) return code%2000;
            else if (code<0) return Math.abs(code);
            else return code;
        }
    }



    public static void main(String[] args) {

        }

    }

