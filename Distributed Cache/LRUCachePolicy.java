import java.util.LinkedHashSet;

public class LRUCachePolicy<K> implements EvictionPolicy<K> {

    private final LinkedHashSet<K> order = new LinkedHashSet<>();

    @Override
    public void keyAccessed(K key) {
        order.remove(key);
        order.add(key);
    }

    @Override
    public K evictKey() {
        K first = order.iterator().next();
        order.remove(first);
        return first;
    }
}