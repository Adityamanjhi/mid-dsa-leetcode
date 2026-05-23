package LinkedList.Mid;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class DeleteNode {

    static void deleteNode(ListNode node) {
            ListNode nextNode = node.next;
            node.val = nextNode.val;
            node.next = nextNode.next;
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
        int[] list = new int[]{4,5,1,9};
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
        ListNode nextPtr = head.next.next;
        deleteNode(nextPtr);
        printList(head);
    }
}
