package LinkedList.Hard;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    int cnt;
    Node prev;
    Node next;
    public Node(int _key, int _value) {
        key = _key;
        value = _value;
        cnt = 1;
    }
}

class LFUCache {
    int capacity;
    Map<Integer, Pair<Node, Node>> freqMap;
    Map<Integer, Node> map;
    int minFreq;
    public LFUCache(int _capacity) {
        capacity = _capacity;
        minFreq = 0;
        freqMap = new HashMap<>();
        map = new HashMap<>();
    }

    static class Pair<F, S> {
        F first;
        S second;
        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(capacity == 0) {
            return;
        }
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }
        // remove least frequently used element
        if(map.size() == capacity) {
            Node node = freqMap.get(minFreq).second.prev;
            map.remove(node.key);
            deleteNode(node);
        }
        Node node = new Node(key, value);
        map.put(key, node);

        // Reset min frequency to 1
        minFreq = 1;
        addNode(node, minFreq);
    }

    void updateFreq(Node node) {
        int oldFreq = node.cnt;
        node.cnt++;
        deleteNode(node);
        // in case DDL (LRU) becomes empty remove it from frequency map
        if(freqMap.get(oldFreq).first.next == freqMap.get(oldFreq).second) {
            freqMap.remove(oldFreq);
            // also minFreq increased as we remove min frequency list from freqMap
            if(minFreq == oldFreq) {
                minFreq++;
            }
        }
        addNode(node, node.cnt);
    }

    void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    void addNode(Node node, int freq) {
        if(!freqMap.containsKey(freq)) {
            Node head = new Node(-1, -1);
            Node tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            freqMap.put(freq, new Pair<>(head, tail));
        }
        Node head = freqMap.get(freq).first;
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
}

public class LFUCacheImpl {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.get(1) + " ");
        cache.put(3, 3);
        System.out.print(cache.get(2) + " ");
        cache.put(4, 4);
        System.out.print(cache.get(3) + " ");
        System.out.print(cache.get(4) + " ");
        cache.put(5, 5);
    }
}
