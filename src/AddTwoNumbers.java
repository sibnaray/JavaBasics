import datastructures.Node;

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//Example
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.

public class AddTwoNumbers {
    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next= new Node(4);
        l1.next.next= new Node(3);

        Node l2 = new Node(5);
        l2.next= new Node(6);
        l2.next.next= new Node(4);

        Node result = addTwoNumbers(l1,l2);
    }

    public static  Node addTwoNumbers(Node l1, Node l2) {
        Node dummyHead = new Node(0);
        Node p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while(p!=null || q!=null){
            int p_val = (p!=null)?p.val:0;
            int q_val = (q!=null)?q.val:0;
            int sum = p_val + q_val + carry;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        }
        if(carry > 0){
            curr.next = new Node(carry);
        }
        return dummyHead.next;
    }
}

