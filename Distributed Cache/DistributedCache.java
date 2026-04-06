import java.util.List;

public class DistributedCache<K, V> {

    private final List<CacheNode<K, V>> nodes;
    private final DistributionStrategy<K, V> strategy;
    private final Database<K, V> db;

    public DistributedCache(List<CacheNode<K, V>> nodes,
            DistributionStrategy<K, V> strategy,
            Database<K, V> db) {
        this.nodes = nodes;
        this.strategy = strategy;
        this.db = db;
    }

    public V get(K key) {
        CacheNode<K, V> node = strategy.getNode(key, nodes);

        V value = node.get(key);

        if (value == null) {
            value = db.get(key);
            if (value != null) {
                node.put(key, value);
            }
        }

        return value;
    }

    public void put(K key, V value) {
        CacheNode<K, V> node = strategy.getNode(key, nodes);

        node.put(key, value);

        // write-through
        db.put(key, value);
    }
}