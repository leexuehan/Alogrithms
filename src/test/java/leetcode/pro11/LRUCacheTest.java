package leetcode.pro11;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author leexuehan on 2019/6/25.
 */
public class LRUCacheTest {
    @Test
    public void testCase() throws Exception {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));

        cache.put(3, 3);
        assertEquals(-1, cache.get(2));// evicts key 2

        cache.put(4, 4);
        assertEquals(-1, cache.get(1));// evicts key 1
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }
}