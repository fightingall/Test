package PolandNotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        String suffixExpression="34+5*6-";//计算(3+4)*5-6的值
        List<String> printList=getListString(suffixExpression);
        System.out.println("List is"+printList);
        int res=calculate(printList);
        System.out.println("计算结果是："+res);
    }
    public static List<String> getListString(String suffixExpression){
        String[] split=suffixExpression.split("");
        List<String> list=new ArrayList<>();
        for(String els:split){
            list.add(els);
        }
        return list;
    }

    public static int calculate(List<String> ls){
        Stack<String> stack=new Stack<>();
        for(String item:ls){
            if(item.matches("\\d+")){//使用正则表达式，匹配的是多位数
                stack.push(item);
            }else {
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if(item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res=num1-num2;
                }else if(item.equals("*")){
                    res=num1*num2;
                }else if(item.equals("/")){
                    res=num1/num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(""+res);//此处要把int类型的res转换成string类型的
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
