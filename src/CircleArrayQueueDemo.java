import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {

        System.out.println("测试数组模拟环形队列的案例");

        //创建一个环形队列 说明设置4，其队列数据最大是3
        CircleArray queue = new CircleArray(4);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数字");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e'://退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
    static class CircleArray{
        private int maxSize;
        private int front;
        private int rear;
        private int[] arr;
        public CircleArray(int maxSize){
            this.maxSize=maxSize;//构造函数初始化
            arr=new int[maxSize];
        }
        public boolean isFull(){
            return (rear+1)%maxSize==front;
        }
        public boolean isEmpty(){
            return rear==front;
        }
        public void addQueue(int n){
            if(isFull()){
                System.out.println("队列满,不能加入数据");
                return;
            }
            arr[rear]=n;
            rear=(rear+1)%maxSize;//将rear后移，这里考虑取模
        }
        public int getQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空,不能取数据");
            }
            int value=arr[front];
            front=(front+1)%maxSize;
            return value;
        }
        public void showQueue(){
            if (isEmpty()){
                System.out.println("队列为空，没有数据");
                return;
            }
            for (int i=front;i<front+size();i++){
                System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
            }
        }
        //
        public int size(){
            //加上maxSize 防止模出负数，因为这是一个环形队列
            return (rear+maxSize-front)%maxSize;
        }

        public int headQueue(){
            if (isEmpty()){
                throw new RuntimeException("队列是空的，~没有数据");
            }
            return arr[rear];
        }
    }


}
