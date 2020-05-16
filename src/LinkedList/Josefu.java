package LinkedList;

public class Josefu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(10);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,10);
    }
}
//创建一个环形的单向链表
class CircleSingleLinkedList{
    private Boy first=new Boy(-1);
    //添加元素数据boy
    public void addBoy(int nums){
        if(nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy=null;
        for (int i=1;i<nums;i++){
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }
    //遍历环形链表
    public void showBoy(){
        if(first==null){
            System.out.println("链表为空");
            return;
        }
        //
        Boy curBoy=first;
        while (true){
            System.out.printf("小孩的编号%d\n",curBoy.getNum());
            if(curBoy.getNext()==first){//说明已经遍历完毕
                break;
            }
            curBoy=curBoy.getNext();//curBoy后移
        }
    }

    public void countBoy(int startNum,int countNum,int nums){
        if(first==null||startNum<1||startNum>nums){
            System.out.println("参数输入有误，请重新输入");
        }
        Boy helper=first;
        while (true){
            if(helper.getNext()==first){break;}//说明helper是最后一个节点
            helper=helper.getNext();
        }
        for(int j=0;j<startNum;j++){
            first=first.getNext();
            helper=helper.getNext();
        }
        while (true){
            if(helper==first){//说明圈中只有一个节点
                break;
            }
            //让first和helper指正同时移动cuntNum-1
            for (int j=0;j<countNum;j++){
                first=first.getNext();
                helper=helper.getNext();
            }
            //这是first指向的节点就是出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.getNum());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("留在圈中的小孩编号是%d\n",first.getNum());
    }
}

class Boy{
    private int num;
    private Boy next;//指向下一个节点，默认为null
    public Boy(int num){
        this.num=num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
