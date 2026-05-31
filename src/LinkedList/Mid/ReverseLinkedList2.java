package LinkedList.Mid;

public class ReverseLinkedList2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null && left == right) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        for(int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return prev;
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
//        reverseBetween(head, 1, 2);
        printList(reverseBetween(head, 1, 5));
    }

}
