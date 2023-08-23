package 集合框架;

import java.util.LinkedList;

public class MyHashMap implements IHashMap {
    LinkedList obArray[]=new LinkedList[2000];


    @Override
    public void put(String key, Object object) {
        int Index=MyHashCode.hashcode(key);
        if(obArray[Index]==null){
            Entry newEntry=new Entry(key,object);
            LinkedList list = new LinkedList<>();
            list.add(newEntry);
            obArray[Index]=list;
        }
        else {
            Entry newEntry=new Entry(key,object);
            obArray[Index].add(newEntry);
        }
    }

    @Override
    public Object get(String key) {
        int Index=MyHashCode.hashcode(key);
        if(obArray[Index]==null) return null;
        else{
            LinkedList getlist=obArray[Index];
            for (int i = 0; i < getlist.size(); i++) {
                Entry getEN=(Entry)getlist.get(i);
                if(getEN.key==key) {
                    System.out.println("1");
                    return getEN;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String a="123";
        Entry en1= new Entry("123"," 321V");
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("123",en1);
        myHashMap.get("123");




    }
}
