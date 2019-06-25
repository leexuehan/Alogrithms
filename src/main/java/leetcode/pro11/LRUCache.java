package leetcode.pro11;

import java.util.LinkedHashMap;

/**
 * @author leexuehan on 2019/6/24.
 *         <p>
 *         手写 LRUCache(Least Recently Used) 算法
 */
public class LRUCache {
    private final int MAX_CAPACITY;
    private int elemNum = 0;
    private Node head;
    private Node tail;

    //利用双向循环链表实现

    //双向循环链表中的一个结点
    class Node {
        Node prev;
        Node next;
        Integer key;
        Integer value;

        public Node(Integer key, Integer value) {
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
    }

    public int get(int key) {
        Node cur = head;
        while (cur != tail) {
            if (cur.key == key) {
                //添加到链表结尾
                appendToTail(cur.key, cur.value);
                //删除链表头
                Node oldHead = head;
                head = oldHead.next;
                oldHead = null;
                return cur.value;
            }
            cur = cur.next;
        }

        return -1;
    }

    public void put(int key, int value) {
        //空
        if (elemNum == 0) {
            Node node = new Node(key, value);
            head = node;
            tail = node;
            head.next = tail;
            tail.next = head;
            elemNum++;
        }
        //满了
        else if (elemNum == MAX_CAPACITY) {
            //添加到链表结尾
            appendToTail(key, value);
            //删除链表头
            Node oldHead = head;
            head = oldHead.next;
            oldHead = null;
        }
        //添加到链表的结尾
        else {
            appendToTail(key, value);
            elemNum++;
        }
    }

    private void appendToTail(int key, int value) {
        Node node = new Node(key, value);
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

}

/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
