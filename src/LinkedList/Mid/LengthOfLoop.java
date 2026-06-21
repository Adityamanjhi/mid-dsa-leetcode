package LinkedList.Mid;

import LinkedList.Easy.LinkedListCycle;

public class LengthOfLoop {
    static class Node {
        int val;
        Node next;
        Node(int x) {
            val = x;
            next = null;
        }
    }

    static int lengthOfLoop(Node head) {
//        int length = 0;
        Node sNode = head;
        Node fNode = head;
        while(fNode != null && fNode.next != null) {
            sNode = sNode.next;
            fNode = fNode.next.next;
            if(sNode == fNode) {
                return countLoopLength(sNode);
//                length = 1;
//                while (sNode != fNode) {
//                    sNode = sNode.next;
//                    length++;
//                }
//                return length;
            }
        }
        return 0;
    }

    static int countLoopLength(Node meetingPoint) {
        Node temp = meetingPoint;
        int length = 1;
        while (temp.next != meetingPoint) {
            temp = temp.next;
            length++;
        }
        return length;
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
        System.out.println(lengthOfLoop(head));

    }
}
