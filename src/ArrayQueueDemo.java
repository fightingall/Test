public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.getQueue();
        queue.showQueue();
    }
}
//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue{
    private int maxSize; //表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr; //该数组用于存放数据,模拟队列

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    //判断队列是否已满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列已满");
            return;
        }

        arr[++rear] = n;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列已空");
        }
        return arr[++front];
    }

    //显示队列所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列已空");
            return;
        }

        for(int i = front+1 ;i <= rear;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
}
