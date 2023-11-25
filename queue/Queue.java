package queue;

public class Queue {
    Node head,tail;

    public void enqueue(Tree.Node node){
        Node newNode = new Node(node);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public Tree.Node dequeue(){
        if(isEmpty()){
            throw new RuntimeException("The Queue is Empty");
        }
        Tree.Node node= head.node;
        head = head.next;


        return node;
    }
}
