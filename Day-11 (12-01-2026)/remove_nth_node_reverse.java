
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class remove_nth_node_reverse {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode k = head;
        int num = 0;
        while (k != null) {
            num++;
            k = k.next;
        }

        num = (num - n);

        if (num == 0)
            return head.next;

        int i = 0;
        ListNode prev = null;
        ListNode start = head;
        while (i < num) {
            prev = head;
            head = head.next;
            i++;
        }

        if (prev != null)
            prev.next = prev.next.next;

        return start;

    }

    public static void printLL(ListNode head) {

        while (head != null) {
            System.out.print(head.val + "--> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(0);

        ListNode ref = head;

        for (int i = 1; i <= 5; i++) {
            ref.next = new ListNode(i);
            ref = ref.next;
        }

        int n = 2;
        System.out.println("Input Linked List, N=" + n);

        printLL(head);

        ListNode start = removeNthFromEnd(head, n);

        System.out.println("Output LL");

        printLL(start);

    }

}



/* 
19. Remove Nth Node From End of List
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 

Follow up: Could you do this in one pass? */
