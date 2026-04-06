import java.util.*;

public class Main {

    public static void main(String[] args) {

        int numberOfNodes = 3;
        int capacityPerNode = 2;

        List<CacheNode<Integer, String>> nodes = new ArrayList<>();

        for (int i = 0; i < numberOfNodes; i++) {
            nodes.add(new CacheNode<>(capacityPerNode, new LRUCachePolicy<>()));
        }

        DistributedCache<Integer, String> cache = new DistributedCache<>(
                nodes,
                new ModuloBasedStrategy<>(),
                new InMemoryDatabase<>());

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.put(4, "D");
        cache.put(5, "E");
        cache.put(6, "F");
        cache.put(7, "G"); // should trigger eviction

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}