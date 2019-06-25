package leetcode.pro11;

import java.util.HashMap;

/**
 * @author leexuehan on 2019/6/24.
 *         <p>
 *         手写 LRUCache(Least Recently Used) 算法
 */
public class LRUCache {
    private final int MAX_CAPACITY;
    private Node head;
    private Node tail;

    private HashMap<Integer, Node> map = new HashMap<>();

    //利用双向循环链表实现

    //双向循环链表中的一个结点
    class Node {
        Node prev;
        Node next;
        Integer key;
        Integer value;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }


    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity:" + capacity + "(expected > 0)");
        }
        MAX_CAPACITY = capacity;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            //添加到链表结尾
            appendToTail(node);
            //删除链表头
            deleteHead();
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        //if exists
        if (n != null) {
            Node newNode = new Node(key, value);
            //override map if exists
            map.put(key, newNode);
            //添加到链表结尾
            appendToTail(newNode);
            //删除链表头
            deleteHead();
            return;
        }
        Node node = new Node(key, value);
        //update list first
        //满了
        if (map.size() == MAX_CAPACITY) {
            //添加到链表结尾
            appendToTail(node);
            //删除链表头
            map.remove(head.key);
            deleteHead();
        }
        //添加到链表的结尾
        else {
            appendToTail(node);
        }

        //update map
        map.put(key, node);

    }

    private void deleteHead() {
        Node old = head;
        head.next = old.next;
        old.prev = head;
        old = null;
    }

    private void appendToTail(Node node) {
        node.next = tail.next;
        node.prev = tail.prev;

        node.prev.next = node;
        tail.prev = node;
    }

}

/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
