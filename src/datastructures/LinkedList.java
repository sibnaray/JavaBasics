package datastructures;

public class LinkedList {
    public Node head;
    // Method to insert a new node
    public LinkedList insert(LinkedList list, int data){
        Node newNode = new Node(data);
        if(list.head == null){
            list.head = newNode;
        }else{
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
        }
        return list;
    }

    // Method to print the LinkedList.
    public void printList(LinkedList list)
    {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.val + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }
}
