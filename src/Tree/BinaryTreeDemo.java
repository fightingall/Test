package Tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        HeroNode root=new HeroNode(1,"张三");
        HeroNode node2=new HeroNode(2,"李四");
        HeroNode node3=new HeroNode(3,"王五");
        HeroNode node4=new HeroNode(4,"赵六");
        //构建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        binaryTree.setRoot(root);

        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("后序遍历");
        binaryTree.posOrder();
    }
}
class BinaryTree{
    private HeroNode root;
    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void posOrder(){
        if(this.root!=null){
            this.root.posOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }


}
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;//默认null
    private HeroNode right;

    public HeroNode(int no, String name) {
        super();
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        //递归向左子树遍历
        if(this.left!=null){
            this.left.preOrder();
        }
        //递归向右子树遍历
        if(this.right!=null){
            this.right.preOrder();
        }
    }

     public void infixOrder(){
        if(this.left!=null){
            this.left.preOrder();
        }
         System.out.println(this);
        if(this.right!=null){
            this.right.preOrder();
        }
     }

     public void posOrder(){
         if(this.left!=null){
             this.left.posOrder();
         }
         if(this.right!=null){
             this.right.posOrder();
         }
         System.out.println(this);
     }
    //前序遍历查找
     public HeroNode preOrdersearch(int no){
        if(this.no==no){//比较当前节点是不是
            return this;
        }
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.preOrdersearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode=this.right.preOrdersearch(no);
        }
        return resNode;
     }
}
