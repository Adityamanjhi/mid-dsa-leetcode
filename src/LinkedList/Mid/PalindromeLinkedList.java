package LinkedList.Mid;

import java.util.Stack;

public class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int _val) {
            val = _val;
            next = null;
        }
    }

    static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> st = new Stack<>();
        while(temp != null)  {
            st.push(temp.val);
            temp = temp.next;
        }
        while(head != null) {
            int stVal = st.pop();
            if(stVal != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    static boolean isPalindromeOptimal(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode sNode = head;
        ListNode fNode = head;
        while (fNode.next != null && fNode.next.next != null) {
            sNode = sNode.next;
            fNode = fNode.next.next;
        }
        ListNode secondHalf = reverseList(sNode.next);
        while (secondHalf != null) {
            if(head.val != secondHalf.val) {
                return false;
            }
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode second = new ListNode(7);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(3);
        ListNode fifth = new ListNode(7);
        ListNode sixth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
//        System.out.println(isPalindrome(head));
        System.out.println(isPalindromeOptimal(head));
    }
}
