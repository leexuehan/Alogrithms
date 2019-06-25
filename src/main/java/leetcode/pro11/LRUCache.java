package leetcode.pro11;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author leexuehan on 2019/6/24.
 *         <p>
 *         手写 LRUCache(Least Recently Used) 算法
 */
public class LRUCache {
    private final int capacity;

    //use map to store values in order to get value in time complexity:O(1)
    private HashMap<Integer, Node> map = new HashMap<>();
    //use list to save values in order to delete node which is Least Recently Used.
    private LinkedList<Node> list = new LinkedList<>();

    private final class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;

    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            list.remove(node);
            list.addLast(node);
            return node.value;
        }
        //not exists
        else {
            return -1;
        }

    }

    public void put(int key, int value) {
        Node node = map.get(key);
        //if key exists,then change the value of key
        if (node != null) {
            node.value = value;
            map.put(key, node);
            list.remove(node);
            list.addLast(node);
            return;
        }
        //key not exists
        if (list.size() == capacity) {
            //delete LRU node
            Node removed = list.removeFirst();
            map.remove(removed.key);
        }

        node = new Node(key, value);
        list.addLast(node);
        map.put(key, node);
    }

}

