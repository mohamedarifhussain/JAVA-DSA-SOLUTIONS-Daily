class ListNode {
   int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class reorder_list_leetcode {
    

    public static void reorderList(ListNode head) {

        if(head==null || head.next==null) return;

        ListNode slow = head;
        ListNode fast = slow;

        while(fast!=null && fast.next!=null){

            slow = slow.next;
            fast = fast.next;
            if(fast!=null) fast = fast.next;
        }

        ListNode prev=null;
        ListNode cur = slow;
        ListNode fut = cur;

        while(fut!=null){
            fut = cur.next;
            cur.next = prev;
            prev = cur;
            cur = fut;
            
        }

        ListNode left = head;
        ListNode right = prev;

        while(right!=null && left!=null){
            ListNode past =  left;
            left = left.next;
            past.next = right;
            past = right;
            right = right.next;
            if(right!=null){
                past.next = left;
            }
        }
        

        return;
        
    }


    static void printLL(ListNode head){

        while(head!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        

        ListNode head = new ListNode(1);
        ListNode start = head;

        for(int i=2;i<=10;i++){
            head.next = new ListNode(i);
            head = head.next;
        }
        System.out.println("Before reorder");
        printLL(start);

        reorderList(start);

        System.out.println("After reorder");
        printLL(start);

        
    }
}


/* 
143. Reorder List
Solved
Medium
Topics
premium lock icon
Companies
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000 */