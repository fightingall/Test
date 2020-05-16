package Tree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int arr[]={7,3,10,12,5,1,9};
        BinarySortTree binarySortTree=new BinarySortTree();
        for(int i=0;i<arr.length;i++){
            binarySortTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历二叉树");
        binarySortTree.infixOrder();
    }
}

//创建二叉排序树
class BinarySortTree{
    private Node root;
    public void add(Node node){
        if(root!=null){
            root=node;//如果root为空直接指让root指向Node
        }else {
            root.add(node);
        }
    }
    //中序遍历
    public void infixOrder(){
        if (root!=null){
            root.infixOrder();
        }else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }
}
//创建Node节点
class Node{
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }
    //返回左子树的高度
    public int leftHeight(){
        if(left==null){
            return 0;
        }
        return left.height();
    }
    //返回当前节点的高度，以该节点为根节点的树的高度
    public int height(){
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
    }
    //查找要删除的节点
    public Node search(int value){
        if(value==this.value){
            return this;
        }else if(value<this.value){
            if (this.left==null){
                return null;}
            return this.left.search(value);
        }else {//如果查找的值不小于当前节点，向右子树查找
            if(this.right==null){
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找父节点
    public Node searchParent(int value){
        if((this.left!=null&&this.left.value==value) ||(this.right!=null &&this.right.value==value)){
            return this;
        }else {
            if(value<this.value && this.left!=null){
                return this.left.searchParent(value);
            }else if(value>=this.value&&this.right!=null){
                return this.right.searchParent(value);//向右子树递归
            }else {
                return null;
            }
        }
    }


    //输出节点的信息
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加节点的方法
    public void add(Node node){
        if(node==null){
            return;
        }
        if(node.value<this.value){//判断传入的节点的值，与当前子树的根节点的值关系
            if(this.left==null){
                this.left=node;
            }else {
                this.left.add(node);//递归向左子树添加节点
            }
        }else {
            if(this.right==null){
                this.right=node;
            }else {
                this.right.add(node);//递归向右子树添加节点
            }
        }
    }
    //中序遍历 左中右
    public void infixOrder(){
        if (this.left!=null){
            this.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.infixOrder();
        }
    }
}
