package Tree;

import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    Node root;
    int index;
    boolean match;
    int max,min;

    public BinaryTree(){
        index = -1;
        match = false;
        max = min = -1;
    }
    // insert method by getting from user
    public void insert(Scanner scanner){
        System.out.print("Please Enter the value for Root Node : ");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(scanner,root);
    }
    public void insert(Scanner scanner,Node root){
        System.out.println("Do you want to insert the node in the Left of the "+root.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.print("Please Enter the value for Node that is Left to : "+root.value+" : ");
            int value = scanner.nextInt();
            root.left = new Node(value);
            insert(scanner,root.left);
        }

        System.out.println("Do you want to insert the node in the Right of the "+root.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.print("Please Enter the value for Node that is Right to : "+root.value+" : ");
            int value = scanner.nextInt();
            root.right = new Node(value);
            insert(scanner,root.right);
        }
    }
    // insert method by array from user
    public void insert(int [] nodes){
        root = insert(nodes,root);
    }
    public Node insert(int [] nodes,Node root){
        index++;
        if(nodes[index] == -1){
            return null;
        }
        root = new Node(nodes[index]);
        root.left = insert(nodes,root.left);
        root.right = insert(nodes,root.right);

        return root;
    }

    public void preOrder(){
        System.out.println("Pre Order Traversal");
        preOrder(root);
    }
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.value+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(){
        System.out.println("Post Order Traversal");
        postOrder(root);
    }
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value+" ");
    }

    public void inOrder(){
        System.out.println("In Order Traversal");
        inOrder(root);
    }
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.value+" ");
        inOrder(root.right);
    }

    public void levelTraversal(){
        System.out.println("Level Traversal");
        levelTraversal(root);
    }
    public void levelTraversal(Node root){
        if(root == null){
            return;
        }
        queue.Queue q = new queue.Queue();
        q.enqueue(root);
        q.enqueue(null);
        while(!q.isEmpty()){
            Node temp = q.dequeue();
            if(temp == null){
                System.out.println();
                if(q.isEmpty()){
                    return;
                }
                else {
                    q.enqueue(null);
                }
            }else {
                System.out.print(temp.value+" ");
                if(temp.left != null){
                    q.enqueue(temp.left);
                }
                if(temp.right != null){
                    q.enqueue(temp.right);
                }

            }
        }
    }
    public boolean search(int key){
        search(key,root);
        return match;
    }
    public void search(int key,Node root){
        if(root == null){
            return;
        }
        if(root.value == key){
            match = true;
            return;
        }
        search(key, root.left);
        search(key, root.left);
    }

    public int findMax() throws Exception{
        max = root.value;
        findMax(root);
        if(max == -1){
            throw new Exception("Tree is Empty");
        }
        return max;
    }
    public void findMax(Node root){
        if(root == null){
            return;
        }
        if(root.value > max){
            max = root.value;
        }
        findMax(root.left);
        findMax(root.right);
    }

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        int [] nodes = {4,2,6,-1,-1,-1,1,10,-1,-1,-1};
//        tree.insert(scanner);
        tree.insert(nodes);
        System.out.println(tree.search(78));
        System.out.println(tree.max);
    }
}
