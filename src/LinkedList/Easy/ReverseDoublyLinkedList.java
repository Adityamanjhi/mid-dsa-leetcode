package LinkedList.Easy;

import LinkedList.Mid.ReverseLinkedList2;

public class ReverseDoublyLinkedList {

    static class ListNode {
        int val;
        ListNode prev;
        ListNode next;
        ListNode(int x) {
            val = x;
            prev = null;
            next = null;
        }
    }

    static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode last = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = curr.prev;
            curr.prev = next;
            last = curr;
            curr = next;
        }
        return last;
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
        ListNode prev = null;
        for(int i: list) {
            ListNode ele = new ListNode(i);
            if(head == null) {
                head = ele;
                head.prev = null;
                prev = ele;
            } else {
                prev.next = ele;
                ele.prev = prev;
                prev = ele;
            }
        }
        printList(head);
        printList(reverse(head));
    }

}
