package LinkedList.Mid;

public class RemoveNth_NodeFromList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int _val) {
            val = _val;
            next = null;
        }
    }

    static ListNode removeNthNode(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        int deleteNodeInd = length - n + 1;
        if(deleteNodeInd == 1) {
            return head.next;
        }
        temp = head;
        int cnt = 1;
        while(cnt < deleteNodeInd - 1) {
            temp = temp.next;
            cnt++;
        }
        temp.next = temp.next.next;
        return head;
    }

    static ListNode removeNthNodeOpt(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int cnt = 0;
        if(head == null) {
            return null;
        }
        while(cnt <= n) {
            fast = fast.next;
            cnt++;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
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

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
//        printList(removeNthNode(head, 4));
        printList(removeNthNodeOpt(head, 5));
    }
}
