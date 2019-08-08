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

    // This method mainly calls deleteRec()
    void delete( int data){
        root = deleteRec(root,data);
    }

    Node deleteRec(Node root, int data){
        if(root == null)
            return null;
        else if(data < root.data)
            root.left = deleteRec(root.left,data);
        else if(data > root.data)
            root.right = deleteRec(root.right,data);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
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
        bst.insert(7);
        bst.insert(8);

        bst.inorderTraversal(bst.root);
        Node result = bst.search(bst.root,10);
        if(null != result)
            System.out.println("Element found");
        else
            System.out.println("Element not found");

        bst.delete(5);
        bst.inorderTraversal(bst.root);

    }
}
