package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    BinaryTree()
    {
        root = null;
    }

    //Height of tree
    static int height(Node root){
        if(root == null){
            return 0;
        }
        else{
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }

    }

    //Print nodes at the given level
    static void printLevelOrder(Node root){
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }

    static void printGivenLevel(Node root, int level){
        if (root == null)
            return;
        if(level == 1)
            System.out.println(root.data+ " ");
        else if(level > 1){
            printGivenLevel(root.left,level -1);
            printGivenLevel(root.right, level-1);
        }
    }

    static void printLevelOrder_Queue(Node root){
        if(null == root)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp.data);

            /*Enqueue left child */
            if(temp.left!=null)
                queue.add(temp.left);

            /*Enqueue right child */
            if(temp.right != null)
                queue.add(temp.right);
        }
    }

    //Depth First Traversals.
    static void inorderTraversal(Node temp){
        if(temp == null){
            return;
        }
        inorderTraversal(temp.left);
        System.out.println(temp.data+" ");
        inorderTraversal((temp.right));
    }

    static void preOrderTraversal(Node temp){
        if(temp == null){
            return;
        }

        System.out.println(temp.data+" ");
        preOrderTraversal(temp.left);
        preOrderTraversal((temp.right));
    }

    static void postOrderTraversal(Node temp){
        if(temp == null){
            return;
        }

        postOrderTraversal(temp.left);
        postOrderTraversal((temp.right));
        System.out.println(temp.data+" ");

    }

    //The idea is to do iterative level order traversal of the given tree using queue. If we find a node whose left
    // child is empty, we make new key as left child of the node. Else if we find a node whose right child is empty,
    // we make new key as right child. We keep traversing the tree until we find a node whose either left or right is empty.
    static void insertNode(BinaryTree binaryTree, int data){
        if (binaryTree.root == null){
            binaryTree.root = new Node(data);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(binaryTree.root);
        while(!queue.isEmpty()){
            Node temp = queue.peek();
            queue.remove();

            if(temp.left==null){
                temp.left=new Node(data);
                break;
            }else
                queue.add(temp.left);

            if(temp.right==null){
                temp.right=new Node(data);
                break;
            }else
                queue.add(temp.right);
        }
    }

    static void deleteNode(BinaryTree binaryTree, int data){
        if (binaryTree.root == null){
            return;
        }else if(binaryTree.root.data == data && binaryTree.root.left == null && binaryTree.root.right==null){
            binaryTree.root=null;
            return;
        }


        Queue<Node> queue = new LinkedList<>();
        queue.add(binaryTree.root);
        Node temp=null,d_node = null,parent=null;
        while(!queue.isEmpty()){
            temp = queue.peek();
            queue.remove();
            if(temp.data == data){
                d_node = temp;
            }
            if(temp.left!=null){
                parent = temp;
                queue.add(temp.left);
            }
            if(temp.right!=null){
                parent = temp;
                queue.add(temp.right);
            }
        }

        if(d_node != null){
            d_node.data = temp.data;
            if(parent.left.data == temp.data){
                parent.left=null;
            }else if(parent.right.data == temp.data){
                parent.right = null;
            }
        }
    }



    /*
                    1
                2      3
             4    5  6   7
     */

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        insertNode(binaryTree,1);
        insertNode(binaryTree,2);
        insertNode(binaryTree,3);

        insertNode(binaryTree,4);
        insertNode(binaryTree,5);
        insertNode(binaryTree,6);
        insertNode(binaryTree,7);

        System.out.println("Height : "+height(binaryTree.root));

        System.out.println("Breadth First Search OR Level Order ");
        printLevelOrder(binaryTree.root);

        System.out.println("PreOrder Traversal");
        preOrderTraversal(binaryTree.root);

        System.out.println("In Order Traversal");
        inorderTraversal(binaryTree.root);

        System.out.println("Post Order Traversal");
        postOrderTraversal(binaryTree.root);

        System.out.println("Breadth First Search OR Level Order  - Queue");
        printLevelOrder_Queue(binaryTree.root);

        System.out.println("Delete Node");
        deleteNode(binaryTree,7);

        System.out.println("Breadth First Search OR Level Order  - After Deletion");
        printLevelOrder_Queue(binaryTree.root);

    }
}
