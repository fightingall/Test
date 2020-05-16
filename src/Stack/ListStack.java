package Stack;

public class ListStack <T>{
    public static void main(String[] args) throws Exception {
        ListStack<String> list=new ListStack<>();
        list.push("1");
        list.push("2");
        list.push("3");
        list.push("4");
        list.list();
        System.out.println(list.pop());
        System.out.println(list.pop());
    }

    private Node<T> top;
    public ListStack(){
        top=null;
    }
    public void push(T data){
        Node<T> node=new Node<T>(data,top);
        top=node;
    }
    public T pop() throws Exception {
        if (top==null){
            throw new Exception("栈为空，元素不可出栈");
        }
        Node<T> node=top;
        top=top.next;
        return node.data;
    }
    public void list(){
        Node<T> node=top;
        while (node!=null){
            System.out.println(node.data);
            node=node.next;
        }
    }
    class Node<T>{
        private Node<T> next;
        private T data;
        public Node(T data,Node<T> next){
            this.data=data;
            this.next=next;
        }
    }

}
