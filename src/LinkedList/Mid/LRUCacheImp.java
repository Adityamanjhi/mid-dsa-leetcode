package LinkedList.Mid;

import java.util.HashMap;

 class LRUCache {
      class Node {
         int key;
         int value;
         Node next;
         Node prev;

         public Node(int k, int v) {
             key = k;
             value = v;
         }
     }
     int capacity;
     HashMap<Integer, Node> map = new HashMap<>();
     Node head = new Node(-1, -1);
     Node tail = new Node(-1, -1);

    public LRUCache(int capacity_) {
        capacity = capacity_;
        map.clear();
        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertAfterHead(Node newNode) {
        Node currentHead = head.next;
        head.next = newNode;
        newNode.next = currentHead;
        newNode.prev = head;
        currentHead.prev = newNode;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        } else {
            if(map.size() == capacity) {
                Node lastNode = tail.prev;
                map.remove(lastNode.key);
                deleteNode(lastNode);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAfterHead(newNode);
        }
    }
}

public class LRUCacheImp {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
    }
}

