package wheels;

import java.util.Objects;

/**
 * @author leexuehan on 2019/6/26.
 */
public class HashMap<K, V> implements Map<K, V> {
    static final int MAX_CAPACITY = 1 << 30;


    //load factor
    static final float DEFAULT_LOAD_FACTOR = 0.75f;


    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;


    //after the list size exceeds this threshold, it will become a rb tree.
    static final int TREEIFY_THRESHOLD = 8;

    static final int UNTREEIFY_THRESHOLD = 6;


    //store nodes
    transient Node<K, V>[] table;


    //the size of map
    transient int size;

    transient int modCount;

    int threshold;
    final float loadFactor;


    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public HashMap(int initialCapacity, float loadFactor) {
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    private int tableSizeFor(int initialCapacity) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public void put(K key, V value) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int len;
        if ((tab = table) == null || (len = tab.length) == 0) {
            tab = resize();
            len = tab.length;
        }

        int hash = hash(key);
        int index = (len - 1) & hash;
        p = tab[index];
        if (p == null) {
            tab[index] = newNode(hash, key, value, null);
        }
        //hash conflicts:already exists a node
        else {

        }
    }

    private Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
        return new Node<>(hash, key, value, next);
    }

    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    //initializes or doubles table size
    private Node<K, V>[] resize() {
        Node<K, V>[] oldTable = table;
        int oldCapacity = (oldTable == null) ? 0 : oldTable.length;
        int oldThreshold = threshold;
        int newCapacity = 0;
        int newThreshold = 0;


        if (oldCapacity > 0) {
            if (oldCapacity >= MAX_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTable;
            }
            //double capacity
            newCapacity = oldCapacity << 1;
            if (newCapacity < MAX_CAPACITY && oldCapacity >= DEFAULT_INITIAL_CAPACITY) {
                //double threshold
                newThreshold = oldThreshold << 1;
            }
        }
        // oldCapacity = 0 && oldThreshold > 0
        else if (oldThreshold > 0) {
            newCapacity = oldThreshold;
        }
        // oldCapacity = 0 && oldThreshold = 0
        else {
            newCapacity = DEFAULT_INITIAL_CAPACITY;
            newThreshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        }

        if (newThreshold == 0) {
            float ft = (float) newCapacity * loadFactor;
            if (newCapacity < MAX_CAPACITY && ft < (float) MAX_CAPACITY) {
                newThreshold = (int) ft;
            }
            //otherwise
            else {
                newThreshold = Integer.MAX_VALUE;
            }
        }

        //get new threshold
        threshold = newThreshold;
        //new array
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCapacity];
        table = newTab;
        //need to copy data from old table
        if (oldTable != null) {
            for (int i = 0; i < oldCapacity; i++) {
                //get the element from the old bucket
                Node<K, V> e = oldTable[i];
                if (e != null) {
                    //free the memory of the old bucket
                    oldTable[i] = null;
                    //just ordinary nodes
                    if (e.next == null) {
                        //find index and insert to new array
                        newTab[e.hash & (newCapacity - 1)] = e;
                    }
                    //there is a tree
                    else if (e instanceof TreeNode) {

                    }
                    //there is a list under the node at this position,so need to preserve the order
                    else {
                        /*
                         * after the capacity been doubled, index of some nodes in the bucket will be changed,
                         * while others not.
                         *
                         * so there is a condition that can differentiate them:
                         *
                         * e.hash & oldCapacity == 0:
                         *      means that index of nodes will not change, so just hang them under the same index in the new table.
                         * e.hash & oldCapacity != 0:
                         *      means that index of nodes will change to new index, so there is need to hang them under a different index
                         * in the new table.
                         *
                         * the meanings of the pointers below:
                         * - loHead: the head of node list whose index will <strong>not</strong> change.
                         * - loTail: the tail of node list whose index will <strong>not</strong> change.
                         * - hiHead: the head of node list whose index will be changed.
                         * - hiTail: the tail of node list whose index will be changed.
                         */
                        Node<K, V> loHead = null;
                        Node<K, V> loTail = null;
                        Node<K, V> hiHead = null;
                        Node<K, V> hiTail = null;
                        Node<K, V> next;
                        do {
                            next = e.next;
                            //no need to change
                            if ((e.hash & oldCapacity) == 0) {
                                if (loTail == null) {
                                    loHead = e;
                                }
                                //
                                else {
                                    loTail.next = e;
                                }
                                loTail = e;
                            }
                            //need to change
                            else {
                                if (hiTail == null) {
                                    hiHead = e;
                                }
                                //
                                else {
                                    hiTail.next = e;
                                }
                                hiTail = e;
                            }
                        } while ((e = next) != null);

                        if (loTail != null) {
                            table[i] = loHead;
                            loTail.next = null;
                        }
                        if (hiTail != null) {
                            table[i + oldCapacity] = hiHead;
                            hiTail.next = null;
                        }
                    }
                }
            }

        }
        return newTab;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    //basic hash bin node
    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }


        @Override
        public final K getKey() {
            return key;
        }

        @Override
        public final V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }

    static final class TreeNode<K, V> extends Node<K, V> {


        public TreeNode(int hash, K key, V value, Node<K, V> next) {
            super(hash, key, value, next);
        }
    }
}
