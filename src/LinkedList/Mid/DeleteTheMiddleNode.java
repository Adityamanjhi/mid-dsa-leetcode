package LinkedList.Mid;

public class DeleteTheMiddleNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int _val) {
            val = _val;
            next = null;
        }
    }

    static ListNode removeMiddleNode(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

//        head.next = second;
//        second.next = third;
//        third.next = fourth;
//        fourth.next = fifth;
//        fifth.next = sixth;
//        printList(removeNthNode(head, 4));
        printList(removeMiddleNode(head));
    }
}
