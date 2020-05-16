package HashTable;

import java.util.Scanner;

public class HashTableDemo  {
    public static void main(String[] args) {
        //创建哈希表
        HashTable hashTable=new HashTable(7);
        String key="";
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id=scanner.nextInt();
                    System.out.println("输入name");
                    String name=scanner.next();
                    Emp emp=new Emp(id,name);//创建雇员
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id=scanner.nextInt();
                    hashTable.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
//创建哈希表 管理多链表
class HashTable{
   private EmpLinkedList[] empLinkedListArray;
   private int size;
   public HashTable(int size){
       this.size=size;
       empLinkedListArray=new EmpLinkedList[size];
       for (int i=0;i<size;i++){
           //初始化每个链表
           empLinkedListArray[i]=new EmpLinkedList();
       }
   }
   public void add(Emp emp){
       //根据员工的id，得到该员工应当添加到哪一条链表
       int empLinkedListNo=hashFun(emp.id);
       //将emp添加到对应的链表中去
       empLinkedListArray[empLinkedListNo].add(emp);
   }
   //遍历哈希表：数组加上链表构成
   public void list(){
       for (int i=0;i<size;i++){
           empLinkedListArray[i].list();
       }
   }
   //编写一个散列函数，简单的就是取模法
    public int hashFun(int id){
       return id % size;
    }
    //根据输入雇员的id查找雇员
    public void findEmpById(int id){
       int empLinkedListNo=hashFun(id);
       Emp emp=empLinkedListArray[empLinkedListNo].findEmpById(id);
       if (emp!=null){
           System.out.println("找到雇员");
       }
       else {
           System.out.println("在哈希表中没有找到雇员的信息");
        }
    }

}

//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id,String name){
        super();
        this.id=id;
        this.name=name;
    }
}
class EmpLinkedList{
    private Emp head;//默认为null
    //添加雇员到链表中去 id自增长
    public void add(Emp emp){
        if(head==null){
            head=emp;
            return;
        }
        //如果不是第一个雇员，使用一个辅助的指针，帮助定位到最后
        Emp curEmp=head;
        while (true){
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;//后移
        }
        //
        curEmp.next=emp;
    }
    public void list(){
        if(head==null){
            System.out.println("当前链表为空");
            return;
        }
        Emp curEmp=head;//辅助指针
        while (true){
            System.out.printf("=> id=%d name=%s\t",curEmp.id,curEmp.name);
            System.out.println();
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;//后移遍历
        }
    }
    public Emp findEmpById(int id){
        if(head==null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp=head;
        while (true){
            if(curEmp.id==id){
                break;
            }
            if(curEmp.next==null){
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;
        }
        return curEmp;
    }
}
