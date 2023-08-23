package 集合框架;


public class HeroNode {
    // 左子节点
    String HeroNodeName;
    public HeroNode leftNode;
    // 右子节点
    public HeroNode rightNode;
    // 值
    public int hp;

    public HeroNode HeroTree;
    public void show(){
        while(HeroTree!=null){
            System.out.println(HeroTree.hp);
            HeroTree=HeroTree.rightNode;
        }

    }
    public HeroNode( ){

    }
    public HeroNode( String HeroNodeName,int hp){
        this.hp=hp;
        this.HeroNodeName=HeroNodeName;
    }
    public void add(HeroNode hd){  //题目没要求，我直接用单叉树了
        if(HeroTree==null){
            HeroTree=hd;
        }
        else{
            if(hd.hp>=HeroTree.hp){
                hd.rightNode=HeroTree;
                HeroTree=hd;
            }
            else{
                if(HeroTree.rightNode==null) HeroTree.rightNode=hd;
                else{
                    HeroNode pre=HeroTree;
                    HeroNode Next=HeroTree.rightNode;
                    while(Next!=null){
                        if(hd.hp<pre.hp &&hd.hp> Next.hp){
                            pre.rightNode=hd;
                            hd.rightNode=Next;
                            break;
                        }
                        else {
                            pre=pre.rightNode;
                            Next=pre.rightNode;
                        }
                    }
                }
            }

        }
    }


    public static void main(String[] args) {
        HeroNode hero[] =new HeroNode[10];
        for(int i=0;i<5;i++){
            hero[i]=new HeroNode("hero"+i, (int)((Math.random())*100));
            System.out.println(hero[i].HeroNodeName+""+hero[i].hp);
        }
        HeroNode hn =new HeroNode();
        for(int i=0;i<5;i++){
            hn.add(hero[i]);
        }
        hn.show();

    }

}
