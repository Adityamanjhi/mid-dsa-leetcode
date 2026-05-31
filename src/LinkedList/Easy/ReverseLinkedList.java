package LinkedList.Easy;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ReverseLinkedList {

    static ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null) {
//            return head;
//        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static ListNode reverseListRecursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode rest = reverseListRecursive(head.next);
        head.next.next = head; // reverse link
        head.next = null; // remove circular loop
        return rest;
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
        int[] list = new int[]{1,2,3,4,5};
        ListNode head = null;
        ListNode lastEle = null;
        for(int i: list) {
            ListNode ele = new ListNode(i);
            if(head == null) {
                head = ele;
                lastEle = ele;
            } else {
                lastEle.next = ele;
                lastEle = ele;
            }
        }
        printList(head);
        printList(reverseList(head));
    }
}
