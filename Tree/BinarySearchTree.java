package Tree;

public class BinarySearchTree {
    Node root;

    public void insert(int value){
        root = insert(value,root);
    }
    public Node insert(int value,Node root){
        if(root == null){
            root = new Node(value);
            return root;
        }
        if(root.value > value){
            root.left = insert(value,root.left);
        } else if (root.value < value) {
            root.right = insert(value,root.right);
        }

        return root;
    }

    public void delete(int key){
        delete(key,root);
    }
    public Node delete(int key,Node root){
        if(root == null){
            return null;
        }
        if(root.value > key){
            root.left = delete(key, root.left);
        } else if (root.value < key) {
            root.right = delete(key, root.right);
        } else {
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node IS = inOrderSuccessor(root.right);
            root.value = IS.value;
            root.right = delete(IS.value,root.right);
        }

        return root;
    }
    public Node inOrderSuccessor(Node root){
        if(root.left == null){
            return root;
        }
        return inOrderSuccessor(root.left);
    }

    public int findMax(){
        return findMax(root).value;
    }
    public Node findMax(Node root){
        if(root.right == null){
            return root;
        }
        return findMax(root.right);
    }

    public int findMin(){
        return findMin(root).value;
    }
    public Node findMin(Node root){
        if(root.left == null){
            return root;
        }
        return findMin(root.left);
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
    }
    public void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value+" ");
        inOrderTraversal(root.right);
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
        return search(key,root);
    }
    public boolean search(int key,Node root){
        if(root == null){
            return false;
        }
        if(root.value > key){
            return search(key,root.left);
        } else if(root.value < key){
            return search(key,root.right);
        } else {
            return true;
        }
    }

    public void printInRange(int X,int Y){
        printInRange(X,Y,root);
    }
    public void printInRange(int X,int Y,Node node){
        if(node == null){
            return;
        }
        if(node.value >= X && node.value <= Y){
            printInRange(X,Y,node.left);
            System.out.print(node.value+" ");
            printInRange(X,Y,node.right);
        } else if (node.value > Y) {
            printInRange(X,Y,node.left);
        } else {
            printInRange(X,Y,node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int [] values = {4,1,2,7,2000,6,14,10,16,8};
        for(int i=0;i< values.length;i++){
            tree.insert(values[i]);
        }
        tree.inOrderTraversal();
        System.out.println();
        tree.levelTraversal();
        System.out.println(tree.findMin());
        System.out.println(tree.search(1000));
        tree.printInRange(5,10);
    }
}
