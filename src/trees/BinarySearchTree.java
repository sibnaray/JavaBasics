package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;
    BinarySearchTree(){
        root = null;
    }

    //Depth First Traversals.
    void inorderTraversal(Node temp){
        if(temp == null){
            return;
        }
        inorderTraversal(temp.left);
        System.out.println(temp.data+" ");
        inorderTraversal((temp.right));
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }


    Node insertRec(Node root, int data){
        if(root == null){
            root = new Node(data);
        }else{
            if(data > root.data){
                root.right=insertRec(root.right,data);
            }else{
                root.left=insertRec(root.left,data);
            }
        }
        return root;
    }

    Node search(Node root, int key){
        if(root == null || root.data == key)
            return  root;
        else if(key > root.data)
            return search(root.right,key);
        else
            return search(root.left,key);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(4);
        bst.insert(6);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        bst.insert(7);
        bst.insert(8);

        bst.inorderTraversal(bst.root);
        Node result = bst.search(bst.root,10);
        if(null != result)
            System.out.println("Element found");
        else
            System.out.println("Element not found");
    }
}
