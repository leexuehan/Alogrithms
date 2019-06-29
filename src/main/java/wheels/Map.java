package wheels;

/**
 * @author leexuehan on 2019/6/26.
 */
public interface Map<K, V> {
    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    V put(K key, V value);

    V get(Object key);

    V remove(Object key);

    interface Entry<K, V> {
        K getKey();

        V getValue();

        V setValue(V value);

        int hashCode();
    }
}
