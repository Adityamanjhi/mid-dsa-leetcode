package LinkedList.Easy;

public class LinkedListCycle {

    static class Node {
        int val;
        Node next;
        Node(int x) {
            val = x;
            next = null;
        }
    }

    static boolean detectLoop(Node head) {
        Node sHead = head;
        Node fHead = head;
        while (sHead != null && fHead != null && fHead.next != null) {
            sHead = sHead.next;
            fHead = fHead.next.next;
            if(sHead == fHead) {
                return true;
            }
        }
        return false;
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

        if (detectLoop(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
