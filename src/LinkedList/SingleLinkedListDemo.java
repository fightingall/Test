package LinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试代码
        HeroNode hero1=new HeroNode(1,"宋江","及时雨");
        HeroNode hero2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3=new HeroNode(3,"吴用","智多星");
        HeroNode hero4=new HeroNode(4,"林冲","豹子头");
        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();

        HeroNode hero5=new HeroNode(2,"吴彦","wuyan");
        singleLinkedList.update(hero5);
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero2);
//显示链表
        singleLinkedList.list();
    }
}
    class SingleLinkedList{
        //初始化头节点，头节点不要动
        private HeroNode head=new HeroNode(0,"","");
       //添加节点
        public void add(HeroNode heroNode) {
            //找到最后节点，将这个节点next指向新的节点
            HeroNode temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                //退出while循环时，temp指向链表的最后
                temp = temp.next;
            }
            temp.next=heroNode;
            //当退出while循环后，temp就指向了链表最后，将这个节点的next指向新节点
        }
        //按照排名插入到指定的位置
        public void addByOrder(HeroNode heroNode){
            HeroNode temp=head;
            boolean flag=false;
            while (true){
                if(temp==null){
                    break;
                }
                if(temp.next.no>heroNode.no){
                    break;
                }
                else if(temp.next.no==heroNode.no){
                    flag=true;
                    break;
                }
                temp=temp.next;//后移，遍历当前链表
            }
            if (flag){
                System.out.println("编号已经存在，不能继续添加"+heroNode.no);
            }else {
                heroNode.next=temp.next;
                temp.next=heroNode;
            }
        }
        public void update(HeroNode newHeroNode){
            if(head.next==null){
                return;
            }
            HeroNode temp=head.next;
            boolean flag=false;
            while (true){
                if(temp==null){break;}
                if(temp.no==newHeroNode.no){
                    flag=true;
                    break;
                }
                if (flag){
                    temp.name=newHeroNode.name;
                    temp.nickname=newHeroNode.nickname;
                }else {
                    System.out.println("没有找到相关节点");
                }
            }
        }
        //显示链表
         public void list(){
                if(head.next==null){
                    System.out.println("链表为空");
                    return;
                }
                HeroNode temp=head.next;
                while (true){
                    if(temp==null){
                        break;
                    }
                    System.out.println(temp);
                    temp=temp.next;
                }
            }
        }
    class HeroNode{
        public int no;
        public String name;
        public String nickname;
        public HeroNode next;//指向下一个节点
        public HeroNode(int no,String name,String nickname){
            this.no=no;
            this.name=name;
            this.nickname=nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }

