import java.util.HashMap;
import java.util.Map;

public class CacheNode<K, V> {

    private final int capacity;
    private final Map<K, V> cache;
    private final EvictionPolicy<K> evictionPolicy;

    public CacheNode(int capacity, EvictionPolicy<K> evictionPolicy) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.evictionPolicy = evictionPolicy;
    }

    public V get(K key) {
        if (!cache.containsKey(key))
            return null;

        evictionPolicy.keyAccessed(key);
        return cache.get(key);
    }

    public void put(K key, V value) {

        if (cache.containsKey(key)) {
            cache.put(key, value);
            evictionPolicy.keyAccessed(key);
            return;
        }

        if (cache.size() >= capacity) {
            K evict = evictionPolicy.evictKey();
            cache.remove(evict);
        }

        cache.put(key, value);
        evictionPolicy.keyAccessed(key);
    }
}