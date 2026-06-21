package LinkedList.Mid;

public class SortLinkedListOfZeroOneTwo {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int _val) {
            val = _val;
            next = null;
        }
    }

    static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode zeroDummy = new ListNode(-1);
        ListNode oneDummy = new ListNode(-1);
        ListNode twoDummy = new ListNode(-1);
        ListNode zeroHead = zeroDummy;
        ListNode oneHead = oneDummy;
        ListNode twoHead = twoDummy;
        while(head != null) {
            if(head.val == 0) {
                zeroDummy.next = head;
                zeroDummy = zeroDummy.next;
            } else if(head.val == 1) {
                oneDummy.next = head;
                oneDummy = oneDummy.next;
            } else if(head.val == 2) {
                twoDummy.next = head;
                twoDummy = twoDummy.next;
            }
            head = head.next;
        }
        zeroDummy.next = oneHead.next != null ? oneHead.next : twoHead.next;
        oneDummy.next = twoHead.next;
        twoDummy.next = null;
        return zeroHead.next;
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
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(1);
        ListNode fifth = new ListNode(0);
        ListNode sixth = new ListNode(2);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
//        printList(removeNthNode(head, 4));
        printList(sortList(head));
    }
}
