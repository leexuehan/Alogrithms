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

    @Test
    public void testCase2() throws Exception {
        LRUCache cache = new LRUCache(1 /* capacity */);
        cache.put(1, 1);
        assertEquals(1, cache.get(1));

        cache.put(2, 2);
        assertEquals(-1, cache.get(1));
    }

    @Test
    public void testCase3() throws Exception {
        LRUCache cache = new LRUCache(2 /* capacity */);
        cache.put(2, 1);
        cache.put(2, 2);
        assertEquals(2, cache.get(2));

        cache.put(1, 1);
        cache.put(4, 1);
        assertEquals(-1, cache.get(2));

    }

    @Test
    public void testCase4() throws Exception {
        LRUCache cache = new LRUCache(2 /* capacity */);
        cache.put(2, 1);
        cache.put(1, 1);
        assertEquals(1, cache.get(2));

        cache.put(4, 1);
        assertEquals(-1, cache.get(1));
        assertEquals(1, cache.get(2));
    }

    @Test
    public void testCase5() throws Exception {
        LRUCache cache = new LRUCache(2 /* capacity */);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);

        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }

    @Test
    public void testCase6() throws Exception {
        LRUCache cache = new LRUCache(2 /* capacity */);
        assertEquals(-1, cache.get(2));

        cache.put(2, 6);
        assertEquals(-1, cache.get(1));

        cache.put(1, 5);
        cache.put(1, 2);
        assertEquals(2, cache.get(1));
        assertEquals(6, cache.get(2));
        assertEquals(-1, cache.get(4));

        cache.put(3, 2);
        assertEquals(2, cache.get(3));
        cache.put(3, 1);
        cache.put(4, 1);
        assertEquals(1, cache.get(4));

    }

    @Test
    public void testCase7() throws Exception {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(2, 1);
        cache.put(3, 2);

        assertEquals(2, cache.get(3));
        assertEquals(1, cache.get(2));

        cache.put(4, 3);
        assertEquals(1, cache.get(2));
        assertEquals(-1, cache.get(3));
        assertEquals(3, cache.get(4));
    }
}