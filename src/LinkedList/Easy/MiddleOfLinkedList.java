package LinkedList.Easy;

public class MiddleOfLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode middleNode(ListNode head) {
        ListNode middleNode = head;
        int length = 0;
        ListNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
            length++;
        }
        int middle = (length+1)/2;
        for(int i = 0; i < middle; i++) {
            middleNode = middleNode.next;
        }
        return middleNode;
    }

    private static ListNode tortoiseHareMiddleNode(ListNode head) {
        ListNode sNode = head;
        ListNode fNode = head;
        while(fNode != null && fNode.next != null) {
            sNode = sNode.next;
            fNode = fNode.next.next;
        }
        return sNode;
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
//        printList(middleNode(head));
        printList(tortoiseHareMiddleNode(head));
    }
}
