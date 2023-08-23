package 多线程;

import java.security.PublicKey;

public class Hero {
    public String name;
    public float hp;

    public Hero(String name,float hp){
        this.hp=hp;
        this.name=name;
    }

    public synchronized void Hurt(){
        if(this.hp==1) this.notify();
        else this.hp-=1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
    }

    public synchronized  void Recover() throws InterruptedException {
        if(this.hp==1000) this.wait();
        else this.hp+=1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
    }
}
