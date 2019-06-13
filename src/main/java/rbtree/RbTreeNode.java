package rbtree;

/**
 * 红黑树节点
 *
 * @param <K> key
 * @param <V> value
 */
public class RbTreeNode<K, V> {
    private static final boolean RED = true; //红色为真
    private static final boolean BLACK = false; //黑色为假
    K key;
    V value;
    RbTreeNode<K, V> left;
    RbTreeNode<K, V> right;
    int N;
    boolean color;
}
