package Stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack=new ArrayStack(4);
        String key="";
        boolean loop=true;
        Scanner scanner=new Scanner(System.in);
       while (loop){
           System.out.println("show:表示显示栈");
           System.out.println("exit:退出程序");
           System.out.println("push:表示入栈");
           System.out.println("pop:表示出栈");
           key=scanner.next();
           switch (key){
               case "show":
                   arrayStack.list();
                   break;
               case "push":
                   System.out.println("请输入一个数");
                   int value=scanner.nextInt();
                   arrayStack.push(value);
                   break;
               case "pop":
                   int res=arrayStack.pop();
                   System.out.printf("出栈的数据是%d\n",res);
                   break;
               case "exit":
                   scanner.close();
                   loop=false;
                   break;
           }
       }
    }
}
class ArrayStack{
    private int maxsize;//栈的大小
    private int[] stack;//用数组来模拟栈
    private int top=-1;
    //构造器
    public ArrayStack(int maxsize){
        this.maxsize=maxsize;
        stack=new int[maxsize];//初始化数组
    }
    public boolean isFull(){
        return top==maxsize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    //入栈
    public void push(int value){
        if (isFull()){
          System.out.println("栈满了");
          return;
        }
        top++;
        stack[top]=value;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            System.out.println("栈为空");
        }
        int value=stack[top];
        top--;
        return value;
    }
    //遍历时需要从栈底显示
    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有数据");
        }
        for(int i=top;i>0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}