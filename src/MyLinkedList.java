/**
 * Created With IntelliJ IDEA.
 * Description:单链表
 * User:Zoushaungshuang
 * Date:2020-07-23
 * Time:15:44
 **/
class Node{
    private int data;
    private Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public class MyLinkedList {
    private Node head;
    public void addFirst(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        node.setNext(head);
        this.head = node;
    }
    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.getNext() != null){
            cur = cur.getNext();
        }
        cur.setNext(node);
    }
    public int size(){
        Node cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }
    public boolean contains(int key){
        Node cur = this.head;
        while(cur != null){
            if (cur.getData() == key){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }
    public Node findIndex(int index){
        int count = 0;
        Node pre = this.head;
        while(count < index-1){
            count++;
            pre = pre.getNext();
        }
        return pre;
    }
    public void addIndex(int index,int data){
        if (index<0 || index>size()){
            throw new RuntimeException("下标位置异常");
        }
        if (index == 0){
            addFirst(data);
        }
        if (index == size()){
            addLast(data);
        }
        Node pre = findIndex(index);
        Node node = new Node(data);
        node.setNext(pre.getNext());
        pre.setNext(node);
    }

    public void display(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.getData()+" ");
            cur = cur.getNext();

        }
    }
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(10);
        myLinkedList.addLast(20);
        myLinkedList.addLast(30);
        myLinkedList.addLast(40);
        myLinkedList.display();
        int ret = myLinkedList.size();
        System.out.println(ret);
        boolean tmp = myLinkedList.contains(90);
        System.out.println(tmp);
        myLinkedList.addIndex(2,88);
        myLinkedList.display();
        System.out.println();

    }
}
