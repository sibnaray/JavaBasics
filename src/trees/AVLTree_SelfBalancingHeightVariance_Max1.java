package trees;

class AVLNode{
    int key, height;
    AVLNode left, right;

    AVLNode(int d){
        key = d;
        height = 1;
    }
}
public class AVLTree_SelfBalancingHeightVariance_Max1 {
 AVLNode root;

 int height(AVLNode n){
     if (n==null)
         return 0;
     else
         return n.height;
 }
//     y                               x               20               10
//    / \     Right Rotation          /  \            /  \             /  \
//   x   T3   - - - - - - - >       T1    y          10   25          5   20
//  / \       < - - - - - - -            / \        /  \                 /  \
// T1  T2     Left Rotation             T2  T3     5   15               15  25

    AVLNode rightRotate(AVLNode y){
     AVLNode x = y.left;
     AVLNode T2 = x.right;

     x.right = y;
     y.left = T2;

     y.height = Math.max(height(y.left),height(y.right))+1;
     x.height = Math.max(height(x.left), height(x.right)) + 1;

     return x;
 }

    AVLNode leftRotate(AVLNode x){
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(AVLNode n) {
        if (n == null)
            return 0;

        return height(n.left) - height(n.right);
    }


    AVLNode insert(AVLNode node,int key){
     if(node == null)
         return new AVLNode(key);
     if(node.key<key){
         node.right = insert(node.right,key);
     }
     if(node.key>key){
         node.left =  insert(node.left,key);
     }

     /* 2. Update height of this ancestor node */
        node.height = 1 + Math.max(height(node.left),height(node.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        //Left - Left
        if(balance > 1 && key < node.left.key )
            return rightRotate(node);
        // Right - Right
        if(balance < -1 && key > node.right.key)
            return leftRotate(node);
        //Left - Right
        if(balance > 1 && key > node.left.key){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //Right - Left
        if(balance < -1 && key < node.right.key){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    void preOrder(AVLNode node){
        if(node != null){
            System.out.println(node.key+"."+node.height);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree_SelfBalancingHeightVariance_Max1 tree = new AVLTree_SelfBalancingHeightVariance_Max1();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder(tree.root);
    }
}

