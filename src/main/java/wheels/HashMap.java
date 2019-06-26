package wheels;

import java.util.Objects;

/**
 * @author leexuehan on 2019/6/26.
 */
public class HashMap<K, V> implements Map<K, V> {
    static final int MAX_CAPACITY = 1 << 30;


    //load factor
    static final float DEFAULT_LOAD_FACTOR = 0.75f;


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
        return 0;
    }

    private Node<K, V>[] resize() {
        return new Node[0];
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
}
