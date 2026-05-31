package LinkedList.Mid;

public class DetectCycle {

    static class Node {
        int val;
        Node next;
        Node(int x) {
            val = x;
            next = null;
        }
    }

    static Node detectCycle(Node head) {
        Node sHead = head;
        Node fHead = head;
        while (fHead != null && fHead.next != null) {
            sHead = sHead.next;
            fHead = fHead.next.next;
            if(sHead == fHead) {
                sHead = head;
                while (sHead != fHead) {
                    sHead = sHead.next;
                    fHead = fHead.next;
                }
                return sHead;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;
        Node startPoint = detectCycle(head);
        System.out.println(startPoint != null ? startPoint.val : null);
    }
}
